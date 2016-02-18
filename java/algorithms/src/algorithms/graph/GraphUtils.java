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
}
