/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ModelosDAO;

import ModelosD.Equipo;
import java.util.List;
import mysqlImplements.DAOException;

/**
 *
 * @author braul
 */
public interface DAO<Objeto,Tipo> {
     
    
    void agregar(Objeto e) throws DAOException;
    void eliminar(Objeto e)throws DAOException;
    void modificar(Objeto e)throws DAOException;
    Objeto obtener(Tipo id)throws DAOException;
    List<Objeto> obtenerTodos()throws DAOException;
    
}
