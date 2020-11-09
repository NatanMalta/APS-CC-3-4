/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_dados.model;

import java.sql.Date;
/**
 *
 * @author brian
 */
public class Cliente {
    private int ID_Cliente;
    private String Nm_Cliente;
    private String Nr_Rg;
    private String Nr_Cpf;
    private String Nr_Tel;
    private Date Dt_Nascimento;
    private int ID_Endereco;

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getNm_Cliente() {
        return Nm_Cliente;
    }

    public void setNm_Cliente(String Nm_Cliente) {
        this.Nm_Cliente = Nm_Cliente;
    }

    public String getNr_Rg() {
        return Nr_Rg;
    }

    public void setNr_Rg(String Nr_Rg) {
        this.Nr_Rg = Nr_Rg;
    }

    public String getNr_Cpf() {
        return Nr_Cpf;
    }

    public void setNr_Cpf(String Nr_Cpf) {
        this.Nr_Cpf = Nr_Cpf;
    }

    public String getNr_Tel() {
        return Nr_Tel;
    }

    public void setNr_Tel(String Nr_Tel) {
        this.Nr_Tel = Nr_Tel;
    }

    public Date getDt_Nascimento() {
        return Dt_Nascimento;
    }

    public void setDt_Nascimento(Date Dt_Nascimento) {
        this.Dt_Nascimento = Dt_Nascimento;
    }

    public int getID_Endereco() {
        return ID_Endereco;
    }

    public void setID_Endereco(int ID_Endereco) {
        this.ID_Endereco = ID_Endereco;
    }
}