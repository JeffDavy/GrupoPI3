package br.sp.senac.teste;

import br.sp.senac.tads.controller.LoginController;
import br.sp.senac.tads.model.LoginDAO;
import br.sp.senac.tads.bean.Login;

/**
 *
 * @author Jeferson Davi
 */
public class LoginMain {
    
    public static void main(String[] args) {
        
        Login lm = new Login();
        LoginController lc = new LoginController();
        LoginDAO ld = new LoginDAO();
        
        /** CADASTRAR LOGIN*/
//        lm.setUsuario("admin");
//        lm.setSenha("admin");
//        
//        lc.cadastrarLoginController(lm, "c");

        /** ALTERAR LOGIN */
//        lm.setCodLogin(1);
//        lm.setUsuario("jeff");
//        lm.setSenha("jeff");
//        
//        lc.alterarLoginController(lm);

        /** DESATIVAR LOGIN */
//        lm.setCodLogin(1);
//        lm.setStatusLogin("0");
//        
//        lc.statusLoginController(lm);

        /** ATIVAR LOGIN */
//        lm.setCodLogin(1);
//        lm.setStatusLogin("1");
//        
//        lc.statusLoginController(lm);
//        

        /** VALIDAR LOGIN*/
//        lm.setUsuario("jeff");
//        
//        boolean status = lc.validarLoginController(lm);
//        
//        System.out.println(status);

        /** CONSULTAR ID */
//        lm.setUsuario("jeferson");
//        
//        int ret = ld.pegarId(lm);
//        
//        System.out.println(ret);
        
        


        
        
        
    }
    
}
