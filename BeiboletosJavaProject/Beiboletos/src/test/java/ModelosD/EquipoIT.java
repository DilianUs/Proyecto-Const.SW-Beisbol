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
