/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_dados.DAL;

import aps_dados.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author brian
 */
public class ClienteDAO {
    public static String mensagem;
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
            stmt.setDate(5, cliente.getDt_Nascimento());
            stmt.setInt(6, cliente.getID_Endereco());
            stmt.execute();
            mensagem = "Cadastrado com sucesso.";
        }
        catch (SQLException e) {
            mensagem = "Erro ao cadastrar cliente.";
        }
    }
    public static List<Cliente> pesquisarPorNome(String nome) {
        mensagem = "";
        try {
            Connection con = Conexao.getCon();
            List<Cliente> listaClientes = new ArrayList<>();
            String instrucao = "select * from Tb_Cliente where Nm_Cliente like %?%";
            PreparedStatement stmt = con.prepareStatement(instrucao);
            stmt.setString(1, nome);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next) {
                Cliente novoCliente = new Cliente();
                novoCliente.setID_Cliente(resultado.getInt("ID_Cliente"));
                novoCliente.setNm_Cliente(resultado.getString("Nm_Cliente"));
                novoCliente.setNr_Rg(resultado.getString("Nr_Rg"));
                novoCliente.setNr_Cpf(resultado.getString("Nr_Cpf"));
                novoCliente.setNr_Tel(resultado.getString("Nr_Tel"));
                novoCliente.setDt_Nascimento(resultado.getDate("Dt_Nascimento"));
                novoCliente.setID_Endereco(resultado.getInt("ID_Endereco"));
                listaClientes.add(novoCliente);
            }
            mensagem = "Sua pesquisa retornou " + listaClientes.size() + " resultados.";
            return listaClientes;
        }
        catch (SQLException e) {
            mensagem = "Erro ao pesquisar clientes.";
        }
        return null;
    }
}