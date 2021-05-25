package br.sp.senac.tads.controller;

import br.sp.senac.tads.model.LoginDAO;
import br.sp.senac.tads.bean.Login;
import java.util.ArrayList;

/**
 *
 * @author Jeferson Davi
 */
public class LoginController {
    
    LoginDAO loginDAO = new LoginDAO();

    public LoginController() {
    }
    
    public int cadastrarLoginController(Login loginBean, String tipo) {
        
        loginDAO.cadastrarLogin(loginBean, tipo);
        
        int codLogin = loginDAO.pegarId(loginBean);
        
        return codLogin;
        
    }
    
    public boolean alterarLoginController(Login loginBean) {
        
        return loginDAO.alterarLogin(loginBean);
        
    }
    
    public boolean removerLoginController(Login loginBean) {
        
        return loginDAO.removerLogin(loginBean);
        
    }
    
    public boolean validarLoginController(Login loginBean) {
        
        return loginDAO.validarLogin(loginBean);
        
    }
    
    public ArrayList listarLoginsController(Login loginBean) {
        
        ArrayList<Login> listaLogin = new ArrayList<Login>();
        
        listaLogin = loginDAO.listarLogins();
        
        return listaLogin;
        
    }

    
}
