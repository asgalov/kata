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
public class MatrixChain {
    
    public static void parenthesized(int[] p){
        int[][] m = new int[p.length][p.length];
        int[][] s = new int[p.length][p.length];

        for (int len = 2; len < m.length; len++) {
            for (int i = 0; i < m.length - len; i++) {
                int split = 0;
                int minSum = Integer.MAX_VALUE;
                for (int k = i + 1; k < i + len; k++) {
                    int j = i + len;
                    int join = p[i]*p[k]*p[j];
                    int weight = m[i][k - 1] + m[k][j - 1];
                    int sum = weight + join;
                    System.out.println(" len "+len+" i "+i+" k "+k+" j "+j+" join "+p[i]+"x"+p[k]+"x"+p[j]+"="+join+
                            " weight "+m[i][k - 1]+"+"+m[k][j - 1]+" sum="+sum);
                    if (sum < minSum){
                        minSum = sum;
                        split = k;
                    }
                }
                
                m[i][i + len - 1] = minSum;
                s[i][i + len - 1] = split;
            }
            System.out.println("len = "+len);
            print(m, s);
            
        }
        print(m, s);
    }

    
    
    
    private static void print(int[][] m, int[][] s) {
        System.out.println("mm:");
        for (int i = 0; i < m.length; i++) {
            System.out.println("");
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j]+" ");
            }
        }
        System.out.println("");
        System.out.println("ss:");
        for (int i = 0; i < s.length; i++) {
            System.out.println("");
            for (int j = 0; j < s.length; j++) {
                System.out.print(s[i][j]+" ");
            }
        }

    }

}