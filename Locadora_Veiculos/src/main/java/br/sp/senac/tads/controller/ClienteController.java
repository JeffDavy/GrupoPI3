package br.sp.senac.tads.controller;

import br.sp.senac.tads.dao.ClienteDAO;
import br.sp.senac.tads.dao.LoginDAO;
import br.sp.senac.tads.model.Cliente;
import br.sp.senac.tads.model.Login;
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
    
    public void cadastrarClienteController(Cliente clienteBean, Login loginBean) {
        
        int codLogin = loginController.cadastrarLoginController(loginBean, "c");
        
        clienteBean.setCodLogin(codLogin);
        
        clienteDAO.cadastrarCliente(clienteBean);
        
    }
    
    public void alterarCLienteController(Cliente clienteBean) {
        
        clienteDAO.alterarCliente(clienteBean);
        
    }
    
    public void statusClienteController(Cliente clienteBean) {
        
        clienteDAO.desativarAtivarCliente(clienteBean);
        
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
    
}
