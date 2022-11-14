/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysqlImplements;

import ModelosD.Equipo;
import ModelosDAO.EquipoDAO;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import 
/**
 *
 * @author braul
 */
public class MySQLEquipoDAO implements EquipoDAO{
    final String INSERT="INSERT INTO equipo(ClvEquipo, NombreEquipo) VALUES(?,?)";
    private Connection conn;
    
    public MySQLEquipoDAO(Connection conn){
        this.conn=conn;
    }
    
    @Override
    public void agregar(Equipo e) throws DAOException{
        PreparableStatement stat = null;
        try {
           
            
        }catch(SQLException ex){
            throw new DAOException("Error en SQL", ex);
        }finally {
            if(stat != null){
                try {
                   
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    @Override
    public void eliminar(Equipo e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(Equipo e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void obtener(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Equipo> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
