/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_dados.DAL;

import static aps_dados.DAL.ClienteDAO.mensagem;
import aps_dados.model.Capturar;
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
    
    /*public static List<Cliente> clientes = new ArrayList<>();
    public static List<Pedido> pedidos = new ArrayList<>();
    public static List<Endereco> enderecos = new ArrayList<>();*/
    
   //public static List<Capturar> captura = new ArrayList<>();
    public static List<Comparable> captura = new ArrayList<>();
    
   private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM
    
    
    public static void pedido() {
        mensagem = "";
        try {
            captura = new ArrayList<>();
            Connection con = Conexao.getCon();
            String instrucao = "select p.ID_Pedido, c.Nm_Cliente, e.Nm_Rua, e.Nm_Bairro, e.Nr_Lat, e.Nr_Lon, e.Nm_Cidade from TB_Cliente as c inner join TB_Pedido as p on c.ID_Cliente = p.ID_Cliente inner join TB_Endereco as e on c.ID_Endereco = e.ID_Endereco";
            PreparedStatement stmt = con.prepareStatement(instrucao);

            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()) {
                
                
                Capturar novoCaptura = new Capturar();
                
                /*Cliente novoCliente = new Cliente();
                Endereco novoEndereco = new Endereco();
                Pedido novoPedido = new Pedido();*/
                
                
                novoCaptura.setNm_Cliente(resultado.getString("Nm_Cliente"));
                
                novoCaptura.setNm_Rua(resultado.getString("Nm_Rua"));
                novoCaptura.setNm_Bairro(resultado.getString("Nm_Bairro"));
                novoCaptura.setNr_Lat(resultado.getString("Nr_Lat"));
                novoCaptura.setNr_Lon(resultado.getString("Nr_Lon"));
                novoCaptura.setNm_Cidade(resultado.getString("Nm_Cidade"));
                
                novoCaptura.setID_Pedido(resultado.getInt("ID_Pedido"));
                novoCaptura.setNr_Distancia( distance(-23.500385,-47.4620022, Double.parseDouble(resultado.getString("Nr_Lat")),
                        Double.parseDouble(resultado.getString("Nr_Lon"))) );
                
                captura.add(novoCaptura);
                //@-23.500385,-47.4620022
                
                
            }
            mensagem = "Sua pesquisa retornou " + captura.size()  +  " resultados.";
            
            
        }
        catch (SQLException e) {
            mensagem = e.getMessage();
        }
        
    }
    
    
    
    
    

    public static Double distance(Double startLat, Double startLong,Double endLat, Double endLong)
    {

        Double dLat  = Math.toRadians((endLat - startLat));
        Double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat   = Math.toRadians(endLat);

        Double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c; // <-- d
    }

    public static Double haversin(Double val)
    {
        return Math.pow(Math.sin(val / 2), 2);
    }
    }
