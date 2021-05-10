package br.sp.senac.tads.controller;

import br.sp.senac.tads.bean.Locacao;
import br.sp.senac.tads.model.LocacaoDAO;

/**
 *
 * @author Jeferson Davi
 */
public class LocacaoController {

    LocacaoDAO locacaoDAO = new LocacaoDAO();
    
    public LocacaoController() {
    }
    
    
    public boolean realizarLocacaoController(Locacao locBean) {
        
        boolean status = false;
               
        return locacaoDAO.realizarLocacao(locBean);
        
    }
    
    
}
