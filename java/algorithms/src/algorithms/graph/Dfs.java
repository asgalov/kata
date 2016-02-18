/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graph;

import algorithms.data.ArrayStack;

/**
 *
 * @author gas
 */
public class Dfs {
    
    private final int[][] adjMatrix;
    private final int[] startTimes;
    private final int[] finishTimes;
    private final int[] colors;
    private int t = 0;
    
    public Dfs(int[][] adjMatrix) {
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
        ArrayStack stack = new ArrayStack(adjMatrix.length);
        for (int i = 0; i < adjMatrix.length; i++) {
            if (colors[i] == 0){
                t ++;
                startTimes[i] = t;
                colors[i] = 1;
                stack.push(i + 1);
                System.out.println("push "+(i + 1));
                while (!stack.isEmpty()){
                    int v = (int) stack.pop();
                    stack.push(v);
                    int[] adjV = GraphUtils.getAdj(adjMatrix, v);
                    if (!pushNext(stack, adjV)){
                        t ++;
                        int f = (int) stack.pop();
                        System.out.println("pop "+f);
                        finishTimes[f - 1] = t;
                    }
                    
                }
            }
        }
    }

    private boolean pushNext(ArrayStack stack, int[] adjV) {
        for (int j = 0; j < adjV.length; j++) {
            int u = adjV[j];
            if (colors[u - 1] == 0){
                colors[u - 1] = 1;
                t ++;
                startTimes[u - 1] = t;
                stack.push(u);
                System.out.println("push "+u);
                return true;
            }
        }
        return false;
    }

}