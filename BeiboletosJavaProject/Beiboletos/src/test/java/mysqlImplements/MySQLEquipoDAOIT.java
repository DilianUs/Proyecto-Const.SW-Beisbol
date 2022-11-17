/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlImplements;

import ModelosD.Equipo;
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
public class MySQLEquipoDAOIT {
    
    public MySQLEquipoDAOIT() {
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
     * Test of agregar method, of class MySQLEquipoDAO.
     */
    @Test
    public void testAgregar() throws Exception {
        System.out.println("agregar");
        Equipo e = null;
        MySQLEquipoDAO instance = new MySQLEquipoDAO();
        instance.agregar(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class MySQLEquipoDAO.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        Equipo e = null;
        MySQLEquipoDAO instance = new MySQLEquipoDAO();
        instance.eliminar(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class MySQLEquipoDAO.
     */
    @Test
    public void testModificar() throws Exception {
        System.out.println("modificar");
        Equipo e = null;
        MySQLEquipoDAO instance = new MySQLEquipoDAO();
        instance.modificar(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtener method, of class MySQLEquipoDAO.
     */
    @Test
    public void testObtener() {
        System.out.println("obtener");
        Long id = null;
        MySQLEquipoDAO instance = new MySQLEquipoDAO();
        instance.obtener(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodos method, of class MySQLEquipoDAO.
     */
    @Test
    public void testObtenerTodos() {
        System.out.println("obtenerTodos");
        MySQLEquipoDAO instance = new MySQLEquipoDAO();
        List<Equipo> expResult = null;
        List<Equipo> result = instance.obtenerTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
