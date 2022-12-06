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
    
    Partido partidoPrueba = null;
    Partido partidoDeBDD = null;
    MySQLPartidoDAO partidoDAO = new MySQLPartidoDAO();

    @Before
    public void crearPartido() {
        System.out.println("Se esta creando el nuevo partido de prueba");
        int clavePartido = 1111;
        String lugar = "Mérida";
        int equipoUno = 123;
        int equipoDos = 345;
        int hora = 12;
        int dia = 6;
        int mes = 12;
        if (partidoPrueba == null) {
            partidoPrueba = new Partido();
            partidoPrueba.setClvPartido(clavePartido);
            partidoPrueba.setLugar(lugar);
            partidoPrueba.setEquipo_Uno(equipoUno);
            partidoPrueba.setEquipo_Dos(equipoDos);
            partidoPrueba.setHora(hora);
            partidoPrueba.setDia(dia);
            partidoPrueba.setMes(mes);
        }

    }

    /**
     * Test of agregar method, of class MySQLPartidoDAO.
     */
    @Test
    public void testAgregar() throws Exception {
        System.out.println("Prueba de agregacion a la base de datos");
        System.out.println("Se intentara agregar un partido con los siguientes datos");
        System.out.println(partidoPrueba.toString());

        partidoDAO.agregar(partidoPrueba);
        System.out.println("Se agrego a la base de datos");
        System.out.println("Recuperando elemento de la base de datos para comparar resultados");

        int claveP = partidoPrueba.getClvPartido();
        partidoDeBDD = partidoDAO.obtener(claveP);
        assertEquals(partidoPrueba.getClvPartido(), partidoDeBDD.getClvPartido());

        System.out.println("Test realizado con exito:");
        System.out.println("Original: " + partidoPrueba.toString());
        System.out.println("Obtenido de la BD:" + partidoDeBDD.toString());
        System.out.println("Eliminando de la base de datos para no alterarla \n");
        partidoDAO.eliminar(partidoPrueba);
    }

    /**
     * Test of eliminar method, of class MySQLPartidoDAO.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("Prueba de eliminacion a la base de datos");
        System.out.println("Agreando partido a la BD");
        partidoDAO.agregar(partidoPrueba);

        System.out.println("Verificando que se pudo agregar");
        int claveP = partidoPrueba.getClvPartido();
        partidoDeBDD = partidoDAO.obtener(claveP);
        System.out.println("partido en base de datos" + partidoDeBDD.toString());

        System.out.println("Eliminado de la base de datos");
        partidoDAO.eliminar(partidoPrueba);

        System.out.println("Recuperando elemento para verificacion");
        partidoDeBDD = partidoDAO.obtener(claveP);
        assertEquals(null, partidoDeBDD);
        System.out.println("Se elemino de forma exitosa \n");
    }

    /**
     * Test of modificar method, of class MySQLPartidoDAO.
     */
    @Test
    public void testModificar() throws Exception {
        System.out.println("Prueba de modificacion/edicion a la base de datos");
        System.out.println("Agregando partido a la BD");
        partidoDAO.agregar(partidoPrueba);

        System.out.println("Verificando que se pudo agregar");
        int claveP = partidoPrueba.getClvPartido();
        partidoDeBDD = partidoDAO.obtener(claveP);
        System.out.println("partido en base de datos" + partidoDeBDD.toString());

        System.out.println("Intentando modificar los datos");
        String nuevoLugarPartido = "Campeche";
        System.out.println("Cambiando lugar del partido a " + nuevoLugarPartido);
        partidoPrueba.setLugar(nuevoLugarPartido);
        partidoDAO.modificar(partidoPrueba);

        System.out.println("Verificando la modificacion");
        partidoDeBDD = partidoDAO.obtener(claveP);
        assertEquals(nuevoLugarPartido, partidoDeBDD.getLugar());

        System.out.println("Se hizo la modificacion correctamente");
        System.out.println("Antiguo: Partido{clavePartido= 1111, lugar=Mérida, equipoUno=123, equipoDos=345, hora=12, dia=6, mes=12 }");
        System.out.println("Modificado: " + partidoDeBDD.toString());

        System.out.println("Eliminando de la base de datos para no alterarla \n");
        partidoDAO.eliminar(partidoPrueba);
    }

    /**
     * Test of obtener method, of class MySQLPartidoDAO.
     */
    @Test
    public void testObtener() throws Exception {
        System.out.println("Prueba de obtencion a la base de datos");
        System.out.println("Agregando partido a la BD");
        partidoDAO.agregar(partidoPrueba);
        
        System.out.println("Recuperando elemento de la base de datos para comparar resultados");
        int claveP = partidoPrueba.getClvPartido();
        partidoDeBDD=partidoDAO.obtener(claveP);
        
        assertEquals(partidoPrueba.getClvPartido(), partidoDeBDD.getClvPartido());
        System.out.println("Test realizado con exito:");
        System.out.println("Original: "+partidoPrueba.toString());
        System.out.println("Obtenido de la BD:"+partidoDeBDD.toString());
        System.out.println("Eliminando de la base de datos para no alterarla \n");
        partidoDAO.eliminar(partidoPrueba);
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
