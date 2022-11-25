
import ModelosD.Equipo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysqlImplements.DAOException;
import mysqlImplements.MySQLEquipoDAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author braul
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MySQLEquipoDAO equipoDao = new MySQLEquipoDAO();
        Equipo equipoObtenido=null;
        try {
           
            equipoObtenido= equipoDao.obtener(23);
            
            

        } catch (DAOException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
