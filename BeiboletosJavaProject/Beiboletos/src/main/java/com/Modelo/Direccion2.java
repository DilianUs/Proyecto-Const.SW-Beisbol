/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Modelo;

/**
 *
 * @author IGNITER
 */
public class Direccion2 {
    private int claveLugar;
    private String nombreLugar;
    private int calle, numero;

    public Direccion2(int claveLugar, String nombreLugar, int calle, int numero) {
        this.claveLugar = claveLugar;
        this.nombreLugar = nombreLugar;
        this.calle = calle;
        this.numero = numero;
    }
    
    public Direccion2(){}

    public int getClaveLugar() {
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

    public void setClaveLugar(int claveLugar) {
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
