package br.sp.senac.tads.controller;

import br.sp.senac.tads.model.ClienteDAO;
import br.sp.senac.tads.bean.Cliente;
import br.sp.senac.tads.bean.Login;
import java.util.ArrayList;

/**
 *
 * @author Jeferson Davi
 */
public class ClienteController {
    
    ClienteDAO clienteDAO = new ClienteDAO();
    LoginController loginController = new LoginController();

    public ClienteController() {
    }
    
    public boolean cadastrarClienteController(Cliente clienteBean, Login loginBean) {
        
        int codLogin = loginController.cadastrarLoginController(loginBean, "c");
        
        clienteBean.setCodLogin(codLogin);
        
        return clienteDAO.cadastrarCliente(clienteBean);
        
    }
    
    public boolean alterarCLienteController(Cliente clienteBean) {
        
        return clienteDAO.alterarCliente(clienteBean);
        
    }
    
    public boolean removerClienteController(Cliente clienteBean) {
        
        return clienteDAO.removerCliente(clienteBean);
        
    }
    
    public ArrayList consultarClienteController(Cliente clienteBean) {
        
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        
        listaCliente = clienteDAO.consultarCliente(clienteBean);
        
        return listaCliente;
        
    }
    
    public ArrayList listarClienteController(Cliente clienteBean) {
        
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        
        clienteDAO.listarClientes(clienteBean);
        
        return listaCliente;
        
    }
    
    public int pegarIdController(Cliente clienteBean) {
        
        return clienteDAO.pegarId(clienteBean);
        
    }
    
}
