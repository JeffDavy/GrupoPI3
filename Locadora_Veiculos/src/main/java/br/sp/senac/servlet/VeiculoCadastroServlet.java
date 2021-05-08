package br.sp.senac.servlet;

import br.sp.senac.tads.bean.Veiculo;
import br.sp.senac.tads.controller.VeiculoController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jeferson Davi
 */
public class VeiculoCadastroServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
              
        Veiculo veiculoBean = new Veiculo();
        VeiculoController veiculoControl = new VeiculoController();
        
        veiculoBean.setMarca(request.getParameter("marca"));
        veiculoBean.setModelo(request.getParameter("modelo"));
        veiculoBean.setAno(Integer.parseInt(request.getParameter("ano")));
        veiculoBean.setPlaca(request.getParameter("placa"));
        veiculoBean.setCor(request.getParameter("cor"));
        veiculoBean.setQuilometragem(Integer.parseInt(request.getParameter("km")));
        veiculoBean.setValorVeiculo(Double.parseDouble(request.getParameter("valor")));
        
        boolean ok = veiculoControl.cadastrarVeiculoController(veiculoBean);
        
        if (ok) {
            response.sendRedirect("sucesso.jsp");
        } else {
            response.sendRedirect("sucesso.jsp");
            
        }
        
    }

}
