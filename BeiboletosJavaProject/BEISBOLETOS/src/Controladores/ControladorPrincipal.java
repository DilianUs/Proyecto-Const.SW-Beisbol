package Controladores;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import mysqlImplements.DAOException;
import views.VentanaEquipos;
import views.VentanaInicio;
import views.VentanaPartidos;
import views.VistaPrincipal;

/**
 *
 * @author braul
 */
public class ControladorPrincipal implements ActionListener{
    private VistaPrincipal ventanaNavegacion;
     private  VentanaEquipos equipos = new VentanaEquipos();
    private VentanaPartidos partidos = new VentanaPartidos();
    private VentanaInicio inicio = new VentanaInicio();
    private ControladorVentanaEquipos controladorEquipos;
    private ControladorVentanaPartidos controladorPartidos;
    

    public ControladorPrincipal(VistaPrincipal ventana) throws DAOException {
        this.ventanaNavegacion = ventana;
        this.ventanaNavegacion.getBtn_Inicio().addActionListener(this);
        this.ventanaNavegacion.getBtn_Partidos().addActionListener(this);
        this.ventanaNavegacion.getBtn_Equipos().addActionListener(this);
        this.ventanaNavegacion.getBtn_Exit().addActionListener(this);
        this.controladorEquipos = new ControladorVentanaEquipos(this.equipos);
        this.controladorPartidos = new ControladorVentanaPartidos(this.partidos);
        showPanel(inicio);
    }
     
    @Override
    public void actionPerformed(ActionEvent actionUser){
        if(actionUser.getSource()==this.ventanaNavegacion.getBtn_Inicio()){
            showPanel(inicio);
        }
        if(actionUser.getSource()==this.ventanaNavegacion.getBtn_Partidos()){
            showPanel(partidos);
        }
        if(actionUser.getSource()==this.ventanaNavegacion.getBtn_Equipos()){
                showPanel(equipos);   
        }
    }
    
    private void showPanel(JPanel p){
        p.setSize(980, 690);
        p.setLocation(0, 0);
        this.ventanaNavegacion.getContent().removeAll();
        this.ventanaNavegacion.getContent().add(p, BorderLayout.CENTER);
        this.ventanaNavegacion.getContent().revalidate();
        this.ventanaNavegacion.getContent().repaint();
    } 
     
}
