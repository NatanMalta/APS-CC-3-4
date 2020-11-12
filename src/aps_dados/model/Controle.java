package aps_dados.model;

import aps_dados.DAL.ClienteDAO;
import aps_dados.DAL.EmpresaDAO;
import java.util.List;

/**
 *
 * @author muril
 */
public class Controle
{
    
    private static String mensagem;
    
    
    public static List<Cliente> pesquisarPorNome(Cliente cliente)
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
    
    public static List<Empresa> pesquisarEmpresa(Empresa empresa)
    {
         
        
        Validacao.ValidarEmpresa(empresa);
       
        if(Validacao.getMensagem().equals(""))
        {
            List<Empresa> nomesEmpresa = EmpresaDAO.pesquisarPorNome(empresa.getNm_Empresa());
            
            
            if(nomesEmpresa == null)
            {
                return nomesEmpresa;
            }
            
        }
                
        return null;
    }  
}
