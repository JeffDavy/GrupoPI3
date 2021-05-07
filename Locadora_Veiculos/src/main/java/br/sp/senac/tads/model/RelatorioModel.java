
package br.sp.senac.tads.model;

/**
 *
 * @author dilaz
 */
public class RelatorioModel {
    
    
    private String nomeFilial;
    private String nomeVeiculo;
    private double valorLocacao;
    private int qtdLocacao;
    private double valorTotal;
    private double percentual;

    public RelatorioModel() {

    }

    //Construtor
    public RelatorioModel(String nomeFilial, String nomeVeiculo, double valorLocacao, int qtdLocacao, double valorTotal) {
        this.nomeFilial = nomeFilial;
        this.nomeVeiculo = nomeVeiculo;
        this.valorLocacao = valorLocacao;
        this.qtdLocacao = qtdLocacao;
        this.valorTotal = valorTotal;
    }
    
    //Construtor Total Filial
    public RelatorioModel(String nomeFilial, double valorTotal){
        this.nomeFilial = nomeFilial;
        this.valorTotal = valorTotal;
    }
    
    //Construtor Percentual
    public RelatorioModel(String nomeFilial, double valorTotal, double percentual){
        this.nomeFilial = nomeFilial;
        this.valorTotal = valorTotal;
        this.percentual = percentual;
    }

    public String getNomeFilial() {
        return nomeFilial;
    }

    public void setNomeFilial(String nomeFilial) {
        this.nomeFilial = nomeFilial;
    }

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public int getQtdLocacao() {
        return qtdLocacao;
    }

    public void setQtdLocacao(int qtdLocacao) {
        this.qtdLocacao = qtdLocacao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }


    
}
