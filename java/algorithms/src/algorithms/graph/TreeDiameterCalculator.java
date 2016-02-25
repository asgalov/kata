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
public class TreeDiameterCalculator {
    
    public static int getDiameter(int[][] adjMatrix){
        int[] distances1 = Bfs.getDistances(adjMatrix, 1);
        int leaf = 1;
        for (int i = 0; i < distances1.length; i++) {
            if (distances1[i] > distances1[leaf - 1]){
                leaf = i + 1;
            }
        }
        System.out.println("distances "+Utils.toString(distances1));
        System.out.println("leaf "+leaf);
        int[] distances2 = Bfs.getDistances(adjMatrix, leaf);
        int max = 0;
        for (int i = 0; i < distances2.length; i++) {
            max = distances2[i] > max ? distances2[i] : max;
        }
        return max;
    }
}
