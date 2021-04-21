/*Feito por Lila ♥
 */
package br.sp.senac.tads.model;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author dilaz
 */
public class Funcionario {
   private int codFuncionario;//id do func
    private int Logins_codLogin; //login de acess
    private String senha;
    private String nome;
    private String email;
    private boolean statusFuncionario; //status de ativacao

    public Funcionario() {
    }

    public Funcionario(int codFuncionario, int Logins_codLogin, String senha, String nome,
            String email, boolean statusFuncionario) {
        this.codFuncionario = codFuncionario;
        this.Logins_codLogin = Logins_codLogin;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.statusFuncionario = statusFuncionario;
    }

    public Funcionario(int ID, int codFuncionario, int Logins_codLogin, String senha, String nome,
            String email, boolean statusFuncionario) {
        this.codFuncionario = ID;
        this.Logins_codLogin = Logins_codLogin;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.statusFuncionario = statusFuncionario;

    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public String getSenha() {
        return senha;
    }

    public final void setSenhaHash(String senha) {
        this.senha = BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public boolean validarSenha(String senhaUsuario) {
        return BCrypt.checkpw(senhaUsuario, senha);
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public int getLogins_codLogin() {
        return Logins_codLogin;
    }

    public void setLogins_codLogin(int Logins_codLogin) {
        this.Logins_codLogin = Logins_codLogin;
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

    public boolean isStatusFuncionario() {
        return statusFuncionario;
    }

    public void setStatusFuncionario(boolean statusFuncionario) {
        this.statusFuncionario = statusFuncionario;
    }

    public boolean getStatusFuncionario() {
        return statusFuncionario;
    }
}