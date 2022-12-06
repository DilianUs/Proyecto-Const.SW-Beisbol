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

    Boleto boletoPrueba = null;
    Boleto boletoDeBDD = null;
    MySQLBoletoDAO boletoDAO = new MySQLBoletoDAO();

    @Before
    public void crearBoleto() {
        System.out.println("Se esta creando el nuevo boleto de prueba");
        int claveBoleto = 777;
        int clavePartido = 1111;
        if (boletoPrueba == null) {
            boletoPrueba = new Boleto();
            boletoPrueba.setClvBoleto(claveBoleto);
            boletoPrueba.setClvPartido(clavePartido);
        }

    }

    @Test
    public void testAgregar() throws Exception {
        System.out.println("Prueba de agregacion a la base de datos");
        System.out.println("Se intentara agregar un boleto con los siguientes datos");
        System.out.println(boletoPrueba.toString());

        boletoDAO.agregar(boletoPrueba);
        System.out.println("Se agrego a la base de datos");
        System.out.println("Recuperando elemento de la base de datos para comparar resultados");

        int claveB = boletoPrueba.getClvBoleto();
        boletoDeBDD = boletoDAO.obtener(claveB);
        assertEquals(boletoPrueba.getClvBoleto(), boletoDeBDD.getClvBoleto());

        System.out.println("Teste realizado con exito:");
        System.out.println("Original: " + boletoPrueba.toString());
        System.out.println("Obtenido de la BD:" + boletoDeBDD.toString());
        System.out.println("Eliminando de la base de datos para no alterarla \n");
        boletoDAO.eliminar(boletoPrueba);
    }

    /**
     * Test of eliminar method, of class MySQLBoletoDAO.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("Prueba de eliminacion a la base de datos");
        System.out.println("Agreando equipo a la BD");
        boletoDAO.agregar(boletoPrueba);

        System.out.println("Verificando que se pudo agregar");
        int claveB = boletoPrueba.getClvBoleto();
        boletoDeBDD = boletoDAO.obtener(claveB);
        System.out.println("boleto en base de datos" + boletoDeBDD.toString());

        System.out.println("Eliminado de la base de datos");
        boletoDAO.eliminar(boletoPrueba);

        System.out.println("Recuperando elemento para verificacion");
        boletoDeBDD = boletoDAO.obtener(claveB);
        assertEquals(null, boletoDeBDD);
        System.out.println("Se elemino de forma exitosa \n");
    }

    /**
     * Test of modificar method, of class MySQLBoletoDAO.
     */
    @Test
    public void testModificar() throws Exception {
        System.out.println("Prueba de modificacion/edicion a la base de datos");
        System.out.println("Agregando boleto a la BD");
        boletoDAO.agregar(boletoPrueba);

        System.out.println("Verificando que se pudo agregar");
        int claveB = boletoPrueba.getClvBoleto();
        boletoDeBDD = boletoDAO.obtener(claveB);
        System.out.println("boleto en base de datos" + boletoDeBDD.toString());

        System.out.println("Intentando modificar los datos");
        int nuevaClavePartido = 2222;
        System.out.println("Cambiando clave del partido a " + nuevaClavePartido);
        boletoPrueba.setClvPartido(nuevaClavePartido);
        boletoDAO.modificar(boletoPrueba);

        System.out.println("Verificando la modificacion");
        boletoDeBDD = boletoDAO.obtener(claveB);
        assertEquals(nuevaClavePartido, boletoDeBDD.getClvPartido());

        System.out.println("Se hizo la modificacion correctamente");
        System.out.println("Antiguo: Boleto{claveBoleto= 777, clavePartido=1111 }");
        System.out.println("Modificado: " + boletoDeBDD.toString());

        System.out.println("Eliminando de la base de datos para no alterarla \n");
        boletoDAO.eliminar(boletoPrueba);
    }

    /**
     * Test of obtener method, of class MySQLBoletoDAO.
     */
    @Test
    public void testObtener() throws Exception {
        System.out.println("Prueba de obtencion a la base de datos");
        System.out.println("Agregando boleto a la BD");
        boletoDAO.agregar(boletoPrueba);
        
        System.out.println("Recuperando elemento de la base de datos para comparar resultados");
        int claveB = boletoPrueba.getClvBoleto();
        boletoDeBDD=boletoDAO.obtener(claveB);
        
        assertEquals(boletoPrueba.getClvBoleto(), boletoDeBDD.getClvBoleto());
        System.out.println("Test realizado con exito:");
        System.out.println("Original: "+boletoPrueba.toString());
        System.out.println("Obtenido de la BD:"+boletoDeBDD.toString());
        System.out.println("Eliminando de la base de datos para no alterarla \n");
        boletoDAO.eliminar(boletoPrueba);
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
