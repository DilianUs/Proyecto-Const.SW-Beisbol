package ComboBoxModel;

import ModelosD.Partido;
import ModelosDAO.PartidoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import mysqlImplements.DAOException;

/**
 *
 * @author braul
 */
public class PartidosComboModel extends DefaultComboBoxModel<String>{
    private PartidoDAO partidos;
    private List<Partido> listaPartidos;
    public PartidosComboModel(PartidoDAO partidos) {
        this.partidos= partidos;
        this.listaPartidos = new ArrayList<>();
    }
    
    public void update(){
        if(partidos !=null){
           
            try {
                listaPartidos = partidos.obtenerTodos();
                removeAllElements();
                for(Partido p:listaPartidos){
                    
                    addElement(String.valueOf(p.getClvPartido()));
                }
            } catch (DAOException ex) {
                java.util.logging.Logger.getLogger(PartidosComboModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
           
        }

    }
}
