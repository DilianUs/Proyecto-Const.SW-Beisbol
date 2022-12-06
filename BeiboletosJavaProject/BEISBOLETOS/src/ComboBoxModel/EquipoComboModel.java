package ComboBoxModel;

import ModelosD.Equipo;
import ModelosDAO.EquipoDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import mysqlImplements.DAOException;

/**
 *
 * @author braul
 */
public class EquipoComboModel extends DefaultComboBoxModel<String>{
    private EquipoDAO equipos;
    private List<Equipo> listaEquipos;
    public EquipoComboModel(EquipoDAO equipos) {
        this.equipos = equipos;
        this.listaEquipos = new ArrayList<>();
    }
    
    public void update(){
        if(equipos !=null){
            try {
                listaEquipos = equipos.obtenerTodos();
                removeAllElements();
                for(Equipo e:listaEquipos){
                    
                    addElement(e.getNombreEquipo()+"("+e.getClaveEquipo()+")");
                }
            } catch (DAOException ex) {
                Logger.getLogger(EquipoComboModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
}
