
package mysqlImplements;


import ModelosD.Equipo;
import ModelosDAO.EquipoDAO;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.util.List;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author braul
 */
public class MySQLEquipoDAO implements EquipoDAO{
    Conexion jdbc = new Conexion();
    final String INSERT="INSERT INTO equipo(ClvEquipo, NombreEquipo) VALUES(?,?)";
    final String DELETE="DELETE FROM equipo WHERE ClvEquipo=?";
    final String UPDATE="UPDATE equipo SET NombreEquipo=? WHERE ClvEquipo=?";
    final String GETALL="SELECT ClvEquipo,NombreEquipo FROM equipo";
    final String GETONE="SELECT ClvEquipo,NombreEquipo WHERE ClvEquipo=?";
    
    @Override
    public void agregar(Equipo e) throws DAOException{
   
       PreparedStatement statement=null;
        try {
           statement = jdbc.conectar().prepareStatement(INSERT);
           statement.setString(1, e.getClaveEquipo());
           statement.setString(2, e.getNombreEquipo());
           if(statement.executeUpdate()==0){
               throw new DAOException("No se pudo guardar");
           }
              
        }catch(SQLException ex){
            throw new DAOException("Error en SQL", ex);
        }finally {
            if(statement != null){
                try {
                  statement.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    
    @Override
    public void eliminar(Equipo e) throws DAOException{
        PreparedStatement statement=null;
        try {
            statement = jdbc.conectar().prepareStatement(DELETE);
            statement.setString(1,e.getClaveEquipo());
           
            if(statement.executeUpdate()==0){
                throw new DAOException("No se pudo eliminar");
            }
            
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error SQL",ex);
                }
            }
        }
    }

    @Override
    public void modificar(Equipo e)throws DAOException{
       PreparedStatement statement=null;
        try {
            statement = jdbc.conectar().prepareStatement(UPDATE);
            statement.setString(1,e.getNombreEquipo());
            statement.setString(2, e.getClaveEquipo());
            if(statement.executeUpdate()==0){
                throw new DAOException("No se pudo eliminar");
            }
            
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error SQL",ex);
                }
            }
        } 
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
