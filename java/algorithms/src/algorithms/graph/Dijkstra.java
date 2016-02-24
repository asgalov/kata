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
        public final int w;

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
        int[] pred = new int[adjMatrix.length];
        int[] colors = new int[adjMatrix.length];
        for (int i = 0; i < paths.length; i++) {
            paths[i] = Integer.MAX_VALUE;
            pred[i] = -1;
            colors[i] = 0;
        }
        paths[s - 1] = 0;
        colors[s - 1] = 1;
        
        PriorityQueue<WeightedVertex> queue = new PriorityQueue<>(paths.length);
        queue.add(new WeightedVertex(s, paths[s - 1]));
        while (!queue.isEmpty()){
            WeightedVertex wv = queue.poll();
            int v = wv.v;
            colors[v - 1] = 2;
            int[] adjV = GraphUtils.getAdj(adjMatrix, v);
            for (int i = 0; i < adjV.length; i++) {
                relax(adjMatrix, paths, pred, v, adjV[i]);
                if (colors[adjV[i] - 1] == 0){
                    queue.add(new WeightedVertex(adjV[i], paths[adjV[i] - 1]));
                    colors[adjV[i] - 1] = 1;
                }
            }
        }
        return paths;
    }

    private static void relax(int[][] adjMatrix, int[] paths, int[] pred, int v, int u) {
        int w = adjMatrix[v - 1][u - 1];
        if (paths[u - 1] > paths[v - 1] + w){
            paths[u - 1] = paths[v - 1] + w;
            pred[u - 1] = v;
        }
    }
        
}