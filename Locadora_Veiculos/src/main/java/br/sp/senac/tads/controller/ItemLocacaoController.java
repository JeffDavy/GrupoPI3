package br.sp.senac.tads.controller;

import br.sp.senac.tads.dao.ItemLocacaoDAO;
import br.sp.senac.tads.model.ItemLocacao;
import java.util.ArrayList;

/**
 *
 * @author Jeferson Davi
 */
public class ItemLocacaoController {

    public ItemLocacaoController() {
    }
    
    ItemLocacaoDAO itemDAO = new ItemLocacaoDAO();
    
    public  ArrayList<ItemLocacao> salvarItensController(ItemLocacao itemLocacao) {
        
        ArrayList<ItemLocacao> listaItem = new ArrayList<>();
        
        listaItem = itemDAO.salvarItem(itemLocacao);
        
        return listaItem;
        
    }
    
    
}
