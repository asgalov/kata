/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalsort;

import static externalsort.ExternalSorter.BUF_SIZE;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.READ;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author gas
 */
public class ExternalMerger {

    public static List<Integer> mergeBigFile(String inputFileName, String outputFileName,
            List<Integer> oldIndexes) {
        
        List<Integer> newIndexes = new ArrayList<>();
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
            
            try (SeekableByteChannel inputChannel = Files.newByteChannel(inputPath, inputOptions, attr); 
                 SeekableByteChannel outputChannel = Files.newByteChannel(outputPath, outputOptions, attr)) {

                System.out.println("oldIndexes.size() "+oldIndexes.size());
                for (int i = 0; i < oldIndexes.size() - oldIndexes.size() % 2; i += 2) {
                    System.out.println("i "+i);
                    int input1 = oldIndexes.get(i);
                    int input2 = oldIndexes.get(i + 1);
                    long end1 = oldIndexes.get(i + 1);
                    long end2 = i + 2 >= oldIndexes.size() ? inputSize : oldIndexes.get(i + 2);
                    
                    while (input1 < end1 && input2 < end2){
                        long size1 = Math.max(Math.min(BUF_SIZE, end1 - input1), 0);
                        long size2 = Math.max(Math.min(BUF_SIZE, end2 - input2), 0);
                        ByteBuffer buf1 = Utils.readNextBuffer(inputChannel, input1, size1);
                        ByteBuffer buf2 = Utils.readNextBuffer(inputChannel, input2, size2);
                        input1 += size1;
                        input2 += size2;
                        ByteBuffer outputBuf = mergeBuffers(buf1, buf2);
                        outputChannel.write(outputBuf);
                        newIndexes.add(i);
                    }
                }
                
                if (oldIndexes.size() % 2 != 0){
                    int lastPosition = oldIndexes.get(oldIndexes.size() - 1);
                    ByteBuffer restBuf = Utils.readNextBuffer(inputChannel, lastPosition, inputSize - lastPosition);
                    outputChannel.write(restBuf);
                }
                
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return newIndexes;
    }

    private static ByteBuffer mergeBuffers(ByteBuffer inputBuf1, ByteBuffer inputBuf2) {
        if (inputBuf1.array().length == 0)
                return inputBuf2;
        
        if (inputBuf2.array().length == 0)
                return inputBuf1;
        
        List<String> lines = new ArrayList<>();
        lines.addAll(Utils.toLines(inputBuf1));
        lines.addAll(Utils.toLines(inputBuf2));
        Collections.sort(lines);
        return Utils.toByteBuffer(lines);
    }

}