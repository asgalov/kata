/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.graph;

/**
 *
 * @author gas
 */
public class BinaryTree {
    
    public class Node{
        public final Node left;
        public final Node right;
        public final Integer value;

        public Node(Integer value, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
    
    public final Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }
    
}