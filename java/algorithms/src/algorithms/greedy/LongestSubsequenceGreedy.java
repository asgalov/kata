/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.greedy;

/**
 *
 * @author gas
 */
public class LongestSubsequenceGreedy {

    public static String getLongestStrand(char[] s1, char[] s2){
        assert s1.length < s2.length;
        String maxStr = "";
        for (int s = 0; s < s1.length; s++) {
            String str = "";
            int i = s;
            int j = 0;
            while (i < s1.length && j < s2.length){
                boolean found = false;
                int startJ = j;
                while (!found && j < s2.length){
                    if (s2[j] == s1[i]){
                        str += s2[j];
                        found = true;
                    }
                    j++;
                }
                if (!found){
                    j = startJ;
                }
                i++;    
            }
            if (str.length() > maxStr.length()){
                maxStr = str;
            }
        }
        return maxStr;
    }
}
