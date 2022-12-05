
package TableModels;

import ModelosD.Equipo;
import ModelosDAO.EquipoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import mysqlImplements.DAOException;

/**
 *
 * @author braul
 */
public class EquipoTableModel extends  AbstractTableModel{
    
    private EquipoDAO equipos;
    private List<Equipo> datos = new ArrayList<>();
    public EquipoTableModel(EquipoDAO equipos){
        this.equipos = equipos;
    }
    
    public void updateModel() throws DAOException{
        datos = equipos.obtenerTodos();
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "Nombre";
            default: return "[no]";
        }
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Equipo preguntado = datos.get(rowIndex);
        switch(columnIndex){
            case 0: return preguntado.getClaveEquipo();
            case 1: return preguntado.getNombreEquipo();
            default: return "";
        }
    }
    
}
