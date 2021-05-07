/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.tads.dao;

import br.sp.senac.tads.model.RelatorioModel;
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
public class RelatorioDAO {
     private static Connection obterConexao() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost.cp2usnfank7u.us-east-1.rds.amazonaws.com:3306/locadora_veiculos?useTimezone=true&serverTimezone=UTC&useSSL=false", "root", "");
        return conexao;
    }

    public ArrayList<RelatorioModel> getRelatorio(int locacao) {

        ArrayList<RelatorioModel> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT \n"
                    + "    a.codVeiculo,\n"
                    + "    a.marca,\n"
                    + "    a.modelo,\n"
                    + "    a.placa,\n"
                    + "    a.cor,\n"
                    + "    b.valorPendente,\n"
                    + "    b.valorPago,\n"
                    + "    b.observacoes,\n"
                    + "    c.dataLocacao,\n"
                    + "    c.valorTotal,\n"
                    + "    c.dataDevolucao,\n"
                    + "    c.nomeResponsavel,\n"
                    + "    c.cpfResponsavel,\n"
                    + "    d.dataDevolucao,\n"
                    + "    d.observacoesCarro,\n"
                    + "    d.multas,\n"
                    + "    d.valorCobranca,\n"
                    + "    SUM(b.valorPendente + b.valorPago + d.multas) b.valorTotal\n"
                    + "FROM\n"
                    + "    locadora_veiculos.Item_Locacao b\n"
                    + "        INNER JOIN\n"
                    + "    locadora_veiculos.Veiculos a ON b.codItem_Locacao = b.codVeiculo\n"
                    + "        INNER JOIN\n"
                    + "    locadora_veiculos.Locacoes c ON b.codItem_Locacao = c.codLocacao\n"
                    + "        INNER JOIN\n"
                    + "    locadora_veiculos.Devolucoes d ON c.codLocacao = d.codDevolucao\n"
                    + "WHERE c.codLocacao = ?\n"
                    + "GROUP BY 1 , 2\n"
                    + "ORDER BY 4 CRESC\n");

            comandoSQL.setInt(1, locacao);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    RelatorioModel relatorio = new RelatorioModel();
                    relatorio.setNomeVeiculo(rs.getString("modeloVeiculo"));
                    relatorio.setValorLocacao(rs.getDouble("valorCobranca"));
                    lista.add(relatorio);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

   // Fazer posteriormente pra filial
//2 arrays pra filial
    public ArrayList<RelatorioModel> getRelatorioPercentual(int locacao) {

        ArrayList<RelatorioModel> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT \n"
                    + "    b.valorCobranca,\n"
                    + "    b.multas,\n"
                    + "    a.valorTotal,\n"
                    + "    c.valorPago,\n"
                    + "    c.valorPendente,\n"
                    + "    SUM(a.valorTotal + b.valorCobranca + b.multas) AS valorTotal,\n"
                    + "    locadora_veiculos.Devolucoes a\n"
                    + "        INNER JOIN\n"
                    + "    locadora_veiculos.Locacoes b ON a.codDevolucao = b.codLocacao\n"
                    + "        INNER JOIN\n"
                    + "    locadora_veiculos.Financeiro c ON a.codDevolucao = .codFinanceiro\n"
                    + "    WHERE b.codFinanceiro = ?\n"
                    + "GROUP BY 1\n"
                    + "ORDER BY 2 DESC;");

            comandoSQL.setInt(1, locacao);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    RelatorioModel relatorio = new RelatorioModel();
                    relatorio.setNomeVeiculo(rs.getString("modeloVeiculo"));
                    relatorio.setValorLocacao(rs.getDouble("valorCobranca"));
                    relatorio.setPercentual(rs.getDouble("PERCENTUAL_TOTAL"));
                    lista.add(relatorio);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }
}
