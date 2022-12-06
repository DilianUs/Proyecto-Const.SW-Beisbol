package Controladores;

import ModelosD.Partido;
import TableModels.PartidoTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysqlImplements.DAOException;
import mysqlImplements.MySQLDaoManager;
import views.VentanaPartidos;

/**
 *
 * @author braul
 */
public class ControladorVentanaPartidos implements ActionListener {
    private MySQLDaoManager manager;
    private PartidoTableModel model;
    private VentanaPartidos ventanaPartidos;
    private Partido partido;
    private boolean editableClv;
    private boolean editableElement;
    public ControladorVentanaPartidos(VentanaPartidos ventana) throws DAOException  {
        this.manager = new MySQLDaoManager();
        this.model = new PartidoTableModel(manager.getPartidoDAO(),manager.getEquipoDAO());
        this.ventanaPartidos = ventana;
        this.ventanaPartidos.getTb_Partidos().setModel(model);
        this.ventanaPartidos.getTb_Partidos().getTableHeader().setReorderingAllowed(false);
        this.model.updateModel();
        this.ventanaPartidos.getBtn_Nuevo().addActionListener(this);
        this.ventanaPartidos.getBtn_Editar().addActionListener(this);
        this.ventanaPartidos.getBtn_Borrar().addActionListener(this);
        this.ventanaPartidos.getBtn_Guardar().addActionListener(this);
        this.ventanaPartidos.getBtn_Cancelar().addActionListener(this);
        setInitialButtonsState();
    }
    private void setInitialButtonsState(){
        this.ventanaPartidos.getBtn_Nuevo().setEnabled(true);
        this.ventanaPartidos.getBtn_Editar().setEnabled(false);
        this.ventanaPartidos.getBtn_Borrar().setEnabled(false);
        this.ventanaPartidos.getBtn_Guardar().setEnabled(false);
        this.ventanaPartidos.getBtn_Cancelar().setEnabled(false);
    }  

    @Override
    public void actionPerformed(ActionEvent actionUser) {
        if(actionUser.getSource() == this.ventanaPartidos.getBtn_Nuevo()){
           nuevoBtnAction();
        }
        if(actionUser.getSource() == this.ventanaPartidos.getBtn_Editar()){
            editarBtnAction();
        }
        if(actionUser.getSource() == this.ventanaPartidos.getBtn_Borrar()){
            borrarBtnAction();
        }
        if(actionUser.getSource() == this.ventanaPartidos.getBtn_Guardar()){
            try {
                guardarBtnAction();
            } catch (DAOException ex) {
                Logger.getLogger(ControladorVentanaEquipos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(actionUser.getSource() == this.ventanaPartidos.getBtn_Cancelar()){
            cancelarBtnAction();
        }
    }
    //metodos de botones
    private void nuevoBtnAction() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void editarBtnAction() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void borrarBtnAction() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void guardarBtnAction() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void cancelarBtnAction() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public boolean isEditableClv() {
        return editableClv;
    }

    public boolean isEditableElement() {
        return editableElement;
    }

    public void setEditableClv(boolean editableClv,boolean editableElement) {
        this.editableClv = editableClv;
        this.editableElement = editableElement;
    }
    
    
    
    
    
}
