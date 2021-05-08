package br.sp.senac.teste;

import br.sp.senac.tads.controller.ClienteController;
import br.sp.senac.tads.controller.LoginController;
import br.sp.senac.tads.model.Cliente;
import br.sp.senac.tads.model.Login;

/**
 *
 * @author Jeferson Davi
 */
public class ClienteMain {
    
    public static void main(String[] args) {
        
        Cliente cm = new Cliente();
        Login lm = new Login();
        
        ClienteController cc = new ClienteController();
        LoginController lc = new LoginController();
        
        /** CADASTRAR CLIENTE E LOGIN*/
        cm.setCodLogin(1);
        cm.setNome("Jeferson Davi");
        cm.setCpf("88899977703");
        cm.setDataNascimento("15111998");
        cm.setSexo("m");
        cm.setEmail("jeferson@email.com");
        cm.setContato1("1140028922");
        cm.setContato2("11981286341");
        cm.setRua("Panorama");
        cm.setNumero(155);
        cm.setBairro("Santo Eduardo");
        cm.setCidade("Embu das Artes");
        cm.setEstado("SP");
        cm.setComplemento("Perto do mercado.");
        
        lm.setUsuario("jeff");
        lm.setSenha("1234");
        
        cc.cadastrarClienteController(cm, lm);
    
        /** PEGAR ID DO CLIENTE*/
//        cm.setCpf("88899977703");
//        
//        int id = cc.pegarIdController(cm);
//        
//        System.out.println(id);
        
    }
    
}
