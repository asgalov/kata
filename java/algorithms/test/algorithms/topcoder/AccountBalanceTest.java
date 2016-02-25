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
public class AccountBalanceTest {
    
    public AccountBalanceTest() {
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
     * Test of processTransactions method, of class AccountBalance.
     */
    @Test
    public void testProcessTransactions() {
        System.out.println("processTransactions");
        String[] transactions = {"C 1000", "D 500", "D 350"};
        AccountBalance balance = new AccountBalance();
        System.out.println(balance.processTransactions(100, transactions));
        
    }
    
}
