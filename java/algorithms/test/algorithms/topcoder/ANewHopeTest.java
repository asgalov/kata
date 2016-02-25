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
public class ANewHopeTest {
    
    public ANewHopeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of count method, of class ANewHope.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        ANewHope instance = new ANewHope();
        int[] firstWeek1 = {1,2,3,4};
        int[] lastWeek1 = {4,3,2,1};
        int d1 = 3;
        assertEquals(4, instance.count(firstWeek1, lastWeek1, d1));        
        
        int[] firstWeek2 = {8,5,4,1,7,6,3,2};
        int[] lastWeek2 = {2,4,6,8,1,3,5,7};
        int d2 = 3;
        assertEquals(3, instance.count(firstWeek2, lastWeek2, d2));        
        
        int[] firstWeek3 = {1,2,3,4};
        int[] lastWeek3 = {1,2,3,4};
        int d3 = 2;
        assertEquals(1, instance.count(firstWeek3, lastWeek3, d3));        
    }
    
}
