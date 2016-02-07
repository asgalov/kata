/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.sorting;

/**
 *
 * @author gas
 */
public class QuickSort {
    
    public static int[] sort(int[] arr, int l, int p){
        if (l >= p){
            return arr;
        }
        
        int left = l;
        for (int right = l + 1; right <= p; right++) {
            if (arr[left] <= arr[p]){
                left ++;
            }

            if (arr[right] <= arr[p]){
                int tmp = arr[right];
                arr[right] = arr[left];
                arr[left] = tmp;
            }
        }
        
        arr = sort(arr, l, left - 1);
        arr = sort(arr, left + 1, p);
        return arr;
    }
    
}