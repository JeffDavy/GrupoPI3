/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.tads.dao;

import br.sp.senac.tads.model.LocacaoModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class LocacaoDAO 
{
     Connection conexao;

    /**
     * Driver do MySQL a partir da versão 8.0
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    
    public void Inserir(LocacaoModel model) throws ClassNotFoundException 
    {
        try 
        {
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "insert into Locacoes (Funcionarios_codFuncionario, Clientes_codCliente"
                    + ", dataLocacao, valorTotal, dataDevolucao, nomeResponsavel, cpfResponsavel, dataNascimento) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setInt(1, model.getId_funcionario());
            instrucaoSQL.setInt(2, model.getId_cliente());
            instrucaoSQL.setDate(3, (Date) model.getDt_locacao());
            instrucaoSQL.setDouble(4, model.getVl_total());
            instrucaoSQL.setDate(5, (Date) model.getDt_devolucao());
            instrucaoSQL.setString(6, model.getNm_responsavel());
            instrucaoSQL.setString(7, model.getCpf());
            instrucaoSQL.setDate(8, (Date) model.getDt_nascimento());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) 
            {
                System.out.println("Locação realizada!");
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
     
    public ArrayList<LocacaoModel> Listar(LocacaoModel model) 
    {
        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<LocacaoModel> locacoes = new ArrayList<LocacaoModel>();
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "SELECT * FROM Locacoes (Funcionarios_codFuncionario, Clientes_codCliente"
                    + ", dataLocacao, valorTotal, dataDevolucao, nomeResponsavel, cpfResponsavel, dataNascimento) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                
                LocacaoModel modelo = new LocacaoModel();
                
                modelo.setId_locacao(rs.getInt("codLocacao"));
                modelo.setId_funcionario(rs.getInt("Funcionarios_codFuncionario"));
                modelo.setId_cliente(rs.getInt("Clientes_codCliente"));
                modelo.setCpf(rs.getString("cpf"));
                modelo.setDt_locacao(rs.getDate("dataLocacao"));
                modelo.setVl_total(rs.getDouble("valorTotal"));
                modelo.setDt_devolucao(rs.getDate("dataDevolucao"));
                modelo.setNm_responsavel(rs.getString("nomeResponsavel"));
                modelo.setCpf(rs.getString("cpfResponsavel"));
                modelo.setDt_nascimento(rs.getDate("dataNascimento"));
                
                locacoes.add(modelo);
            }
            
        } catch (Exception e) {
            System.out.println("Erro na consulta");
            
        } finally {
            
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
    
    public void Alterar(LocacaoModel model) {
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = 
            "ALTER TABLE ITEM_VENDA (Funcionarios_codFuncionario, Clientes_codCliente, dataLocacao, valorTotal, "
            + "dataDevolucao, nomeResponsavel, cpfResponsavel, dataNascimento) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setInt(1, model.getId_funcionario());
            instrucaoSQL.setInt(2, model.getId_cliente());
            instrucaoSQL.setDate(3, (Date) model.getDt_locacao());
            instrucaoSQL.setDouble(4, model.getVl_total());
            instrucaoSQL.setDate(5, (Date) model.getDt_devolucao());
            instrucaoSQL.setString(6, model.getNm_responsavel());
            instrucaoSQL.setString(7, model.getCpf());
            instrucaoSQL.setDate(8, (Date) model.getDt_nascimento());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Locação Alterado!");

            } else {
                throw new Exception();

            }

            conexao.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao iniciar conexão com o BD");
        }
    }
        
    public void Remover(LocacaoModel model) 
    {
        try 
        {
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();
            
            String sql = "DROP TABLE Locacoes (Funcionarios_codFuncionario, Clientes_codCliente, dataLocacao, valorTotal, dataDevolucao, nomeResponsavel, cpfResponsavel, dataNascimento) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
            instrucaoSQL.setInt(1,model.getId_funcionario());
            instrucaoSQL.setInt(2,model.getId_cliente());
            instrucaoSQL.setDate(3, (Date) model.getDt_locacao());
            instrucaoSQL.setDouble(4,model.getVl_total());
            instrucaoSQL.setDate(5, (Date) model.getDt_devolucao());
            instrucaoSQL.setString(5,model.getNm_responsavel());
            instrucaoSQL.setString(5,model.getCpf());
            instrucaoSQL.setDate(5, (Date) model.getDt_nascimento());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) 
            {
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); 
            
                if (generatedKeys.next()) {
                    model.setId_locacao(generatedKeys.getInt(1));
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
