/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ModelosDAO;

/**
 *
 * @author braul
 */
public interface DAOManager {
    
    EquipoDAO getEquipoDAO();
    
    PartidoDAO getPartidoDAO();
    
    BoletoDAO getBoletoDAO();
    
}
