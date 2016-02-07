/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.data;

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
public class RBTreeTest {
    
    public RBTreeTest() {
    }
    

    /**
     * Test of insert method, of class RBTree.
     */
//    @Test
    public void testInsert() {
        RBTree<Integer> t = new RBTree<>();
        t.insert(7);
        t.insert(4);
        t.insert(11);
        t.insert(3);
        t.insert(6);
        t.insert(9);
        t.insert(18);
        t.insert(2);
        t.insert(14);
        t.insert(19);
        t.insert(12);
        t.insert(17);
        t.insert(22);
        t.insert(20);
        
        t.leftRotate(t.search(11));
        t.rightRotate(t.search(18));
    }
    
    @Test
    public void testInsert2() {
        RBTree<Integer> t = new RBTree<>();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(5);
        t.insert(6);
        t.insert(7);
        t.insert(8);
        t.insert(9);
        t.insert(10);
        t.insert(11);
        t.insert(12);
    }
    
    
}
