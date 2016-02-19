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
public class DfsTest {
    
    public DfsTest() {
    }

//    @Test
    public void testGetStartTimes() {
        int[][] matrix = {
            {0,1,0,1,0,0},
            {0,0,0,0,1,0},
            {0,0,0,0,1,1},
            {0,1,0,0,0,0},
            {0,0,0,1,0,0},
            {0,0,0,0,0,1}};
        
        Dfs instance = new Dfs(matrix);
        System.out.println("dfs start times: "+Utils.toString(instance.getStartTimes()));
        System.out.println("dfs finish times: "+Utils.toString(instance.getFinishTimes()));
//        assertArrayEquals(expResult, result);
    }


    @Test
    public void testDfs() {
        int[][] matrix = {
            {0,0,0,0,0,0,0,1,1},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0},
            {1,0,0,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,1,0},
            {0,0,0,1,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0}};
        
        Dfs instance = new Dfs(matrix);
        System.out.println("dfs start times: "+Utils.toString(instance.getStartTimes()));
        System.out.println("dfs finish times: "+Utils.toString(instance.getFinishTimes()));
//        assertArrayEquals(expResult, result);
    }

    
}