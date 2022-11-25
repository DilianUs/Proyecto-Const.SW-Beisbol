
package vistas;

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
        return super.getColumnName(column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
