package br.sp.senac.teste;

import br.sp.senac.tads.controller.VeiculoController;
import br.sp.senac.tads.model.Veiculo;
import java.util.ArrayList;

/**
 *
 * @author Jeferson Davi
 */
public class Main {
        
    
    
    
    public static void main(String[] args) {
        
        Veiculo veiculoBean = new Veiculo();
        VeiculoController veiculoControl = new VeiculoController();
        
        /** CADASTRAR VEÍCULO */
//        veiculoBean.setMarca("Volks");
//        veiculoBean.setModelo("Fox");
//        veiculoBean.setAno(2014);
//        veiculoBean.setPlaca("EEW0970");
//        veiculoBean.setCor("Branca");
//        veiculoBean.setQuilometragem(12000);
//        veiculoBean.setRevisao("1");
//        veiculoBean.setValorVeiculo(250.00);
//        veiculoBean.setStatusVeiculo("1");
//        
//        veiculoControl.cadastrarVeiculoController(veiculoBean);
        
    
        /** EDITAR VEÍCULO */
//        veiculoBean.setMarca("Yamaha");
//        veiculoBean.setModelo("Crosser");
//        veiculoBean.setAno(2019);
//        veiculoBean.setPlaca("EEW0970");
//        veiculoBean.setCor("Branca");
//        veiculoBean.setQuilometragem(22000);
//        veiculoBean.setRevisao("0");
//        veiculoBean.setValorVeiculo(13000.00);
//        veiculoBean.setCodVeiculo(1);
//        
//        veiculoControl.alterarVeiculoController(veiculoBean);
        
        /** DESATIVAR E ATIVAR UM VEÍCULO */ 
        
            /** ATIVAR VEÍCULO */ 
//            veiculoBean.setStatusVeiculo("1");
//            veiculoBean.setCodVeiculo(1);
//
//            veiculoControl.statusVeiculoController(veiculoBean);

            
            /** DESATIVAR VEÍCULO */ 
//            veiculoBean.setStatusVeiculo("0");
//            veiculoBean.setCodVeiculo(1);
//
//            veiculoControl.statusVeiculoController(veiculoBean);

        
        veiculoBean.setCodVeiculo(1);

         ArrayList<Veiculo> listaVeiculo = new ArrayList<Veiculo>();
         
         listaVeiculo = veiculoControl.consultarVeiculoController(veiculoBean);
         
        for (int i = 0; i < listaVeiculo.size(); i++) {
    System.out.println("aula : " + listaVeiculo.get(i));
}

             
            


        
        
        
        
        
    

        
    }
    
}
