/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosD;

/**
 *
 * @author braul
 */
public class Partido {
    private int ClvPartido;
    private String Lugar;
    private int Equipo_Uno;
    private int Equipo_Dos;
    private int Hora;
    private int Dia;
    private int Mes;

    public Partido() {
        this.ClvPartido = 0;
        this.Lugar = "";
        this.Equipo_Uno = 0;
        this.Equipo_Dos = 0;
        this.Hora = 0;
        this.Dia = 0;
        this.Mes = 0;
    }

    public int getClvPartido() {
        return ClvPartido;
    }

    public void setClvPartido(int ClvPartido) {
        this.ClvPartido = ClvPartido;
    }


    public int getEquipo_Uno() {
        return Equipo_Uno;
    }

    public void setEquipo_Uno(int Equipo_Uno) {
        this.Equipo_Uno = Equipo_Uno;
    }

    public int getEquipo_Dos() {
        return Equipo_Dos;
    }

    public void setEquipo_Dos(int Equipo_Dos) {
        this.Equipo_Dos = Equipo_Dos;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String Lugar) {
        this.Lugar = Lugar;
    }

    public int getHora() {
        return Hora;
    }

    public void setHora(int Hora) {
        this.Hora = Hora;
    }

    public int getDia() {
        return Dia;
    }

    public void setDia(int Dia) {
        this.Dia = Dia;
    }

    public int getMes() {
        return Mes;
    }

    public void setMes(int Mes) {
        this.Mes = Mes;
    }

    @Override
    public String toString() {
        return "Partido{" + "ClvPartido=" + ClvPartido + ", Lugar=" + Lugar + ", Equipo_1=" + Equipo_Uno + ", Equipo_2=" + Equipo_Dos + ", Hora=" + Hora + ", Dia=" + Dia + ", Mes=" + Mes + '}';
    }

    
    
}
