/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.dynamic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gas
 */
public class FibonacciTest {
    
    public FibonacciTest() {
    }
    
    /**
     * Test of fib method, of class Fibonacci.
     */
    @Test
    public void testFib() {
        System.out.println("fib "+Fibonacci.fib(0));
        System.out.println("fib "+Fibonacci.fib(1));
        System.out.println("fib "+Fibonacci.fib(2));
        System.out.println("fib "+Fibonacci.fib(3));
        System.out.println("fib "+Fibonacci.fib(4));
        System.out.println("fib "+Fibonacci.fib(5));
        System.out.println("fib "+Fibonacci.fib(6));
        System.out.println("fib "+Fibonacci.fib(7));
        assertEquals(21, Fibonacci.fib(7));
    }
    
}
