package mysqlImplements;

import ModelosD.Partido;

import java.util.List;

import mysqlImplements.Conexion;

import ModelosDAO.PartidoDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author braul
 */
public class MySQLPartidoDAO implements PartidoDAO{
    Conexion jdbc = new Conexion();
    final String INSERT="INSERT INTO partidos(ClvPartido, direccion, Equipo_1, Equipo_2, Hora, Dia, Mes) VALUES (?,?,?,?,?,?,?)";
    final String DELETE="DELETE FROM equipo WHERE ClvEquipo=?";
    final String UPDATE="UPDATE equipo SET NombreEquipo=? WHERE ClvEquipo=?";
    final String GETALL="SELECT ClvEquipo,NombreEquipo FROM equipo";
    final String GETONE="SELECT ClvEquipo,NombreEquipo WHERE ClvEquipo=?";
    @Override
    public void agregar(Partido e) throws DAOException {
      PreparedStatement statement=null;
        try {
           statement = jdbc.conectar().prepareStatement(INSERT);
           statement.setInt(1, e.getClvPartido());
           statement.setString(2, e.getLugar());
           statement.setInt(3, e.getEquipo_Uno());
           statement.setInt(4, e.getEquipo_Dos());
           statement.setInt(5, e.getHora());
           statement.setInt(6, e.getDia());
           statement.setInt(7, e.getMes());
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
    public void eliminar(Partido e) throws DAOException {
                PreparedStatement statement=null;
        try {
            statement = jdbc.conectar().prepareStatement(DELETE);
            statement.setInt(2, e.getClvPartido());
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
    public void modificar(Partido e) throws DAOException {
               PreparedStatement statement=null;
        try {
            statement = jdbc.conectar().prepareStatement(UPDATE);
            
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
    public void obtener(Long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Partido> obtenerTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
