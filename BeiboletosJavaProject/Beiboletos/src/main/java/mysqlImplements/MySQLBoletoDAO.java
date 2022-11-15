
package mysqlImplements;

import ModelosD.Boleto;
import ModelosDAO.BoletoDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    final String GETALL="SELECT ClvBoleto,ClvPartido FROM equipo";
    final String GETONE="SELECT ClvBoleto,ClvPartido WHERE ClvBoleto=?";
    
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
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    @Override
    public void eliminar(Boleto e) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(Boleto e) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void obtener(Long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Boleto> obtenerTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
