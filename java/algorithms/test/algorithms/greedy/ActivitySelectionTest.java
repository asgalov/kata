/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.greedy;

import algorithms.data.SinglyLinkedList;
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
public class ActivitySelectionTest {
    
    public ActivitySelectionTest() {
    }

    /**
     * Test of select method, of class ActivitySelection.
     */
    @Test
    public void testSelect() {
        System.out.println("select");
        int[] ss = {1,3,0,5,3,5,6,8,8,2,12};
        int[] ff = {4,5,6,7,9,9,10,11,12,14,16};
        SinglyLinkedList<Integer> result1 = ActivitySelection.selectIter(ss, ff);
        SinglyLinkedList<Integer> result2 = ActivitySelection.select(ss, ff);
        result1.reverse();
        result2.reverse();
        System.out.println(result1.toString());
        System.out.println(result2.toString());
    }
    
}
