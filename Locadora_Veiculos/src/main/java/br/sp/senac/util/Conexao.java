package br.sp.senac.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jeferson Davi
 */
public class Conexao {

    public static String status = "Não conectado";
    public static String driver = "com.mysql.cj.jdbc.Driver";   //DRIVER DO MYSQL A PARTIR DA VERSÃO 8                   
    public static String server = "localhost";                  //ENDEREÇO DO SERVIDOR DE BANCO DE DADOS
    public static String database = "locadora_veiculos";               //NOME DO BANCO DE DADOS
    public static String login = "root";                        //USUÁRIO DO BANCO DE DADOS      
    public static String senha = "1234";                       //SENHA DE ACESSO
    public static String url = "";
    public static Connection CONEXAO;

    public static Connection abrirConexao() throws ClassNotFoundException, SQLException {

        /**
         * Cria a URL concatenando os valores inseridos pelas variaveis da
         * classe
         *
         */
        url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";

        /**
         * Verifica se a conxão está vazia
         */
        if (CONEXAO == null) {
            try {
                //Carrega a classe responsável pelo driver
                Class.forName(driver);
                CONEXAO = DriverManager.getConnection(url, login, senha);
                if (CONEXAO != null) {
                    status = "Conexão realizada com sucesso!";
                } else {
                    status = "Não foi possivel realizar a conexão";
                }
            } catch (ClassNotFoundException e) {  //Driver não encontrado
                throw new ClassNotFoundException("O driver expecificado nao foi encontrado.");
            } catch (SQLException e) {  //Erro ao estabelecer a conexão (Ex: login ou senha errados)
                //Outra falha de conexão
                throw new SQLException("Erro ao estabelecer a conexão (Ex: login ou senha errados).");
            }
        } else {
            try {
                //Se a conexão estiver fechada, reabro a conexão
                if (CONEXAO.isClosed()) {
                    CONEXAO = DriverManager.getConnection(url, login, senha);
                }
            } catch (SQLException ex) {
                throw new SQLException("Falha ao fechar a conexão.");
            }
        }
        return CONEXAO;
    }
    
     /**
     * Método responsável por Fechar a conexão com o Banco de Dados.
     * 
     * @return boolean informando se a conexão está fechada ou aberta
     * @throws SQLException 
     */
    public static boolean fecharConexao() throws SQLException {
        boolean retorno = false;
        try {
            if (CONEXAO != null) {
                if (!CONEXAO.isClosed()) {
                    CONEXAO.close();
                }
            }
            status = "Não conectado";
            retorno = true;
        } catch (SQLException e) {
            retorno = false;
        }
        return retorno;
    }

    /**
     * Método responsável por informar se está conectado ou não.
     * 
     * @return STATUS  
     */
    public static String getStatusConexao() {
        System.out.println("Status: " + status);
        return status;
    }
//criado
    public static Connection getConexao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
