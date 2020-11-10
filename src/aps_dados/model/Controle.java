package aps_dados.model;

import aps_dados.DAL.ClienteDAO;
import java.util.List;

/**
 *
 * @author muril
 */
public class Controle
{
    
    private String mensagem;
    
    
    public List<Cliente> pesquisarPorNome(Cliente cliente)
    {
        Validacao validacao = new Validacao();
        validacao.ValidarCliente(cliente.getNm_Cliente());
        
        if(validacao.getMensagem().equals(""))
        {
            List<Cliente> listaClientes = ClienteDAO.pesquisarPorNome(cliente.getNm_Cliente());
            
            if(listaClientes != null)
            {
                return listaClientes;
            }            
        }      
        return null;
    }
}
