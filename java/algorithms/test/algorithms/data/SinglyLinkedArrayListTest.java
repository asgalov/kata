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
public class SinglyLinkedArrayListTest {
    
    public SinglyLinkedArrayListTest() {
    }
    

    /**
     * Test of insert method, of class SinglyLinkedArrayList.
     */
    @Test
    public void testInsert() {
        
        SinglyLinkedArrayList list = new SinglyLinkedArrayList();
        list.insert(1);
        System.out.println("insert "+list.toString());
        list.insert(2);
        System.out.println("insert "+list.toString());
        list.insert(3);
        System.out.println("insert "+list.toString());
        list.insert(4);
        System.out.println("insert "+list.toString());
        list.delete(2);
        System.out.println("delete  "+list.toString());
        list.delete(3);
        System.out.println("delete  "+list.toString());
        list.delete(1);
        System.out.println("delete  "+list.toString());
    }
    
}
