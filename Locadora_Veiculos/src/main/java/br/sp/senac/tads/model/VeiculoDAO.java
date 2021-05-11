package br.sp.senac.tads.model;

import br.sp.senac.tads.bean.Veiculo;
import br.sp.senac.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    public boolean cadastrarVeiculo(Veiculo veiculoBean) {
        
        boolean status = false;
        try {

            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "insert into Veiculos (marca, modelo, ano, placa, cor, quilometragem, valorVeiculo) values (?,?,?,?,?,?,?)";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);

            instrucaoSQL.setString(1, veiculoBean.getMarca());
            instrucaoSQL.setString(2, veiculoBean.getModelo());
            instrucaoSQL.setInt(3, veiculoBean.getAno());
            instrucaoSQL.setString(4, veiculoBean.getPlaca());
            instrucaoSQL.setString(5, veiculoBean.getCor());
            instrucaoSQL.setInt(6, veiculoBean.getQuilometragem());
            instrucaoSQL.setDouble(7, veiculoBean.getValorVeiculo());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                return true;                
                
            } else {
                throw new Exception();

            }

        } catch (Exception e) {
            System.out.println("Erro ao iniciar conexão com o BD");

        }
        
        return status;
        
    }

    public boolean alterarVeiculo(Veiculo veiculoBean) {
        
        boolean status = false;
        
        try {

            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "update Veiculos set marca = ?, modelo = ?, ano = ?, placa = ?, cor = ?, quilometragem = ?, valorVeiculo = ? where codVeiculo = ?";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);

            instrucaoSQL.setString(1, veiculoBean.getMarca());
            instrucaoSQL.setString(2, veiculoBean.getModelo());
            instrucaoSQL.setInt(3, veiculoBean.getAno());
            instrucaoSQL.setString(4, veiculoBean.getPlaca());
            instrucaoSQL.setString(5, veiculoBean.getCor());
            instrucaoSQL.setInt(6, veiculoBean.getQuilometragem());
            instrucaoSQL.setDouble(7, veiculoBean.getValorVeiculo());
            instrucaoSQL.setInt(8, veiculoBean.getCodVeiculo());

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

    public boolean removerVeiculo(Veiculo veiculoBean) {
        
        boolean status = false;
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "delete from Veiculos where codVeiculo = ?";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setInt(1, veiculoBean.getCodVeiculo());
            
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

    public ArrayList<Veiculo> consultarVeiculo(Veiculo veiculoBean) {

        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Veiculo> listaVeiculo = new ArrayList<Veiculo>();

        try {

            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "select codVeiculo, marca, modelo, ano, placa, valorVeiculo from Veiculos where placa = ?";

            instrucaoSQL = conexao.prepareStatement(sql);

            instrucaoSQL.setString(1, veiculoBean.getPlaca());

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {

                Veiculo veiculo = new Veiculo();

                veiculo.setCodVeiculo(rs.getInt("codVeiculo"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setAno(rs.getInt("ano"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setValorVeiculo(rs.getDouble("valorVeiculo"));

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

    public ArrayList<Veiculo> listarVeiculos(Veiculo veiculoBean) {

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
                veiculo.setValorVeiculo(rs.getDouble("valorVeiculo"));

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
    
    public int pegarId(Veiculo veiculoBean) {
        
        int id = 0;
        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "select codVeiculo from Veiculos where placa = ?";
            
            instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setString(1, veiculoBean.getPlaca());
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                
                id = rs.getInt("codVeiculo");
                
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
