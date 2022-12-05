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
public class PartidoIT {
    
    
    @Test
    public void testPartidoModelo() {
        System.out.println("Test de la clase partido");
        int ClvPartido = 123;
        String Lugar = "Mérida";
        int Equipo_Uno = 23;
        int Equipo_Dos = 342;
        int Hora = 12;
        int Dia = 6;
        int Mes = 12;
        System.out.println("Se creara un partdio con clave:"+ClvPartido+", lugar: "+Lugar+", equipo 1:" + Equipo_Uno + ", equipo 2:" + Equipo_Dos+ ", hora:"+Hora+", dia:"+Dia+" y mes:"+Mes);
        Partido instancia = new Partido();
        instancia.setClvPartido(ClvPartido);
        instancia.setLugar(Lugar);
        instancia.setEquipo_Uno(Equipo_Uno);
        instancia.setEquipo_Dos(Equipo_Dos);
        instancia.setHora(Hora);
        instancia.setDia(Dia);
        instancia.setMes(Mes);
        
        assertEquals(instancia.getClvPartido() + instancia.getLugar() + instancia.getEquipo_Uno() + instancia.getEquipo_Dos() + instancia.getHora() + instancia.getDia() + instancia.getMes(), ClvPartido+Lugar+Equipo_Uno+Equipo_Dos+Hora+Dia+Mes);
        
        System.out.println("Partido creado correctamente, obteniendo datos con los metodos del toString ");
        System.out.println(instancia.toString());
    }

    
    
}
