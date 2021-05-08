/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.tads.model;

/**
 *
 * @author joaop
 */
public class ItemLocacao 
{
    private int Id_ItemLocacao;
    private int Id_Veiculo;
    private int Id_Locacao;
    private double Vl_Veiculo;
    private String MarcaVeiculo;
    private String ModeloVeiculo;
    private String PlacaVeiculo;

    public int getId_ItemLocacao() {
        return Id_ItemLocacao;
    }

    public void setId_ItemLocacao(int Id_ItemLocacao) {
        this.Id_ItemLocacao = Id_ItemLocacao;
    }

    public int getId_Veiculo() {
        return Id_Veiculo;
    }

    public void setId_Veiculo(int Id_Veiculo) {
        this.Id_Veiculo = Id_Veiculo;
    }

    public int getId_Locacao() {
        return Id_Locacao;
    }

    public void setId_Locacao(int Id_Locacao) {
        this.Id_Locacao = Id_Locacao;
    }

    public double getVl_Veiculo() {
        return Vl_Veiculo;
    }

    public void setVl_Veiculo(double Vl_Veiculo) {
        this.Vl_Veiculo = Vl_Veiculo;
    }

    public String getMarcaVeiculo() {
        return MarcaVeiculo;
    }

    public void setMarcaVeiculo(String MarcaVeiculo) {
        this.MarcaVeiculo = MarcaVeiculo;
    }

    public String getModeloVeiculo() {
        return ModeloVeiculo;
    }

    public void setModeloVeiculo(String ModeloVeiculo) {
        this.ModeloVeiculo = ModeloVeiculo;
    }

    public String getPlacaVeiculo() {
        return PlacaVeiculo;
    }

    public void setPlacaVeiculo(String PlacaVeiculo) {
        this.PlacaVeiculo = PlacaVeiculo;
    }
}
