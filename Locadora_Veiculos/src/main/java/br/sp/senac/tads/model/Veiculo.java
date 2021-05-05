package br.sp.senac.tads.model;

/**
 *
 * @author Jeferson Davi
 */
public class Veiculo {
    
    private int codVeiculo;
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private String cor;
    private int quilometragem;
    private String revisao;
    private double valorVeiculo;
    private String statusVeiculo;

    public Veiculo() {
    }

    public Veiculo(int codVeiculo, String marca, String modelo, int ano, String placa, String cor, int quilometragem, String revisao, double valorVeiculo, String statusVeiculo) {
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

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getRevisao() {
        return revisao;
    }

    public void setRevisao(String revisao) {
        this.revisao = revisao;
    }

    public double getValorVeiculo() {
        return valorVeiculo;
    }

    public void setValorVeiculo(double valorVeiculo) {
        this.valorVeiculo = valorVeiculo;
    }

    public String getStatusVeiculo() {
        return statusVeiculo;
    }

    public void setStatusVeiculo(String statusVeiculo) {
        this.statusVeiculo = statusVeiculo;
    }
    
    
    
}
