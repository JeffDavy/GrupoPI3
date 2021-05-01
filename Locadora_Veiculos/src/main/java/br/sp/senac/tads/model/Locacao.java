package br.sp.senac.tads.model;

/**
 *
 * @author Jeefrson Davi
 */
public class Locacao {
    
    private int codLocacao;
    private String dataLocacao;
    private double valorTotal;
    private String dataDevolucao;
    private String nomeResponsavel;
    private String cpfResponsavel;
    private String dataNascimento;

    public Locacao() {
    }

    public Locacao(int codLocacao, String dataLocacao, double valorTotal, String dataDevolucao, String nomeResponsavel, String cpfResponsavel, String dataNascimento) {
        this.codLocacao = codLocacao;
        this.dataLocacao = dataLocacao;
        this.valorTotal = valorTotal;
        this.dataDevolucao = dataDevolucao;
        this.nomeResponsavel = nomeResponsavel;
        this.cpfResponsavel = cpfResponsavel;
        this.dataNascimento = dataNascimento;
    }

    public int getCodLocacao() {
        return codLocacao;
    }

    public void setCodLocacao(int codLocacao) {
        this.codLocacao = codLocacao;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    
    
}
