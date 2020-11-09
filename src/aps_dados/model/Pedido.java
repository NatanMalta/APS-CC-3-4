/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_dados.model;

/**
 *
 * @author brian
 */
public class Pedido {
    private int ID_Pedido;
    private int ID_Cliente;
    private int ID_Empresa;

    public int getID_Pedido() {
        return ID_Pedido;
    }

    public void setID_Pedido(int ID_Pedido) {
        this.ID_Pedido = ID_Pedido;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public int getID_Empresa() {
        return ID_Empresa;
    }

    public void setID_Empresa(int ID_Empresa) {
        this.ID_Empresa = ID_Empresa;
    }
    
}