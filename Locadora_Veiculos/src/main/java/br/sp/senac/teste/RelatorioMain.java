
package br.sp.senac.teste;

import br.sp.senac.tads.bean.Relatorio;
import br.sp.senac.tads.controller.RelatorioController;
import java.util.ArrayList;

/**
 *
 * @author Jeferson Davi
 */
public class RelatorioMain {
    
    public static void main(String[] args) {
        
        Relatorio relBean = new Relatorio();
        RelatorioController relControl = new RelatorioController();
        
        
//        /** TESTE RELATÓRIO POR MARCA DE VEÍCULO*/
//        relBean.setMarcaVeiculo("Honda");
//        
//        // DATA DE INICIO E FIM PARA A BUSCA
//        relBean.setDataUm("2021-06-06");
//        relBean.setDataDois("2021-06-08");
        
        //ArrayList<Relatorio> listaMarca = relControl.relatorioMarcaController(relBean);
        
        
//        relBean.setCodCliente(1);
//        relBean.setDataUm("2021-06-06");
//        relBean.setDataDois("2021-06-08");
//        
//        ArrayList<Relatorio> listaMarca = relControl.relatorioClienteController(relBean);
        
        relBean.setNomeFilial("Embu");
        relBean.setDataUm("2020-06-06");
        relBean.setDataDois("2021-06-08");
        
        ArrayList<Relatorio> listaMarca = relControl.relatorioFilialController(relBean);

        if (listaMarca.size() > 0){
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
        
        imprimirRelatorio(listaMarca);
        
        
    }
    
    public static void imprimirRelatorio(ArrayList<Relatorio> lista) {
        
        for (Object obj : lista) {
                
                Relatorio relBean = (Relatorio) obj;
                
                System.out.println("Lista");
                
                System.out.println("Filial: " + relBean.getNomeFilial());
                System.out.println("Cod Locação: " + relBean.getCodLocacao());
                System.out.println("Cod Cliente: " + relBean.getCodCliente());
                System.out.println("Nome Cliente: " + relBean.getNomeCliente());
                System.out.println("Cod Funcionario: " + relBean.getCodFuncionario());
                System.out.println("Nome Funcionario: " + relBean.getNomeFuncionario());
                System.out.println("Cod Veículo: " + relBean.getCodVeiculo());
                System.out.println("Marca: " + relBean.getMarcaVeiculo());
                System.out.println("Modelo: " + relBean.getModeloVeiculo());
                System.out.println("Ano: " + relBean.getAnoVeiculo());
                System.out.println("Placa: " + relBean.getPlacaVeiculo());
                System.out.println("Valor: " + relBean.getValorVeiculo());
                System.out.println("Data: " + relBean.getDataLocacao());
                
                System.out.println("");
                
            }
        
    }
    
}
