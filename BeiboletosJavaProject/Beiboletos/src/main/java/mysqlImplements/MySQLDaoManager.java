/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysqlImplements;

import ModelosDAO.BoletoDAO;
import ModelosDAO.DAOManager;
import ModelosDAO.EquipoDAO;
import ModelosDAO.PartidoDAO;

/**
 *
 * @author braul
 */
public class MySQLDaoManager implements DAOManager{
    
    private EquipoDAO equipo = null;
    private PartidoDAO partido = null;
    private BoletoDAO boleto = null;

    @Override
    public EquipoDAO getEquipoDAO() {
      if(equipo==null){
          equipo=new MySQLEquipoDAO();
      }
      return equipo;
    }

    @Override
    public PartidoDAO getPartidoDAO() {
      if(partido==null){
          partido=new MySQLPartidoDAO();
      }
      return partido;
    }

    @Override
    public BoletoDAO getBoletoDAO() {
      if(boleto==null){
          boleto=new MySQLBoletoDAO();
      }
      return boleto;
    }
    
    
    
    
    
    
}
