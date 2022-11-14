/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Modelo.Equipo;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author IGNITER
 */
public class EquipoDAO {
    private final int primeraColumna = 1;
    private final int segundaColumna = 2;
    public EquipoDAO(){}
    
    /*
        Recibe un objeto equipo y un JTextField que da la entrada que pasa al
        objeto equipo para que por medio de consultas, guarde los datos.
        Nota: quiten la forma que no sirva. Pruebenlas antes de decidir.
    */
    public void agregarEquipo(Equipo equipo, JTextField paramNombre){
        equipo.setNombreEquipo(paramNombre.getText());
        Conexion conexion = new Conexion();
        
        //Forma uno, con comillas
        String consulta = "INSERT INTO `equipo` (`ClvEquipo`, `NombreEquipo`) VALUES (NULL,?);";
        //Forma dos, sin comillas
        //String consulta = "INSERT INTO equipo (ClvEquipo, NombreEquipo) VALUES (NULL, ?);";
         try {
            CallableStatement callableStatement = conexion.establecerConexion().prepareCall(consulta);
            //Por ser autoincremento, no colocamos ningún valor
            callableStatement.setString(1, null);
            //Se agrega el único dato relevante
            callableStatement.setString(2, equipo.getNombreEquipo());
            //Comienza la consulta
            callableStatement.execute();
            
            JOptionPane.showMessageDialog(null,"Se inserta");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No inserta");
        }
    }
    
    /*
     mostrar en ventanas los equipos, la tabla vendrá por defecto sin nada
    Nota: quiten la forma que no sirva. Pruebenlas antes de decidir.
    */
    public void mostrarEquipo(JTable nombreTablaEquipo){
        Conexion conect = new Conexion();
        DefaultTableModel tablaPlantilla = new DefaultTableModel();
        
        String sql = "";
        
        //Agregando encabezados a las tablas
        tablaPlantilla.addColumn("Id");
        tablaPlantilla.addColumn("Nombre");
        
        nombreTablaEquipo.setModel(tablaPlantilla);
        
        //Forma con comillas
        sql = "SELECT * FROM `equipo`;";
        //Forma sin comillas
        //sql = "SELECT * FROM equipo;";
        
        String[] datos = new String[2];
        Statement consulta;
        
        try{
            
            consulta = conect.establecerConexion().createStatement();
            ResultSet resultSet = consulta.executeQuery(sql);
            while(resultSet.next()){
                datos[0] = resultSet.getString(primeraColumna);
                datos[1] = resultSet.getString(segundaColumna);
                
                tablaPlantilla.addRow(datos);
            }
            nombreTablaEquipo.setModel(tablaPlantilla);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Lo sentimos, no se pudo");
        }
    }
    
    /*
        En los campos de texto se llena el nombre y se procede en eliminar
    */
    public void eliminarEquipo(JTextField nombreEquipo, Equipo equipo){
        //entrada de las ventanas
        equipo.setNombreEquipo(nombreEquipo.getText());
        Conexion conect = new Conexion();
        //Forma sin comillas
        String consulta = "DELETE FROM equipo WHERE equipo.NombreEquipo=?;";
        //Forma con comillas
        //String consulta = DELETE FROM `equipo` WHERE `equipo.NombreEquipo`=?;";
        try{
            //Se realiza la consulta
            CallableStatement callableStatement = conect.establecerConexion().prepareCall(consulta);
            callableStatement.setString(segundaColumna, equipo.getNombreEquipo());
            callableStatement.execute();
            JOptionPane.showMessageDialog(null, "Eliminado");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No Eliminado");
        }
    }
}
