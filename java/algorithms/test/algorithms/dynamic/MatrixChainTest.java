/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.dynamic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gas
 */
public class MatrixChainTest {
    
    public MatrixChainTest() {
    }
    
    @Test
    public void testParenthesized() {
        System.out.println("parenthesized");
        int[] pp = {30,35,15,5,10,20,25};
        MatrixChain.parenthesized(pp);
    }
    
}
