/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModels;

import ModelosD.Boleto;
import ModelosDAO.BoletoDAO;
import ModelosDAO.EquipoDAO;
import ModelosDAO.PartidoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author braul
 */
public class BoletosTableModel {
    private PartidoDAO partidos;
    private EquipoDAO equipos;
    private BoletoDAO boletos;
    private List<Boleto> datos = new ArrayList<>();
    
}
