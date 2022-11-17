/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlImplements;

import ModelosD.Partido;
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
public class MySQLPartidoDAOIT {
    
    public MySQLPartidoDAOIT() {
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
     * Test of agregar method, of class MySQLPartidoDAO.
     */
    @Test
    public void testAgregar() throws Exception {
        System.out.println("agregar");
        Partido e = null;
        MySQLPartidoDAO instance = new MySQLPartidoDAO();
        instance.agregar(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class MySQLPartidoDAO.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        Partido e = null;
        MySQLPartidoDAO instance = new MySQLPartidoDAO();
        instance.eliminar(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class MySQLPartidoDAO.
     */
    @Test
    public void testModificar() throws Exception {
        System.out.println("modificar");
        Partido e = null;
        MySQLPartidoDAO instance = new MySQLPartidoDAO();
        instance.modificar(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtener method, of class MySQLPartidoDAO.
     */
    @Test
    public void testObtener() throws Exception {
        System.out.println("obtener");
        Long id = null;
        MySQLPartidoDAO instance = new MySQLPartidoDAO();
        instance.obtener(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodos method, of class MySQLPartidoDAO.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        MySQLPartidoDAO instance = new MySQLPartidoDAO();
        List<Partido> expResult = null;
        List<Partido> result = instance.obtenerTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
