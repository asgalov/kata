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
class GraphUtils {

    static int[] getAdj(int[][] adjMatrix, int v) {
        int n = 0;
        for (int i = 0; i < adjMatrix.length; i++){
            n += adjMatrix[v - 1][i];
        }
        
        int[] adj = new int[n];
        int k = 0;
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[v - 1][i] == 1){
                adj[k] = i + 1;
                k ++;
            }
        }
        
        return adj;
    }    
    
    
    static void printDfsTrees(int[] startTimes, int[] finishTimes){
        int[] tmp = new int[startTimes.length * 2];
        for (int i = 0; i < startTimes.length; i++) {
            tmp[startTimes[i] - 1] = i + 1;
            tmp[finishTimes[i] - 1] = -1*(i + 1);
        }
        
        System.out.println("dfs trees: ");
        int sign = 1;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] > 0){
                System.out.print(tmp[i]+" ");    
                sign = 1;
            } else{
                if (sign > 0){
                    System.out.println("");
                }
                sign = -1;
            }
            
        }
    }
}
