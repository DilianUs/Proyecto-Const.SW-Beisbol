/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import com.Modelo.Boleto;
import ModelosD.Equipo;
import com.Modelo.Partido;
import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author allen
 */
public class BoletoDao {
    public void agregarBoleto(Boleto boletin,JTextField partidoClave){
        boletin.setClvPartido(Integer.parseInt(partidoClave.getText()));
        Conexion conexion = new Conexion();
        
        //Forma uno, con comillas
        String consulta = "INSERT INTO `boleto` (`ClvBoleto`,`ClvPartido`) VALUES (NULL,?);";
        //Forma dos, sin comillas
        //String consulta = "INSERT INTO boleto (ClvPartido) VALUES (NULL, ?);";
         try {
            CallableStatement callableStatement = conexion.establecerConexion().prepareCall(consulta);
            //Por ser autoincremento, no colocamos ningún valor
            callableStatement.setString(1, null);
            //Se agrega el único dato relevante
            callableStatement.setInt(2, boletin.getClvPartido());
            //Comienza la consulta
            callableStatement.execute();
            
            JOptionPane.showMessageDialog(null,"Se inserta");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No inserta");
        }
    }
    public void eliminarBoleto(Boleto boletin, JTextField partidoClave){
        boletin.setClvPartido(Integer.parseInt(partidoClave.getText()));
        Conexion conexion = new Conexion();
        
        //Forma uno, con comillas
        
        /*
            Nota, en caso que no cuadre la consulta, verifica si está en orden
            la variable consulta de abajo.
        */
        String consulta = "DELETE FROM `boleto` WHERE boleto.ClvPartido=?;";
        //Forma dos, sin comillas
        //String consulta = "DELETE FROM boleto WHERE boleto.ClvPartido=?;";
         try {
            CallableStatement callableStatement = conexion.establecerConexion().prepareCall(consulta);
            //Por ser autoincremento, no colocamos ningún valor
            callableStatement.setString(1, null);
            //Se agrega el único dato relevante
            callableStatement.setInt(2, boletin.getClvPartido());
            //Comienza la consulta
            callableStatement.execute();
            
            JOptionPane.showMessageDialog(null,"Se elimina");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No elimina");
        }
    }
}
