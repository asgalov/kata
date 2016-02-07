/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.data;

/**
 *
 * @author gas
 */
public class LinkedTree<K extends Comparable> {

    private class Node {
        
        Node p;
        Node l;
        Node r;
        K value;

        public Node(K value, Node p, Node l, Node r) {
            this.p = p;
            this.l = l;
            this.r = r;
            this.value = value;
        }
    }

    private Node root = null;
    
    public void insert(K value){
        if (root == null){
            root = new Node(value, null, null, null);
        } else{
            Node next = root;
            while(next != null){
                if (value.compareTo(next.value) < 0){
                    if (next.l == null){
                        next.l = new Node(value, next, null, null);
                        next = null;
                    } else {
                        next = next.l;
                    }
                } else {
                    if (next.r == null){
                        next.r = new Node(value, next, null, null);
                        next = null;
                    } else {
                        next = next.r;
                    }
                }
                
            }
        }
    }
    
    public K search(K value){
        Node next = root;
        while (next != null){
            if (next.value.equals(value)){
                return next.value;
            } else {
                next = value.compareTo(next.value) < 0 ? next.l : next.r;
            }
        }
        return null;
    }
    
    public K delete(K value){
        Node next = root;
        while (next != null){
            if (next.value.equals(value)){
                if (next.p.r.value.equals(value)){
                    next.p.r = concat(next.l, next.r);
                } else {
                    Node concat = concat(next.l, next.r);
                    if (concat != null){
                        concat.p = next.p;
                    }
                    next.p.l = concat;
                }
                return next.value;
            } else {
                next = value.compareTo(next.value) < 0 ? next.l : next.r;
            }
        }
        return null;
    }

    private Node concat(Node l, Node r) {
        if (l == null){
            return r;
        }
        
        Node lr = getLowerRight(l);
        lr.r = r;
        r.p = lr;
        return l;
    }

    public K getMax(){
        return getLowerRight(root).value;
    }
    
    private Node getLowerRight(Node n){
        Node next = n;
        while (next != null){
            if (next.r == null){
                return next;
            }
            next = next.r;
        }
        return next;
    }
        
    public K getMin(){
        Node next = root;
        while (true){
            if (next.l == null){
                return next.value;
            }
            next = next.l;
        }
    }
    
    @Override
    public String toString(){
        String str = getString(root);
        return str;
    }
    
    private String getString(Node node) {
        if (node == null){
            return "";
        }
        String s = node.value + " ";
        String sl = getString(node.l);
        String sr = getString(node.r);
        return s+sl+sr;
    }
    
}