/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.utils;

/**
 *
 * @author gas
 */
public class Utils {
    
    public static String toString(int[] arr){
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i]+ " ";
        }    
        return s;
    }
    
}
