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
public class LongestSubsequentDynamic {

    public static String getLongestStrand(char[] s1, char[] s2){
        String maxStr = "";
        int i = 0;
        for (int s = s2.length - 1; s >= 0 ; s--) {
            String str = "";
            i = s;
            int j = s1.length - 1;
            while (i >= 0 && j >= 0){
                boolean found = false;
                while (!found && j >= 0){
                    if (s2[i] == s1[j]){
                        str += s2[i];
                        found = true;
                    }
                    j--;
                }
                i--;
            }
            System.out.println("str "+str);
            if (str.length() > maxStr.length()){
                maxStr = str;
            }
        }
        
        return maxStr;
    }
}
