package br.sp.senac.tads.controller;

import br.sp.senac.tads.dao.VeiculoDAO;
import br.sp.senac.tads.model.Veiculo;
import java.util.ArrayList;

/**
 *
 * @author Jeferson Davi
 */
public class VeiculoController {

    VeiculoDAO veiculoDAO = new VeiculoDAO();
    
    public VeiculoController() {
    }
    
    public void cadastrarVeiculoController(Veiculo veiculoBean) {
        
        veiculoDAO.cadastrarVeiculo(veiculoBean);
        
    }
    
    public void alterarVeiculoController(Veiculo veiculoBean) {
        
        veiculoDAO.alterarVeiculo(veiculoBean);
        
    }
    
    public void statusVeiculoController(Veiculo veiculoBean) {
        
        veiculoDAO.desativarAtivarVeiculo(veiculoBean);
        
    }
    
    public ArrayList consultarVeiculoController(Veiculo veiculoBean) {
        
        ArrayList<Veiculo> listaVeiculo = new ArrayList<Veiculo>();
        
        listaVeiculo = veiculoDAO.consultarVeiculo(veiculoBean);
        
        return listaVeiculo;
        
    }
    
}
