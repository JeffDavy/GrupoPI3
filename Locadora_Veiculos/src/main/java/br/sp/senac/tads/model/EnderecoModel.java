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
public class EnderecoModel 
{
    private int id_endereco;
    private String rua;
    private String bairro;
    private int numero;
    private String cidade;
    private String estado;
    private String complemento;

    public int getId_endereco() 
    {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) 
    {
        this.id_endereco = id_endereco;
    }

    public String getRua() 
    {
        return rua;
    }

    public void setRua(String rua) 
    {
        this.rua = rua;
    }

    public String getBairro() 
    {
        return bairro;
    }

    public void setBairro(String bairro) 
    {
        this.bairro = bairro;
    }

    public int getNumero() 
    {
        return numero;
    }

    public void setNumero(int numero) 
    {
        this.numero = numero;
    }

    public String getCidade() 
    {
        return cidade;
    }

    public void setCidade(String cidade) 
    {
        this.cidade = cidade;
    }

    public String getEstado() 
    {
        return estado;
    }

    public void setEstado(String estado) 
    {
        this.estado = estado;
    }

    public String getComplemento() 
    {
        return complemento;
    }

    public void setComplemento(String complemento) 
    {
        this.complemento = complemento;
    }

}
