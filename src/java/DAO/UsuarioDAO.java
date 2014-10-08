/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Conexao;
import Beans.Setor;
import Beans.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thales
 */
public class UsuarioDAO {
    
    private Connection con;
    
    public UsuarioDAO() throws InstantiationException{
        this.con = new Conexao().getConexao();
    }
    
    public void AdicionarUsuario(Usuario usuario){
        String sql = "INSERT INTO usuario (IdUsuario, IdSetor, nome, senha, tipoUsuario, email, celular) VALUES (?,?,?,?,?,?,?);";
        
        try{
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, Integer.toString(usuario.getIdUsuario()));
            stmt.setString(2, Integer.toString(usuario.getIdSetor()));
            stmt.setString(3, usuario.getNome());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getTipoUsuario());
            stmt.setString(6, usuario.getEmail());
            stmt.setString(7, usuario.getCelular());
            
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
	public List<Usuario> ListarUsuario(String str_filtro, String tipo_filtro){
            String variavel_str = "";
            String sql = "";
            
            if(tipo_filtro.equals("matricula")){
                variavel_str = "a.idUsuario";
            } else if(tipo_filtro.equals("nome")){
                variavel_str = "a.nome";
            } else if(tipo_filtro.equals("setor")){
                variavel_str = "b.nome";
            } else {
                variavel_str = "normal";
            }
            
            if(variavel_str.equals("normal")){
                sql = "Select a.idUsuario, b.nome, a.nome, a.tipoUsuario, a.email, a.celular FROM usuario a, setor b WHERE a.idSetor = b.idSetor";
            } else {
                sql = "Select a.idUsuario, b.nome, a.nome, a.tipoUsuario, a.email, a.celular FROM usuario a, setor b WHERE a.idSetor = b.idSetor AND " + variavel_str + " LIKE '%"+ str_filtro +"%'";
            }
        try{
            List<Usuario> usuarios = new ArrayList<Usuario>();
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Usuario objUsuario = new Usuario();
                objUsuario.setIdUsuario(rs.getInt("a.idUsuario"));
                objUsuario.setSetor(rs.getString("b.nome"));
                objUsuario.setNome(rs.getString("a.nome"));
                objUsuario.setTipoUsuario(rs.getString("a.tipoUsuario")); 
                objUsuario.setEmail(rs.getString("a.email")); 
                objUsuario.setCelular(rs.getString("a.celular")); 
                
                usuarios.add(objUsuario);
            }       
            rs.close();
            stmt.close();
            return usuarios;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
        
        
    public Usuario SelecionarUsuario(int idUsuario){
        String sql = "Select * FROM usuario WHERE idUsuario = ?";
        try{
            
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1, Integer.toString(idUsuario));
            ResultSet rs = stmt.executeQuery();
                Usuario objUsuario = new Usuario();
                objUsuario.setIdUsuario(rs.getInt("idUsuario"));
                objUsuario.setIdSetor(rs.getInt("idSetor"));
                objUsuario.setNome(rs.getString("nome"));
                objUsuario.setTipoUsuario(rs.getString("tipoUsuario")); 
                objUsuario.setEmail(rs.getString("email")); 
                objUsuario.setCelular(rs.getString("celular")); 
                     
            rs.close();
            stmt.close();
            return objUsuario;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void EditarUsuario(Usuario usuario, String idEditar){
        String sql = "UPDATE usuario SET idUsuario =?, tipoUsuario=?, idSetor=?, nome=?, email=?, celular=? WHERE idUsuario =?";
        
        try{
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1, Integer.toString(usuario.getIdUsuario()));
            stmt.setString(2, usuario.getTipoUsuario());
            stmt.setString(3, Integer.toString(usuario.getIdSetor()));
            stmt.setString(4, usuario.getNome());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getCelular());
            stmt.setString(7, idEditar);
            
            
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);            
        }
    }
    
    public void ExcluirUsuario(Usuario usuario){
        String sql = "DELETE FROM usuario WHERE idUsuario=?";
        
        try{
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, usuario.getIdUsuario());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Setor> ListarSetores(){
        String sql = "Select IdSetor, nome FROM setor";
        try{
            List<Setor> setores = new ArrayList<Setor>();
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Setor objSetor = new Setor();
                objSetor.setIdSetor(rs.getInt("idSetor"));
                objSetor.setNomeSetor(rs.getString("nome"));
                
                setores.add(objSetor);
            }       
            rs.close();
            stmt.close();
            return setores;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    } 
}
