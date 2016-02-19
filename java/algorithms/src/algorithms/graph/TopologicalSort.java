/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graph;

/**
 *
 * @author gas
 */
public class TopologicalSort {
    
    private final int[][] adjMatrix;
    private final int[] startTimes;
    private final int[] finishTimes;
    private final int[] colors;
    private int t = 0;
    private final int[] sort;
    private int counter = 0;

    public TopologicalSort(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
        this.colors = new int[adjMatrix.length];
        this.startTimes = new int[adjMatrix.length];
        this.finishTimes = new int[adjMatrix.length];
        this.sort = new int[adjMatrix.length];
        this.counter = adjMatrix.length - 1;
        for (int i = 0; i < adjMatrix.length; i++) {
            colors[i] = 0;
        }
        dfs();

    }
    
    public int[] sort(){
        return sort;
    }
   

    private void dfs() {
        for (int i = 0; i < adjMatrix.length; i++) {
            int v = i + 1;
            if (colors[i] == 0){
                dfsVisit(v);
            }
        }
    }

    private void dfsVisit(int v) {
        t ++;
        startTimes[v - 1] = t;
        System.out.println("visit "+v);
        colors[v - 1] = 1;
        int[] adjV = GraphUtils.getAdj(adjMatrix, v);
        for (int i = 0; i < adjV.length; i++) {
            int u = adjV[i];
            if (colors[u - 1] == 0){
                colors[u - 1] = 1;
                dfsVisit(u);
            }
        }
        colors[v - 1] = 2;
        t ++;
        finishTimes[v - 1] = t;
        sort[counter] = v;
        counter --;
    }
    
}
