package br.sp.senac.tads.controller;

import br.sp.senac.tads.dao.FuncionarioDAO;
import br.sp.senac.tads.model.Funcionario;
import br.sp.senac.tads.model.Login;
import java.util.ArrayList;

/**
 *
 * @author Jeferson Davi
 */
public class FuncionarioController {

    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    LoginController loginController = new LoginController();
    
    public FuncionarioController() {
    }
    
    public void cadastrarFuncionarioController(Funcionario funcBean, Login loginBean, String tipo) {
        
        int codLogin = loginController.cadastrarLoginController(loginBean, tipo);
        
        funcBean.setCodLogin(codLogin);
        
        funcionarioDAO.cadastrarFuncionario(funcBean);
        
    }
    
    public void alterarFuncionarioController(Funcionario funcBean) {
        
        funcionarioDAO.alterarFuncionario(funcBean);
        
    }
    
    public void statusFuncionarioController(Funcionario funcBean) {
        
        //funcionarioDAO.desativarAtivarCliente(funcBean);
        
    }
    
    public ArrayList consultarFuncionarioController(Funcionario funcBean) {
        
        ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        
        listaFuncionario = funcionarioDAO.consultarFuncionario(funcBean);
        
        return listaFuncionario;
        
    }
    
    public ArrayList listatFuncionariosController(Funcionario funcBean) {
        
        ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        
        listaFuncionario = funcionarioDAO.listarFuncionarios(funcBean);
        
        return listaFuncionario;
        
    }
    
}
