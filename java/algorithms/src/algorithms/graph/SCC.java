/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graph;

import algorithms.utils.Utils;

/**
 *
 * @author gas
 */
public class SCC {
    
    private final int[][] adjMatrix;
    private final int[] startTimes;
    private final int[] finishTimes;
    private final int[] colors;
    private int t = 0;
    
    public SCC(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
        this.colors = new int[adjMatrix.length];
        this.startTimes = new int[adjMatrix.length];
        this.finishTimes = new int[adjMatrix.length];
        for (int i = 0; i < adjMatrix.length; i++) {
            colors[i] = 0;
        }
        dfs();
    }

    public int[] getStartTimes() {
        return startTimes;
    }

    public int[] getFinishTimes() {
        return finishTimes;
    }

    private void dfs() {
        for (int i = 0; i < adjMatrix.length; i++) {
            int v = i + 1;
            if (colors[i] == 0){
                dfsVisit(adjMatrix, v);
            }
        }
        
        int[][] transposeAdjMatrix = getTranspose(adjMatrix);
        int[] newOrder = new int[finishTimes.length * 2];
        for (int i = 0; i < newOrder.length; i++) {
            newOrder[i] = -1;
        }
        
        for (int i = 0; i < finishTimes.length; i++) {
            newOrder[finishTimes[i] - 1] = i + 1;
        }
        
        System.out.println("new order: "+Utils.toString(newOrder));
        
        t = 0;
        for (int i = 0; i < colors.length; i++) {
            colors[i] = 0;
        }
        for (int i = newOrder.length - 1; i >= 0; i--) {
            if (newOrder[i] > 0 && colors[newOrder[i] - 1] == 0){
                dfsVisit(transposeAdjMatrix, newOrder[i]);
            }
        }
    }

    private void dfsVisit(int[][] adjMatrix, int v) {
        t ++;
        startTimes[v - 1] = t;
        colors[v - 1] = 1;
        int[] adjV = GraphUtils.getAdj(adjMatrix, v);
        for (int i = 0; i < adjV.length; i++) {
            int u = adjV[i];
            if (colors[u - 1] == 0){
                colors[u - 1] = 1;
                dfsVisit(adjMatrix, u);
            }
        }
        colors[v - 1] = 2;
        t ++;
        finishTimes[v - 1] = t;
    }

    private int[][] getTranspose(int[][] adjMatrix) {
        int[][] transpose = new int[adjMatrix.length][adjMatrix.length];
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                transpose[j][i] = adjMatrix[i][j];
            }
        }
        return transpose;
    }

}