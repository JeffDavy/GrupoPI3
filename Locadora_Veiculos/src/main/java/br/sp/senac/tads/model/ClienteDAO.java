package br.sp.senac.tads.model;

import br.sp.senac.tads.bean.Cliente;
import br.sp.senac.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jeferson Davi
 */
public class ClienteDAO {
    
    Connection conexao;

    /**
     * Driver do MySQL a partir da versão 8.0
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public ClienteDAO() {
    }
    
    public boolean cadastrarCliente(Cliente clienteBean) {
               
        boolean status = false;
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "insert into Clientes (Logins_codLogin, nome, cpf, dataNascimento, sexo, email, contato1, contato2, rua, numero, bairro, cidade, estado, complemento) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setInt(1, clienteBean.getCodLogin());
            instrucaoSQL.setString(2, clienteBean.getNome());
            instrucaoSQL.setString(3, clienteBean.getCpf());
            instrucaoSQL.setString(4, clienteBean.getDataNascimento());
            instrucaoSQL.setString(5, clienteBean.getSexo());
            instrucaoSQL.setString(6, clienteBean.getEmail());
            instrucaoSQL.setString(7, clienteBean.getContato1());
            instrucaoSQL.setString(8, clienteBean.getContato2());
            instrucaoSQL.setString(9, clienteBean.getRua());
            instrucaoSQL.setInt(10, clienteBean.getNumero());
            instrucaoSQL.setString(11, clienteBean.getBairro());
            instrucaoSQL.setString(12, clienteBean.getCidade());
            instrucaoSQL.setString(13, clienteBean.getEstado());
            instrucaoSQL.setString(14, clienteBean.getComplemento());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                status = true;
                
            } else {
                throw new Exception();

            }

                        
        } catch (Exception e) {
            System.out.println("Erro ao iniciar conexão com o BD");
            
        }
        
        return status;
        
    }
    
    public boolean alterarCliente(Cliente clienteBean) {
        
        boolean status = false;
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "update Clientes set nome = ?, cpf = ?, dataNascimento = ?, sexo = ?, email = ?, contato1 = ?, contato2 = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, complemento = ? where codCliente = ?";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setString(1, clienteBean.getNome());
            instrucaoSQL.setString(2, clienteBean.getCpf());
            instrucaoSQL.setString(3, clienteBean.getDataNascimento());
            instrucaoSQL.setString(4, clienteBean.getSexo());
            instrucaoSQL.setString(5, clienteBean.getEmail());
            instrucaoSQL.setString(6, clienteBean.getContato1());
            instrucaoSQL.setString(7, clienteBean.getContato2());
            instrucaoSQL.setString(8, clienteBean.getRua());
            instrucaoSQL.setInt(9, clienteBean.getNumero());
            instrucaoSQL.setString(10, clienteBean.getBairro());
            instrucaoSQL.setString(11, clienteBean.getCidade());
            instrucaoSQL.setString(12, clienteBean.getEstado());
            instrucaoSQL.setString(13, clienteBean.getComplemento());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                status = true;

            } else {
                throw new Exception();

            }

            conexao.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao iniciar conexão com o BD");
            
        }
        
        return status;
        
    }
    
    public boolean removerCliente(Cliente clienteBean) {
        
        boolean status = false;
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "update Clientes set estatus = ? where cpf = ?";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setString(1, clienteBean.getEstatus());
            instrucaoSQL.setString(2, clienteBean.getCpf());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                status = true;

            } else {
                throw new Exception();

            }
            
        } catch (Exception e) {
            System.out.println("Erro ao iniciar conexão com o BD");
            
        }
        
        return status;
        
    }
    
    public boolean validarCliente(Cliente clienteBean) {
        
        boolean status = false;
        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "select * from Clientes where cpf = ?";

            instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setString(1, clienteBean.getCpf());
            
            rs = instrucaoSQL.executeQuery();
    
            if (rs != null) {
                rs.close();
                System.out.println("Cliente existe!");

            }

            if (instrucaoSQL != null) {
                instrucaoSQL.close();
                System.out.println("Cliente não existe.");

            }
            
            conexao.close();
            
            
        } catch (Exception e) {
            System.out.println("Erro na consulta.");
            
        }
        
        return status;
        
    }
    
    public ArrayList<Cliente> consultarCliente(Cliente clienteBean) {
        
        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "select * from Clientes where cpf = ?";
            
            instrucaoSQL = conexao.prepareStatement(sql);

            instrucaoSQL.setString(1, clienteBean.getCpf());
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                
                Cliente cliente = new Cliente();
                
                cliente.setCodCliente(rs.getInt("codCliente"));
                cliente.setCodLogin(rs.getInt("Logins_codLogin"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setDataNascimento(rs.getString("dataNascimento"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setEmail(rs.getString("email"));
                cliente.setContato1(rs.getString("contato1"));
                cliente.setContato2(rs.getString("contato2"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setComplemento(rs.getString("complemento"));
                
                listaCliente.add(cliente);
                
            }
            
        } catch (Exception e) {
            System.out.println("Erro na consulta");
            
        } finally {
            
            try {

                if (rs != null) {
                    rs.close();
                    System.out.println("Cliente existe! Fim");

                }

                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                    System.out.println("Cliente não existe. Fim");

                }

                conexao.close();

            } catch (Exception e) {
                System.out.println("Falha no fechamento da conexão");

            }
            
        }
        
        return listaCliente;
        
    }    
    
    public ArrayList<Cliente> listarClientes(Cliente clienteBean) {
        
        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "select * from Clientes";

            instrucaoSQL = conexao.prepareStatement(sql);
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                
                Cliente cliente = new Cliente();
                
                cliente.setCodCliente(rs.getInt("codCliente"));
                cliente.setCodLogin(rs.getInt("Logins_codLogin"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setDataNascimento(rs.getString("dataNascimento"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setEmail(rs.getString("email"));
                cliente.setContato1(rs.getString("contato1"));
                cliente.setContato2(rs.getString("contato2"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setComplemento(rs.getString("complemento"));
                
                listaCliente.add(cliente);
                
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
        
        return listaCliente;
        
    }
    
    public int pegarId(Cliente clienteBean) {
        
        int id = 0;
        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "select codCliente from Clientes where cpf = ?";
            
            instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setString(1, clienteBean.getCpf());
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                
                id = rs.getInt("codCliente");
                
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
