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
public class SCCTest {
    
    public SCCTest() {
    }

    /**
     * Test of getStartTimes method, of class SCC.
     */
    @Test
    public void testGetStartTimes() {
        int[][] matrix = {
            {0,1,0,0,0,0,0,0},
            {0,0,1,0,1,1,0,0},
            {0,0,0,1,0,0,1,0},
            {0,0,1,0,0,0,0,1},
            {1,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,1,0},
            {0,0,0,0,0,1,0,1},
            {0,0,0,0,0,0,0,1}};
        
        SCC scc = new SCC(matrix);
        System.out.println("dfs start times: "+Utils.toString(scc.getStartTimes()));
        System.out.println("dfs finish times: "+Utils.toString(scc.getFinishTimes()));
    }
    
}