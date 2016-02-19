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
public class TopologicalSortTest {
    
    public TopologicalSortTest() {
    }

    @Test
    public void testSomeMethod() {
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
        
        TopologicalSortDfs sort = new TopologicalSortDfs(matrix);
        System.out.println("topological sort: " + Utils.toString(sort.sort()));
    }
    
}
