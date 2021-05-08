package br.sp.senac.tads.model;

/**
 *
 * @author Jeferson Davi
 */
public class Funcionario {
    
    private int codFuncionario;
    private int codLogin;
    private String nome;
    private String email;
    private String tipo;

    public Funcionario() {
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public int getCodLogin() {
        return codLogin;
    }

    public void setCodLogin(int codLogin) {
        this.codLogin = codLogin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
