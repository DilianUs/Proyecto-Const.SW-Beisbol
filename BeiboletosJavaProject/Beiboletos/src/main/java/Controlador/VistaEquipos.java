/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.EquipoDAO;
import ModelosD.Equipo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.Equipos;

/**
 *
 * @author braul
 */
public class VistaEquipos implements ActionListener{
    private Equipos panelVentana;
    
    public VistaEquipos(Equipos panel){
        this.panelVentana = panel;
        this.panelVentana.getBtn_AgregarEquipo().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent actionUser){
        
        if(actionUser.getSource()== this.panelVentana.getBtn_AgregarEquipo()){
            agregarEquipo();
        }
    }
    
    public void agregarEquipo(){
        String nombreEquipo=panelVentana.getInput_Nequipo().getText();
        String claveEquipo = panelVentana.getInput_ClaveEquipo().getText();
        Equipo nuevoEquipo = new Equipo(nombreEquipo, claveEquipo);
        EquipoDAO equipoDAO = new EquipoDAO();
        equipoDAO.agregarEquipo(nuevoEquipo);
        System.out.println("Hola mundo");
        
    }

    
}
