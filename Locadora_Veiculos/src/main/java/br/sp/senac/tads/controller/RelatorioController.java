package br.sp.senac.tads.controller;

import br.sp.senac.tads.bean.Relatorio;
import br.sp.senac.tads.model.RelatorioDAO;
import java.util.ArrayList;

/**
 *  
 * 
 *
 * @author Jeferson Davi
 */
public class RelatorioController {

    public RelatorioController() {
    }
    
    RelatorioDAO relatorioDAO = new RelatorioDAO();
    
    /** RELATÓRIO FILTRADO POR MARCA DO VEÍCULO*/
    public ArrayList<Relatorio> relatorioMarcaController(Relatorio relBean) {
        
        ArrayList<Relatorio> listaMarca = new ArrayList<Relatorio>();
        
        return listaMarca = relatorioDAO.relatorioMarcaVeiculo(relBean);
        
    }
    
    /** RELATÓRIO FILTRADO POR CLIENTE DA VENDA*/
    public ArrayList<Relatorio> relatorioClienteController(Relatorio relBean) {
        
        ArrayList<Relatorio> listaCliente = new ArrayList<Relatorio>();
        
        return listaCliente = relatorioDAO.relatorioCliente(relBean);
        
    }
    
    /** RELATÓRIO FILTRADO POR FILIAL*/
    public ArrayList<Relatorio> relatorioFilialController(Relatorio relBean) {
        
        ArrayList<Relatorio> listaFilial = new ArrayList<Relatorio>();
        
        return listaFilial = relatorioDAO.relatorioFilial(relBean);
        
    }
    
}