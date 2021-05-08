package br.sp.senac.tads.dao;

import br.sp.senac.tads.model.Funcionario;
import br.sp.senac.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jeferson Davi
 */
public class FuncionarioDAO {
    
    Connection conexao;

    /**
     * Driver do MySQL a partir da versão 8.0
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public FuncionarioDAO() {
    }
    
    public void cadastrarFuncionario(Funcionario funcBean) {
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "insert into Funcionarios (Logins_codLogin, nome, email, tipo) values (?,?,?,?)";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setInt(1, funcBean.getCodLogin());
            instrucaoSQL.setString(2, funcBean.getNome());
            instrucaoSQL.setString(3, funcBean.getEmail());
            instrucaoSQL.setString(4, funcBean.getTipo());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Funcionário Cadastrado!");

            } else {
                throw new Exception();

            }

            conexao.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao iniciar conexão com o BD");
            
        }
        
        
    }
    
    public void alterarFuncionario(Funcionario funcBean) {
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "update Funcionarios set nome = ?, email = ?, tipo = ? where codFuncionario = ?";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setString(1, funcBean.getNome());
            instrucaoSQL.setString(2, funcBean.getEmail());
            instrucaoSQL.setString(3, funcBean.getTipo());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Funcionário Alterado!");

            } else {
                throw new Exception();

            }

            conexao.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao iniciar conexão com o BD");
            
        }
        
    }
    
    //Remover funcionario
    
    public ArrayList<Funcionario> consultarFuncionario(Funcionario funcBean) {
        
        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;
        
        ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "select * from Funcionario where codFuncionario = ?";
            
            instrucaoSQL = conexao.prepareStatement(sql);

            instrucaoSQL.setInt(1, funcBean.getCodFuncionario());
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                
                Funcionario funcionario = new Funcionario();
                
                funcionario.setCodFuncionario(rs.getInt("codFuncionario"));
                funcionario.setCodLogin(rs.getInt("Logins_codLogin"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setTipo(rs.getString("tipo"));
                
                listaFuncionario.add(funcionario);
                
            }
            
        } catch (Exception e) {
            System.out.println("Erro na consulta");
            
        } finally {
            
            try {

                if (rs != null) {
                    rs.close();
                    System.out.println("Funcionario existe! Fim");

                }

                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                    System.out.println("Funcionario não existe. Fim");

                }

                conexao.close();

            } catch (Exception e) {
                System.out.println("Falha no fechamento da conexão");

            }
            
        }
        
        return listaFuncionario;
        
    }
    
    public ArrayList<Funcionario> listarFuncionarios(Funcionario funcBean) {
        
        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;
        
        ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "select * from Funcionarios";
            
            instrucaoSQL = conexao.prepareStatement(sql);
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                
                Funcionario funcionario = new Funcionario();
                
                funcionario.setCodFuncionario(rs.getInt("codFuncionario"));
                funcionario.setCodLogin(rs.getInt("Logins_codLogin"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setTipo(rs.getString("tipo"));
                
                listaFuncionario.add(funcionario);
                
            }
            
        } catch (Exception e) {
            System.out.println("Erro na listagem");
            
        } finally {
            
            try {

                if (rs != null) {
                    rs.close();

                }

                if (instrucaoSQL != null) {
                    instrucaoSQL.close();

                }

                conexao.close();

            } catch (Exception e) {
                System.out.println("Falha no fechamento da conexão");

            }
            
        }
        
        return listaFuncionario;
        
    }
    
    public int pegarId(Funcionario funcBean) {
        
        int id = 0;
        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "select codFuncionario from Clientes where email = ?";
            
            instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setString(1, funcBean.getEmail());
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                
                id = rs.getInt("codFuncionario");
                
            }
            
        } catch (Exception e) {
            System.out.println("Erro na consulta");
            
        } finally {
            
            try {

                if (rs != null) {
                    rs.close();

                }

                if (instrucaoSQL != null) {
                    instrucaoSQL.close();

                }

                conexao.close();

            } catch (Exception e) {
                System.out.println("Falha no fechamento da conexão");

            }
            
        }

        return id;
        
    }
    
}
