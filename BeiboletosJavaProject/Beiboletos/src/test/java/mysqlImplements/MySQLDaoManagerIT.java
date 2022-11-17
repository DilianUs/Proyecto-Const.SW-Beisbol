/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlImplements;

import ModelosDAO.BoletoDAO;
import ModelosDAO.EquipoDAO;
import ModelosDAO.PartidoDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bryan
 */
public class MySQLDaoManagerIT {
    
    public MySQLDaoManagerIT() {
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
     * Test of getEquipoDAO method, of class MySQLDaoManager.
     */
    @Test
    public void testGetEquipoDAO() {
        System.out.println("getEquipoDAO");
        MySQLDaoManager instance = new MySQLDaoManager();
        EquipoDAO expResult = null;
        EquipoDAO result = instance.getEquipoDAO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPartidoDAO method, of class MySQLDaoManager.
     */
    @Test
    public void testGetPartidoDAO() {
        System.out.println("getPartidoDAO");
        MySQLDaoManager instance = new MySQLDaoManager();
        PartidoDAO expResult = null;
        PartidoDAO result = instance.getPartidoDAO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoletoDAO method, of class MySQLDaoManager.
     */
    @Test
    public void testGetBoletoDAO() {
        System.out.println("getBoletoDAO");
        MySQLDaoManager instance = new MySQLDaoManager();
        BoletoDAO expResult = null;
        BoletoDAO result = instance.getBoletoDAO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
