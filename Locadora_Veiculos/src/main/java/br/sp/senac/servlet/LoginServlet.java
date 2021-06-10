package br.sp.senac.servlet;

import br.sp.senac.tads.bean.Login;
import br.sp.senac.tads.bean.Usuario;
import br.sp.senac.tads.controller.LoginController;
import br.sp.senac.tads.model.LoginDAO;
import br.sp.senac.tads.model.UsuarioDAO;
import br.sp.senac.util.CryptoUtils;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        String login = request.getParameter("login");
        String senhaAberta = request.getParameter("senha");

        Usuario usuario = UsuarioDAO.getUsuario(login);
        
        if (usuario == null)
        {
            response.sendRedirect("login.jsp?erroLogin=true");
        } 
        else
        {
            boolean senhaOK = CryptoUtils.validarSenha(senhaAberta, usuario.getSenha());
            String var=usuario.getSenha();
            if (var.compareTo(senhaAberta)==0) 
            { // Login OK
                HttpSession sessao = request.getSession();
                sessao.setAttribute("usuario", usuario);
                response.sendRedirect("protegido/Administrador.jsp");
            } 
            else 
            { // Login falhou
                response.sendRedirect("login.jsp?erroLogin=true");
            }
        }
    }
}
