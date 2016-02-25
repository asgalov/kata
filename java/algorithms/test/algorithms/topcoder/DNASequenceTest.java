/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.topcoder;

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
public class DNASequenceTest {
    
    public DNASequenceTest() {
    }

    /**
     * Test of longestDNASequence method, of class DNASequence.
     */
    @Test
    public void testLongestDNASequence() {
        System.out.println("longestDNASequence");
        DNASequence instance = new DNASequence();
        assertEquals(2, instance.longestDNASequence("TOPBOATER"));
        assertEquals(0, instance.longestDNASequence("SUSHI"));
        assertEquals(7, instance.longestDNASequence("GATTACA"));
        assertEquals(1, instance.longestDNASequence("GOODLUCK"));
        assertEquals(6, instance.longestDNASequence("VVZWKCSIQEGANULDLZESHUYHUQGRKUMFCGTATGOHMLKBIRCA"));
    }
    
}
