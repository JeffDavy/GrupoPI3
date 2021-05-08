/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.tads.model;

import java.util.Date;

/**
 *
 * @author Administrador
 */
public class LocacaoModel 
{
    private int Id_locacao;
    private int Id_funcionario;
    private int Id_cliente;
    private Date Dt_locacao;
    private double Vl_total;
    private Date Dt_devolucao;
    private String Nm_responsavel;
    private String Cpf;
    private Date Dt_nascimento;

    public int getId_locacao() {
        return Id_locacao;
    }

    public void setId_locacao(int Id_locacao) {
        this.Id_locacao = Id_locacao;
    }

    public int getId_funcionario() {
        return Id_funcionario;
    }

    public void setId_funcionario(int Id_funcionario) {
        this.Id_funcionario = Id_funcionario;
    }

    public int getId_cliente() {
        return Id_cliente;
    }

    public void setId_cliente(int Id_cliente) {
        this.Id_cliente = Id_cliente;
    }

    public Date getDt_locacao() {
        return Dt_locacao;
    }

    public void setDt_locacao(Date Dt_locacao) {
        this.Dt_locacao = Dt_locacao;
    }

    public double getVl_total() {
        return Vl_total;
    }

    public void setVl_total(double Vl_total) {
        this.Vl_total = Vl_total;
    }

    public Date getDt_devolucao() {
        return Dt_devolucao;
    }

    public void setDt_devolucao(Date Dt_devolucao) {
        this.Dt_devolucao = Dt_devolucao;
    }

    public String getNm_responsavel() {
        return Nm_responsavel;
    }

    public void setNm_responsavel(String Nm_responsavel) {
        this.Nm_responsavel = Nm_responsavel;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public Date getDt_nascimento() {
        return Dt_nascimento;
    }

    public void setDt_nascimento(Date Dt_nascimento) {
        this.Dt_nascimento = Dt_nascimento;
    }
}
