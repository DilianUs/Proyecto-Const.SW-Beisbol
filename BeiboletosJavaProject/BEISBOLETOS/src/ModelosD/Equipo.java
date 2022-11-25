/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosD;

import java.awt.Image;

/**
 *
 * @author IGNITER
 */
public class Equipo {
    private String claveEquipo;
    private String nombreEquipo;
    
    public Equipo(String claveEquipo, String nombreEquipo) {
        this.claveEquipo = claveEquipo;
        this.nombreEquipo = nombreEquipo;     
    }

    public String getClaveEquipo() {
        return claveEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public void setClaveEquipo(String claveEquipo) {
        this.claveEquipo = claveEquipo;
    }

    @Override
    public String toString() {
        return "Equipo{" + "claveEquipo=" + claveEquipo + ", nombreEquipo=" + nombreEquipo + '}';
    }
      
}
