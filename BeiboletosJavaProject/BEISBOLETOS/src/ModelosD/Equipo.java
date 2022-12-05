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
    private int claveEquipo;
    private String nombreEquipo;
    
    public Equipo() {
        this.claveEquipo = 0;
        this.nombreEquipo = "";     
    }

    public int getClaveEquipo() {
        return claveEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public void setClaveEquipo(int claveEquipo) {
        this.claveEquipo = claveEquipo;
    }

    @Override
    public String toString() {
        return "Equipo{" + "claveEquipo=" + claveEquipo + ", nombreEquipo=" + nombreEquipo + '}';
    }
      
}
