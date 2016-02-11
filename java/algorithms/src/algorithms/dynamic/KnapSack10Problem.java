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
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        select(list, ww, vv, maxW);
        list.reverse();
        return list;
    }

    private static void select(SinglyLinkedList<Integer> list, int[] ww, int[] vv, int maxW) {
        if (maxW <= 0){
            return;
        }
        
        double maxRv = 0;
        int maxI = -1;
        for (int i = 0; i < ww.length; i++) {
            double rv = (1.0*vv[i]/(1.0*ww[i]));
            int n = (maxW/ww[i]);
            if (ww[i] * rv * n > maxRv){
                maxRv = ww[i] * rv * n;
                maxI = i;
            }
        }
        list.insert(ww[maxI]);
        select(list, ww, vv, maxW - ww[maxI]*((int)(maxW/ww[maxI])));
    }
    
}
