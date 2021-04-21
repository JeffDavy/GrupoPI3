/*Feito por Lila ♥
 */
package br.sp.senac.tads.model;

/**
 *
 * @author dilaz
 */
public class Ouvidoria {

    private int id;
    private String nome;
    private String CPF;
    private String celular;
    private String estado;
    private String email;
    private String tipo;
    private String mensagem;

    public Ouvidoria() {
    }

    public Ouvidoria(int id, String nome, String CPF, String celular, String estado, String email, String tipo, String mensagem) {
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
        this.celular = celular;
        this.estado = estado;
        this.email = email;
        this.tipo = tipo;
        this.mensagem = mensagem;
    }

    public Ouvidoria(String nome, String CPF, String celular, String estado, String email, String tipo, String mensagem) {
        this.nome = nome;
        this.CPF = CPF;
        this.celular = celular;
        this.estado = estado;
        this.email = email;
        this.tipo = tipo;
        this.mensagem = mensagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
