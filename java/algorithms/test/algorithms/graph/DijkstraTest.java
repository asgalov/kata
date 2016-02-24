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
public class DijkstraTest {
    
    public DijkstraTest() {
    }
    
    /**
     * Test of getShortestPaths method, of class Dijikstra.
     */
    @Test
    public void testGetShortestPaths() {
        int[][] matrix = {
            {0,10, 0, 0, 5},
            {0, 0, 1, 0, 2},
            {0, 0, 0, 4, 0},
            {7, 0, 6, 0, 0},
            {0, 3, 9, 2, 0}};
        
        int s = 1;
        int[] expResult = {0, 8, 9, 7, 5};
        int[] result = Dijkstra.getShortestPaths(matrix, s);
        System.out.println("expected paths: "+Utils.toString(expResult));
        System.out.println("shortest paths: "+Utils.toString(result));
        assertArrayEquals(expResult, result);
    }
    
}
