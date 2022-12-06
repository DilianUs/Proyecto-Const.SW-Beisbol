
package mysqlImplements;


import ModelosD.Equipo;
import ModelosDAO.EquipoDAO;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.util.List;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

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
    final String GETONE="SELECT ClvEquipo,NombreEquipo FROM equipo WHERE ClvEquipo=?";
    
    @Override
    public void agregar(Equipo e) throws DAOException{
   
       PreparedStatement statement=null;
        try {
           statement = jdbc.conectar().prepareStatement(INSERT);
           statement.setInt(1, e.getClaveEquipo());
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
                  jdbc.desconectar();
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
            statement.setInt(1,e.getClaveEquipo());
           
            if(statement.executeUpdate()==0){
                throw new DAOException("No se pudo eliminar");
            }
            
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                   jdbc.desconectar();
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
            statement.setInt(2, e.getClaveEquipo());
            if(statement.executeUpdate()==0){
                throw new DAOException("No se pudo modificar");
            }
            
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                    jdbc.desconectar();
                } catch (SQLException ex) {
                    throw new DAOException("Error SQL",ex);
                }
            }
        } 
    }
    
    private Equipo convertir(ResultSet rs) throws SQLException{
        int claveEquipo = rs.getInt("ClvEquipo");
        String nombreEquipo = rs.getString("NombreEquipo");
        Equipo equipo = new Equipo();
        equipo.setClaveEquipo(claveEquipo);
        equipo.setNombreEquipo(nombreEquipo);
        return equipo;
        
    }
    @Override
    public Equipo obtener(Integer id) throws DAOException{
        PreparedStatement statement=null;
        ResultSet rs =null;
        Equipo equipoEncontrado=null;
        try {
            statement = jdbc.conectar().prepareStatement(GETONE);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            
            if(rs.next()){
                equipoEncontrado = convertir(rs);
            }else{
                System.out.println("No se encuentra el elemento en la base de datos");
                equipoEncontrado=null;
            }
            
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
            if(rs !=null){
                try {
                    rs.close();
                   
                } catch (SQLException ex) {
                    new DAOException("Error en SQL",ex);
                }
            }
            if(statement != null){
                try {
                    statement.close();
                    jdbc.desconectar();
                } catch (SQLException ex) {
                    new DAOException("Error en SQL",ex);
                }
            }
        }
        return equipoEncontrado;
    }

    @Override
    public List<Equipo> obtenerTodos() throws DAOException{
        PreparedStatement statement=null;
        ResultSet rs =null;
        List<Equipo> equiposEncontrados= new ArrayList<>();
        try {
            statement = jdbc.conectar().prepareStatement(GETALL);
            rs = statement.executeQuery();
            while(rs.next()){
                equiposEncontrados.add(convertir(rs));
            }      
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    new DAOException("Error en SQL",ex);
                }
            }
            if(statement != null){
                try {
                    statement.close();
                    jdbc.desconectar();
                } catch (SQLException ex) {
                    new DAOException("Error en SQL",ex);
                }
            }
        }
        return equiposEncontrados;
    }
    
}
