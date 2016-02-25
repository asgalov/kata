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
public class AccountBalance {
    public int processTransactions(int startingBalance, String[] transactions){
         long start = startingBalance;
         for (int i = 0; i < transactions.length; i++){
             String str = transactions[i];
             int tr = Integer.parseInt(str.substring(2, str.length()));
             if (str.charAt(0) == 'C'){
                 start += tr;
             } else {
                 start -= tr;
             }
         }
         return (int) start;
     }    
}
