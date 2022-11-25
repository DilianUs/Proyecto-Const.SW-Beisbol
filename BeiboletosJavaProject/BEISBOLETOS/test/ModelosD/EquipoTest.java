/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ModelosD;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author braul
 */
public class EquipoTest {
    
    
    @Test
    public void testEquipoModelo(){
        System.out.println("Test de la clase equipo");
        int clave = 123;
        String nombreEquipo = "Leones";
        System.out.println("Se creara un equipo con claver:"+clave+" y nombre: "+nombreEquipo);
        Equipo instancia = new Equipo(clave, nombreEquipo);
        
        assertEquals(instancia.getClaveEquipo() + instancia.getNombreEquipo(), clave+nombreEquipo);
        
        System.out.println("Equipo creado correctamente, obteniendo datos con los metodos del toString ");
        System.out.println(instancia.toString());
    }

    
}
