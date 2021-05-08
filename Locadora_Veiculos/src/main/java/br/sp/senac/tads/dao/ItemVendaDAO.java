/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.tads.dao;

import br.sp.senac.tads.model.ItemLocacao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author joaop
 */
public class ItemVendaDAO 
{
    Connection conexao;

    /**
     * Driver do MySQL a partir da versão 8.0
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    
    public void Inserir(ItemLocacao model) throws ClassNotFoundException 
    {
        try 
        {
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "insert into Item_Locacao (Veiculos_codVeiculo, Locacoes_codLocacao"
                    + ", valorVeiculo, marcaVeiculo, modeloVeiculo, placaVeiculo) "
                    + "values (?,?,?,?,?,?)";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setInt(1, model.getId_Locacao());
            instrucaoSQL.setInt(2, model.getId_Veiculo());
            instrucaoSQL.setDouble(3, model.getVl_Veiculo());            
            instrucaoSQL.setString(4, model.getMarcaVeiculo());
            instrucaoSQL.setString(5, model.getModeloVeiculo());
            instrucaoSQL.setString(6, model.getPlacaVeiculo());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) 
            {
                conexao.close();
            } 
            else 
            {
                throw new Exception();
            }

            conexao.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Erro ao iniciar conexão com o Banco de Dados");
        }    
    }
     
    public ArrayList<ItemLocacao> Listar(ItemLocacao model) 
    {
        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<ItemLocacao> locacoes = new ArrayList<ItemLocacao>();
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "SELECT * FROM ITEM_VENDA (Veiculos_codVeiculo, Locacoes_codLocacao, valorVeiculo, marcaVeiculo, modeloVeiculo, placaVeiculo) "
                    + "VALUES(?, ?, ?, ?, ?, ?)";

            
            rs = instrucaoSQL.executeQuery();
            
            instrucaoSQL.setInt(1, model.getId_Locacao());
            instrucaoSQL.setInt(2, model.getId_Veiculo());
            instrucaoSQL.setDouble(3, model.getVl_Veiculo());            
            instrucaoSQL.setString(4, model.getMarcaVeiculo());
            instrucaoSQL.setString(5, model.getModeloVeiculo());
            instrucaoSQL.setString(6, model.getPlacaVeiculo());
            
            
        } 
        catch (Exception e) 
        {
            System.out.println("Erro na consulta");
            
        } 
        finally {
            
            try {

                if (rs != null) {
                    rs.close();
                    System.out.println("Locação existe! Fim");
                }

                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                    System.out.println("Locação não existe. Fim");
                }

                conexao.close();

            } catch (Exception e) {
                System.out.println("Falha no fechamento da conexão");
            }
        }
        
        return locacoes;
    }
    
    public void Alterar(ItemLocacao model) 
    {
        
        try 
        {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "ALTER TABLE ITEM_VENDA (Veiculos_codVeiculo, Locacoes_codLocacao, valorVeiculo, marcaVeiculo, modeloVeiculo, placaVeiculo) "
                    + "VALUES(?, ?, ?, ?, ?, ?)";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setInt(1, model.getId_Locacao());
            instrucaoSQL.setInt(2, model.getId_Veiculo());
            instrucaoSQL.setDouble(3, model.getVl_Veiculo());            
            instrucaoSQL.setString(4, model.getMarcaVeiculo());
            instrucaoSQL.setString(5, model.getModeloVeiculo());
            instrucaoSQL.setString(6, model.getPlacaVeiculo());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) 
            {
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                
                if (generatedKeys.next()) 
                {
                    model.setId_Locacao(generatedKeys.getInt(1));
                } else 
                {
                    throw new SQLException("Falha ao alterar a Venda.");
                }
            }
            else 
            {
                throw new Exception();
            }

            conexao.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao iniciar conexão com o BD");
        }
    }
        
    public void Remover(ItemLocacao model) 
    {
        try 
        {
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();
            
            String sql = "DROP TABLE Locacoes (Funcionarios_codFuncionario, Clientes_codCliente, dataLocacao, valorTotal, dataDevolucao, nomeResponsavel, cpfResponsavel, dataNascimento) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
            instrucaoSQL.setInt(1, model.getId_Locacao());
            instrucaoSQL.setInt(2, model.getId_Veiculo());
            instrucaoSQL.setDouble(3, model.getVl_Veiculo());            
            instrucaoSQL.setString(4, model.getMarcaVeiculo());
            instrucaoSQL.setString(5, model.getModeloVeiculo());
            instrucaoSQL.setString(6, model.getPlacaVeiculo());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) 
            {
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); 
            
                if (generatedKeys.next()) {
                    model.setId_ItemLocacao(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao excluir a Venda.");
                }
            }
        } 
        
        catch (Exception e) 
        {
            System.out.println("Erro ao iniciar conexão com o BD");
        }
    }
   
}
