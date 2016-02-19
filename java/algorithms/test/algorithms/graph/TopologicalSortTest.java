/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graph;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Test;

/**
 *
 * @author gas
 */
public class TopologicalSortTest {
    
    public TopologicalSortTest() {
    }

    @Test
    public void testSomeMethod() {
        LinkedList<LinkedList<Integer>> adjList = new LinkedList<>();
        adjList.add(new LinkedList<>(Arrays.asList(1, 9)));
        adjList.add(new LinkedList<>(Arrays.asList(2)));
        adjList.add(new LinkedList<>(Arrays.asList(3)));
        adjList.add(new LinkedList<>(Arrays.asList(4, 2)));
        adjList.add(new LinkedList<>(Arrays.asList(5, 1, 8)));
        adjList.add(new LinkedList<>(Arrays.asList(6, 8)));
        adjList.add(new LinkedList<>(Arrays.asList(7, 4, 9)));
        adjList.add(new LinkedList<>(Arrays.asList(8)));
        adjList.add(new LinkedList<>(Arrays.asList(9, 2)));

        System.out.println("topological sort: " + TopologicalSort.sort(adjList).toString());
    }
    
}
