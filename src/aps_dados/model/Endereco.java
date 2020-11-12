/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_dados.model;

/**
 *
 * @author brian
 */
public class Endereco {
    private int ID_Endereco;
    private String Nm_Rua;
    private int Nr_Casa;
    private String Nm_Bairro;
    private String Nr_Cep;
    private String Nm_Cidade;
    private String Nm_Estado;
    private String Us_Estado;
    private String Nr_Lat;
    private String Nr_Lon;

    public int getID_Endereco() {
        return ID_Endereco;
    }

    public void setID_Endereco(int ID_Endereco) {
        this.ID_Endereco = ID_Endereco;
    }

    public String getNm_Rua() {
        return Nm_Rua;
    }

    public void setNm_Rua(String Nm_Rua) {
        this.Nm_Rua = Nm_Rua;
    }

    public int getNr_Casa() {
        return Nr_Casa;
    }

    public void setNr_Casa(int Nr_Casa) {
        this.Nr_Casa = Nr_Casa;
    }

    public String getNm_Bairro() {
        return Nm_Bairro;
    }

    public void setNm_Bairro(String Nm_Bairro) {
        this.Nm_Bairro = Nm_Bairro;
    }

    public String getNr_Cep() {
        return Nr_Cep;
    }

    public void setNr_Cep(String Nr_Cep) {
        this.Nr_Cep = Nr_Cep;
    }

    public String getNm_Cidade() {
        return Nm_Cidade;
    }

    public void setNm_Cidade(String Nm_Cidade) {
        this.Nm_Cidade = Nm_Cidade;
    }

    public String getNm_Estado() {
        return Nm_Estado;
    }

    public void setNm_Estado(String Nm_Estado) {
        this.Nm_Estado = Nm_Estado;
    }

    public String getUs_Estado() {
        return Us_Estado;
    }

    public void setUs_Estado(String Us_Estado) {
        this.Us_Estado = Us_Estado;
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
}