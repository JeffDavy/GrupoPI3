/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.tads.dao;

import br.sp.senac.tads.model.Ouvidoria;
import br.sp.senac.tads.util.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dilaz
 */
public class OuvidoriaDAO {
     private static final String DRIVER = "com.mysql.cj.jdbc.Driver";            //Driver do MySQL a partir da versão 8.0
    private static final String LOGIN = "root";                                           //Nome de Usuário do Bando de Dados
    private static final String SENHA = "";    
    //Senha de Acesso ao Banco de Dados
    //alterar após 3306/ ; colocar o nome do banco para conexão
    private static final String URL = "jdbc:mysql://localhost:3306/ ?useTimezone=true&serverTimezone=UTC&useSSL=false";     //URL do banco de dados
    private static Connection conexao;

    public static boolean adicionar(Ouvidoria pOuvidoria) {
        boolean retorno = false;
        //  Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("INSERT INTO cliente (nome, CPF, celular, estado, email,"
                    + "tipo, mensagem) VALUES(?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID

            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, pOuvidoria.getNome());
            instrucaoSQL.setString(2, pOuvidoria.getCPF());
            instrucaoSQL.setString(3, pOuvidoria.getCelular());
            instrucaoSQL.setString(4, pOuvidoria.getEstado());
            instrucaoSQL.setString(5, pOuvidoria.getEmail());
            instrucaoSQL.setString(6, pOuvidoria.getTipo());
            instrucaoSQL.setString(7, pOuvidoria.getMensagem());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                    pOuvidoria.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao cadastrar Ouvidoria!.");
                }
            } else {
                retorno = false;
            }

        } catch (SQLException | ClassNotFoundException ex) {

            System.out.println(ex.getMessage());
            retorno = false;
        } finally {

            //Libero os recursos da memória
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                GerenciadorConexao.fecharConexao();

            } catch (SQLException ex) {
            }
        }

        return retorno;
    }

    public static boolean consultar(Ouvidoria pOuvidoria) {
        boolean retorno = false;
        //Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("SELECT NOME, CPF, SEXO where OUVIDORIA ",
                    Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID

            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, pOuvidoria.getNome());
            instrucaoSQL.setString(2, pOuvidoria.getCPF());
            instrucaoSQL.setString(3, pOuvidoria.getCelular());
            instrucaoSQL.setString(4, pOuvidoria.getEstado());
            instrucaoSQL.setString(5, pOuvidoria.getEmail());
            instrucaoSQL.setString(6, pOuvidoria.getTipo());
            instrucaoSQL.setString(7, pOuvidoria.getMensagem());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                    pOuvidoria.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o ID da Ouvidoria!.");
                }
            } else {
                retorno = false;
            }

        } catch (SQLException | ClassNotFoundException ex) {

            System.out.println(ex.getMessage());
            retorno = false;
        } finally {

            //Libero os recursos da memória
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                GerenciadorConexao.fecharConexao();

            } catch (SQLException ex) {
            }
        }

        return retorno;
    }

    public static boolean alterar(Ouvidoria pOuvidoria) {
        boolean retorno = false;
        //  Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("update OUVIDORIA set NOME = ?, CPF = ?,"
                    + "CELULAR=?, ESTADO=?, EMAIL=?, TIPO=?, MENSAGEM=? where ID_OUVIDORIA = ? ");

            instrucaoSQL.setString(1, pOuvidoria.getNome());
            instrucaoSQL.setString(2, pOuvidoria.getCPF());
            instrucaoSQL.setString(3, pOuvidoria.getCelular());
            instrucaoSQL.setString(4, pOuvidoria.getEstado());
            instrucaoSQL.setString(5, pOuvidoria.getEmail());
            instrucaoSQL.setString(6, pOuvidoria.getTipo());
            instrucaoSQL.setString(7, pOuvidoria.getMensagem());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                    pOuvidoria.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao alterar Cliente!.");
                }
            } else {
                retorno = false;
            }

        } catch (SQLException | ClassNotFoundException ex) {

            System.out.println(ex.getMessage());
            retorno = false;
        } finally {

            //Libero os recursos da memória
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                GerenciadorConexao.fecharConexao();

            } catch (SQLException ex) {
            }
        }

        return retorno;
    }

    public static boolean remover(Ouvidoria pOuvidoria) {
        boolean retorno = false;
        // Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("delete from OUVIDORIA where ID_OUVIDORIA=?",
                    Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID

            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, pOuvidoria.getNome());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                    pOuvidoria.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao excluir Cliente!.");
                }
            } else {
                retorno = false;
            }

        } catch (SQLException | ClassNotFoundException ex) {

            System.out.println(ex.getMessage());
            retorno = false;
        } finally {

            //Libero os recursos da memória
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                GerenciadorConexao.fecharConexao();

            } catch (SQLException ex) {
            }
        }

        return retorno;
    }

    public ArrayList<Ouvidoria> consultarOuvidoria(Ouvidoria ouviBean) {

        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Ouvidoria> listaOuvidoria = new ArrayList<Ouvidoria>();

        try {

            Class.forName(DRIVER);

            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("select ID_CLIENTE, NOME, CPF, CELULAR, ESTADO, EMAIL, TIPO, MENSAGEM"
                    + " from OUVIDORIA where NOME");

            instrucaoSQL.setInt(1, ouviBean.getId());

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                Ouvidoria ouvi = new Ouvidoria();
                ouvi.setId(rs.getInt("ID_CLIENTE"));
                ouvi.setNome(rs.getString("NOME_"));
                ouvi.setCPF(rs.getString("CPF"));
                ouvi.setCelular(rs.getString("CELULAR"));
                ouvi.setEstado(rs.getString("ESTADO"));
                ouvi.setEmail(rs.getString("EMAIL"));
                ouvi.setTipo(rs.getString("TIPO"));
                ouvi.setMensagem(rs.getString("MENSAGEM"));

                listaOuvidoria.add(ouvi);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Falha na consulta!");

        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }

                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                //Fecho a minha conexão
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Falha ao fechar a conexão!");
            }

        }

        return listaOuvidoria;

    }

    public ArrayList<Ouvidoria> listarTabelaOuvidoria() {

        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Ouvidoria> listaOuvidoria = new ArrayList<Ouvidoria>();

        try {

            Class.forName(DRIVER);

            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("select ID_CLIENTE, NOME, CPF, CELULAR, ESTADO, EMAIL, TIPO, MENSAGEM"
                    + " from OUVIDORIA");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {

                Ouvidoria ouvi = new Ouvidoria();
                ouvi.setId(rs.getInt("ID_CLIENTE"));
                ouvi.setNome(rs.getString("NOME_"));
                ouvi.setCPF(rs.getString("CPF"));
                ouvi.setCelular(rs.getString("CELULAR"));
                ouvi.setEstado(rs.getString("ESTADO"));
                ouvi.setEmail(rs.getString("EMAIL"));
                ouvi.setTipo(rs.getString("TIPO"));
                ouvi.setMensagem(rs.getString("MENSAGEM"));

                listaOuvidoria.add(ouvi);
            }

            return listaOuvidoria;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Falha na consulta!");

            return null;

        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }

                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                //Fecho a minha conexão
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Falha ao fechar a conexão!");
            }

        }

    }
    
 
    public ArrayList<Ouvidoria> pesquisarOuvidoria(Ouvidoria ouviBean) {

        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Ouvidoria> listaOuvidoria = new ArrayList<Ouvidoria>();

        try {

            Class.forName(DRIVER);

            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("select ID_CLIENTE, NOME, CPF, CELULAR, ESTADO, EMAIL, TIPO, MENSAGEM"
                    + " from OUVIDORIA where NOME like ?");

            instrucaoSQL.setString(1, ouviBean.getNome()+ "%");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {

               Ouvidoria ouvi = new Ouvidoria();
                ouvi.setId(rs.getInt("ID_CLIENTE"));
                ouvi.setNome(rs.getString("NOME_"));
                ouvi.setCPF(rs.getString("CPF"));
                ouvi.setCelular(rs.getString("CELULAR"));
                ouvi.setEstado(rs.getString("ESTADO"));
                ouvi.setEmail(rs.getString("EMAIL"));
                ouvi.setTipo(rs.getString("TIPO"));
                ouvi.setMensagem(rs.getString("MENSAGEM"));

                listaOuvidoria.add(ouvi);

            }

            return listaOuvidoria;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Falha na consulta!");

            return null;

        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }

                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                //Fecho a minha conexão
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Falha ao fechar a conexão!");
            }

        }

    }

}
