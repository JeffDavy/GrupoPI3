/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.util;

import at.favre.lib.crypto.bcrypt.BCrypt;

//import org.mindrot.jbcrypt.BCrypt;


public class CryptoUtils {
    
    
    public static String gerarHash(String senhaAberta) {
        return BCrypt.withDefaults().hashToString(12, senhaAberta.toCharArray());
        
    }
    
    public static boolean validarSenha(String senhaAberta, String senhaFechada) 
    {
        BCrypt.Result result = BCrypt.verifyer().verify(senhaAberta.toCharArray(), senhaFechada);
        return result.verified;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String senha = "1234";
        System.out.println("Hash = " + gerarHash(senha));
    }
}
