/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author IGNITER
 */
public class Direccion {
    String claveLugar;
    String nombreLugar;
    int calle, numero;

    public Direccion(String claveLugar, String nombreLugar, int calle, int numero) {
        this.claveLugar = claveLugar;
        this.nombreLugar = nombreLugar;
        this.calle = calle;
        this.numero = numero;
    }

    public String getClaveLugar() {
        return claveLugar;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public int getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setClaveLugar(String claveLugar) {
        this.claveLugar = claveLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    public void setCalle(int calle) {
        this.calle = calle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}
