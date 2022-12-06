package TableModels;

import ModelosD.Equipo;
import ModelosD.Partido;
import ModelosDAO.EquipoDAO;
import ModelosDAO.PartidoDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import mysqlImplements.DAOException;

/**
 *
 * @author braul
 */
public class PartidoTableModel extends AbstractTableModel{

    private PartidoDAO partidos;
    private EquipoDAO equipos;
    private List<Partido> datos = new ArrayList<>();
    public PartidoTableModel(PartidoDAO partidos,EquipoDAO equipos){
        this.partidos = partidos;
        this.equipos = equipos;
    }
    
     public void updateModel() throws DAOException{
        datos = partidos.obtenerTodos();
    }
     @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "Lugar";
            case 2: return "Equipo_Uno";
            case 3: return "Equipo_Dos";
            case 4: return "Hora";
            case 5: return "Dia";
            case 6: return "Mes";
            default: return "[no]";
        }
    } 
    
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Partido preguntado = datos.get(rowIndex);
         Equipo equipoUno = new Equipo();
         Equipo equipoDos = new Equipo();
        try {
            equipoUno = equipos.obtener(preguntado.getEquipo_Uno());
            equipoDos = equipos.obtener(preguntado.getEquipo_Dos());
        } catch (DAOException ex) {
            Logger.getLogger(PartidoTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        switch(columnIndex){
            case 0: return preguntado.getClvPartido();
            case 1: return preguntado.getLugar();
            case 2: return equipoUno.getNombreEquipo();
            case 3: return equipoDos.getNombreEquipo();
            case 4: return preguntado.getHora();
            case 5: return preguntado.getDia();
            case 6: return preguntado.getMes();
            default: return "";
        }
    }
    
}
