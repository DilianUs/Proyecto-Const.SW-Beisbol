package Controladores;

import ModelosD.Partido;
import TableModels.PartidoTableModel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        this.ventanaPartidos.getTb_Partidos().getSelectionModel().addListSelectionListener(e ->{
            boolean seleccionValida = (this.ventanaPartidos.getTb_Partidos().getSelectedRow()!=-1);
            this.ventanaPartidos.getBtn_Editar().setEnabled(seleccionValida);
            this.ventanaPartidos.getBtn_Borrar().setEnabled(seleccionValida);
        });
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
            borrarBtnAction();
        }
        if(actionUser.getSource() == this.ventanaPartidos.getBtn_Guardar()){
                guardarBtnAction();         
        }
        if(actionUser.getSource() == this.ventanaPartidos.getBtn_Cancelar()){
            cancelarBtnAction();
        }
    }
    //metodos de botones
    private void nuevoBtnAction() throws ParseException {
        loadData(null);
        setPartido(null);
        setEditableClv(true, true);
        this.ventanaPartidos.getBtn_Guardar().setEnabled(true);
        this.ventanaPartidos.getBtn_Cancelar().setEnabled(true);        
    }

    private void editarBtnAction() throws ParseException {
           try {
            Partido partidoSelected = getPartidoSeleccionado();
            loadData(partidoSelected);

            setEditableClv(false,true); 
            
            this.ventanaPartidos.getBtn_Guardar().setEnabled(true);
            this.ventanaPartidos.getBtn_Cancelar().setEnabled(true);
           
        } catch (DAOException ex) {
            Logger.getLogger(ControladorVentanaEquipos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        this.ventanaPartidos.getTf_ClvPartido().setEditable(editableClv);
        this.ventanaPartidos.getTf_NomLugar().setEditable(editableElement);
        this.ventanaPartidos.getCb_EquipoUno().setEditable(editableElement);
        this.ventanaPartidos.getCb_EquipoDos().setEditable(editableElement);
        
    }
    
    public void loadData(Partido partidoCargar) throws ParseException{
        if(partidoCargar != null){
            this.ventanaPartidos.getTf_ClvPartido().setText(String.valueOf(partidoCargar.getClvPartido()));
            this.ventanaPartidos.getTf_NomLugar().setText(partidoCargar.getLugar());
           Date fechaFormateada = convertirFechaJDC(partidoCargar.getFechaPartido());
            this.ventanaPartidos.getTf_FechaPartido().setDate(fechaFormateada);
        }else{
            this.ventanaPartidos.getTf_ClvPartido().setText("");
            this.ventanaPartidos.getTf_NomLugar().setText("");
            this.ventanaPartidos.getTf_FechaPartido().setDateFormatString("");
        }
        
        this.ventanaPartidos.getTf_ClvPartido().requestFocus();
    }
    public void saveData(){
        if(partido == null){
            partido = new Partido();
        }
        partido.setClvPartido(Integer.parseInt(ventanaPartidos.getTf_ClvPartido().getText()));
        partido.setLugar(ventanaPartidos.getTf_NomLugar().getText());
        String fechaFormatoCorrecto = convertirFechaBD(ventanaPartidos.getTf_FechaPartido().getDate());
        partido.setFechaPartido(fechaFormatoCorrecto);
    }
    
    private Partido getPartidoSeleccionado() throws DAOException{
       int id = (int) this.ventanaPartidos.getTb_Partidos().getValueAt(this.ventanaPartidos.getTb_Partidos().getSelectedRow(), 0);
       return manager.getPartidoDAO().obtener(id);
    } 
    
    private String convertirFechaBD(Date fechaJCal){
        SimpleDateFormat formato_FechaBD = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFormateada = formato_FechaBD.format(fechaJCal);
        return fechaFormateada;
    }
    
    private Date convertirFechaJDC(String fechaString) throws ParseException{
        SimpleDateFormat formato_FechaJCalendar = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaFormateada;      
            fechaFormateada = formato_FechaJCalendar.parse(fechaString);
            return fechaFormateada;
   
    }
 
}
