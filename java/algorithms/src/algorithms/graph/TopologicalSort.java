/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graph;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author gas
 */
public class TopologicalSort {
    
    public static LinkedList<Integer> sort(LinkedList<LinkedList<Integer>> adjList){
        LinkedList<Integer> sort = new LinkedList<>();
        removeEmpty(adjList, sort);
        Collections.reverse(sort);
        return sort;
    }
    
    private static void removeEmpty(LinkedList<LinkedList<Integer>> adjList, LinkedList<Integer> sort) {
        if (adjList.isEmpty()){
            return ;
        }
                
        for (Iterator<LinkedList<Integer>> it = adjList.iterator(); it.hasNext();) {
            LinkedList<Integer> list = it.next();
            if (list.size() == 1){
                Integer v = list.get(0);
                sort.add(v);
                System.out.println("remove "+v);
                it.remove();
                clearVertex(v, adjList);
            }
        }
        
        removeEmpty(adjList, sort);
    }

    private static void clearVertex(Integer v, LinkedList<LinkedList<Integer>> adjList) {
        for (LinkedList<Integer> list : adjList) {
            for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
                if (it.next().equals(v)){
                    it.remove();
                }
            }
        }
    }
   
}