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
        
        boolean status = false;
        
        int codLogin = loginController.cadastrarLoginController(loginBean, "c");
        
        clienteBean.setCodLogin(codLogin);
        
        status = clienteDAO.cadastrarCliente(clienteBean);
        
        return status;
        
    }
    
    public void alterarCLienteController(Cliente clienteBean) {
        
        clienteDAO.alterarCliente(clienteBean);
        
    }
    
    public void statusClienteController(Cliente clienteBean) {
        
        //clienteDAO.desativarAtivarCliente(clienteBean);
        
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
        
        int id = clienteDAO.pegarId(clienteBean);
        
        return id;
        
    }
    
}
