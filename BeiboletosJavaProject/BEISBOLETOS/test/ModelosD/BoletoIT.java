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
public class BoletoIT {
    
    
    @Test
    public void testBoletoModelo() {
        System.out.println("Test de la clase boleto");
        int claveBoleto = 123;
        int clavePartido = 456;
        System.out.println("Se creara un boleto con clave:"+claveBoleto+" y partido con clave: "+clavePartido);
        Boleto instancia = new Boleto();
        //instancia.setClaveEquipo(clave);
        instancia.setClvBoleto(claveBoleto);
        instancia.setClvPartido(clavePartido);
        
        assertEquals(instancia.getClvBoleto() + instancia.getClvPartido(), claveBoleto+clavePartido);
        
        System.out.println("Boleto creado correctamente, obteniendo datos con los metodos del toString ");
        System.out.println(instancia.toString());
    }

    
    
}
