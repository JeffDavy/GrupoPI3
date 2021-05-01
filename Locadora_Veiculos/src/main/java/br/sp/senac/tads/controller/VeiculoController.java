package br.sp.senac.tads.controller;

import br.sp.senac.tads.dao.VeiculoDAO;
import br.sp.senac.tads.model.Veiculo;

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
    
}
