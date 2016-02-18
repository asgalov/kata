/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graph;

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
public class GraphUtilsTest {
    
    public GraphUtilsTest() {
    }

    
    @Test
    public void testAdjUndir() {
        int[][] tmp = {
            {1,1,1,0,0,0,0,1},
            {1,1,0,0,0,1,0,0},
            {1,0,1,0,1,1,1,0},
            {0,0,0,1,1,0,0,0},
            {0,0,1,1,1,1,0,0},
            {0,1,1,0,1,1,0,0},
            {0,0,1,0,0,0,1,0},
            {1,0,0,0,0,0,0,1}};

        int[] adj = GraphUtils.getAdj(tmp, 3);
        System.out.println("adjacent to 3 :");
        for (int i = 0; i < adj.length; i++) {
            System.out.print(" "+adj[i]);
        }
        System.out.println("");
    }
    
        
    @Test
    public void testAdjDir() {
        int[][] matrix = {
            {0,1,0,1,0,0},
            {0,0,0,0,1,0},
            {0,0,0,0,1,1},
            {0,1,0,0,0,0},
            {0,0,0,1,0,0},
            {0,0,0,0,0,1}};
        
        int[] adj = GraphUtils.getAdj(matrix, 3);
        System.out.println("adjacent to 3 :");
        for (int i = 0; i < adj.length; i++) {
            System.out.print(" "+adj[i]);
        }
        System.out.println("");
    }
    
}
