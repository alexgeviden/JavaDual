/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.util.List;
import Modelo.Cliente;

/**
 *
 * @author a925660
 */
public interface CRUD {
    
    /**
     *
     * @return
     */
    public List listar();
    public Cliente list(int dni);
    public boolean add(Cliente cli);
    public boolean edit(Cliente cli);
    public boolean eliminar(int dni);
    
}
