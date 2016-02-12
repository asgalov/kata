/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.dynamic;

import algorithms.greedy.*;
import algorithms.data.SinglyLinkedList;

/**
 *
 * @author gas
 */
public class KnapSack10Problem {

    public static SinglyLinkedList<Integer> selectItems(int[] vv, int[] ww, int maxW){
        int[][] cc = new int[vv.length + 1][maxW + 1];
        
        for (int i = 0; i < vv.length + 1; i++) {
            cc[i][0] = 0;
        }
        
        for (int j = 0; j < maxW + 1; j++) {
            cc[0][j] = 0;
        }

        for (int i = 1; i < vv.length + 1; i++) {
            for (int w = 1; w < maxW + 1; w++) {
                int v1 = w - ww[i-1] < 0 ? 0 : vv[i-1] + cc[i-1][w - ww[i-1]];
                int v2 = cc[i-1][w];
                cc[i][w] = Math.max(v1, v2);
            }
        }

        System.out.println("cc: ");
        System.out.println("");
        for (int i = 0; i < cc.length; i++) {
            for (int j = 0; j < cc[i].length; j++) {
                System.out.print(cc[i][j]+" ");
            }
            System.out.println("");
        }
        
        
        int i = cc.length - 1;
        int w = maxW;
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        while (i >= 1 && w >= 1){
            if (cc[i][w] == cc[i - 1][w]){
                i -= 1;
            } else {
                list.insert(ww[i - 1]);
                w -= ww[i - 1];
                i -= 1;
            }
        }
        return list;
    }
    
}