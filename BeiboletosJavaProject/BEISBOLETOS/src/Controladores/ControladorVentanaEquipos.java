package Controladores;

import ModelosD.Equipo;
import mysqlImplements.DAOException;
import mysqlImplements.MySQLDaoManager;
import TableModels.EquipoTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import views.VentanaEquipos;

/**
 *
 * @author braul
 */
public class ControladorVentanaEquipos implements ActionListener{
    private MySQLDaoManager manager;
    private EquipoTableModel model;
    private  VentanaEquipos ventanaEquipos;
    private boolean editableClv;
    private boolean editableNom;
    private Equipo equipo;
   
    public ControladorVentanaEquipos(VentanaEquipos ventana) throws DAOException {
        this.manager = new MySQLDaoManager();
        this.model = new EquipoTableModel(manager.getEquipoDAO());
        this.ventanaEquipos = ventana;
        this.ventanaEquipos.getTb_Equipos().setModel(model);
        this.ventanaEquipos.getTb_Equipos().getTableHeader().setReorderingAllowed(false);
        this.model.updateModel();
        this.ventanaEquipos.getBtn_Nuevo().addActionListener(this);
        this.ventanaEquipos.getBtn_Editar().addActionListener(this);
        this.ventanaEquipos.getBtn_Borrar().addActionListener(this);
        this.ventanaEquipos.getBtn_Guardar().addActionListener(this);
        this.ventanaEquipos.getBtn_Cancelar().addActionListener(this);
        setInitialButtonsState();
        setEditable(false,false);
         this.ventanaEquipos.getTb_Equipos().getSelectionModel().addListSelectionListener(e ->{
            boolean seleccionValida = (this.ventanaEquipos.getTb_Equipos().getSelectedRow()!=-1);
            this.ventanaEquipos.getBtn_Editar().setEnabled(seleccionValida);
            this.ventanaEquipos.getBtn_Borrar().setEnabled(seleccionValida);
        });
        
    }

    private void setInitialButtonsState(){
        this.ventanaEquipos.getBtn_Nuevo().setEnabled(true);
        this.ventanaEquipos.getBtn_Editar().setEnabled(false);
        this.ventanaEquipos.getBtn_Borrar().setEnabled(false);
        this.ventanaEquipos.getBtn_Guardar().setEnabled(false);
        this.ventanaEquipos.getBtn_Cancelar().setEnabled(false);
    }    
    
    
     @Override
    public void actionPerformed(ActionEvent actionUser) {
        if(actionUser.getSource() == this.ventanaEquipos.getBtn_Nuevo()){
           nuevoBtnAction();
        }
        if(actionUser.getSource() == this.ventanaEquipos.getBtn_Editar()){
            editarBtnAction();
        }
        if(actionUser.getSource() == this.ventanaEquipos.getBtn_Borrar()){
            borrarBtnAction();
        }
        if(actionUser.getSource() == this.ventanaEquipos.getBtn_Guardar()){
            try {
                guardarBtnAction();
            } catch (DAOException ex) {
                Logger.getLogger(ControladorVentanaEquipos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(actionUser.getSource() == this.ventanaEquipos.getBtn_Cancelar()){
            cancelarBtnAction();
        }
        
    }
    
    private void nuevoBtnAction(){
        loadData(null);
        setEquipo(null);
        setEditable(true,true);
        this.ventanaEquipos.getBtn_Guardar().setEnabled(true);
        this.ventanaEquipos.getBtn_Cancelar().setEnabled(true);
    }
    
    private void editarBtnAction(){
        try {
            Equipo equipoSelected = getEquipoSeleccionado();
            loadData(equipoSelected);
            /**
            this.ventanaEquipos.getTf_ClvEquipo().setText(String.valueOf(equipoSelected.getClaveEquipo()));
            this.ventanaEquipos.getTf_NomEquipo().setText(equipoSelected.getNombreEquipo());
            * */
            setEditable(false,true); 
            
            this.ventanaEquipos.getBtn_Guardar().setEnabled(true);
            this.ventanaEquipos.getBtn_Cancelar().setEnabled(true);
           
        } catch (DAOException ex) {
            Logger.getLogger(ControladorVentanaEquipos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void borrarBtnAction() {
        if(JOptionPane.showConfirmDialog(ventanaEquipos, "¿Seguro que quieres borrar este equipo?", "Borrar Equipo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION){
            try {
                Equipo equipoBorrar = getEquipoSeleccionado();
                manager.getEquipoDAO().eliminar(equipoBorrar);
                model.updateModel();
                model.fireTableDataChanged();
            } catch (DAOException ex) {
                Logger.getLogger(ControladorVentanaEquipos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            cancelarBtnAction();
        }
    }

    private void guardarBtnAction() throws DAOException {
        saveData();
        Equipo equipoActual = getEquipo();
        Boolean existe = (manager.getEquipoDAO().obtener(equipoActual.getClaveEquipo())!=null);
        if(existe ==true){
            manager.getEquipoDAO().modificar(equipoActual);
        }else{
            manager.getEquipoDAO().agregar(equipoActual);
        }
        setEquipo(null);
        loadData(null);
        setEditable(false,false);
        this.ventanaEquipos.getTb_Equipos().clearSelection();
        this.ventanaEquipos.getBtn_Guardar().setEnabled(false);
        this.ventanaEquipos.getBtn_Cancelar().setEnabled(false);
        model.updateModel();
        model.fireTableDataChanged();
    }
    
    private void cancelarBtnAction(){
        setEquipo(null);
        loadData(null);
        setEditable(false,false);
        this.ventanaEquipos.getTb_Equipos().clearSelection();
        this.ventanaEquipos.getBtn_Guardar().setEnabled(false);
        this.ventanaEquipos.getBtn_Cancelar().setEnabled(false);
        
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    public boolean isEditableClv() {
        return editableClv;
    }

    public boolean isEditableNom() {
        return editableNom;
    }
    
    public void setEditable(boolean editableClv,boolean editableNom) {
        this.editableClv = editableClv;
        this.editableNom = editableNom;
        this.ventanaEquipos.getTf_ClvEquipo().setEditable(editableClv);
        this.ventanaEquipos.getTf_NomEquipo().setEditable(editableNom);
    }
    
    public void loadData(Equipo equipoCargar){
        if(equipoCargar != null){
            this.ventanaEquipos.getTf_ClvEquipo().setText(String.valueOf(equipoCargar.getClaveEquipo()));
            this.ventanaEquipos.getTf_NomEquipo().setText(equipoCargar.getNombreEquipo());
        }else{
            this.ventanaEquipos.getTf_ClvEquipo().setText("");
            this.ventanaEquipos.getTf_NomEquipo().setText("");
        }
        
        this.ventanaEquipos.getTf_ClvEquipo().requestFocus();
    }
    
    public void saveData(){
        if(equipo == null){
            equipo = new Equipo();
        }
        equipo.setClaveEquipo(Integer.parseInt(ventanaEquipos.getTf_ClvEquipo().getText()));
        equipo.setNombreEquipo(ventanaEquipos.getTf_NomEquipo().getText());
    }

    private Equipo getEquipoSeleccionado() throws DAOException{
       int id = (int) this.ventanaEquipos.getTb_Equipos().getValueAt(this.ventanaEquipos.getTb_Equipos().getSelectedRow(), 0);
       return manager.getEquipoDAO().obtener(id);
    }   
}
