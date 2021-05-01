package br.sp.senac.tads.model;

/**
 *
 * @author Jeferson Davi
 */
public class VeiculoModel {
    
    private int codVeiculo;
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private String cor;
    private String quilometragem;
    private boolean revisao;
    private double valorVeiculo;
    private boolean statusVeiculo;

    public VeiculoModel() {
    }

    public VeiculoModel(int codVeiculo, String marca, String modelo, int ano, String placa, String cor, String quilometragem, boolean revisao, double valorVeiculo, boolean statusVeiculo) {
        this.codVeiculo = codVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.cor = cor;
        this.quilometragem = quilometragem;
        this.revisao = revisao;
        this.valorVeiculo = valorVeiculo;
        this.statusVeiculo = statusVeiculo;
    }

    public int getCodVeiculo() {
        return codVeiculo;
    }

    public void setCodVeiculo(int codVeiculo) {
        this.codVeiculo = codVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(String quilometragem) {
        this.quilometragem = quilometragem;
    }

    public boolean isRevisao() {
        return revisao;
    }

    public void setRevisao(boolean revisao) {
        this.revisao = revisao;
    }

    public double getValorVeiculo() {
        return valorVeiculo;
    }

    public void setValorVeiculo(double valorVeiculo) {
        this.valorVeiculo = valorVeiculo;
    }

    public boolean isStatusVeiculo() {
        return statusVeiculo;
    }

    public void setStatusVeiculo(boolean statusVeiculo) {
        this.statusVeiculo = statusVeiculo;
    }
    
    
    
}
