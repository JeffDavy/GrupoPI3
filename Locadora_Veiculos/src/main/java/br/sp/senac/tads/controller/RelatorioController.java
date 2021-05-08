
package br.sp.senac.tads.controller;

import br.sp.senac.tads.bean.RelatorioModel;
import java.util.ArrayList;

/**
 *  
 * 
 *
 * @author dilaz
 */
public class RelatorioController {
       public ArrayList<RelatorioModel> getRelatorio(int filial) {

        ArrayList<RelatorioModel> relatorio = new br.sp.senac.tads.model.RelatorioDAO().getRelatorio(filial);
        return relatorio;
    }


    public ArrayList<RelatorioModel> getRelatorioPercentual(int filial) {

        ArrayList<RelatorioModel> relatorio = new br.sp.senac.tads.model.RelatorioDAO().getRelatorioPercentual(filial);
        return relatorio;
    }
}
