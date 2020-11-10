/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_dados.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author muril
 */
public class Controle {
    
    private static String mensagem;
    aps_dados.DAL.ClienteDAO ClienteDAO = new aps_dados.DAL.ClienteDAO();
    
    public static List<Cliente> pesquisarClientePorNome(String nome)
    {
        mensagem = "";
        
        List<String> listaDadosPessoa = new ArrayList<>();
        
    }
}
