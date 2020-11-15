package aps_dados.model;

import aps_dados.DAL.tudoDAO;

/**
 *
 * @author natan
 */


public class Capturar implements Comparable<Capturar>
{
    
    private int ID_Pedido;
    private String Nm_Cliente;
    private String Nm_Rua;
    private String Nm_Bairro;
    private String Nr_Lat;
    private String Nr_Lon;
    private Double Nr_Distancia;
    private String Nm_Cidade;
    @Override
    public int compareTo(Capturar alvo) {
        return (int)(this.getNr_Distancia()*1000000 - alvo.getNr_Distancia()*1000000);
    }

    public int getID_Pedido() {
        return ID_Pedido;
    }

    public void setID_Pedido(int ID_Pedido) {
        this.ID_Pedido = ID_Pedido;
    }

    public String getNm_Cliente() {
        return Nm_Cliente;
    }

    public void setNm_Cliente(String Nm_Cliente) {
        this.Nm_Cliente = Nm_Cliente;
    }

    public String getNm_Rua() {
        return Nm_Rua;
    }

    public void setNm_Rua(String Nm_Rua) {
        this.Nm_Rua = Nm_Rua;
    }

    public String getNm_Bairro() {
        return Nm_Bairro;
    }

    public void setNm_Bairro(String Nm_Bairro) {
        this.Nm_Bairro = Nm_Bairro;
    }

    public String getNr_Lat() {
        return Nr_Lat;
    }

    public void setNr_Lat(String Nr_Lat) {
        this.Nr_Lat = Nr_Lat;
    }

    public String getNr_Lon() {
        return Nr_Lon;
    }

    public void setNr_Lon(String Nr_Lon) {
        this.Nr_Lon = Nr_Lon;
    }

    public double getNr_Distancia() {
        return Nr_Distancia;
    }

    public void setNr_Distancia(Double Nr_Distancia) {
        this.Nr_Distancia = Nr_Distancia;
    }

 

    public String getNm_Cidade() {
        return Nm_Cidade;
    }

    public void setNm_Cidade(String Nm_Cidade) {
        this.Nm_Cidade = Nm_Cidade;
    }
    
    
    
}
