package br.sp.senac.servlet;

import br.sp.senac.tads.bean.Cliente;
import br.sp.senac.tads.bean.Funcionario;
import br.sp.senac.tads.bean.Locacao;
import br.sp.senac.tads.bean.Veiculo;
import br.sp.senac.tads.controller.ClienteController;
import br.sp.senac.tads.controller.FuncionarioController;
import br.sp.senac.tads.controller.LocacaoController;
import br.sp.senac.tads.controller.VeiculoController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jeferson Davi
 */
public class RealizarLocacaoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        ArrayList<Veiculo> listaVeiculo = new ArrayList<Veiculo>();

        LocacaoController locControl = new LocacaoController();
        VeiculoController veiculoControl = new VeiculoController();
        ClienteController clienteControl = new ClienteController();
        FuncionarioController funcControl = new FuncionarioController();
        
        Locacao locBean = new Locacao();
        Funcionario funcBean = new Funcionario();
        Cliente clienteBean = new Cliente();
        Veiculo veiculoBean = new Veiculo();
        
        clienteBean.setCpf(request.getParameter("cpfCliente"));
        int codCliente = clienteControl.pegarIdController(clienteBean);
        
        funcBean.setEmail(request.getParameter("emailFuncionario"));
        int codFuncionario = funcControl.pegarIdFuncionarioController(funcBean);
        
        veiculoBean.setPlaca(request.getParameter("placaVeiculoLocacao"));        
        listaVeiculo = veiculoControl.consultarVeiculoController(veiculoBean);
        
        locBean.setCodCliente(codCliente);
        locBean.setCodFuncionario(codFuncionario);
        locBean.setDataLocacao(request.getParameter("dataLocacao"));
        
        for (Veiculo lista : listaVeiculo) {
            
            locBean.setCodVeiculo(lista.getCodVeiculo());
            locBean.setMarcaVeiculo(lista.getMarca());
            locBean.setModeloVeiculo(lista.getModelo());
            locBean.setAnoVeiculo(lista.getAno());
            locBean.setPlacaVeiculo(lista.getPlaca());
            locBean.setValorVeiculo(lista.getValorVeiculo());

        }
        
        boolean status = locControl.realizarLocacaoController(locBean);
        
        if (status) {
            response.sendRedirect("sucesso.jsp");
            
        } else {
            response.sendRedirect("erro.jsp");
            
        }
        
    }

}
