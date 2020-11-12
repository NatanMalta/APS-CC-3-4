package aps_dados;

import aps_dados.model.Cliente;
import aps_dados.model.Controle;

/**
 *
 * @author brian
 */

public class APS_Dados {

    public static void main(String[] args) {

        Controle controle = new Controle();
        Cliente cliente = new Cliente();
        cliente.setNm_Cliente("lukao");
        controle.pesquisarPorNome(cliente);
    }
}