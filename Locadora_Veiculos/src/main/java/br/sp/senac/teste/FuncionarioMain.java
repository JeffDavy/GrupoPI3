package br.sp.senac.teste;

import br.sp.senac.tads.controller.FuncionarioController;
import br.sp.senac.tads.model.Funcionario;
import br.sp.senac.tads.model.Login;

/**
 *
 * @author Jeferson Davi
 */
public class FuncionarioMain {
    
    public static void main(String[] args) {
        
        Funcionario fm = new Funcionario();
        Login lm = new Login();
        
        FuncionarioController fc = new FuncionarioController();
        
        /** CADASTRAR FUNCIONÁRIO*/
        fm.setNome("Adalberto Souza");
        fm.setEmail("adalberto@email.com");
        fm.setTipo("f");
        
        lm.setUsuario("adalberto");
        lm.setSenha("1234");
        
        fc.cadastrarFuncionarioController(fm, lm, fm.getTipo());
        
        
        
    }
    
}
