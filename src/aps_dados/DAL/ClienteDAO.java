/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_dados.DAL;

import aps_dados.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 *
 * @author brian
 */
public class ClienteDAO {
    private static String mensagem;
    public static void cadastrar(Cliente cliente) {
        mensagem = "";
        try {
            Connection con = Conexao.getCon();
            String instrucao = "insert into Tb_Cliente (Nm_Cliente, Nr_Rg, Nr_Cpf, Nr_Tel, Dt_Nascimento, Id_Endereco) "
                    + "values (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(instrucao);
            stmt.setString(1, cliente.getNm_Cliente());
            stmt.setString(2, cliente.getNr_Rg());
            stmt.setString(3, cliente.getNr_Cpf());
            stmt.setString(4, cliente.getNr_Tel());
            stmt.setString(5, cliente.getDt_Nascimento());
            stmt.setInt(6, cliente.getID_Endereco());
            stmt.execute();
            mensagem = "Cadastrado com sucesso.";
        }
        catch (Exception e) {
            mensagem = "Erro ao cadastrar cliente.";
        }
    }
}