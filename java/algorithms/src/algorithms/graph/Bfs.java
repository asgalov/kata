/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graph;

import algorithms.data.ArrayStack;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author gas
 */
public class Bfs {
    
    public static int search(Graph g, int vertex){
        ArrayStack<Integer> stack = new ArrayStack(g.getVerticies().length);
        stack.push(g.getVerticies()[0]);
        Set<Integer> black = new HashSet<>();
        Set<Integer> gray = new HashSet<>();
        while (!stack.isEmpty()){
            int v = stack.pop();
            black.add(v);
            if (v == vertex){
                return v;
            }
            Set<Integer> adjacent = g.getAdjacent(v);
            for (Integer va : adjacent) {
                if (!gray.contains(va) && !black.contains(va)){
                    stack.push(va);
                }
            }
            gray.addAll(adjacent);
        }
        return -1;
    }

    public static int dist(Graph g, int start, int end){
        ArrayStack<Integer> stack = new ArrayStack(g.getVerticies().length);
        stack.push(start);
        Set<Integer> black = new HashSet<>();
        Set<Integer> gray = new HashSet<>();
        while (!stack.isEmpty()){
            int v = stack.pop();
            if (v == end){
                return black.size();
            }
            black.add(v);
            Set<Integer> adjacent = g.getAdjacent(v);
            for (Integer va : adjacent) {
                if (!gray.contains(va) && !black.contains(va)){
                    stack.push(va);
                }
            }
            gray.addAll(adjacent);
        }
        return -1;
    }
    
}