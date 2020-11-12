/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_dados.DAL;

import static aps_dados.DAL.ClienteDAO.mensagem;
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
 * @author natan
 */
public class tudoDAO {
    
    public static List<Cliente> clientes = new ArrayList<>();
    public static List<Pedido> pedidos = new ArrayList<>();
    public static List<Endereco> enderecos = new ArrayList<>();
    
    
    public static void pedido() {
        mensagem = "";
        try {
            Connection con = Conexao.getCon();
            
            String instrucao = "select p.ID_Pedido, c.Nm_Cliente, e.Nm_Rua, e.Nm_Bairro, e.Nr_Lat, e.Nr_Lon, e.Nm_Cidade from TB_Cliente as c inner join TB_Pedido as p on c.ID_Cliente = p.ID_Cliente inner join TB_Endereco as e on c.ID_Endereco = e.ID_Endereco";
            PreparedStatement stmt = con.prepareStatement(instrucao);

            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()) {
                
                
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
                
                clientes.add(novoCliente);
                pedidos.add(novoPedido);
                enderecos.add(novoEndereco);
                
                
            }
            mensagem = "Sua pesquisa retornou  resultados.";
            System.out.println(enderecos.size());
            
        }
        catch (SQLException e) {
            mensagem = e.getMessage();
        }
        
    }
    
    
    
}
