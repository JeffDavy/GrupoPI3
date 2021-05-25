package br.sp.senac.servlet;

import br.sp.senac.tads.bean.Login;
import br.sp.senac.tads.controller.LoginController;
import br.sp.senac.tads.model.LoginDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dilaz
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    
       
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Login loginBean = new Login();
        
        LoginController lControl = new LoginController();
   
        loginBean.setUsuario(request.getParameter("usuarioFuncionario"));
        loginBean.setSenha(request.getParameter("senhaFuncionario"));
        
        String recebe = request.getParameter("codLogin");
        int codLogin = Integer.parseInt(recebe);
        String usuario = request.getParameter("usuario");
        String tipo = request.getParameter("tipo");
        String senha = request.getParameter("senha");

        Login login = new Login(codLogin, usuario, senha, tipo);
//        boolean ok = LoginDAO.cadastrarLogin(login,0);
        
        boolean ok = lControl.validarLoginController(loginBean);
        
        if (ok) {
            response.sendRedirect("sucesso.jsp");
            
        } else {
            response.sendRedirect("erro.jsp");
            
        }
        
    }
}
