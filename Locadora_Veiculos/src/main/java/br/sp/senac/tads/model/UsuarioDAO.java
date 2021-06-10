/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.tads.model;

import br.sp.senac.tads.bean.Usuario;
import br.sp.senac.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaop
 */
public class UsuarioDAO 
{
    static Connection conexao;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public UsuarioDAO() {
    }
    
    public static Usuario getUsuario(String usuario)
    {
        Usuario user = null;
        try
        {
            Class.forName(DRIVER);
            conexao = Conexao.abrirConexao();
            
            String query = "select * from Logins where usuario = ?";
            PreparedStatement instrucaoSQL = conexao.prepareStatement(query);
            
            instrucaoSQL.setString(1, usuario);
            ResultSet rs = instrucaoSQL.executeQuery();
            
            if (rs.next()) 
            {
                user = new Usuario();
                user.setUser(usuario);
                user.setSenha(rs.getString("senha"));
                user.setFilial(rs.getString("filial"));
                user.setPerfil(rs.getString("perfil"));
            }
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
