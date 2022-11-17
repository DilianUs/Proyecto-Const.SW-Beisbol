/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosD;

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
public class EquipoIT {
    
    public EquipoIT() {
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
     * Test of getClaveEquipo method, of class Equipo.
     */
    @Test
    public void testGetClaveEquipo() {
        System.out.println("getClaveEquipo");
        Equipo instance = null;
        String expResult = "";
        String result = instance.getClaveEquipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreEquipo method, of class Equipo.
     */
    @Test
    public void testGetNombreEquipo() {
        System.out.println("getNombreEquipo");
        Equipo instance = null;
        String expResult = "";
        String result = instance.getNombreEquipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreEquipo method, of class Equipo.
     */
    @Test
    public void testSetNombreEquipo() {
        System.out.println("setNombreEquipo");
        String nombreEquipo = "";
        Equipo instance = null;
        instance.setNombreEquipo(nombreEquipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClaveEquipo method, of class Equipo.
     */
    @Test
    public void testSetClaveEquipo() {
        System.out.println("setClaveEquipo");
        String claveEquipo = "";
        Equipo instance = null;
        instance.setClaveEquipo(claveEquipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Equipo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Equipo instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
