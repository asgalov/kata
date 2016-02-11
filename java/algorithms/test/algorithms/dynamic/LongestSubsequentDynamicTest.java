/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.dynamic;

import algorithms.greedy.LongestSubsequenceGreedy;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author gas
 */
public class LongestSubsequentDynamicTest {
    
    public LongestSubsequentDynamicTest() {
    }
    
    @Test
    public void testGetLongestCommonSubsequence() {
        System.out.println("getLongestCommonSubsequence");
        char[] s1 = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
        char[] s2 = {'B', 'D', 'C', 'A', 'B', 'A'};
        char[] s4 = {'B', 'C', 'B', 'A'};
        String s3 = LongestSubsequentDynamic.getLongestStrand(s1, s2);
        System.out.println(s3);
    }
    
//    @Test
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
        String result = LongestSubsequentDynamic.getLongestStrand(s1, s2);
        System.out.println("exp "+expResult);
        System.out.println("res "+result);
        assertEquals(expResult.length(), result.length());
    }
    
}
