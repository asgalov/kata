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
    
    private final Graph g;
    
    public BfsTest() {
        int[][] tmp = {
            {1,1,1,0,0,0,0,1},
            {1,1,0,0,0,1,0,0},
            {1,0,1,0,1,1,1,0},
            {0,0,0,0,1,0,0,0},
            {0,0,1,1,0,1,0,0},
            {0,1,1,0,1,0,0,0},
            {0,0,1,0,0,0,0,0},
            {1,0,0,0,0,0,0,0}};
        
        this.g = new Graph(tmp);
    }
    
    @Test
    public void testSearch() {
        System.out.println("search");
        assertEquals(-1, Bfs.search(g, 10));
        assertEquals(-1, Bfs.search(g, 0));
        assertEquals(-1, Bfs.search(g, 11));
        assertEquals(3, Bfs.search(g, 3));
        assertEquals(6, Bfs.search(g, 6));
        assertEquals(5, Bfs.search(g, 5));
        assertEquals(4, Bfs.search(g, 4));
        assertEquals(8, Bfs.search(g, 8));
    }
    
    @Test
    public void testDist() {
        System.out.println("dist");
        assertEquals(-1, Bfs.dist(g, 1, 10));
        assertEquals(3, Bfs.dist(g, 1, 4));
        assertEquals(4, Bfs.dist(g, 8, 4));
        assertEquals(2, Bfs.dist(g, 1, 5));
    }
    
}
