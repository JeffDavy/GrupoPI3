package br.sp.senac.servlet;

import br.sp.senac.tads.bean.Funcionario;
import br.sp.senac.tads.bean.Login;
import br.sp.senac.tads.controller.FuncionarioController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jeferson Davi
 */
public class FuncionarioCadastroServlet extends HttpServlet {

   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Funcionario funcBean = new Funcionario();
        Login loginBean = new Login();
        
        FuncionarioController funcControl = new FuncionarioController();
        
        funcBean.setNome(request.getParameter("nomeFuncionario"));
        funcBean.setEmail(request.getParameter("emailFuncioanrio"));
        funcBean.setTipo(request.getParameter("tipo"));
        
        loginBean.setUsuario(request.getParameter("usuarioFuncionario"));
        loginBean.setSenha(request.getParameter("senhaFuncionario"));
        
        boolean status = funcControl.cadastrarFuncionarioController(funcBean, loginBean, funcBean.getTipo());
        
        if (status) {
            response.sendRedirect("sucesso.jsp");
            
        } else {
            response.sendRedirect("erro.jsp");
            
        }
        
    }

}
