/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.data;

import org.junit.Test;

/**
 *
 * @author gas
 */
public class LinkedTreeTest {
    
    public LinkedTreeTest() {
    }

    /**
     * Test of insert method, of class LinkedTree.
     */
    @Test
    public void testInsert() {
        
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
        Integer d = tree.delete(7);
        System.out.println("delete 7: "+"("+d+") "+tree.toString());
        d = tree.delete(1);
        System.out.println("delete 1: "+"("+d+") "+tree.toString());

        System.out.println("max:"+tree.getMax());
        System.out.println("min:"+tree.getMin());
    }


}
