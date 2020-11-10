/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_dados.DAL;

import aps_dados.model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author brian
 */
public class EnderecoDAO {
    private static String mensagem;
    public static void cadastrar(Endereco endereco) {
        if (endereco == null) return;
        mensagem = "";
        try {
            Connection con = Conexao.getCon();
            String instrucao = "insert into Tb_Endereco (Nm_Rua, Nr_Casa, Nm_Bairro, Nr_Cep, Nm_Cidade, Nm_Estado, Us_Estado)"
                    + "values( ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(instrucao);
            stmt.setString(1, endereco.getNm_Rua());
            stmt.setInt(2, endereco.getNr_Casa());
            stmt.setString(3, endereco.getNm_Bairro());
            stmt.setString(4, endereco.getNr_Cep());
            stmt.setString(5, endereco.getNm_Cidade());
            stmt.setString(6, endereco.getNm_Estado());
            stmt.setString(7, endereco.getUs_Estado());
            stmt.execute();
            mensagem = "Cadastrado com sucesso.";
        }
        catch (SQLException e) {
            mensagem = "Erro ao cadastrar cliente.";
        }
    }
    public static void deletar(Endereco endereco) {
        mensagem = "";
        try {
            Connection con = Conexao.getCon();
            PreparedStatement stmt = con.prepareStatement("delete from Tb_Endereco where ID_Endereco = ?");
            stmt.setInt(1, endereco.getID_Endereco());
            stmt.execute();
            mensagem = "Deletado com sucesso";
        }
        catch (Exception e) {
            mensagem = "Erro ao deletar endereço.";
        }
    }
    public static String getMensagem() {
        return mensagem;
    }
    public static Endereco pesquisarPorID(int id) {
        mensagem = "";
        try {
            Connection con = Conexao.getCon();
            String instrucao = "select * from Tb_Endereco where ID_Endereco = ?";
            PreparedStatement stmt = con.prepareStatement(instrucao);
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            resultado.next();
            Endereco novoEndereco = new Endereco();
            novoEndereco.setID_Endereco(resultado.getInt("ID_Endereco"));
            novoEndereco.setNm_Rua(resultado.getString("Nm_Rua"));
            novoEndereco.setNr_Casa(resultado.getInt("Nr_Casa"));
            novoEndereco.setNm_Bairro(resultado.getString("Nm_Bairro"));
            novoEndereco.setNr_Cep(resultado.getString("Nr_Cep"));
            novoEndereco.setNm_Cidade(resultado.getString("Nm_Cidade"));
            novoEndereco.setNm_Estado(resultado.getString("Nm_Estado"));
            novoEndereco.setUs_Estado(resultado.getString("Us_Estado"));;
            mensagem = "Pesquisado com sucesso.";
            return novoEndereco;
        }
        catch (Exception e) {
            mensagem = "Nenhum resultado encontrado.";
        }
        return null;
    }
}