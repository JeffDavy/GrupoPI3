package br.sp.senac.tads.dao;

import br.sp.senac.tads.model.Locacao;
import br.sp.senac.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Jeferson Davi
 */
public class LocacaoDAO {

    Connection conexao;

    /**
     * Driver do MySQL a partir da versão 8.0
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public LocacaoDAO() {
    }
    
    public void realizarLocacao(Locacao locacaoDao) {
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "insert into Locacoes (codLocacao, Veiculos_codVeiculo, Clientes_codCliente, Funcionarios_codFuncionario, marcaVeiculo, modeloVeiculo, anoVeiculo, placaVeiculo, valorVeiculo, dataLocacao) values (?,?,?,?,?,?,?,?,?)";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setInt(1, locacaoDao.getCodVeiculo());
            instrucaoSQL.setInt(2, locacaoDao.getCodCliente());
            instrucaoSQL.setInt(3, locacaoDao.getCodFuncionario());
            instrucaoSQL.setString(4, locacaoDao.getMarcaVeiculo());
            instrucaoSQL.setString(5, locacaoDao.getModeloVeiculo());
            instrucaoSQL.setInt(6, locacaoDao.getAnoVeiculo());
            instrucaoSQL.setString(7, locacaoDao.getPlacaVeiculo());
            instrucaoSQL.setDouble(8, locacaoDao.getValorVeiculo());
            instrucaoSQL.setDate(9, locacaoDao.getDataLocacao());
                       
            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Locação realizada!");

            } else {
                throw new Exception();

            }

            conexao.close();
            
        } catch (Exception e) {
        }
        
        
    }
    
    
}
