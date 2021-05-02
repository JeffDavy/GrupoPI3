package br.sp.senac.tads.model;

/**
 *
 * @author Jeferson Davi
 */
public class ItemLocacao {
    
    private int codItemLocacao;
    private int codVeiculo;
    private int codLocacao;
    private double valorVeiculo;
    private String marcaVeiculo;
    private String modeloVeiculo;
    private String placaVeiculo;

    public ItemLocacao() {
    }

    public int getCodItemLocacao() {
        return codItemLocacao;
    }

    public void setCodItemLocacao(int codItemLocacao) {
        this.codItemLocacao = codItemLocacao;
    }

    public int getCodVeiculo() {
        return codVeiculo;
    }

    public void setCodVeiculo(int codVeiculo) {
        this.codVeiculo = codVeiculo;
    }

    public int getCodLocacao() {
        return codLocacao;
    }

    public void setCodLocacao(int codLocacao) {
        this.codLocacao = codLocacao;
    }

    public double getValorVeiculo() {
        return valorVeiculo;
    }

    public void setValorVeiculo(double valorVeiculo) {
        this.valorVeiculo = valorVeiculo;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }
    
    
    
}
