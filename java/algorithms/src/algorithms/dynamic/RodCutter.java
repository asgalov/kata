/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.dynamic;

/**
 *
 * @author gas
 */
public class RodCutter {
    
    public static int getCharge(int n, int[] price){
        int[] charges = new int[n];
        for (int i = 0; i < n; i++) {
            int max = price[i];
            for (int j = 1; j <= (i + 1)/2.0; j++) {
                int c = charges[i - j] + charges[j - 1];
                max = c > max ? c : max;
            }
            charges[i] = max;
        }
        return charges[n - 1];
    }

}