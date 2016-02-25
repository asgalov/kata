/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.topcoder;

import algorithms.utils.Utils;

/**
 *
 * @author gas
 */
public class ANewHope {
    
    public int count(int[] firstWeek, int[] lastWeek, int D){
        int N = firstWeek.length;
        int[] firstIndexes = new int[firstWeek.length];
        int[] lastIndexes = new int[firstWeek.length];
        for (int i = 0; i < firstWeek.length; i++) {
            firstIndexes[firstWeek[i] - 1] = i;
            lastIndexes[lastWeek[i] - 1] = i;
        }
        
        int maxWeeks = 0;
        for (int i = 0; i < firstWeek.length; i++) {
            int index = firstIndexes[firstWeek[i] - 1];
            int lastIndex = lastIndexes[firstWeek[i] - 1];
            int weeks = 0;
            while (index > lastIndex){
                index = index + D;
                if (index >= N){
                    index -= N;
                    weeks ++;
                }
            }

            
            if (maxWeeks < weeks){
                maxWeeks = weeks;
            }
        }

        return maxWeeks + 1;
    }
}
