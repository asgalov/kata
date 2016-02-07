/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.data;

import java.util.Arrays;

/**
 *
 * @author gas
 */
public class ArrayStack <K extends Object> {
    
    private final Object[] stack;
    private int last;
    
    public ArrayStack(int maxSize) {
        this.stack = new Object[maxSize];
        this.last = -1;
    }
    
    public void push(K el){
        assert last < stack.length - 1 : "stack overflow!";
        last ++;
        stack[last] = el;
    }
    
    public boolean isEmpty(){
        return last < 0;
    }
    
    public K pop(){
        assert last >= 0 : "stack underflow!";
        K el = (K) stack[last];
        last--;
        return el;
    }

}