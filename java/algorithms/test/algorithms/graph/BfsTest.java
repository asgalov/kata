/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graph;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gas
 */
public class BfsTest {
    
//    int[][] tmp = {
//            {1,1,1,0,0,0,0,1},
//            {1,1,0,0,0,1,0,0},
//            {1,0,1,0,1,1,1,0},
//            {0,0,0,1,1,0,0,0},
//            {0,0,1,1,1,1,0,0},
//            {0,1,1,0,1,1,0,0},
//            {0,0,1,0,0,0,1,0},
//            {1,0,0,0,0,0,0,1}};
    
    int[][] tmp = {
            {0,1,1,1,0,0,0,0,0,0,1,0,0},
            {1,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,0,0,0,1,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,1,0,0,0,0},
            {0,0,0,0,0,0,0,0,1,0,0,0,1},
            {0,0,0,0,0,0,0,0,1,0,0,0,0},
            {0,0,0,0,0,1,1,1,0,0,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {1,0,0,0,0,0,0,0,1,1,0,1,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,1,0,0,0,0,0,0}};
    
    
    
    @Test
    public void testSearch() {
        int[] dist = Bfs.getDistances(tmp, 1);
        System.out.println("distances to 1 :");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + 1 +" "+dist[i]);
        }
        
    }
    
}
