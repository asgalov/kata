/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.graph;

import algorithms.data.LinkedBinaryTree;

/**
 *
 * @author gas
 */
public class TreeDiameterCalculator {
    
    private final LinkedBinaryTree tree;
    private int diameter = -1;
    
    public TreeDiameterCalculator(LinkedBinaryTree tree) {
        this.tree = tree;
    }
    
    public int getDiameter() {
        if (diameter == -1){
            calc();
        }
        return diameter;
    }
    
    private void calc(){
        int len = getLen(tree.getRoot());
    }

    private int getLen(LinkedBinaryTree.Node v) {
        int left = v.getLeft() == null ? 0 : getLen(v.getLeft()) + 1;
        int right = v.getRight()== null ? 0 : getLen(v.getRight()) + 1;
        diameter = Math.max(left + right, diameter);
        return Math.max(left, right);
    }

}