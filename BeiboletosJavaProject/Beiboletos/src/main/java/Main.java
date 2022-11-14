
import Controlador.VistaEquipos;
import vistas.Equipos;
import vistas.Plantilla;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author braul
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Plantilla ventana = new Plantilla();
       Equipos panel = new Equipos();
       VistaEquipos controlador = new VistaEquipos(panel);
       ventana.setVisible(true);
    }
    
}
