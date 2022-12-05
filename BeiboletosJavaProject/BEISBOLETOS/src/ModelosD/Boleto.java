/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosD;

/**
 *
 * @author braul
 */
public class Boleto {
    private int ClvBoleto;
    private int ClvPartido;

    public Boleto() {
        this.ClvBoleto = 0;
        this.ClvPartido = 0;
    }

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

    @Override
    public String toString() {
        return "Boleto{" + "ClvBoleto=" + ClvBoleto + ", ClvPartido=" + ClvPartido + '}';
    }
    
    
}
