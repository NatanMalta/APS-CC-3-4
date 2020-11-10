/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_dados.DAL;

import aps_dados.model.Empresa;
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
public class EmpresaDAO {
    public static String mensagem;
    public static Empresa pesquisarPorID(int id) {
        mensagem = "";
        List<Empresa> listaEmpresas = new ArrayList<>();
        try {
            Connection con = Conexao.getCon();
            String instrucao = "select * from Tb_Empresa";
            PreparedStatement stmt = con.prepareStatement(instrucao);
            ResultSet resultado = stmt.executeQuery();
            resultado.next();
            Empresa novaEmpresa = new Empresa();
            novaEmpresa.setID_Empresa(resultado.getInt("ID_Empresa"));
            novaEmpresa.setNm_Empresa(resultado.getString("Nm_Empresa"));
            novaEmpresa.setNr_Cnpj(resultado.getString("Nr_Cnpj"));
            novaEmpresa.setNr_Tel(resultado.getString("Nr_Tel"));
            novaEmpresa.setID_Endereco(resultado.getInt("ID_endereco"));
            mensagem = "Empresa encontrada com sucesso.";
            return novaEmpresa;
        }
        catch (SQLException e) {
            mensagem = "Ocorreu um erro ao pesquisar";
        }
        return null;
    }
    public static void deletar(Empresa empresa) {
        deletar(empresa.getID_Empresa());
    }
    public static void deletar(int id) {
        mensagem = "";
        try {
            Connection con = Conexao.getCon();
            String instrucao = "delete from Tb_Empresa where ID_Empresa = ?";
            PreparedStatement stmt = con.prepareStatement(instrucao);
            stmt.setInt(1, id);
            stmt.execute();
            mensagem = "Empresa " + id + " deletada com sucesso.";
        }
        catch (SQLException e) {
            mensagem = "Ocorreu um erro ao deletar a empresa de ID " + id;
        }
    }
    public static List<Empresa> pesquisarPorNome(String nome) {
        mensagem = "";
        try {
            Connection con = Conexao.getCon();
            List<Empresa> listaEmpresas = new ArrayList<>();
            String instrucao = "select * from Tb_Empresa where Nm_Empresa like %?%";
            PreparedStatement stmt = con.prepareStatement(instrucao);
            stmt.setString(1, nome);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()) {
                Empresa novaEmpresa = new Empresa();
                novaEmpresa.setID_Empresa(resultado.getInt("ID_Empresa"));
                novaEmpresa.setNm_Empresa(resultado.getString("Nm_Empresa"));
                novaEmpresa.setNr_Cnpj(resultado.getString("Nr_Cnpj"));
                novaEmpresa.setNr_Tel(resultado.getString("Nr_Tel"));
                novaEmpresa.setID_Endereco(resultado.getInt("ID_Endereco"));
                listaEmpresas.add(novaEmpresa);
            }
            mensagem = "A pesquisa retornou " + listaEmpresas.size() + " resultados.";
            return listaEmpresas;
        }
        catch (Exception e) {
            mensagem = "Erro ao pesquisar por empresas no banco de dados.";
        }
        return null;
    }
}