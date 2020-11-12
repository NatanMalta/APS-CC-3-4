/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_dados.DAL;

import aps_dados.model.Cliente;
import aps_dados.model.Endereco;
import aps_dados.model.Pedido;
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
            String instrucao = "select * from Tb_Cliente where Nm_Cliente like ? ";
            PreparedStatement stmt = con.prepareStatement(instrucao);
            stmt.setString(1, "%" + nome + "%");
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()) {
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
            mensagem = e.getMessage();
        }
        return null;
    }
    
    
    
    public static List<List> pedido() {
        mensagem = "";
        try {
            Connection con = Conexao.getCon();
            List<List> listaClientes = new ArrayList<>();
            String instrucao = "select p.ID_Pedido, c.Nm_Cliente, e.Nm_Rua, e.Nm_Bairro, e.Nr_Lat, e.Nr_Lon, e.Nm_Cidade from TB_Cliente as c inner join TB_Pedido as p on c.ID_Cliente = p.ID_Cliente inner join TB_Endereco as e on c.ID_Endereco = e.ID_Endereco";
            PreparedStatement stmt = con.prepareStatement(instrucao);

            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()) {
                
                List<List> Clientes = new ArrayList<>();
                Cliente novoCliente = new Cliente();
                Endereco novoEndereco = new Endereco();
                Pedido novoPedido = new Pedido();
                
                
                novoCliente.setNm_Cliente(resultado.getString("Nm_Cliente"));
                
                novoEndereco.setNm_Rua(resultado.getString("Nm_Rua"));
                novoEndereco.setNm_Bairro(resultado.getString("Nm_Bairro"));
                novoEndereco.setNr_Lat(resultado.getString("Nr_Lat"));
                novoEndereco.setNr_Lon(resultado.getString("Nr_Lon"));
                novoEndereco.setNm_Cidade(resultado.getString("Nm_Cidade"));
                
                novoPedido.setID_Pedido(resultado.getInt("ID_Pedido"));
                
                Clientes.add((List) novoCliente);
                Clientes.add((List) novoEndereco);
                Clientes.add((List) novoPedido);
                listaClientes.add(Clientes);
            }
            mensagem = "Sua pesquisa retornou " + listaClientes.size() + " resultados.";
            return listaClientes;
        }
        catch (SQLException e) {
            mensagem = e.getMessage();
        }
        return null;
    }
    
    
    
    
}








