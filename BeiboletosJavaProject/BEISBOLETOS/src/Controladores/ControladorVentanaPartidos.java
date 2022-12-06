package Controladores;

import ComboBoxModel.EquipoComboModel;
import ModelosD.Partido;
import TableModels.PartidoTableModel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
    private EquipoComboModel comboModelLocales;
    private EquipoComboModel comboModelVisitantes;
    
    
    public ControladorVentanaPartidos(VentanaPartidos ventana) throws DAOException  {
        this.manager = new MySQLDaoManager();
        this.model = new PartidoTableModel(manager.getPartidoDAO(),manager.getEquipoDAO());
        this.ventanaPartidos = ventana;
        this.ventanaPartidos.getTb_Partidos().setModel(model);
        this.ventanaPartidos.getTb_Partidos().getTableHeader().setReorderingAllowed(false);
        this.model.updateModel();
        addButtonListeners();
        calendarioEventos();
        setInitialButtonsState();
        setComboBoxModels();
        this.ventanaPartidos.getTb_Partidos().getSelectionModel().addListSelectionListener(e ->{
            boolean seleccionValida = (this.ventanaPartidos.getTb_Partidos().getSelectedRow()!=-1);
            this.ventanaPartidos.getBtn_Editar().setEnabled(seleccionValida);
            this.ventanaPartidos.getBtn_Borrar().setEnabled(seleccionValida);
        });
        setEditableClv(false, false);
    }
    
    private void addButtonListeners(){
        this.ventanaPartidos.getBtn_Nuevo().addActionListener(this);
        this.ventanaPartidos.getBtn_Editar().addActionListener(this);
        this.ventanaPartidos.getBtn_Borrar().addActionListener(this);
        this.ventanaPartidos.getBtn_Guardar().addActionListener(this);
        this.ventanaPartidos.getBtn_Cancelar().addActionListener(this);
    }
    
    private void setInitialButtonsState(){
        this.ventanaPartidos.getBtn_Nuevo().setEnabled(true);
        this.ventanaPartidos.getBtn_Editar().setEnabled(false);
        this.ventanaPartidos.getBtn_Borrar().setEnabled(false);
        this.ventanaPartidos.getBtn_Guardar().setEnabled(false);
        this.ventanaPartidos.getBtn_Cancelar().setEnabled(false);
    }  
    
    private void setComboBoxModels(){
        this.comboModelLocales = new EquipoComboModel(manager.getEquipoDAO());
        this.comboModelVisitantes = new EquipoComboModel(manager.getEquipoDAO());
        this.ventanaPartidos.getCb_EquipoUno().setModel(comboModelLocales);
        this.ventanaPartidos.getCb_EquipoDos().setModel(comboModelVisitantes);
        comboModelLocales.update();
        comboModelVisitantes.update();
    }

    @Override
    public void actionPerformed(ActionEvent actionUser) {
        if(actionUser.getSource() == this.ventanaPartidos.getBtn_Nuevo()){
            try {
                nuevoBtnAction();
            } catch (ParseException ex) {
                Logger.getLogger(ControladorVentanaPartidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(actionUser.getSource() == this.ventanaPartidos.getBtn_Editar()){
            try {
                editarBtnAction();
            } catch (ParseException ex) {
                Logger.getLogger(ControladorVentanaPartidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(actionUser.getSource() == this.ventanaPartidos.getBtn_Borrar()){
            try {
                borrarBtnAction();
            } catch (ParseException ex) {
                Logger.getLogger(ControladorVentanaPartidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(actionUser.getSource() == this.ventanaPartidos.getBtn_Guardar()){
                guardarBtnAction();         
        }
        if(actionUser.getSource() == this.ventanaPartidos.getBtn_Cancelar()){
            try {
                cancelarBtnAction();
            } catch (ParseException ex) {
                Logger.getLogger(ControladorVentanaPartidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void calendarioEventos(){
        this.ventanaPartidos.getCalendario().addPropertyChangeListener((evt) -> {
            if (evt.getOldValue()!=null){
                SimpleDateFormat formato_FechaBD = new SimpleDateFormat("yyyy-MM-dd");
                this.ventanaPartidos.getTf_FechaPartido().setText(formato_FechaBD.format(this.ventanaPartidos.getCalendario().getCalendar().getTime()));
            }else{
              this.ventanaPartidos.getTf_FechaPartido().setText("");  
            }
        });
    }
    //metodos de botones
    private void nuevoBtnAction() throws ParseException {
        loadData();
        setPartido(null);
        setEditableClv(true, true);
        this.ventanaPartidos.getBtn_Guardar().setEnabled(true);
        this.ventanaPartidos.getBtn_Cancelar().setEnabled(true);        
    }

    private void editarBtnAction() throws ParseException {
         try {
              setEditableClv(false,true);
             setPartido(getPartidoSeleccionado());
             
             loadData();
            this.ventanaPartidos.getBtn_Guardar().setEnabled(true);
            this.ventanaPartidos.getBtn_Cancelar().setEnabled(true);
           
        } catch (DAOException ex) {
            Logger.getLogger(ControladorVentanaEquipos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void borrarBtnAction() throws ParseException {
        if(JOptionPane.showConfirmDialog(ventanaPartidos, "¿Seguro que quieres borrar este partido?", "Borrar Partido", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION){
            try {
                Partido partidoBorrar = getPartidoSeleccionado();
                manager.getPartidoDAO().eliminar(partidoBorrar);
                model.updateModel();
                model.fireTableDataChanged();
            } catch (DAOException ex) {
                Logger.getLogger(ControladorVentanaEquipos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            cancelarBtnAction();
        }
    }

    private void guardarBtnAction() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void cancelarBtnAction() throws ParseException {
        setPartido(null);
        loadData();
        setEditableClv(false,false);
        this.ventanaPartidos.getTb_Partidos().clearSelection();
        this.ventanaPartidos.getBtn_Guardar().setEnabled(false);
        this.ventanaPartidos.getBtn_Cancelar().setEnabled(false);
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
        this.ventanaPartidos.getTf_ClvPartido().setEditable(editableClv);
        this.ventanaPartidos.getTf_NomLugar().setEditable(editableElement);
        this.ventanaPartidos.getCb_EquipoUno().setEnabled(editableElement);
        this.ventanaPartidos.getCb_EquipoDos().setEnabled(editableElement);
        this.ventanaPartidos.getTf_FechaPartido().setEditable(editableElement);
        this.ventanaPartidos.getCalendario().setEnabled(editableElement);

    }
    
    public void loadData() throws ParseException  {
        if(this.partido != null){
            this.ventanaPartidos.getTf_ClvPartido().setText(String.valueOf(this.partido.getClvPartido()));
            this.ventanaPartidos.getTf_NomLugar().setText(this.partido.getLugar());
            this.ventanaPartidos.getTf_FechaPartido().setText(this.partido.getFechaPartido());
        }else{
            this.ventanaPartidos.getTf_ClvPartido().setText("");
            this.ventanaPartidos.getTf_NomLugar().setText("");
            this.ventanaPartidos.getTf_FechaPartido().setText("2");
        }
        
        this.ventanaPartidos.getTf_ClvPartido().requestFocus();
    }
    public void saveData(){
        if(partido == null){
            partido = new Partido();
        }
        partido.setClvPartido(Integer.parseInt(ventanaPartidos.getTf_ClvPartido().getText()));
        partido.setLugar(ventanaPartidos.getTf_NomLugar().getText());
        partido.setEquipo_Uno(Integer.parseInt((String) ventanaPartidos.getCb_EquipoUno().getSelectedItem()));
        partido.setEquipo_Dos(Integer.parseInt((String) ventanaPartidos.getCb_EquipoDos().getSelectedItem()));
        partido.setFechaPartido(ventanaPartidos.getTf_FechaPartido().getText());
        
    }
    
    private Partido getPartidoSeleccionado() throws DAOException{
       int id = (int) this.ventanaPartidos.getTb_Partidos().getValueAt(this.ventanaPartidos.getTb_Partidos().getSelectedRow(), 0);
       return manager.getPartidoDAO().obtener(id);
    } 

}
