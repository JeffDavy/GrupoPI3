package br.sp.senac.tads.model;

import br.sp.senac.tads.bean.Locacao;
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
    
    public boolean realizarLocacao(Locacao locacaoDao) {
        
        boolean status = false;
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "insert into Locacoes (Veiculos_codVeiculo, Clientes_codCliente, Funcionarios_codFuncionario, filial, marcaVeiculo, modeloVeiculo, anoVeiculo, placaVeiculo, valorVeiculo, dataLocacao) values (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setInt(1, locacaoDao.getCodVeiculo());
            instrucaoSQL.setInt(2, locacaoDao.getCodCliente());
            instrucaoSQL.setInt(3, locacaoDao.getCodFuncionario());
            instrucaoSQL.setString(4, locacaoDao.getFilial());
            instrucaoSQL.setString(5, locacaoDao.getMarcaVeiculo());
            instrucaoSQL.setString(6, locacaoDao.getModeloVeiculo());
            instrucaoSQL.setInt(7, locacaoDao.getAnoVeiculo());
            instrucaoSQL.setString(8, locacaoDao.getPlacaVeiculo());
            instrucaoSQL.setDouble(9, locacaoDao.getValorVeiculo());
            instrucaoSQL.setString(10, locacaoDao.getDataLocacao());
                       
            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                status = true;
                
            } else {
                throw new Exception();

            }
            
        } catch (Exception e) {
        }
        
        return status;
        
    }
    
    
}
