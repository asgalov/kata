/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.sorting;

import algorithms.utils.Utils;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gas
 */
public class OrderStatisticsTest {
    
    public OrderStatisticsTest() {
    }

    /**
     * Test of getKthMax method, of class OrderStatistics.
     */
    @Test
    public void testGetKthMax() {
        System.out.println("getKthMax");
        int[] arr = {1, 9, 10, 3, 4, 6, 2, 8};
        System.out.println("initial "+Utils.toString(arr));
        assertEquals(1, OrderStatistics.getKthMax(arr, 0));
        assertEquals(2, OrderStatistics.getKthMax(arr, 1));
        assertEquals(3, OrderStatistics.getKthMax(arr, 2));
        assertEquals(4, OrderStatistics.getKthMax(arr, 3));
    }
    
}
