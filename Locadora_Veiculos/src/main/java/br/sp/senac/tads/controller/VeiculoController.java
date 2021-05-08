package br.sp.senac.tads.controller;

import br.sp.senac.tads.model.VeiculoDAO;
import br.sp.senac.tads.bean.Veiculo;
import java.util.ArrayList;

/**
 *
 * @author Jeferson Davi
 */
public class VeiculoController {

    VeiculoDAO veiculoDAO = new VeiculoDAO();
    
    public VeiculoController() {
    }
    
    public boolean cadastrarVeiculoController(Veiculo veiculoBean) {
        
        boolean status = veiculoDAO.cadastrarVeiculo(veiculoBean);
        
        return status;
    }
    
    public void alterarVeiculoController(Veiculo veiculoBean) {
        
        veiculoDAO.alterarVeiculo(veiculoBean);
        
    }
    
    public void statusVeiculoController(Veiculo veiculoBean) {
        
        //veiculoDAO.desativarAtivarVeiculo(veiculoBean);
        
    }
    
    public ArrayList consultarVeiculosController(Veiculo veiculoBean) {
        
        ArrayList<Veiculo> listaVeiculo = new ArrayList<Veiculo>();
        
        listaVeiculo = veiculoDAO.consultarVeiculo(veiculoBean);
        
        return listaVeiculo;
        
    }
    
}
