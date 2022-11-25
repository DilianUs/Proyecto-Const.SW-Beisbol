/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package mysqlImplements;
import ModelosD.Equipo;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author braul
 */
public class MySQLEquipoDAOTest {

    Equipo equipoPrueba = null;
    Equipo equipoDeBDD=null;
 MySQLEquipoDAO equipoDAO = new MySQLEquipoDAO();
    @Before
    public void crearEquipo(){
        System.out.println("Se esta creando el nuevo equipo de prueba");
        int claveEquipo=777;
        String nombreEquipo="Diablos";
        if(equipoPrueba==null){
           equipoPrueba = new Equipo(claveEquipo, nombreEquipo); 
        }
        
    }
    /**
     * Test of agregar method, of class MySQLEquipoDAO.
     */
    @Test
    public void testAgregar() throws Exception {
        
        System.out.println("Prueba de agregacion a la base de datos");
        System.out.println("Se intentara agregar un equipo con los siguientes datos");
        System.out.println(equipoPrueba.toString());
        
        
        equipoDAO.agregar(equipoPrueba);
        System.out.println("Se agrego a la base de datos");
        System.out.println("Recuperando elemento de la base de datos para comprar resultados");
        
        int clave = equipoPrueba.getClaveEquipo();
        equipoDeBDD=equipoDAO.obtener(clave);
        assertEquals(equipoPrueba.getClaveEquipo(), equipoDeBDD.getClaveEquipo());
        
        System.out.println("Teste realizado con exito:");
        System.out.println("Original: "+equipoPrueba.toString());
        System.out.println("Obtenido de la BD:"+equipoDeBDD.toString());
        System.out.println("Eliminando de la base de datos para no alterarla \n");
        equipoDAO.eliminar(equipoPrueba);
        
        
    }

    
    @Test
    public void testEliminar() throws Exception {
         
      System.out.println("Prueba de eliminacion a la base de datos");
        System.out.println("Agreando equipo a la BD");
       equipoDAO.agregar(equipoPrueba);
       
        System.out.println("Verificando que se pudo agregar");
        int clave = equipoPrueba.getClaveEquipo();
        equipoDeBDD=equipoDAO.obtener(clave);
        System.out.println("equipo en base de datos"+equipoDeBDD.toString());
        
        System.out.println("Eliminado de la base de datos");
        equipoDAO.eliminar(equipoPrueba);
        
        System.out.println("Recuperando elemento para verificacion");
        equipoDeBDD = equipoDAO.obtener(clave);
        assertEquals(null, equipoDeBDD);
        System.out.println("Se elemino de forma exitosa \n");
    }

  
    @Test
    public void testModificar() throws Exception {
        System.out.println("Prueba de modificacion/edicion a la base de datos");
        System.out.println("Agreando equipo a la BD");
        equipoDAO.agregar(equipoPrueba);
       
        System.out.println("Verificando que se pudo agregar");
        int clave = equipoPrueba.getClaveEquipo();
        equipoDeBDD=equipoDAO.obtener(clave);
        System.out.println("equipo en base de datos"+equipoDeBDD.toString());
        
        System.out.println("Intentando modificar los datos");
        String nuevoNombreEquipo = "Zapateros";
        System.out.println("Cambiando nombre a "+nuevoNombreEquipo);
        equipoPrueba.setNombreEquipo(nuevoNombreEquipo);
        equipoDAO.modificar(equipoPrueba);
        
        System.out.println("Verificando la modificacion");
        equipoDeBDD=equipoDAO.obtener(clave);
        assertEquals(nuevoNombreEquipo, equipoDeBDD.getNombreEquipo());
        
        System.out.println("Se hizo la modificacion correctamente");
        System.out.println("Antiguo: Equipo{claveEquipo= 777, nombreEquipo=Diablos }");
        System.out.println("Modificado: "+equipoDeBDD.toString());
        
         System.out.println("Eliminando de la base de datos para no alterarla \n");
        equipoDAO.eliminar(equipoPrueba);
  
    }

 
    @Test
    public void testObtener() throws Exception {
        System.out.println("Prueba de obtencion a la base de datos");
        System.out.println("Agreando equipo a la BD");
        equipoDAO.agregar(equipoPrueba);
        
        System.out.println("Recuperando elemento de la base de datos para comprar resultados");
        int clave = equipoPrueba.getClaveEquipo();
        equipoDeBDD=equipoDAO.obtener(clave);
        
        assertEquals(equipoPrueba.getClaveEquipo(), equipoDeBDD.getClaveEquipo());
        System.out.println("Teste realizado con exito:");
        System.out.println("Original: "+equipoPrueba.toString());
        System.out.println("Obtenido de la BD:"+equipoDeBDD.toString());
        System.out.println("Eliminando de la base de datos para no alterarla \n");
        equipoDAO.eliminar(equipoPrueba);
    }

    
     /**
    @Test
    public void testObtenerTodos() throws Exception {
   
    }
    **/
}
