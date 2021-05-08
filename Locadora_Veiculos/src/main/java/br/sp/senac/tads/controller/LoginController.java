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
    
    public void alterarLoginController(Login loginBean) {
        
        loginDAO.alterarLogin(loginBean);
        
    }
    
    public void statusLoginController(Login loginBean) {
        
        //loginDAO.desativarAtivarLogin(loginBean);
        
    }
    
    public boolean validarLoginController(Login loginBean) {
        
        boolean status = loginDAO.validarLogin(loginBean);
        
        return status;
        
    }
    
    public ArrayList listarLoginsController(Login loginBean) {
        
        ArrayList<Login> listaLogin = new ArrayList<Login>();
        
        listaLogin = loginDAO.listarLogins(loginBean);
        
        return listaLogin;
        
    }

    
}
