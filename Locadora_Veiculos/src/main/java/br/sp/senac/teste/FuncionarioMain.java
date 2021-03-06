package br.sp.senac.teste;

import br.sp.senac.tads.controller.FuncionarioController;
import br.sp.senac.tads.bean.Funcionario;
import br.sp.senac.tads.bean.Login;
import java.util.ArrayList;

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
        
        

        ArrayList<Funcionario> listaFunc = new ArrayList<Funcionario>();
        
        fm.setCodFuncionario(2);
        listaFunc = fc.consultarFuncionarioController(fm);

        for (Funcionario func : listaFunc) {
            
            System.out.println("user: " + func.getNome());
            
        }
        
    }
    
}
