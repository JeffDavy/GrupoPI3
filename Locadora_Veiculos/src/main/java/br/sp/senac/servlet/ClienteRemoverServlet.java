package br.sp.senac.servlet;

import br.sp.senac.tads.bean.Cliente;
import br.sp.senac.tads.controller.ClienteController;
import br.sp.senac.tads.model.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jeefrson Davi
 */
public class ClienteRemoverServlet extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        ClienteController clienteBean = new ClienteController();
        Cliente cliente = new Cliente();
        cliente.setCpf(request.getParameter("cpf"));
        
        int codCliente = clienteBean.pegarIdController(cliente);
        
        cliente.setCodCliente(codCliente);
        
        boolean status = clienteBean.removerClienteController(cliente);
        
          boolean exc = clienteBean.removerClienteController(cliente);
        
        if (exc) {
            response.sendRedirect("sucesso.jsp");
            
        } else {
            response.sendRedirect("erro.jsp");
            
        }
    }

}
