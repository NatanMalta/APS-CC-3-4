/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_dados;

import aps_dados.model.Cliente;
import aps_dados.model.Controle;

/**
 *
 * @author brian
 */
public class APS_Dados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Controle controle = new Controle();
        Cliente cliente = new Cliente();
        cliente.setNm_Cliente("luka");
        controle.pesquisarPorNome(cliente);
    }
}