package Controladores;

import ComboBoxModel.EquipoComboModel;
import ModelosD.Equipo;
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
                try {
                    nuevoBtnAction();
                } catch (DAOException ex) {
                    Logger.getLogger(ControladorVentanaPartidos.class.getName()).log(Level.SEVERE, null, ex);
                }
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
            } catch (DAOException ex) {
                Logger.getLogger(ControladorVentanaPartidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(actionUser.getSource() == this.ventanaPartidos.getBtn_Guardar()){
            try {         
                guardarBtnAction();
            } catch (ParseException ex) {
                Logger.getLogger(ControladorVentanaPartidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(actionUser.getSource() == this.ventanaPartidos.getBtn_Cancelar()){
            try {
                cancelarBtnAction();
            } catch (ParseException ex) {
                Logger.getLogger(ControladorVentanaPartidos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DAOException ex) {
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
    private void nuevoBtnAction() throws ParseException, DAOException {
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

    private void borrarBtnAction() throws ParseException, DAOException {
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

    private void guardarBtnAction() throws ParseException {
        try {
            saveData();
            Partido partidoActual = getPartido();
           
            Boolean existe = (manager.getPartidoDAO().obtener(partidoActual.getClvPartido())!=null);
          
            if(existe==true){
                manager.getPartidoDAO().modificar(partidoActual);
            }else{
                manager.getPartidoDAO().agregar(partidoActual);
            }
            setPartido(null);
            loadData();
            setEditableClv(false, false);
            this.ventanaPartidos.getTb_Partidos().clearSelection();
            this.ventanaPartidos.getBtn_Guardar().setEnabled(false);
            this.ventanaPartidos.getBtn_Cancelar().setEnabled(false);
            model.updateModel();
            model.fireTableDataChanged();
        } catch (DAOException ex) {
            Logger.getLogger(ControladorVentanaPartidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cancelarBtnAction() throws ParseException, DAOException {
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
    
    public void loadData() throws ParseException, DAOException  {
        if(this.partido != null){
            this.ventanaPartidos.getTf_ClvPartido().setText(String.valueOf(this.partido.getClvPartido()));
            this.ventanaPartidos.getTf_NomLugar().setText(this.partido.getLugar());
       
            String equipoLocal = obtenerEquipoString(partido.getEquipo_Uno());
            this.ventanaPartidos.getCb_EquipoUno().setSelectedItem(equipoLocal);
            String equipoVisitante = obtenerEquipoString(partido.getEquipo_Dos());
            this.ventanaPartidos.getCb_EquipoDos().setSelectedItem(equipoVisitante);
            this.ventanaPartidos.getTf_FechaPartido().setText(this.partido.getFechaPartido());
            
        }else{
            this.ventanaPartidos.getTf_ClvPartido().setText("");
            this.ventanaPartidos.getTf_NomLugar().setText("");
            this.ventanaPartidos.getTf_FechaPartido().setText("2");
        }
        
        this.ventanaPartidos.getTf_ClvPartido().requestFocus();
    }
    
    private String obtenerEquipoString(int ClvEquipo) throws DAOException{
             Equipo equipo =manager.getEquipoDAO().obtener(ClvEquipo);
             String equipoObtenido = equipo.getNombreEquipo()+"("+equipo.getClaveEquipo()+")";
          
             return equipoObtenido;    
    }
    
    
    
    public void saveData(){
        if(this.partido == null){
            setPartido(new Partido());
        }
        this.partido.setClvPartido(Integer.parseInt(ventanaPartidos.getTf_ClvPartido().getText()));
       this.partido.setLugar(ventanaPartidos.getTf_NomLugar().getText());
        int clvEquipoUno = obtenerNumeroClv((String) ventanaPartidos.getCb_EquipoUno().getSelectedItem());
        this.partido.setEquipo_Uno(clvEquipoUno);
         int clvEquipoDos = obtenerNumeroClv((String) ventanaPartidos.getCb_EquipoDos().getSelectedItem());
       this. partido.setEquipo_Dos(clvEquipoDos);
        this.partido.setFechaPartido(ventanaPartidos.getTf_FechaPartido().getText());
       this. partido.setHora(20);
        
    }
    
    private Partido getPartidoSeleccionado() throws DAOException{
       int id = (int) this.ventanaPartidos.getTb_Partidos().getValueAt(this.ventanaPartidos.getTb_Partidos().getSelectedRow(), 0);
       return manager.getPartidoDAO().obtener(id);
    } 
    private int obtenerNumeroClv(String cadena){
        char[] cadena_div=cadena.toCharArray();
        String numerosEncontrados ="";
        for(int i=0;i<cadena_div.length;i++){
            if(Character.isDigit(cadena_div[i])){
                numerosEncontrados +=cadena_div[i];
            }
        }
        
        int claveObtenida = Integer.parseInt(numerosEncontrados );
        return claveObtenida;
    }

}
