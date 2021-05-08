package br.sp.senac.teste;

import br.sp.senac.tads.controller.ClienteController;
import br.sp.senac.tads.controller.FuncionarioController;
import br.sp.senac.tads.controller.LocacaoController;
import br.sp.senac.tads.bean.Cliente;
import br.sp.senac.tads.bean.Funcionario;
import br.sp.senac.tads.bean.Locacao;

/**
 *
 * @author Jeferson Davi
 */
public class LocacaoMain {
    
    public static void main(String[] args) {
        
        Locacao lm = new Locacao();
        Funcionario fm = new Funcionario();
        Cliente cm = new Cliente();

        LocacaoController lc = new LocacaoController();
        FuncionarioController fc = new FuncionarioController();
        ClienteController cc = new ClienteController();
        
        
        
    }
    
}
