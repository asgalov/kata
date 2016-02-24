/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graph;

import java.util.PriorityQueue;

/**
 *
 * @author gas
 */
public class Dijkstra {
    
    public static class WeightedVertex implements Comparable<WeightedVertex>{

        public final int v;
        public int w;

        public WeightedVertex(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(WeightedVertex u) {
            if (u.w == w){
                return 0;
            }
            return u.w > w ? -1 : 1;
        }
    }
    
    public static int[] getShortestPaths(int[][] adjMatrix, int s){
        int[] paths = new int[adjMatrix.length];
        for (int i = 0; i < paths.length; i++) {
            paths[i] = Integer.MAX_VALUE;
        }
        paths[s - 1] = 0;
        
        PriorityQueue<WeightedVertex> queue = new PriorityQueue<>(paths.length);
        for (int i = 0; i < paths.length; i++) {
            queue.add(new WeightedVertex(i + 1, paths[i]));    
        }
        
        while (!queue.isEmpty()){
            WeightedVertex wv = queue.poll();
            int v = wv.v;
            int[] adjV = GraphUtils.getAdj(adjMatrix, v);
            for (int i = 0; i < adjV.length; i++) {
                relax(adjMatrix, paths, queue, v, adjV[i]);
            }
        }
        return paths;
    }

    private static void relax(int[][] adjMatrix, int[] paths, PriorityQueue<WeightedVertex> queue, int v, int u) {
        int w = adjMatrix[v - 1][u - 1];
        if (paths[u - 1] > paths[v - 1] + w){
            paths[u - 1] = paths[v - 1] + w;
        }

        queue.stream().forEach((wv) -> {
            wv.w = paths[wv.v - 1];
        });
    }
        
}