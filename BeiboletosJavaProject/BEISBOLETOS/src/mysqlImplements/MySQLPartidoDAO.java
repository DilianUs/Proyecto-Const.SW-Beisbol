package mysqlImplements;

import ModelosD.Partido;

import java.util.List;

import mysqlImplements.Conexion;

import ModelosDAO.PartidoDAO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author braul
 */
public class MySQLPartidoDAO implements PartidoDAO{
    Conexion jdbc = new Conexion();
    final String INSERT="INSERT INTO partidos(ClvPartido, direccion, Equipo_1, Equipo_2, Hora, FechaPartido) VALUES (?,?,?,?,?,?)";
    final String DELETE="DELETE FROM partidos WHERE ClvPartido=?";
    final String UPDATE="UPDATE partidos SET direccion=?, Equipo_1=?, Equipo_2=?, Hora=?,FechaPartido=? WHERE ClvPartido=?";
    final String GETALL="SELECT ClvPartido, direccion, Equipo_1, Equipo_2, Hora, FechaPartido FROM partidos";
    final String GETONE="SELECT ClvPartido, direccion, Equipo_1, Equipo_2, Hora, FechaPartido FROM partidos WHERE ClvPartido=?";
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
           statement.setString(6,  e.getFechaPartido());
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
            statement.setInt(1, e.getClvPartido());
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
             statement.setString(1, e.getLugar());
            statement.setInt(2, e.getEquipo_Uno());
            statement.setInt(3, e.getEquipo_Dos());
            statement.setInt(4, e.getHora());
            statement.setString(6, e.getFechaPartido());
            statement.setInt(7, e.getClvPartido());
            if(statement.executeUpdate()==0){
                throw new DAOException("No se pudo modificar el modelo");
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

    private Partido convertir(ResultSet rs) throws SQLException{
     
         int ClvPartido = rs.getInt("ClvPartido");
         String Lugar = rs.getString("direccion");
         int Equipo_Uno = rs.getInt("Equipo_1");
         int Equipo_Dos = rs.getInt("Equipo_2");
         int Hora = rs.getInt("Hora");
         String FechaPartido = rs.getString("FechaPartido");
        Partido partido = new Partido();
        partido.setClvPartido(ClvPartido);
        partido.setLugar(Lugar);
        partido.setEquipo_Uno(Equipo_Uno);
        partido.setEquipo_Dos(Equipo_Dos);
        partido.setHora(Hora);
        partido.setFechaPartido(FechaPartido);
        return partido;
        
    }
    @Override
    public Partido obtener(Integer id) throws DAOException {
        PreparedStatement statement=null;
        ResultSet rs =null;
       Partido partidoEncontrado=null;
        try {
            statement = jdbc.conectar().prepareStatement(GETONE);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            
            if(rs.next()){
                partidoEncontrado = convertir(rs);
            }else{
                throw new DAOException("No se ha encontrado ese registro");
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
                } catch (SQLException ex) {
                    new DAOException("Error en SQL",ex);
                }
            }
        }
        return partidoEncontrado;
    }

    @Override
    public List<Partido> obtenerTodos() throws DAOException {
                PreparedStatement statement=null;
        ResultSet rs =null;
        List<Partido> partidosEncontrados= new ArrayList<>();
        try {
            statement = jdbc.conectar().prepareStatement(GETALL);
            rs = statement.executeQuery();
            while(rs.next()){
                partidosEncontrados.add(convertir(rs));
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
                } catch (SQLException ex) {
                    new DAOException("Error en SQL",ex);
                }
            }
        }
        return partidosEncontrados;
    }
    
}
