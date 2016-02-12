/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.dynamic;

import algorithms.data.SinglyLinkedList;
import algorithms.greedy.BadKnapSackPacker;
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
public class KnapSack10ProblemTest {
    
    public KnapSack10ProblemTest() {
    }

    /**
     * Test of selectItems method, of class KnapSack10Problem.
     */
    @Test
    public void testSelectItems() {
        System.out.println("selectItems");
        int[] ww = {1,2,5,6,10,15,20,100};
        int[] vv = {1,3,2,10,5,30,4,4};
        System.out.println("7 kg: "+KnapSack10Problem.selectItems(vv, ww, 7).toString());
        System.out.println("50 kg: "+KnapSack10Problem.selectItems(vv, ww, 50).toString());
    }
    
}
