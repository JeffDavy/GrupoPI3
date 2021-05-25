package br.sp.senac.tads.bean;
import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author Jeferson Davi
 */
@Getter
@Setter
public class Login {
    
    private int codLogin;
    private String usuario;
    private String senha;
    private String tipo;

    public Login() {
    }
    public  Login(int codLogin, String usuario, String senha, String tipo){
        this.codLogin=codLogin;
        this.usuario=usuario;
        this.senha=senha;
        this.tipo=tipo;
    }

}
