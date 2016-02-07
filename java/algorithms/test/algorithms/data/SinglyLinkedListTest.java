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
public class SinglyLinkedListTest {
    
    public SinglyLinkedListTest() {
    }
    
//    @Test
    public void testIsIn() {
        System.out.println("isIn");
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        assertTrue(list.isIn(5));
    }

    /**
     * Test of insert method, of class SinglyLinkedList.
     */
//    @Test
    public void testInsert() {
        System.out.println("insert");
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        System.out.println(list.toString());
    }

    /**
     * Test of delete method, of class SinglyLinkedList.
     */
//    @Test
    public void testDelete() {
        System.out.println("delete");
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        assertTrue(5 == list.delete(5));
        System.out.println(list.toString());
    }

    @Test
    public void testReverse() {
        System.out.println("test reverse ... ");
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        System.out.println("normal   :"+list.toString());
        list.reverse();
        System.out.println("reversed :"+list.toString());
    }

    
}