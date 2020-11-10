/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_dados.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author muril
 */
public class Validacao {
    private String mensagem;
    private static String identificacao;
    private static int id;
    private Cliente cliente;
    private Empresa empresa;
    private Endereco endereco;
    private Pedido pedido;
    
    public void ValidarCliente(Cliente cliente)
    {
        this.mensagem = "";
        this.cliente = cliente;
        if (cliente.getNm_Cliente().length() < 3)
            this.mensagem += "Nome deve ter mais que 3 caracteres \n";
        if (cliente.getNm_Cliente().length() > 150)
            this.mensagem += "Nome deve ter menos que 150 character \n";
        if(cliente.getNr_Rg().length() > 9)
            this.mensagem += "Rg ivalido numero maior que 9\n";
        if(cliente.getNr_Cpf().length() > 11)
            this.mensagem += "CPF invalido acima de 11 caracter";
        if(cliente.getNr_Tel().length() > 11)
            this.mensagem += "Numero telefone Invalido acima de 11 numeros";
        
    }
    
    public void ValidarEmpresa(Empresa empresa)
    {
        this.mensagem = "";
        this.empresa = empresa;
        if(empresa.getNm_Empresa().length() <3)
            this.mensagem += "Nome muito pequeno";
        if(empresa.getNm_Empresa().length() > 150)
            this.mensagem += "nome da empresa muito grando";
        if(empresa.getNr_Cnpj().length() > 14)
            this.mensagem += "CNPJ invalido maior que 14";
        if(empresa.getNr_Tel().length() > 11)
            this.mensagem += "Numero telefone Invalido acima de 11 numeros";
    }
    
    public void ValidarEndereco(Endereco endereco)
    {
        this.mensagem = "";
        this.endereco = endereco;
        if(endereco.getNm_Rua().length() > 150)
            this.mensagem += "Rua invalida muito grande";
        if(endereco.getNm_Bairro().length() > 150)
            this.mensagem += "Rua invalida muito grande";
        if(endereco.getNr_Cep().length() > 9)
            this.mensagem += "Cep Invalido";
        if(endereco.getNm_Cidade().length() > 50)
            this.mensagem += "Nome da cidade maior que 50 character";
        if(endereco.getNm_Estado().length() > 50)
            this.mensagem += "Nome do Estado mair que 50 character";
        if(endereco.getUs_Estado().length() > 2)
            this.mensagem += "Siglas invalidas Maior que 2 siglas";
    }
    
}
