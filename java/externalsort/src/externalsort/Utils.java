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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gas
 */
class Utils {
    
    static ByteBuffer readNextBuffer(SeekableByteChannel channel, long position) throws IOException {
        channel.position(position);
        ByteBuffer readBuf = ByteBuffer.allocate(BUF_SIZE);
        channel.read(readBuf);
        return readBuf;
    }
    
    static List<String> toLines(ByteBuffer buf) {
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
    
    static ByteBuffer toByteBuffer(List<String> lines) {
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
