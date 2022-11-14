/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author braul
 */
public class Conectar {
    private String driver="com.mysql.jdbc.Driver";
    private String cadenaConeccion="jdbc:mysql://127.0.0.1/beisboletos";
    private String usuario="root";
    private String contrasena="";
    public Connection con;

    public Conectar() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(cadenaConeccion,usuario,contrasena);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido establecer una coneccion con la base de datos"+e.getMessage());
        }
        
    }
    
}
