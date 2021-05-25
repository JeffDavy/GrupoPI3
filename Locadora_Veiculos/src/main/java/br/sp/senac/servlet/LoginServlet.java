/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.servlet;

import br.sp.senac.tads.bean.Login;
import java.io.IOException;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        if (sessao.getAttribute("usuarioLogado") != null) {
            // Usuario já está logado -> redireciona para /menu-principal
            response.sendRedirect(request.getContextPath() + "/index");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("usuario");
        String senha = request.getParameter("senha");

//        Login login = new br.sp.senac.controller.LoginController().getValidarLoginController(login);
//
//        if (login != null) {
//
//            if (login.validarLogin(senha)) {
//
//                HttpSession sessao = request.getSession();
//                sessao.setAttribute("usuarioLogado", login);
//                response.sendRedirect(request.getContextPath() + "/index");
//                return;
//
//            } else {
//
//                request.setAttribute("senhaAtt", true);
//                request.getRequestDispatcher("/WEB-INF/login.jsp")
//                        .forward(request, response);
//
//            }

//        } else {
//            request.setAttribute("usuarioAtt", true);
//            request.getRequestDispatcher("/WEB-INF/login.jsp")
//                    .forward(request, response);
//
//        }
    }
}
