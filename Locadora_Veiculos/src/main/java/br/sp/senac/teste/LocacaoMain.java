package br.sp.senac.teste;

import br.sp.senac.tads.controller.ClienteController;
import br.sp.senac.tads.controller.FuncionarioController;
import br.sp.senac.tads.controller.LocacaoController;
import br.sp.senac.tads.bean.Cliente;
import br.sp.senac.tads.bean.Funcionario;
import br.sp.senac.tads.bean.Locacao;
import br.sp.senac.tads.bean.Veiculo;
import br.sp.senac.tads.controller.VeiculoController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jeferson Davi
 */
public class LocacaoMain {
    
    public static void main(String[] args) {
        
        Locacao lm = new Locacao();
        Funcionario fm = new Funcionario();
        Cliente cm = new Cliente();
        Veiculo vb = new Veiculo();

        LocacaoController lc = new LocacaoController();
        FuncionarioController fc = new FuncionarioController();
        ClienteController cc = new ClienteController();
        VeiculoController vc = new VeiculoController();
        
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        
        lm.setCodVeiculo(1);
        lm.setCodCliente(1);
        lm.setCodFuncionario(1);
        lm.setFilial("Embu");
        lm.setMarcaVeiculo("Volks");
        lm.setModeloVeiculo("Fox");
        lm.setAnoVeiculo(2014);
        lm.setPlacaVeiculo("EEW0970");
        lm.setValorVeiculo(250);
        lm.setDataLocacao("2021-06-08");
        
        lc.realizarLocacaoController(lm);
        
        lm.setCodVeiculo(1);
        lm.setCodCliente(1);
        lm.setCodFuncionario(1);
        lm.setFilial("Matriz");
        lm.setMarcaVeiculo("Yamaha");
        lm.setModeloVeiculo("Crosser");
        lm.setAnoVeiculo(2019);
        lm.setPlacaVeiculo("POR1511");
        lm.setValorVeiculo(200);
        lm.setDataLocacao("2021-05-08");
        
        lc.realizarLocacaoController(lm);

        lm.setCodVeiculo(1);
        lm.setCodCliente(1);
        lm.setCodFuncionario(1);
        lm.setFilial("Matriz");
        lm.setMarcaVeiculo("Honda");
        lm.setModeloVeiculo("Shadow");
        lm.setAnoVeiculo(2006);
        lm.setPlacaVeiculo("FDA1111");
        lm.setValorVeiculo(500);
        lm.setDataLocacao("2021-04-10");
        
        lc.realizarLocacaoController(lm);
        
        lm.setCodVeiculo(1);
        lm.setCodCliente(1);
        lm.setCodFuncionario(1);
        lm.setFilial("Embu");
        lm.setMarcaVeiculo("Honda");
        lm.setModeloVeiculo("Civic");
        lm.setAnoVeiculo(2021);
        lm.setPlacaVeiculo("NEM1478");
        lm.setValorVeiculo(1700);
        lm.setDataLocacao("2021-06-08");
        
        lc.realizarLocacaoController(lm);
        
        
        
        
        

    }
    
}
