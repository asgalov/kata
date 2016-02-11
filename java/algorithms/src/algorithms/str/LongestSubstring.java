/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.str;

/**
 *
 * @author gas
 */
public class LongestSubstring {
    public static String getLongestCommonSubsequence(char[] str1, char[] str2){
        assert str1.length <= str2.length;
        String str = "";
        String maxStr = "";
        int s1 = str1.length - 1;
        int len = 1;
        for (int s2 = 0; s2 < str2.length; s2++) {
            while (s1 > 0){
                str = getMaxStr(str1, str2, s1, s2, len);
                if (str.length() > maxStr.length()){
                    maxStr = str;
                }
                s1 -= 1;
                len += 1;
            }
            
            if (s2 > (str2.length - str1.length)){
                len -= 1;
            }

            str = getMaxStr(str1, str2, s1, s2, len);
            if (str.length() > maxStr.length()){
                maxStr = str;
            }
        }
        return maxStr;
    }

    private static String getMaxStr(char[] str1, char[] str2, int s1, int s2, int len) {
        String str = "";
        String maxStr = "";
        for (int i = 0; i < len; i++) {
            int diff = str1[s1 + i] == str2[s2 + i] ? 1 : 0;
            if (diff == 1){
                str += str1[s1 + i];
                if (str.length() > maxStr.length()){
                    maxStr = str;
                }
            } else{
                str = "";
            }
        }     
//        System.out.println("max s1 "+s1+" s2 "+s2+" len "+len+" str "+str);
        return maxStr;
    }
    
}
