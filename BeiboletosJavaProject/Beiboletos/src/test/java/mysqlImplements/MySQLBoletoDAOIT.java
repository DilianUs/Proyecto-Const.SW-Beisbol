/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlImplements;

import ModelosD.Boleto;
import java.util.List;
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
public class MySQLBoletoDAOIT {
    
    public MySQLBoletoDAOIT() {
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
     * Test of agregar method, of class MySQLBoletoDAO.
     */
    @Test
    public void testAgregar() throws Exception {
        System.out.println("agregar");
        Boleto e = null;
        MySQLBoletoDAO instance = new MySQLBoletoDAO();
        instance.agregar(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class MySQLBoletoDAO.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        Boleto e = null;
        MySQLBoletoDAO instance = new MySQLBoletoDAO();
        instance.eliminar(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class MySQLBoletoDAO.
     */
    @Test
    public void testModificar() throws Exception {
        System.out.println("modificar");
        Boleto e = null;
        MySQLBoletoDAO instance = new MySQLBoletoDAO();
        instance.modificar(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtener method, of class MySQLBoletoDAO.
     */
    @Test
    public void testObtener() throws Exception {
        System.out.println("obtener");
        Long id = null;
        MySQLBoletoDAO instance = new MySQLBoletoDAO();
        instance.obtener(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodos method, of class MySQLBoletoDAO.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        MySQLBoletoDAO instance = new MySQLBoletoDAO();
        List<Boleto> expResult = null;
        List<Boleto> result = instance.obtenerTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
