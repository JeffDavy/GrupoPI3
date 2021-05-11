package br.sp.senac.tads.controller;

import br.sp.senac.tads.model.FuncionarioDAO;
import br.sp.senac.tads.bean.Funcionario;
import br.sp.senac.tads.bean.Login;
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
    
    public boolean cadastrarFuncionarioController(Funcionario funcBean, Login loginBean, String tipo) {
        
        int codLogin = loginController.cadastrarLoginController(loginBean, tipo);
        
        funcBean.setCodLogin(codLogin);
        
        return funcionarioDAO.cadastrarFuncionario(funcBean);
        
    }
    
    public boolean alterarFuncionarioController(Funcionario funcBean) {
        
        return funcionarioDAO.alterarFuncionario(funcBean);
        
    }
    
    public boolean removerFuncionarioController(Funcionario funcBean) {
        
        return funcionarioDAO.removerFuncionario(funcBean);
        
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
    
    public int pegarIdFuncionarioController(Funcionario funcControl) {
        
        return funcionarioDAO.pegarId(funcControl);
        
    }
    
}
