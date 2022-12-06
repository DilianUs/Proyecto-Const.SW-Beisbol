
package mysqlImplements;

import ModelosD.Boleto;
import ModelosDAO.BoletoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author braul
 */
public class MySQLBoletoDAO implements BoletoDAO{

    Conexion jdbc = new Conexion();
    final String INSERT="INSERT INTO boleto(ClvBoleto, ClvPartido) VALUES(?,?)";
    final String DELETE="DELETE FROM boleto WHERE ClvBoleto=?";
    final String UPDATE="UPDATE boleto SET ClvPartido=? WHERE ClvBoleto=?";
    final String GETALL="SELECT ClvBoleto,ClvPartido FROM boleto";
    final String GETONE="SELECT ClvBoleto,ClvPartido FROM boleto WHERE ClvBoleto=?";
    
    @Override
    public void agregar(Boleto e) throws DAOException {
        PreparedStatement statement=null;
        try {
           statement = jdbc.conectar().prepareStatement(INSERT);
           statement.setInt(1, e.getClvBoleto());
           statement.setInt(2, e.getClvPartido());
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
    public void eliminar(Boleto e) throws DAOException {
           PreparedStatement statement=null;
        try {
            statement = jdbc.conectar().prepareStatement(DELETE);
            statement.setInt(1, e.getClvBoleto());
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
    public void modificar(Boleto e) throws DAOException {
              PreparedStatement statement=null;
        try {
            statement = jdbc.conectar().prepareStatement(UPDATE);
            statement.setInt(1,e.getClvPartido());
            statement.setInt(2, e.getClvBoleto());
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
   private Boleto convertir(ResultSet rs) throws SQLException{
     
        int ClvBoleto = rs.getInt("ClvBoleto");
        int ClvPartido = rs.getInt("ClvPartido");
        Boleto boleto = new Boleto(ClvBoleto, ClvPartido);
        return boleto;
        
    }

    @Override
    public Boleto obtener(Integer id) throws DAOException {
         PreparedStatement statement=null;
        ResultSet rs =null;
       Boleto boletoEncontrado=null;
        try {
            statement = jdbc.conectar().prepareStatement(GETONE);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            
            if(rs.next()){
                boletoEncontrado = convertir(rs);
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
                    jdbc.desconectar();
                } catch (SQLException ex) {
                    new DAOException("Error en SQL",ex);
                }
            }
        }
        return boletoEncontrado;
    }

    @Override
    public List<Boleto> obtenerTodos() throws DAOException {
                        PreparedStatement statement=null;
        ResultSet rs =null;
        List<Boleto> boletosEncontrados= new ArrayList<>();
        try {
            statement = jdbc.conectar().prepareStatement(GETALL);
            rs = statement.executeQuery();
            while(rs.next()){
                boletosEncontrados.add(convertir(rs));
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
        return boletosEncontrados;
    }
    
}
