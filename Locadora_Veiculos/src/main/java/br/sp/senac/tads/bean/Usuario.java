
package br.sp.senac.tads.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private String nome;
    private String senha;
    private String perfil;
    private String filial;
    private String login;
    
    public boolean isGerente(){
        return perfil.equalsIgnoreCase("GERENTE");
    }
    
    public boolean isAdmin() {
        return perfil.equalsIgnoreCase("ADMIN");
    }
}
