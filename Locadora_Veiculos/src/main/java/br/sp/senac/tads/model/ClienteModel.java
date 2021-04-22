/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.tads.model;

import java.util.Date;

/**
 *
 * @author joaop
 */
public class ClienteModel 
{
    private int id_cliente;
    private String nome_cliente;
    private String cpf_cliente;
    private Date dt_nascimento;
    private String sexo_cliente;
    private String email_cliente;
    private int id_endereco;
    private String contato1_cliente;
    private String contato2_cliente;
    private int status_cliente;

    public int getId_cliente() 
    {
        return id_cliente;
    }

    public int getId_endereco() 
    {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) 
    {
        this.id_endereco = id_endereco;
    }

    public void setId_cliente(int id_cliente) 
    {
        this.id_cliente = id_cliente;
    }

    public String getNome_cliente() 
    {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) 
    {
        this.nome_cliente = nome_cliente;
    }

    public String getCpf_cliente() 
    {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) 
    {
        this.cpf_cliente = cpf_cliente;
    }

    public Date getDt_nascimento() 
    {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) 
    {
        this.dt_nascimento = dt_nascimento;
    }

    public String getSexo_cliente() 
    {
        return sexo_cliente;
    }

    public void setSexo_cliente(String sexo_cliente) 
    {
        this.sexo_cliente = sexo_cliente;
    }

    public String getEmail_cliente() 
    {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) 
    {
        this.email_cliente = email_cliente;
    }



    public String getContato1_cliente() 
    {
        return contato1_cliente;
    }

    public void setContato1_cliente(String contato1_cliente) 
    {
        this.contato1_cliente = contato1_cliente;
    }

    public String getContato2_cliente() 
    {
        return contato2_cliente;
    }

    public void setContato2_cliente(String contato2_cliente) 
    {
        this.contato2_cliente = contato2_cliente;
    }

    public int getStatus_cliente() 
    {
        return status_cliente;
    }

    public void setStatus_cliente(int status_cliente) 
    {
        this.status_cliente = status_cliente;
    }
}
