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
public class ArrayQueue<K extends Object> {

    private int begin;
    private int end;
    private int size;
    private final Object[] queue;

    public ArrayQueue(int maxSize) {
        this.queue = new Object[maxSize];
        this.begin = 0;
        this.end = -1;
        this.size = 0;
    }

    public void enqueue(K el){
        assert size != queue.length: "queue overflow!";
        end ++;
        size ++;
        if (end == queue.length){
            end = 0;
        }
        queue[end] = el;
        int i = 1;
    }
    
    public K dequeue(){
        assert size > 0 : "queue underflow!";
        K el = (K) queue[begin];
        begin ++;
        size --;
        if (begin == queue.length){
            begin = 0;
        }
        return el;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
}