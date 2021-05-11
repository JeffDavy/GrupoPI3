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
    
    public boolean alterarVeiculoController(Veiculo veiculoBean) {
        
        return veiculoDAO.alterarVeiculo(veiculoBean);
        
    }
    
    public boolean removerVeiculoController(Veiculo veiculoBean) {
                
        return veiculoDAO.removerVeiculo(veiculoBean);
        
    }
    
    public ArrayList<Veiculo> consultarVeiculoController(Veiculo veiculoBean) {
        
        ArrayList<Veiculo> listaVeiculo = new ArrayList<Veiculo>();
        
        listaVeiculo = veiculoDAO.consultarVeiculo(veiculoBean);
        
        return listaVeiculo;
        
    }
    
    public ArrayList<Veiculo> listarVeiculosController(Veiculo veiculoBean) {
        
        ArrayList<Veiculo> listaVeiculo = new ArrayList<Veiculo>();
        
        listaVeiculo = veiculoDAO.listarVeiculos(veiculoBean);
        
        return listaVeiculo;
        
    }
    
}
