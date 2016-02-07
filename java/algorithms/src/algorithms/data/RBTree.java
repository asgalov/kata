/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gas
 */
public class RBTree<K extends Comparable> {

    private enum Color{
        BLACK,
        RED;
    }
    
    public class RBNode {
        RBNode p;
        RBNode l;
        RBNode r;
        Color color;
        K value;
        final boolean isNIL;

        public RBNode(K value, RBNode p, RBNode l, RBNode r, Color color) {
            this.p = p;
            this.l = l;
            this.r = r;
            this.value = value;
            this.isNIL = false;
            this.color = color;
        }

        public RBNode(boolean isNIL) {
            this.isNIL = isNIL;
            this.value = null;
            this.color = Color.BLACK;
        }
    }

    private RBNode NIL = new RBNode(true);
    private RBNode root = NIL;
    private int size = 0;

    public void insert(K value){
        System.out.println("insert "+value);
        RBNode y = NIL;
        RBNode x = root;
        while (x != NIL){
            y = x;
            x = value.compareTo(x.value) < 0 ? x.l : x.r;
        }
        
        RBNode red;
        if (y == NIL){
            root = new RBNode(value, NIL, NIL, NIL, Color.RED);
            red = root;
        } else if (value.compareTo(y.value) < 0){
            red = new RBNode(value, y, NIL, NIL, Color.RED);
            y.l = red;
        } else {
            red = new RBNode(value, y, NIL, NIL, Color.RED);
            y.r = red;
        }
        print();
        rbInsertFixedUp(red);
        size ++;
    }
    
    
    public RBNode search(K value){
        RBNode next = root;
        while (next != NIL){
            if (next.value.equals(value)){
                return next;
            } else {
                next = value.compareTo(next.value) < 0 ? next.l : next.r;
            }
        }
        return NIL;
    }
    
    void leftRotate(RBNode x){
        System.out.println("leftRotate "+x.value);
        assert x.r != NIL;
        RBNode y = x.r;
        if (x.p == NIL){
            y = root;
            y.p = NIL;
        } else if (x.p.r == x){
            x.p.r = y;
            y.p = x.p;
        } else {
            x.p.l = y;
            y.p = x.p;
        }
        
        if (y.l != NIL){
            y.l.p = x;
        }
        x.r = y.l;
        x.p = y;
        y.l = x;
        print();
    }
    
    void rightRotate(RBNode y){
        System.out.println("rightRotate "+y.value);
        RBNode x = y.l;
        if (y.p == NIL){
            x = root;
            x.p = NIL;
        } else if (y.p.r == y){
            y.p.r = x;
            x.p = y.p;
        } else {
            y.p.l = x;
            x.p = y.p;
        }
        
        if (x.r != NIL){
            x.r.p = y;
        }
        y.l = x.r;
        y.p = x;
        x.r = y;
        print();
    }

    private void rbInsertFixedUp(RBNode n) {
        System.out.println("rbInsertFixedUp ........ "+n.value+" "+n.color);
        RBNode z = n;
        while (z.p.color.equals(Color.RED)){
            if (z.p == z.p.p.l){
                RBNode y = z.p.p.r;
                if (y.color.equals(Color.RED)){
                    z.p.color = Color.BLACK;
                    y.color = Color.BLACK;
                    z.p.p.color = Color.RED;
                    z = z.p.p;
                } else if (z == z.p.r){
                    z = z.p;
                    leftRotate(z);
                } else{
                    z.p.p.color = Color.RED;
                    z.p.color = Color.BLACK;
                    z = z.p.p;
                    rightRotate(z);
                }
            } else{
                RBNode y = z.p.p.l;
                if (y.color.equals(Color.RED)){
                    z.p.color = Color.BLACK;
                    y.color = Color.BLACK;
                    z.p.p.color = Color.RED;
                    z = z.p.p;
                } else if (z == z.p.l){
                    z = z.p;
                    rightRotate(z);
                } else{
                    z.p.p.color = Color.RED;
                    z.p.color = Color.BLACK;
                    z = z.p.p;
                    leftRotate(z);
                }
                
            }
        }
        root.color = Color.BLACK;
        System.out.println("rbInsertFixedUp: ");
        print();
    }

    @Override
    public String toString(){
        String str = getString(root);
        return str;
    }
    
    private String getString(RBNode node) {
        if (node == null){
            return "";
        }
        String s = node.value + " ";
        String sl = getString(node.l);
        String sr = getString(node.r);
        return s+sl+sr;
    }
    
    
    public void print() {
        List<String> treeStr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            treeStr.add("");
        }
        addNodes(treeStr, root, 0);
        String rootColor = root.color == Color.RED ? "r" : "b";
        System.out.println(root.value+rootColor);
        for (String str : treeStr) {
            if (str.length() > 0)
                    System.out.println(str);
        }
    }
    
    private void addNodes(List<String> treeStr, RBNode n, int i) {
        if (n == NIL || i > size ) {
            return;
        }
        
        String sl = "*";
        if (n.l != NIL){
            String colorStr = n.l.color == Color.RED ? "r" : "b";
            sl = n.l.value + colorStr +"";
        }
                
        String sr = "*";
        if (n.r != NIL){
            String colorStr = n.r.color == Color.RED ? "r" : "b";
            sr = n.r.value + colorStr + "";
        }
        
        String str = sl + " " + sr+" ";
        if (i < treeStr.size()){
            treeStr.set(i, treeStr.get(i) + str);    
            addNodes(treeStr, n.l, i + 1);
            addNodes(treeStr, n.r, i + 1);
        }
    }
    
}