/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_dados.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author brian
 */
public class Conexao {
    private static Connection con;
    private static String mensagem;
    public static void conectar() {
        mensagem = "";
        try {
            if(con == null || con.isClosed()) {
                con = DriverManager.getConnection("jdbc:sqlserver://35.247.213.106:1433;databaseName=DB_APS",
                        "sa", "Unip2020*");
            }
        }
        catch (Exception e) {
            mensagem = "Erro de conexão SQL.";
        }
    }
    public static Connection getCon() {
        try {
            if(con == null || con.isClosed()) {
                conectar();
            }
        }
        catch (Exception e) {
            mensagem = "Erro de conexão";
        }
        return con;
    }
    public static String getMensagem() {
        return mensagem;
    }
}