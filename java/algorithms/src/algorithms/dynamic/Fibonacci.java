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
public class Fibonacci {
    
    public static int fib(int n){
        int f1 = 1;
        int f2 = 1;
        int f = 1;
        for (int i = 1; i < n; i++) {
            f = f2 + f1;
            f2 = f1;
            f1 = f;
        }
        return f;
    }
    
}
