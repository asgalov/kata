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
import static java.nio.file.StandardOpenOption.CREATE;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author gas
 */
public class ExternalSorter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inputFileName = "/home/gas/tmp/foo";
        String outputFileName = "/home/gas/tmp/foo_sorted";
        sortBigFile(inputFileName, outputFileName, 1);
    }
    
    public static void sortBigFile(String inputFileName, String outputFileName, int availableRamMb) {
        try {
            Path inputPath = Paths.get(inputFileName);
            
            Set<OpenOption> options = new HashSet<>();
            options.add(APPEND);
            options.add(CREATE);
            
            Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-r-----");
            FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
            
            long inputSize = Files.size(inputPath);
            long position = 0;
            try (SeekableByteChannel channel = Files.newByteChannel(inputPath, options, attr)) {
                while (inputSize > 0){
                    ByteBuffer buf = readNextBuffer(channel, position);
                    ByteBuffer sortedBuf = sort(buf);
                    writeSortedBuf("tmp"+position, sortedBuf);
                    long bufSize = buf.array().length;
                    inputSize -= bufSize;
                    position += bufSize;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    private static ByteBuffer readNextBuffer(SeekableByteChannel channel, long position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static ByteBuffer sort(ByteBuffer buf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static void writeSortedBuf(String string, ByteBuffer sortedBuf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
