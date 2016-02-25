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
public class BinaryTreeDiameterCalculatorTest {
    
    public BinaryTreeDiameterCalculatorTest() {
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
        tree.insert(2);
        System.out.println("insert 2:"+tree.toString());
        tree.insert(1);
        System.out.println("insert 1:"+tree.toString());
        tree.insert(3);
        System.out.println("insert 3:"+tree.toString());
        tree.insert(17);
        System.out.println("insert 17:"+tree.toString());
        tree.insert(88);
        System.out.println("insert 88:"+tree.toString());
        tree.insert(11);
        System.out.println("insert 11:"+tree.toString());
        tree.insert(12);
        System.out.println("insert 12:"+tree.toString());
        tree.insert(13);
        System.out.println("insert 13:"+tree.toString());
        tree.insert(14);
        System.out.println("insert 14:"+tree.toString());
        tree.insert(15);
        System.out.println("insert 15:"+tree.toString());
        tree.insert(16);
        System.out.println("insert 16:"+tree.toString());
        tree.insert(10);
        System.out.println("insert 10:"+tree.toString());
        tree.insert(9);
        System.out.println("insert 9:"+tree.toString());
        tree.insert(8);
        System.out.println("insert 8:"+tree.toString());
        tree.insert(7);
        System.out.println("insert 7:"+tree.toString());
        tree.insert(6);
        System.out.println("insert 6:"+tree.toString());
        tree.insert(5);
        System.out.println("insert 5:"+tree.toString());

        BinaryTreeDiameterCalculator instance = new BinaryTreeDiameterCalculator(tree);
        System.out.println("tree diameter: "+instance.getDiameter());
    }

}
