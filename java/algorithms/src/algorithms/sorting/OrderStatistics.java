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
public class OrderStatistics {

    public static int getKthMax(int[] arr, int k){
        int p = arr.length - 1;
        int l = 0;
        int left = -1;
        
        while (left != k){
            left = l;
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
            
            if (left < k){
                l = left + 1;
            } 
            
            if (left > k) {
                p = left - 1;
            }
        }
        
        return arr[left];
    }
    
}