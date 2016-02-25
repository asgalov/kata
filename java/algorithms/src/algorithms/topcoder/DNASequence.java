/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.topcoder;

/**
 *
 * @author gas
 */
public class DNASequence {
    
    //A, C, G, and T       
    public int longestDNASequence(String sequence) {
        int cnt = 0;
        int maxLen = 0;
        for (int i = 0; i < sequence.length(); i++) {
            char c = sequence.charAt(i);
            if (c == 'A' || c == 'C'  || c == 'G' || c == 'T'){
                cnt ++;
                if (maxLen < cnt){
                    maxLen = cnt;
                }
            } else{
                cnt = 0;
            }
        }
        return maxLen;
    }
    
}