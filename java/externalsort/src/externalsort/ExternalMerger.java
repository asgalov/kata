/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalsort;

import com.sun.javafx.scene.control.skin.VirtualFlow;
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
            
            try (SeekableByteChannel inputChannel = Files.newByteChannel(inputPath, inputOptions, attr); 
                 SeekableByteChannel outputChannel = Files.newByteChannel(outputPath, outputOptions, attr)) {

                for (int i = 0; i < oldIndexes.size(); i += 2) {
                    int inputPosition1 = oldIndexes.get(i);
                    int inputPosition2 = oldIndexes.get(i + 1);
                    newIndexes.add(oldIndexes.get(i + 1));
                    
                    while (inputPosition1 > oldIndexes.get(i + 1) && inputPosition2 > oldIndexes.get(i + 2)){
                        int size1 = Math.min(BUF_SIZE, oldIndexes.get(i + 1) - inputPosition1);
                        int size2 = Math.min(BUF_SIZE, oldIndexes.get(i + 2) - inputPosition2);
                        ByteBuffer inputBuf1 = readNextBuffer(inputChannel, inputPosition1, size1);
                        ByteBuffer inputBuf2 = readNextBuffer(inputChannel, inputPosition2, size2);
                        inputPosition1 -= size1;
                        inputPosition2 -= size2;
                        ByteBuffer outputBuf = mergeBuffers(inputBuf1, inputBuf2);
                        outputChannel.write(outputBuf);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return newIndexes;
    }

    private static ByteBuffer readNextBuffer(SeekableByteChannel channel,
                int position, int bufSize) throws IOException {
        channel.position(position);
        ByteBuffer readBuf = ByteBuffer.allocate(bufSize);
        channel.read(readBuf);
        return readBuf;
    }

    private static ByteBuffer mergeBuffers(ByteBuffer inputBuf1, ByteBuffer inputBuf2) {
        List<String> lines = new ArrayList<>();
        lines.addAll(Utils.toLines(inputBuf1));
        lines.addAll(Utils.toLines(inputBuf2));
        Collections.sort(lines);
        return Utils.toByteBuffer(lines);
    }

}