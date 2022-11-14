/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author allen
 */
public class Conexion {
    private Connection con = null;
    private String usuario = "root";
    private String contrasenia = "";
    private String bd = "beisboletos";
    private String ip = "localhost";
    private String puerto = "3306";
    
    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/"+bd;
    
    public Connection establecerConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(cadena,usuario,contrasenia);
            System.out.println("Se pudo conectar");
        }catch(Exception e){
            System.out.println("No se pudo conectar " + e.toString() );
        }
        
        return con;
    }
   
}
