/*Feito por Lila ♥
 */
package br.sp.senac.tads.dao;

import br.sp.senac.tads.model.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dilaz
 */
public class FuncionarioDAO {
    private static Connection conexaoBancoDados() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection("jdbc:mysql://canes.cp2usnfank7u.us-east-1.rds.amazonaws.com:3306?useLegacyDatetimeCode=false&serverTimezone=America/Fortaleza&useTimezone=true", "admin", ""); //
        return conexao;
    }

    public boolean salvarFuncionarioDAO(Funcionario funcionario) {

        boolean retorno = false;

        try (Connection conexao = conexaoBancoDados()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO LOCADORA_VEICULOS.FUNCIONARIO(codFuncionario, Logins_codLogin," +
"nome,email,statusFuncionario)\n"
                    + "VALUES(?,?,?,?,?);");

            comandoSQL.setInt(1, funcionario.getCodFuncionario());
            comandoSQL.setInt(2, funcionario.getLogins_codLogin());
            comandoSQL.setString(3, funcionario.getNome());
            comandoSQL.setString(4, funcionario.getEmail());
            comandoSQL.setBoolean(5, funcionario.getStatusFuncionario());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public boolean alterarFuncionrioDAO(Funcionario funcionario) {

        boolean retorno = false;

        try (Connection conexao = conexaoBancoDados()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE LOCADORA_VEICULOS.FUNCIONARIO \n"
                    + "SET codFuncionario=? , Logins_codLogin = ? , nome = ? , email = ? , statusFuncionario = ? \n"
                    + "WHERE codFuncionario = ?;");
            
            comandoSQL.setInt(1, funcionario.getCodFuncionario());
            comandoSQL.setInt(2, funcionario.getLogins_codLogin());
            comandoSQL.setString(3, funcionario.getNome());
            comandoSQL.setString(4, funcionario.getEmail());
            comandoSQL.setBoolean(5, funcionario.getStatusFuncionario());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }
    
    
    public boolean alterarSenhaFuncionrioDAO(Funcionario funcionario) {

        boolean retorno = false;

        try (Connection conexao = conexaoBancoDados()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE LOCADORA_VEICULOS.LOGINS \n"
                    + "SET SENHA = ?\n"
                    + "WHERE codLogin= ?;");

            comandoSQL.setString(1, funcionario.getSenha());
            comandoSQL.setInt(2, funcionario.getLogins_codLogin());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }


    public ArrayList<Funcionario> getFuncionario(int ID) {

        ArrayList<Funcionario> lista = new ArrayList<>();

        try (Connection conexao = conexaoBancoDados()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM LOCADORA_VEICULOS.FUNCIONARIO WHERE codFuncionario = ?");

            comandoSQL.setInt(1, ID);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setCodFuncionario(rs.getInt("codFuncionario"));
                    funcionario.setLogins_codLogin(rs.getInt("Logins_codLogin"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setEmail(rs.getString("email"));
                    funcionario.setStatusFuncionario(rs.getBoolean("statusFuncionario"));
                    lista.add(funcionario);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

    public Funcionario getFuncionarioLogin(String login) {

        try (Connection conexao = conexaoBancoDados()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM LOCADORA_VEICULOS.FUNCIONARIO WHERE Logins_codLogin = ?");

            comandoSQL.setString(1, login);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Funcionario funcionario = new Funcionario();
                     funcionario.setLogins_codLogin(rs.getInt("Logins_codLogin"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setEmail(rs.getString("email"));
                    funcionario.setStatusFuncionario(rs.getBoolean("statusFuncionario"));
                    
                    return funcionario;
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

  
    public ArrayList<Funcionario> getFuncionarioFilter(String filter) {

        ArrayList<Funcionario> lista = new ArrayList<>();

        try (Connection conexao = conexaoBancoDados()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM LOCADORA_VEICULOS.FUNCIONARIO WHERE nome LIKE '%" + filter + "%' OR email LIKE '%" + filter + "%' OR statusFuncionario LIKE '%" + filter + "%'");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Funcionario funcionario = new Funcionario();
                     funcionario.setLogins_codLogin(rs.getInt("Logins_codLogin"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setEmail(rs.getString("email"));
                    funcionario.setStatusFuncionario(rs.getBoolean("statusFuncionario"));
                    lista.add(funcionario);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

    public boolean excluirFuncionario(int ID) {
        boolean retorno = false;

        try (Connection conexao = conexaoBancoDados()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM LOCADORA_VEICULOS.FUNCIONARIO  WHERE codFuncionario = ?");

            comandoSQL.setInt(1, ID);

            int linhasAfetadas = comandoSQL.executeUpdate();

            retorno = linhasAfetadas > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }


}
