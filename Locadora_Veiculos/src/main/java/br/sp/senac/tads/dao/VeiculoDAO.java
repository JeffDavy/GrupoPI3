package br.sp.senac.tads.dao;

import br.sp.senac.tads.model.Veiculo;
import br.sp.senac.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

            String sql = "insert into Veiculos (marca, modelo, ano, placa, cor, quilometragem, revisao, valorVeiculo) values (?,?,?,?,?,?,?,?)";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);

            instrucaoSQL.setString(1, veiculoBean.getMarca());
            instrucaoSQL.setString(2, veiculoBean.getModelo());
            instrucaoSQL.setInt(3, veiculoBean.getAno());
            instrucaoSQL.setString(4, veiculoBean.getPlaca());
            instrucaoSQL.setString(5, veiculoBean.getCor());
            instrucaoSQL.setInt(6, veiculoBean.getQuilometragem());
            instrucaoSQL.setString(7, veiculoBean.getRevisao());
            instrucaoSQL.setDouble(8, veiculoBean.getValorVeiculo());

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

    public void alterarVeiculo(Veiculo veiculoBean) {

        try {

            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "update Veiculos set marca = ?, modelo = ?, ano = ?, placa = ?, cor = ?, quilometragem = ?, revisao = ?, valorVeiculo = ? where codVeiculo = ?";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);

            instrucaoSQL.setString(1, veiculoBean.getMarca());
            instrucaoSQL.setString(2, veiculoBean.getModelo());
            instrucaoSQL.setInt(3, veiculoBean.getAno());
            instrucaoSQL.setString(4, veiculoBean.getPlaca());
            instrucaoSQL.setString(5, veiculoBean.getCor());
            instrucaoSQL.setInt(6, veiculoBean.getQuilometragem());
            instrucaoSQL.setString(7, veiculoBean.getRevisao());
            instrucaoSQL.setDouble(8, veiculoBean.getValorVeiculo());
            instrucaoSQL.setInt(9, veiculoBean.getCodVeiculo());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Alterado!");

            } else {
                throw new Exception();

            }

            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao iniciar conexão com o BD");

        }

    }

    public void desativarAtivarVeiculo(Veiculo veiculoBean) {

        try {

            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "update Veiculos set statusVeiculo = ? where codVeiculo = ?";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);

            instrucaoSQL.setString(1, veiculoBean.getStatusVeiculo());
            instrucaoSQL.setInt(2, veiculoBean.getCodVeiculo());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {

                if (veiculoBean.getStatusVeiculo().equals("1")) {
                    System.out.println("Veículo ATIVADO!");

                } else {
                    System.out.println("Veículo DESATIVADO!");

                }

            } else {
                throw new Exception();

            }

            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao iniciar conexão com o BD");

        }

    }

    public ArrayList<Veiculo> consultarVeiculo(Veiculo veicuoBean) {

        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Veiculo> listaVeiculo = new ArrayList<Veiculo>();

        try {

            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "select * from Veiculos where codVeiculo = ?";

            instrucaoSQL = conexao.prepareStatement(sql);

            instrucaoSQL.setInt(1, veicuoBean.getCodVeiculo());

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {

                Veiculo veiculo = new Veiculo();

                veiculo.setCodVeiculo(rs.getInt("codVeiculo"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setAno(rs.getInt("ano"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setQuilometragem(rs.getInt("quilometragem"));
                veiculo.setRevisao(rs.getString("revisao"));
                veiculo.setValorVeiculo(rs.getDouble("valorVeiculo"));
                veiculo.setStatusVeiculo(rs.getString("statusVeiculo"));

                listaVeiculo.add(veiculo);

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

        return listaVeiculo;

    }

    public ArrayList<Veiculo> listarVeiculos() {

        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Veiculo> listaVeiculo = new ArrayList<Veiculo>();

        try {

            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "select * from Veiculos";

            instrucaoSQL = conexao.prepareStatement(sql);

            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {

                Veiculo veiculo = new Veiculo();

                veiculo.setCodVeiculo(rs.getInt("codVeiculo"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setAno(rs.getInt("ano"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setQuilometragem(rs.getInt("quilometragem"));
                veiculo.setRevisao(rs.getString("revisao"));
                veiculo.setValorVeiculo(rs.getDouble("valorVeiculo"));
                veiculo.setStatusVeiculo(rs.getString("statusVeiculo"));

                listaVeiculo.add(veiculo);

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
        
        return listaVeiculo;

    }

}
