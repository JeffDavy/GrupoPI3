package br.sp.senac.tads.dao;

import br.sp.senac.tads.model.Login;
import br.sp.senac.tads.model.Veiculo;
import br.sp.senac.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LoginDAO {
    
    Connection conexao;

    /**
     * Driver do MySQL a partir da versão 8.0
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public LoginDAO() {
    }
    
    public void cadastrarLogin(Login loginBean, String tipo) {
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "insert into Logins (usuario, senha, tipo) values (?,?,?)";
            
            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setString(1, loginBean.getUsuario());
            instrucaoSQL.setString(2, loginBean.getSenha());
            instrucaoSQL.setString(3, tipo);
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if (linhasAfetadas > 0) {
                System.out.println("Login Cadastrado!");

            } else {
                throw new Exception();

            }
            
            
            
            conexao.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao iniciar a conexão com o BD.");
            
        }
        
    }
    
    public void alterarLogin(Login loginBean) {
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "update Logins set usuario = ?, senha = ? where codLogin = ?";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setString(1, loginBean.getUsuario());
            instrucaoSQL.setString(2, loginBean.getSenha());
            instrucaoSQL.setInt(3, loginBean.getCodLogin());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Login Alterado!");

            } else {
                throw new Exception();

            }

            conexao.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao iniciar conexão com o BD");
            
        }
        
    }
    
    public void desativarAtivarLogin(Login loginBean) {
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "update Logins set statusLogin = ? where codLogin = ?";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);

            instrucaoSQL.setString(1, loginBean.getStatusLogin());
            instrucaoSQL.setInt(2, loginBean.getCodLogin());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {

                if (loginBean.getStatusLogin().equals("1")) {
                    System.out.println("Login ATIVADO!");

                } else {
                    System.out.println("Login DESATIVADO!");

                }

            } else {
                throw new Exception();

            }

            conexao.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao iniciar conexão com o BD");
            
        }
        
    }
    
    public boolean validarLogin(Login loginBean) {
        
        boolean status = false;
        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;

        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "select * from Logins where usuario = ?";

            instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setString(1, loginBean.getUsuario());
            
            rs = instrucaoSQL.executeQuery();
    
            if (rs != null) {
                rs.close();
                System.out.println("Login existe!");

            }

            if (instrucaoSQL != null) {
                instrucaoSQL.close();
                System.out.println("Login não existe.");

            }
            
            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro na consulta.");
            
        }
        
        return status;

    }
    
    public int consultarLogin(Login loginBean) {
        
        int retorno = 0;
        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "select codLogin from Logins where usuario = ?";
            
            instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setString(1, loginBean.getUsuario());

            rs = instrucaoSQL.executeQuery();
            
            rs.getInt(retorno);
            
        } catch (Exception e) {
            System.out.println("Erro de conexão com o BD");
        }
        
        return retorno;
        
    }
       
    public ArrayList<Login> listarLogins(Login loginBean) {
        
        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Login> listaLogin = new ArrayList<Login>();
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "select codLogin, usuario, statusLogin from Logins where statusLogin = ?";
            
            instrucaoSQL.setString(1, loginBean.getStatusLogin());

            instrucaoSQL = conexao.prepareStatement(sql);

            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                
                Login login = new Login();
                
                login.setCodLogin(rs.getInt("codLogin"));
                login.setUsuario(rs.getString("usuario"));
                login.setSenha(rs.getString("statusLogin"));
                
                listaLogin.add(login);
                
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
        
        return listaLogin;
        
    }
    
}
