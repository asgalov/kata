/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalsort;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.CREATE;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author gas
 */
public class ExternalSorter {

    public static final int BUF_SIZE = 100000;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inputFileName = "/home/gas/tmp/foo";
        String outputFileName = "/home/gas/tmp/foo_sorted";
        String mergedFileName = "/home/gas/tmp/foo_merged";
        List<Integer> indexes1 = sortBigFile(inputFileName, outputFileName);
        List<Integer> indexes2 = ExternalMerger.mergeBigFile(outputFileName, mergedFileName, indexes1);
        for (Integer i : indexes2) {
            System.out.println(i);
        }
    }
    
    public static List<Integer> sortBigFile(String inputFileName, String outputFileName) {
        List<Integer> indexes = new ArrayList<>();
        try {
            Path inputPath = Paths.get(inputFileName);
            Path outputPath = Paths.get(outputFileName);
            
            Set<OpenOption> inputOptions = new HashSet<>();
            inputOptions.add(READ);
            
            Set<OpenOption> outputOptions = new HashSet<>();
            outputOptions.add(APPEND);
            outputOptions.add(CREATE);
            
            Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-r-----");
            FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
            
            long inputSize = Files.size(inputPath);
            System.out.println("inputSize: "+inputSize);
            long inputPosition = 0;
            int outputPosition = 0;
            
            try (SeekableByteChannel inputChannel = Files.newByteChannel(inputPath, inputOptions, attr); 
                 SeekableByteChannel outputChannel = Files.newByteChannel(outputPath, outputOptions, attr)) {
                
                while (inputSize > BUF_SIZE){
                    ByteBuffer inputBuf = Utils.readNextBuffer(inputChannel, inputPosition);
                    List<String> lines = toLines(inputBuf);
                    Collections.sort(lines);
                    ByteBuffer outputBuf = toByteBuffer(lines);
                    outputChannel.write(outputBuf);
                    long inputBufSize = inputBuf.array().length;
                    inputSize -= inputBufSize;
                    inputPosition += inputBufSize;
                    outputPosition += outputBuf.array().length;
                    indexes.add(outputPosition);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return indexes;
    }



    private static List<String> toLines(ByteBuffer buf) {
        List<String> list = new ArrayList<>();
        String str = new String(buf.array());
        String tmp = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\n'){
                list.add(tmp+'\n');
                tmp = "";
            } else {
                tmp += str.charAt(i);
            }
        }
        return list;
    }
    
    private static ByteBuffer toByteBuffer(List<String> lines) {
        int size = 0;
        for (String line : lines) {
            size += line.getBytes().length;
        }
        
        byte data[] = new byte[size];
        int index = -1;
        for (String line : lines) {
            for (int i = 0; i < line.getBytes().length; i++) {
                index++;
                data[index] = line.getBytes()[i];
            }
        }
        
        ByteBuffer buf = ByteBuffer.wrap(data);
        return buf;
    }
    
}