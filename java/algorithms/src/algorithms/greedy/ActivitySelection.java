/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.greedy;

import algorithms.data.SinglyLinkedList;

/**
 *
 * @author gas
 */
public class ActivitySelection {
    
    public static SinglyLinkedList<Integer> selectIter(int[] ss, int[] ff){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        int a = 0;
        list.insert(a + 1);
        for (int i = 1; i < ff.length; i++) {
            if (ss[i] >= ff[a]){
                a = i;
                list.insert(i + 1);
            }
        }
        return list;
    }
    
    public static SinglyLinkedList<Integer> select(int[] ss, int[] ff){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        greedySelect(list, ss, ff, -1);
        return list;
    }

    private static void greedySelect(SinglyLinkedList<Integer> list, int[] ss, int[] ff, int a) {
        int fa = a == -1 ? 0 : ff[a];
        int nextA = -1;
        int nextF = Integer.MAX_VALUE;
        for (int i = 0; i < ff.length; i++) {
            if (ss[i] >= fa && ff[i] < nextF){
                nextA = i;
                nextF = ff[i];
            }
        }
        
        if (nextA != -1){
            list.insert(nextA + 1);
            greedySelect(list, ss, ff, nextA);
        }
        
    }
}
