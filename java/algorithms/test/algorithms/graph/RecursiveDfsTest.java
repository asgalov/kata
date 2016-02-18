/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graph;

import algorithms.utils.Utils;
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
public class RecursiveDfsTest {
    
    public RecursiveDfsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testGetStartTimes() {
        int[][] matrix = {
            {0,1,0,1,0,0},
            {0,0,0,0,1,0},
            {0,0,0,0,1,1},
            {0,1,0,0,0,0},
            {0,0,0,1,0,0},
            {0,0,0,0,0,1}};
        
        RecursiveDfs instance = new RecursiveDfs(matrix);
        System.out.println("dfs start times: "+Utils.toString(instance.getStartTimes()));
        System.out.println("dfs finish times: "+Utils.toString(instance.getFinishTimes()));
//        assertArrayEquals(expResult, result);
    }

    
}
