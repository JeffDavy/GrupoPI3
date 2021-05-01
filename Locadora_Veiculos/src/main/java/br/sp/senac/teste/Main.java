package br.sp.senac.teste;

import br.sp.senac.tads.controller.VeiculoController;
import br.sp.senac.tads.model.Veiculo;

/**
 *
 * @author Jeferson Davi
 */
public class Main {
        
    
    
    
    public static void main(String[] args) {
        
        Veiculo veiculoBean = new Veiculo();
        VeiculoController veiculoControl = new VeiculoController();
        
        
        veiculoBean.setMarca("Volks");
        veiculoBean.setModelo("Fox");
        veiculoBean.setAno(2014);
        veiculoBean.setPlaca("EEW0970");
        veiculoBean.setCor("Branca");
        veiculoBean.setQuilometragem(12000);
        veiculoBean.setRevisao("1");
        veiculoBean.setValorVeiculo(250.00);
        veiculoBean.setStatusVeiculo("1");
        
        veiculoControl.cadastrarVeiculoController(veiculoBean);
    

        
    }
    
}
