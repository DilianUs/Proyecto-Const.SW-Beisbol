/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Image;

/**
 *
 * @author IGNITER
 */
public class Equipo {
    String nombreEquipo;
    String claveEquipo;

    public Equipo(String nombreEquipo, String claveEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.claveEquipo = claveEquipo;
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
    
    
}
