
package br.sp.senac.tads.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private String User;
    private String Senha;
    private String Perfil;
    private String filial;
    
    public boolean isGerente(){
        return Perfil.equalsIgnoreCase("GERENTE");
    }
    
    public boolean isAdmin() {
        return Perfil.equalsIgnoreCase("ADMIN");
    }
}
