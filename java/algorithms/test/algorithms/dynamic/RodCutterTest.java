/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.dynamic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gas
 */
public class RodCutterTest {
    
    public RodCutterTest() {
    }

    /**
     * Test of getCharge method, of class RodCutter.
     */
    @Test
    public void testGetCharge() {
        System.out.println("getCharge");
        int n = 0;
        int[] price = {1,5,8,9,10,17,17,20,24,30};
        assertEquals(1, RodCutter.getCharge(1, price));
        assertEquals(5, RodCutter.getCharge(2, price));
        assertEquals(8, RodCutter.getCharge(3, price));
        assertEquals(10, RodCutter.getCharge(4, price));
        assertEquals(13, RodCutter.getCharge(5, price));
        assertEquals(17, RodCutter.getCharge(6, price));
        assertEquals(18, RodCutter.getCharge(7, price));
        assertEquals(22, RodCutter.getCharge(8, price));
        assertEquals(25, RodCutter.getCharge(9, price));
        assertEquals(30, RodCutter.getCharge(10, price));
        System.out.println("test for n = 7: "+RodCutter.getCharge(7, price));
    }
    
}
