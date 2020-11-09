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
public class Empresa {
    private int ID_Empresa;
    private String Nm_Empresa;
    private String Nr_Cnpj;
    private String Nr_Tel;
    private int ID_Endereco;

    public int getID_Empresa() {
        return ID_Empresa;
    }

    public void setID_Empresa(int ID_Empresa) {
        this.ID_Empresa = ID_Empresa;
    }

    public String getNm_Empresa() {
        return Nm_Empresa;
    }

    public void setNm_Empresa(String Nm_Empresa) {
        this.Nm_Empresa = Nm_Empresa;
    }

    public String getNr_Cnpj() {
        return Nr_Cnpj;
    }

    public void setNr_Cnpj(String Nr_Cnpj) {
        this.Nr_Cnpj = Nr_Cnpj;
    }

    public String getNr_Tel() {
        return Nr_Tel;
    }

    public void setNr_Tel(String Nr_Tel) {
        this.Nr_Tel = Nr_Tel;
    }

    public int getID_Endereco() {
        return ID_Endereco;
    }

    public void setID_Endereco(int ID_Endereco) {
        this.ID_Endereco = ID_Endereco;
    }
    
}