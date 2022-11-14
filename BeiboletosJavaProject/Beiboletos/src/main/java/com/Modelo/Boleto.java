/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Modelo;

/**
 *
 * @author allen
 */
public class Boleto {
    private int ClvBoleto;
    private int ClvPartido;

    public Boleto(int ClvBoleto, int ClvPartido) {
        this.ClvBoleto = ClvBoleto;
        this.ClvPartido = ClvPartido;
    }
    
    public Boleto(){}

    public int getClvBoleto() {
        return ClvBoleto;
    }

    public void setClvBoleto(int ClvBoleto) {
        this.ClvBoleto = ClvBoleto;
    }

    public int getClvPartido() {
        return ClvPartido;
    }

    public void setClvPartido(int ClvPartido) {
        this.ClvPartido = ClvPartido;
    }
    
    
    
}
