/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.topcoder;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gas
 */
public class ZenoDivisionTest {
    
    public ZenoDivisionTest() {
    }

    @Test
    public void testCycle() {
        System.out.println("cycle");
        ZenoDivision instance = new ZenoDivision();
        assertEquals("*-", instance.cycle("2", "3"));
        assertEquals("*-*", instance.cycle("5", "7"));
        assertEquals("-", instance.cycle("0", "1"));
        assertEquals("*---**", instance.cycle("5", "9"));
        assertEquals("impossible", instance.cycle("1", "2"));
        assertEquals("********************************************************----", instance.cycle("76861433640456464", "76861433640456465"));
    }
    
}
