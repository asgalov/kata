/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graph;

import algorithms.data.SinglyLinkedList;
import com.sun.javafx.collections.UnmodifiableListSet;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author gas
 */
public class Graph {
    
    private final int[][] adjacentMatrix;
    private final int[] vertices;
    
    public Graph(int[][] adjacentMatrix) {
        this.adjacentMatrix = adjacentMatrix;
        this.vertices = new int[adjacentMatrix.length];
        for (int i = 0; i < adjacentMatrix.length; i++) {
            vertices[i] = i + 1;
        }
    }
    
    public int[] getVerticies(){
        return vertices;
    }
    
    public boolean isConnected(int u, int v){
        assert u <= vertices.length;
        assert v <= vertices.length;
        return adjacentMatrix[u][v] > 0;
    }
    
    public Set<Integer> getAdjacent(int v){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < adjacentMatrix[v - 1].length; i++) {
            if (adjacentMatrix[v - 1][i] > 0 && (v != i + 1)){
                set.add(i + 1);
            }
        }
        return set;
    }
    
}