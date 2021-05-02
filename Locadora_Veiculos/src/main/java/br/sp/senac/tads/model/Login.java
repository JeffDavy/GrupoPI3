package br.sp.senac.tads.model;

/**
 *
 * @author Jeferson Davi
 */
public class Login {
    
    private int codLogin;
    private String usuario;
    private String senha;
    private String statusLogin;

    public Login() {
    }

    public Login(int codLogin, String usuario, String senha, String statusLogin) {
        this.codLogin = codLogin;
        this.usuario = usuario;
        this.senha = senha;
        this.statusLogin = statusLogin;
    }

    public int getCodLogin() {
        return codLogin;
    }

    public void setCodLogin(int codLogin) {
        this.codLogin = codLogin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatusLogin() {
        return statusLogin;
    }

    public void setStatusLogin(String statusLogin) {
        this.statusLogin = statusLogin;
    }
    
    
    
}
