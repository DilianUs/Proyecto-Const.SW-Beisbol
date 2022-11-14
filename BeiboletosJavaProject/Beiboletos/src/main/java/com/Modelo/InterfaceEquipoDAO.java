/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import ModelosD.Equipo;

/**
 *
 * @author IGNITER
 */
public interface InterfaceEquipoDAO {
    
    public Equipo agregarEquipo(String nombreEquipo, String claveEquipo);
    
    public void eliminarEquipo(Equipo equipo);
    
    public void actualizarEquipo(Equipo equipo);
    
    public Equipo buscarEquipo(String claveEquipo);
    
}
