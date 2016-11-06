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
public class BigFileGenerator {
    
    public static void main(String[] args) throws IOException {
        String fileName = "/home/gas/tmp/foo";
        BigFileGenerator.generateBigFile(fileName, 2, 1);
    }
    
    public static void generateBigFile(String filename,
            int fileSizeMb, int availableRamMb) {
        try {
            Path path = Paths.get(filename);

            Set<OpenOption> options = new HashSet<>();
            options.add(APPEND);
            options.add(CREATE);
            
            Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-r-----");
            FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
            
            try (SeekableByteChannel channel = Files.newByteChannel(path, options, attr)) {
                for (int i = 0; i < fileSizeMb/availableRamMb; i++) {
                    ByteBuffer buf = generateNextBuffer(availableRamMb);
                    channel.write(buf);                
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    private static ByteBuffer generateNextBuffer(int availableRamMb) {
        StringBuilder sb = new StringBuilder("");
        long availableRamBytes = availableRamMb * 1000000;
        while (availableRamBytes > 0){
            String randomString = generateRandomString();
            sb.append(randomString);
            sb.append("\n");
            availableRamBytes -= randomString.length() + 1;
        }
        byte data[] = sb.toString().getBytes();
        ByteBuffer buf = ByteBuffer.wrap(data);
        return buf;
    }

    private static String generateRandomString() {
        String str = Integer.toString((int) (100*Math.random())) + "Hello world!";
        return str;
    }
        
}