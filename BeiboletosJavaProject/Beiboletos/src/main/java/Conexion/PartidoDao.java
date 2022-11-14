/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import Modelo.Direccion;
import ModelosD.Equipo;
import com.Modelo.Partido;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author allen
 */
public class PartidoDao {
    //Número de las columnas de la tabla partidos
    private final int primeraColumna = 1;
    private final int segundaColumna = 2;
    private final int terceraColumna = 3;
    private final int cuartaColumna = 4;
    private final int quintaColumna = 5;
    private final int sextaColumna = 6;
    private final int septimaColumna = 7;
    
    public void agregarPartido(Partido game,JTextField EquipoParam, JTextField EquipoParam2,
            JTextField nombreLugar,JTextField horaParam, 
            JTextField diaParam, JTextField mesParam){
        
        /*
            Representan los valores que van a ser metidos en la base de datos
        */
        game.setEquipo_1(Integer.parseInt(EquipoParam.getText()));
        game.setEquipo_2(Integer.parseInt(EquipoParam.getText()));
        game.setLugar(nombreLugar.getText());
        game.setHora(Integer.parseInt(horaParam.getText()));
        game.setDia(Integer.parseInt(diaParam.getText()));
        game.setMes(Integer.parseInt(mesParam.getText()));
        Conexion conexion = new Conexion();
        
        
        /*
        Nota, en caso que haya problemas de consulta, basta con cambiarla
        */
        
        //Forma uno, con comillas
        String consulta = "INSERT INTO `partidos`(?, `direccion`, "
                        + "`Equipo_1`, `Equipo_2`, `Hora`, `Dia`, `Mes`) "
                        + "VALUES (`?`,`?`,`?`,`?`,"
                        + "`?`,`?`,`?`)";
        //Forma dos, sin comillas
        /*
        String consulta = "INSERT INTO partidos(ClvPartido, direccion, "
                        + "Equipo_1, Equipo_2, Hora, Dia, Mes) "
                        + "VALUES (?,?,?,?,"
                        + "?,?,?)";
        */
         try {
            CallableStatement callableStatement = conexion.establecerConexion().prepareCall(consulta);
            //Por ser autoincremento, no colocamos ningún valor
            callableStatement.setString(1, null);
            //Se agrega indices foraneos
            callableStatement.setInt(2, game.getEquipo_1());
            callableStatement.setInt(3, game.getEquipo_2());
            //se almacena en renglones propios de la tabla
            callableStatement.setString(4, game.getLugar());
            callableStatement.setInt(5, game.getHora());
            callableStatement.setInt(6, game.getDia());
            callableStatement.setInt(7, game.getMes());
            //Comienza la consulta
            callableStatement.execute();
            
            JOptionPane.showMessageDialog(null,"Se inserta");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No inserta");
        }
    }
    
    public void mostrarPartido(JTable nombreTablaPartido){
       
        Conexion conect = new Conexion();
        DefaultTableModel tablaPlantilla = new DefaultTableModel();
        String sql = "";
       
        //Agregando encabezados a las tablas
        tablaPlantilla.addColumn("Id");
        tablaPlantilla.addColumn("Direccion");
        tablaPlantilla.addColumn("Equipo_1");
        tablaPlantilla.addColumn("Equipo_2");
        tablaPlantilla.addColumn("Hora");
        tablaPlantilla.addColumn("Dia");
        tablaPlantilla.addColumn("Mes");
        
        nombreTablaPartido.setModel(tablaPlantilla);
        
        //en caso de fallar la consulta, verificar la variable sql de abajo.
        sql = "SELECT partidos.ClvPartido, partidos.direccion, "
                + "partidos.Equipo_1, partidos.Equipo_2, partidos.Hora, "
                + "partidos.Dia, partidos.Mes FROM `partidos` INNER JOIN `equipo` "
                + "ON partidos.Equipo_1 = equipo.ClvEquipo";// AND partidos.Equipo_2 = equipo.ClvEquipo";
        
        String[] datos = new String[7];
        Statement consulta;
        
        try{
            
            consulta = conect.establecerConexion().createStatement();
            ResultSet resultSet = consulta.executeQuery(sql);
            while(resultSet.next()){
                datos[0] = resultSet.getString(primeraColumna);
                datos[1] = resultSet.getString(segundaColumna);
                datos[2] = resultSet.getString(terceraColumna);
                datos[3] = resultSet.getString(cuartaColumna);
                datos[4] = resultSet.getString(quintaColumna);
                datos[5] = resultSet.getString(sextaColumna);
                datos[6] = resultSet.getString(septimaColumna);
                tablaPlantilla.addRow(datos);
            }
            System.out.println(datos[0]);
            System.out.println(datos[1]);
            System.out.println(datos[2]);
            System.out.println(datos[3]);
            System.out.println(datos[4]);
            System.out.println(datos[5]);
            System.out.println(datos[6]);
            nombreTablaPartido.setModel(tablaPlantilla);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Lo sentimos, no se pudo");
        }
    }
    
    /*
        En base en un registro recién escrito en los campos de texto nombre,
        elimina los partidos con ese equipo.
    */
    public void eliminarPartido(Partido game, JTextField nombre){
        //Recibir datos de las vistas
        game.setEquipo_1(Integer.parseInt(nombre.getText()));
        Conexion conect = new Conexion();
        //Forma sin comillas
        //En caso que algo falle, consulte aquí primero
        String consulta = "DELETE FROM partido WHERE partido.NombreEquipo_1=?;";
        //Forma con comillas
        //String consulta = DELETE FROM `equipo` WHERE `equipo.NombreEquipo`=?;";
        try{
            CallableStatement callableStatement = conect.establecerConexion().prepareCall(consulta);
            callableStatement.setInt(segundaColumna, game.getEquipo_1());
            callableStatement.execute();
            JOptionPane.showMessageDialog(null, "Eliminado");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No Eliminado");
        }
    }
    
}
