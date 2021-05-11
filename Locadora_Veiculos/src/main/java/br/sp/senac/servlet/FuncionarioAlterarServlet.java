package br.sp.senac.servlet;

import br.sp.senac.tads.bean.Funcionario;
import br.sp.senac.tads.controller.FuncionarioController;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jeferson Davi
 */
public class FuncionarioAlterarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        ArrayList<Funcionario> listaFunc = new ArrayList<Funcionario>();
        
        FuncionarioController fc = new FuncionarioController();
        
        Funcionario fb = new Funcionario();
        
        fb.setEmail(request.getParameter("emailFunc"));
        
        int codFuncionario = fc.pegarIdFuncionarioController(fb);
        
        fb.setCodFuncionario(codFuncionario);
        
        if (codFuncionario > 0) {
            
            response.sendRedirect("Funcionario.jsp");
            
            listaFunc = fc.consultarFuncionarioController(fb);
            
            for (Funcionario lista : listaFunc) {
            
                fb.setCodFuncionario(lista.getCodFuncionario());
                fb.setCodLogin(lista.getCodLogin());
                fb.setNome(lista.getNome());
                fb.setEmail(lista.getEmail());
                fb.setTipo(lista.getTipo());

            }
            
            request.setAttribute("listaFunc", listaFunc);
            
            request.getRequestDispatcher("/Funcionario.jsp").forward(request, response);
            
        }
        
    }

}
