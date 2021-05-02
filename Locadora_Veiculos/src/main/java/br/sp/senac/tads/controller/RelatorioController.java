
package br.sp.senac.tads.controller;

import br.sp.senac.tads.model.RelatorioModel;
import java.util.ArrayList;

/**
 *  
 * 
 *
 * @author dilaz
 */
public class RelatorioController {
       public ArrayList<RelatorioModel> getRelatorio(int filial) {

        ArrayList<RelatorioModel> relatorio = new br.sp.senac.tads.dao.RelatorioDAO().getRelatorio(filial);
        return relatorio;
    }


    public ArrayList<RelatorioModel> getRelatorioPercentual(int filial) {

        ArrayList<RelatorioModel> relatorio = new br.sp.senac.tads.dao.RelatorioDAO().getRelatorioPercentual(filial);
        return relatorio;
    }
}
