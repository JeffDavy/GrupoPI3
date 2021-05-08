package br.sp.senac.tads.model;

import br.sp.senac.tads.bean.ItemLocacao;
import br.sp.senac.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Jeferson Davi
 */
public class ItemLocacaoDAO {

    Connection conexao;

    /**
     * Driver do MySQL a partir da versão 8.0
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    private static ArrayList<ItemLocacao> listaItem = new ArrayList<>();

    public ItemLocacaoDAO() {
    }

    public boolean inserirItem(ItemLocacao itemBean) {

        boolean status = false;

        try {

            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();

            String sql = "insert into Item_locacao (Veiculos_codVeiculo, Locacoes_codLocacao, valorVeiculo, marcaVeiculo, modeloVeiculo, placaVeiculo) values (?,?,?,?,?,?)";

            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);

            instrucaoSQL.setInt(1, itemBean.getCodVeiculo());
            instrucaoSQL.setInt(2, itemBean.getCodLocacao());
            instrucaoSQL.setDouble(3, itemBean.getValorVeiculo());
            instrucaoSQL.setString(4, itemBean.getMarcaVeiculo());
            instrucaoSQL.setString(5, itemBean.getModeloVeiculo());
            instrucaoSQL.setString(6, itemBean.getPlacaVeiculo());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Item Cadastrado!");
                return true;

            } else {
                throw new Exception();

            }

        } catch (Exception e) {
            System.out.println("Erro ao iniciar conexão com o BD");

        }

        return status;
    }

    public ArrayList<ItemLocacao> salvarItem(ItemLocacao itemLocacao) {
        
        listaItem.add(itemLocacao);
        
        return listaItem;

    }

    public static ArrayList<ItemLocacao> getItens() {
        
        return ItemLocacaoDAO.listaItem;

    }

    public static boolean excluirItem() {
        listaItem.clear();
        return true;
        
    }

}
