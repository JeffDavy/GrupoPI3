package br.sp.senac.servlet;

import br.sp.senac.tads.bean.Cliente;
import br.sp.senac.tads.bean.Login;
import br.sp.senac.tads.controller.ClienteController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class ClienteCadastroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Cliente clienteBean = new Cliente();
        Login loginBean = new Login();
        
        ClienteController clienteControl = new ClienteController();
        
        clienteBean.setNome(request.getParameter("nome"));
        clienteBean.setCpf(request.getParameter("cpf"));
        clienteBean.setDataNascimento(request.getParameter("data"));
        clienteBean.setSexo(request.getParameter("sexoRadio"));
        clienteBean.setEmail(request.getParameter("email"));
        clienteBean.setContato1(request.getParameter("contato1"));
        clienteBean.setContato2(request.getParameter("contato2"));
        clienteBean.setRua(request.getParameter("rua"));
        clienteBean.setNumero(Integer.parseInt(request.getParameter("numero")));
        clienteBean.setBairro(request.getParameter("bairro"));
        clienteBean.setCidade(request.getParameter("cidade"));
        clienteBean.setEstado(request.getParameter("estado"));
        clienteBean.setComplemento(request.getParameter("complemento"));
        
        loginBean.setUsuario(request.getParameter("usuario"));
        loginBean.setSenha(request.getParameter("senha"));
        
        System.out.println(request.getParameter("sexoRadio"));
        
        boolean status = clienteControl.cadastrarClienteController(clienteBean, loginBean);
        
        if (status) {
            response.sendRedirect("sucesso.jsp");
            
        } else {
            response.sendRedirect("erro.jsp");
            
        }
        
        
    }


}
