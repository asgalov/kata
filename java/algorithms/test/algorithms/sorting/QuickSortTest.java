/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.sorting;

import algorithms.utils.Utils;
import org.junit.Test;

/**
 *
 * @author gas
 */
public class QuickSortTest {
    
    public QuickSortTest() {
    }

    /**
     * Test of sort method, of class QuickSort.
     */
//    @Test
    public void testSort() {
        int[] arr = {1, 8, 9, 10, 3, 4, 6, 2, 1};
        System.out.println("initial "+Utils.toString(arr));
        int l = 0;
        int p = arr.length - 1;
        arr = QuickSort.sort(arr, l, p);
        System.out.println("sorted "+Utils.toString(arr));
    }
    
    @Test
    public void testSort2() {
        int[] arr = {1, 1, 9, 10, 3, 4, 6, 2, 8};
        System.out.println("initial "+Utils.toString(arr));
        int l = 2;
        int p = 8;
        arr = QuickSort.sort(arr, l, p);
        System.out.println("sorted "+Utils.toString(arr));
    }
  
    
}