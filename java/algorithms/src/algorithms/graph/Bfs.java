/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graph;

import algorithms.data.ArrayQueue;

/**
 *
 * @author gas
 */
public class Bfs {
    
    public static int[] getDistances(int[][] adjMatrix, int s){
        int[] colors = new int[adjMatrix.length];
        int[] distances = new int[adjMatrix.length];
        for (int i = 0; i < distances.length; i++) {
            colors[i] = 0;
            distances[i] = Integer.MAX_VALUE;
        }
        colors[s - 1] = 1;
        distances[s - 1] = 0;
        ArrayQueue<Integer> queue = new ArrayQueue<>(adjMatrix.length);
        queue.enqueue(s);
        while (!queue.isEmpty()){
            int v = queue.dequeue();
            int[] uu = getAdj(adjMatrix, v);
            for (int i = 0; i < uu.length; i++) {
                if (colors[uu[i] - 1] == 0){
                    queue.enqueue(uu[i]);
                    distances[uu[i] - 1] = distances[v - 1] + 1;
                    colors[uu[i] - 1] = 1;
                }
            }
            colors[v - 1] = 2;
        }
        return distances;
    }

    static int[] getAdj(int[][] adjMatrix, int v) {
        int n = 0;
        for (int i = 0; i < adjMatrix.length; i++){
            n += adjMatrix[v - 1][i];
        }
        
        int[] adj = new int[n - 1];
        int k = 0;
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[v - 1][i] == 1 && i != v - 1){
                adj[k] = i + 1;
                k ++;
            }
        }
        
        return adj;
    }

    
}