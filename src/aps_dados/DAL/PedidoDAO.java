/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_dados.DAL;

import aps_dados.model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author brian
 */
public class PedidoDAO {
    public static String mensagem;
    public static Pedido pesquisarPorID(int id) {
        mensagem = "";
        try {
            Connection con = Conexao.getCon();
            String instrucao = "select * from Tb_Pedido where ID_Pedido = ?";
            PreparedStatement stmt = con.prepareStatement(instrucao);
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            resultado.next();
            Pedido novoPedido = new Pedido();
            novoPedido.setID_Pedido(resultado.getInt("ID_Pedido"));
            novoPedido.setID_Cliente(resultado.getInt("ID_Pedido"));
            novoPedido.setID_Empresa(resultado.getInt("ID_Empresa"));
            mensagem = "Pesquisa realizada com sucesso.";
            return novoPedido;
        }
        catch (Exception e) {
            mensagem = "Nenhum resultado.";
        }
        return null;
    }
}