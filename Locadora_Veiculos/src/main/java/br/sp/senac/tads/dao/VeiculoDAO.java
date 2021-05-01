package br.sp.senac.tads.dao;

import br.sp.senac.tads.model.Veiculo;
import br.sp.senac.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeferson Davi
 */
public class VeiculoDAO {
    
    Connection conexao;
    
    /**
     * Driver do MySQL a partir da versão 8.0
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public VeiculoDAO() {
    }
    
    public void cadastrarVeiculo(Veiculo veiculoBean) {
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();
            
            String sql = "insert into Veiculos (marca, modelo, ano, placa, cor, quilometragem, revisao, valorVeiculo, statusVeiculo) values (?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setString(1, veiculoBean.getMarca());
            instrucaoSQL.setString(2, veiculoBean.getModelo());
            instrucaoSQL.setInt(3, veiculoBean.getAno());
            instrucaoSQL.setString(4, veiculoBean.getPlaca());
            instrucaoSQL.setString(5, veiculoBean.getCor());
            instrucaoSQL.setInt(6, veiculoBean.getQuilometragem());
            instrucaoSQL.setString(7, veiculoBean.getRevisao());
            instrucaoSQL.setDouble(8, veiculoBean.getValorVeiculo());
            instrucaoSQL.setString(9, veiculoBean.getStatusVeiculo());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if (linhasAfetadas > 0) {
                System.out.println("Cadastrado!");
                
            } else {
                throw new Exception();
                
            }
            
            conexao.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao iniciar conexão com o BD");
            
        }
        
    }
    
}
