/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author IGNITER
 */
public interface InterfaceDireccionDAO {
    
    public Direccion agregarLugar(String claveLugar, String nombreLugar, int calle, int numero);
    
    public void eliminarDireccion(Direccion direccion);
    
    public void actualizarDireccion(Direccion direccion);
    
    public Direccion buscarDireccion(String claveLugar);
}
