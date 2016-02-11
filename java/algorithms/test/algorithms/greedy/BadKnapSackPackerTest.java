/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.greedy;

import org.junit.Test;

/**
 *
 * @author gas
 */
public class BadKnapSackPackerTest {
    
    public BadKnapSackPackerTest() {
    }
    
    @Test
    public void testSelectItems() {
        System.out.println("selectItems");
        int[] vv = {1,3,2,10,5,30,4,4};
        int[] ww = {1,2,5,6,10,15,20,100};
        System.out.println("7 kg: "+BadKnapSackPacker.selectItems(vv, ww, 7).toString());
        System.out.println("50 kg: "+BadKnapSackPacker.selectItems(vv, ww, 50).toString());
    }
    
}
