/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.graph;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author gas
 */
public class TreeDiameterCalculatorTest {
    
    public TreeDiameterCalculatorTest() {
    }
    
    /**
     * Test of getDiameter method, of class TreeDiameterCalculator.
     */
    @Test
    public void testGetDiameter() {
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
    
        int diameter = TreeDiameterCalculator.getDiameter(tmp);
        System.out.println("tree diameter: "+diameter);
        assert diameter == 6;
    }

}
