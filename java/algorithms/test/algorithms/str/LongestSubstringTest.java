/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.str;

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
public class LongestSubstringTest {
    
    public LongestSubstringTest() {
    }
    
    @Test
    public void testGetLongestCommonSubsequence1() {
        System.out.println("getLongestCommonSubsequence");
        char[] str1 = {'A','A','B','A','B','B','A','B'};
        char[] str2 = {'B','A','B','B','A','A','A','A','A','A'};
        String expResult = "BABBA";
        String result = LongestSubstring.getLongestCommonSubsequence(str1, str2);
        System.out.println("RESULT: "+result);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLongestCommonSubsequence() {
        System.out.println("getLongestCommonSubsequence");
        char[] str1 = {'G','T','C','G','T','T','C','C','C','G'};
        char[] str2 = {'A','C','C','G','T','T','C','C','C','G','T','G','C','G',
            'C','G','G','A','A','G','C','C','G','G','C','C','G','A','A'};
        String expResult = "CGTTCCCG";
        String result = LongestSubstring.getLongestCommonSubsequence(str1, str2);
        System.out.println("RESULT: "+result);
        assertEquals(expResult, result);
    }
    
}
