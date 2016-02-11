    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.greedy;

import algorithms.dynamic.LongestSubsequentDynamic;
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
public class LongestSubsequenceGreedyTest {
    
    public LongestSubsequenceGreedyTest() {
    }
    
    /**
     * Test of getLongestStrand method, of class LongestSubsequenceGreedy.
     */
    @Test
    public void testGetLongestStrand() {
        System.out.println("getLongestStrand");
        //ACCGGTCGAGTGCGCGGAAGCCGGCCGAA
        char[] s2 = {'A','C','C','G','G','T','C','G','A','G','T','G','C','G','C',
                'G','G','A','A','G','C','C','G','G','C','C','G','A','A'};
        //GTCGTTCGGAATGCCGTTGCTCTGTAAA
        char[] s1 = {'G','T','C','G','T','T','C','G','G','A','A','T','G','C','C',
            'G','T','T','G','C','T','C','T','G','T','A','A','A'};
        String expResult = "GTCGTCGGAAGCCGGCCGAA";
        //GCGCGGAAGCCGGCCGAA
        String result = LongestSubsequenceGreedy.getLongestStrand(s1, s2);
        System.out.println("exp "+expResult);
        System.out.println("res "+result);
        assertEquals(expResult.length(), result.length());
    }
    
    @Test
    public void testGetLongestCommonSubsequence() {
        System.out.println("getLongestCommonSubsequence");
        char[] s2 = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
        char[] s1 = {'B', 'D', 'C', 'A', 'B', 'A'};
        String s3 = LongestSubsequenceGreedy.getLongestStrand(s1, s2);
        System.out.println(s3);
    }
    
}
