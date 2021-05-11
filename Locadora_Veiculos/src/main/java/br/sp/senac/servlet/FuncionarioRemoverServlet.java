package br.sp.senac.servlet;

import br.sp.senac.tads.bean.Funcionario;
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
public class FuncionarioRemoverServlet extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        FuncionarioController fc = new FuncionarioController();
        
        Funcionario fb = new Funcionario();
        
        fb.setEmail(request.getParameter("RemailFunc"));
        
        int codFuncionario = fc.pegarIdFuncionarioController(fb);
        
        fb.setCodFuncionario(codFuncionario);
        
        boolean status = fc.removerFuncionarioController(fb);
        
        if (status) {
            response.sendRedirect("sucesso.jsp");
            
        } else {
            response.sendRedirect("erro.jsp");
            
        }
        
    }

}
