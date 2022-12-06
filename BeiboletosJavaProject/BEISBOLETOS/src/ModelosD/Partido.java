package ModelosD;

import java.util.Date;



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
    private String FechaPartido;
    
    public Partido() {
        this.ClvPartido = 0;
        this.Lugar = "";
        this.Equipo_Uno = 0;
        this.Equipo_Dos = 0;
        this.Hora = 0;
        this.FechaPartido = "";
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

    public String getFechaPartido() {
        return FechaPartido;
    }

    public void setFechaPartido(String FechaPartido) {
        this.FechaPartido = FechaPartido;
    }

    @Override
    public String toString() {
        return "Partido{" + "ClvPartido=" + ClvPartido + ", Lugar=" + Lugar + ", Equipo_Uno=" + Equipo_Uno + ", Equipo_Dos=" + Equipo_Dos + ", Hora=" + Hora + ", FechaPartido=" + FechaPartido + '}';
    }
}
