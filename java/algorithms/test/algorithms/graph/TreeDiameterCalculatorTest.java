/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.graph;

import algorithms.data.LinkedBinaryTree;
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
public class TreeDiameterCalculatorTest {
    
    public TreeDiameterCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDiameter method, of class TreeDiameterCalculator.
     */
    @Test
    public void testGetDiameter() {
        System.out.println("getDiameter");
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        tree.insert(5);
        System.out.println("insert 5:"+tree.toString());
        tree.insert(2);
        System.out.println("insert 2:"+tree.toString());
        tree.insert(6);
        System.out.println("insert 6:"+tree.toString());
        tree.insert(7);
        System.out.println("insert 7:"+tree.toString());
        tree.insert(8);
        System.out.println("insert 8:"+tree.toString());
        tree.insert(1);
        System.out.println("insert 1:"+tree.toString());
        tree.insert(3);
        System.out.println("insert 3:"+tree.toString());
        tree.delete(11);
        System.out.println("delete 11:"+tree.toString());
        TreeDiameterCalculator instance = new TreeDiameterCalculator(tree);
        System.out.println("tree diameter: "+instance.getDiameter());
    }

}
