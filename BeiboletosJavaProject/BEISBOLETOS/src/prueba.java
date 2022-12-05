import Controladores.ControladorPrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysqlImplements.DAOException;
import views.VistaPrincipal;

/**
 *
 * @author braul
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VistaPrincipal ventana = new VistaPrincipal();
        try {
            ControladorPrincipal controler = new ControladorPrincipal(ventana);
        } catch (DAOException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        ventana.setVisible(true);
    }
    
}
