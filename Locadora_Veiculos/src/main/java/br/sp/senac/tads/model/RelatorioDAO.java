package br.sp.senac.tads.model;

import br.sp.senac.tads.bean.Relatorio;
import br.sp.senac.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jeferson Davi
 */
public class RelatorioDAO {

    Connection conexao;

    /**
     * Driver do MySQL a partir da versão 8.0
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    /** RELATÓRIO FILTRADO POR MARCA DO VEÍCULO*/
    public ArrayList<Relatorio> relatorioMarcaVeiculo(Relatorio relBean) {
        
        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;
        
        ArrayList<Relatorio> listaMarca = new ArrayList<Relatorio>();
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();
            
            String sql = "select filial, codLocacao, CLientes.codCliente, Clientes.nome, Funcionarios.codFuncionario, Funcionarios.nomeFuncionario, Veiculos_codVeiculo, marcaVeiculo, modeloVeiculo, anoVeiculo, placaVeiculo, valorVeiculo, dataLocacao from Locacoes inner join Clientes on Clientes.codCliente = Locacoes.Clientes_codCliente inner join Funcionarios on Funcionarios.codFuncionario = Locacoes.Funcionarios_codFuncionario  where marcaVeiculo = ? and dataLocacao between(?) and (?)";
            
            
            instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setString(1, relBean.getMarcaVeiculo());
            instrucaoSQL.setString(2, relBean.getDataUm());
            instrucaoSQL.setString(3, relBean.getDataDois());
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                
                Relatorio rel = new Relatorio();
                
                rel.setNomeFilial(rs.getString("filial"));
                rel.setCodLocacao(rs.getInt("codLocacao"));
                rel.setCodCliente(rs.getInt("codCliente"));
                rel.setNomeCliente(rs.getString("nome"));
                rel.setCodFuncionario(rs.getInt("codFuncionario"));
                rel.setNomeFuncionario(rs.getString("nomeFuncionario"));
                rel.setCodVeiculo(rs.getInt("Veiculos_codVeiculo"));
                rel.setMarcaVeiculo(rs.getString("marcaVeiculo"));
                rel.setModeloVeiculo(rs.getString("modeloVeiculo"));
                rel.setAnoVeiculo(rs.getInt("anoVeiculo"));
                rel.setPlacaVeiculo(rs.getString("placaVeiculo"));
                rel.setValorVeiculo(rs.getInt("valorVeiculo"));
                rel.setDataLocacao(rs.getString("dataLocacao"));

    
                listaMarca.add(rel);
                
            }
            
        } catch (Exception e) {
            
        }
        
        return listaMarca;
    
    }
    
    /** RELATÓRIO FILTRADO POR CLIENTE DA VENDA*/
    public ArrayList<Relatorio> relatorioCliente(Relatorio relBean) {
        
        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;
        
        ArrayList<Relatorio> listaCliente = new ArrayList<Relatorio>();
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();
            
            String sql = " select filial, codLocacao, CLientes.codCliente, Clientes.nome, Funcionarios.codFuncionario, Funcionarios.nome, Veiculos_codVeiculo,"
                    + " marcaVeiculo, modeloVeiculo, anoVeiculo, placaVeiculo, valorVeiculo, dataLocacao from Locacoes\n" +
                        "inner join Clientes on Clientes.codCliente = Locacoes.Clientes_codCliente\n" +
                        "inner join Funcionarios on Funcionarios.codFuncionario = Locacoes.Funcionarios_codFuncionario\n" +
                        "where Clientes_codCliente = ? and dataLocacao between(?) and (?)";
            
            instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setInt(1, relBean.getCodCliente());
            instrucaoSQL.setString(2, relBean.getDataUm());
            instrucaoSQL.setString(3, relBean.getDataDois());
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                
                Relatorio rel = new Relatorio();
                
                rel.setNomeFilial(rs.getString("filial"));
                rel.setCodLocacao(rs.getInt("codLocacao"));
                rel.setCodCliente(rs.getInt("codCliente"));
                rel.setNomeCliente(rs.getString("nome"));
                rel.setCodFuncionario(rs.getInt("codFuncionario"));
                rel.setNomeFuncionario(rs.getString("nomeFuncionario"));
                rel.setCodVeiculo(rs.getInt("Veiculos_codVeiculo"));
                rel.setMarcaVeiculo(rs.getString("marcaVeiculo"));
                rel.setModeloVeiculo(rs.getString("modeloVeiculo"));
                rel.setAnoVeiculo(rs.getInt("anoVeiculo"));
                rel.setPlacaVeiculo(rs.getString("placaVeiculo"));
                rel.setValorVeiculo(rs.getInt("valorVeiculo"));
                rel.setDataLocacao(rs.getString("dataLocacao"));

    
                listaCliente.add(rel);
                
            }
            
        } catch (Exception e) {
            
        }
        
        return listaCliente;
    
    }
    
    /** RELATÓRIO FILTRADO POR FILIAL*/
    public ArrayList<Relatorio> relatorioFilial(Relatorio relBean) {
        
        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;
        
        ArrayList<Relatorio> listaFilial = new ArrayList<Relatorio>();
        
        try {
            
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();
            
            String sql = "select filial, codLocacao, CLientes.codCliente, Clientes.nome, Funcionarios.codFuncionario, Funcionarios.nome, Veiculos_codVeiculo, marcaVeiculo,"
                    + " modeloVeiculo, anoVeiculo, placaVeiculo, valorVeiculo, dataLocacao from Locacoes\n" +
                        "inner join Clientes on Clientes.codCliente = Locacoes.Clientes_codCliente\n" +
                        "inner join Funcionarios on Funcionarios.codFuncionario = Locacoes.Funcionarios_codFuncionario\n" +
                        "where filial = ? and dataLocacao between(?) and (?)";
            
            instrucaoSQL = conexao.prepareStatement(sql);
            
            instrucaoSQL.setString(1, relBean.getNomeFilial());
            instrucaoSQL.setString(2, relBean.getDataUm());
            instrucaoSQL.setString(3, relBean.getDataDois());
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                
                Relatorio rel = new Relatorio();
                
                rel.setNomeFilial(rs.getString("filial"));
                rel.setCodLocacao(rs.getInt("codLocacao"));
                rel.setCodCliente(rs.getInt("codCliente"));
                rel.setNomeCliente(rs.getString("nome"));
                rel.setCodFuncionario(rs.getInt("codFuncionario"));
                rel.setNomeFuncionario(rs.getString("nomeFuncionario"));
                rel.setCodVeiculo(rs.getInt("Veiculos_codVeiculo"));
                rel.setMarcaVeiculo(rs.getString("marcaVeiculo"));
                rel.setModeloVeiculo(rs.getString("modeloVeiculo"));
                rel.setAnoVeiculo(rs.getInt("anoVeiculo"));
                rel.setPlacaVeiculo(rs.getString("placaVeiculo"));
                rel.setValorVeiculo(rs.getDouble("valorVeiculo"));
                rel.setDataLocacao(rs.getString("dataLocacao"));

    
                listaFilial.add(rel);
                
            }
            
        } catch (Exception e) {
            
        }
        
        return listaFilial;
    
    }

}
