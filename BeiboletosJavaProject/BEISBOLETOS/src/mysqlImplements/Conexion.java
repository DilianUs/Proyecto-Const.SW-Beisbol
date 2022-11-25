/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysqlImplements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author braul
 */
public class Conexion {
    String url="jdbc:mysql://localhost:3306/";
    String db="beisboletos";
    String user="root";
    String password="";
    String driver="com.mysql.cj.jdbc.Driver";

    Connection jdbc;
    public Conexion() {
    }
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            jdbc = DriverManager.getConnection(url+db,user,password);
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se pudo conectar a bd"+e);
        }
        return jdbc;
    }
    public void desconectar(){
        try {
            System.out.println("Conexion finalizada");
            jdbc.close();
        } catch (SQLException e) {
            System.out.println("Error al finalizar la conexion"+e);
        }
    }
    
    
    
}
