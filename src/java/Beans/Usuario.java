/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Edivania
 */
public class Usuario {
    
    private int idUsuario;
    private int idSetor;
    private String nome;
    private String senha;
    private String tipoUsuario;
    private String email;
    private String celular;
    private String setor;
    
    public Usuario(){
        idUsuario = 0;
        idSetor = 0;
        nome = "";
        senha = "";
        tipoUsuario = "";
        email = "";
        celular = "";
        setor = "";
    }
    
    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }
    
    public int getIdUsuario(){
        return idUsuario;
    }
    
    public void setIdSetor(int idSetor){
        this.idSetor = idSetor;
    }
    
    public int getIdSetor(){
        return idSetor;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getSenha(){
        return senha;
    }
    public void setTipoUsuario(String tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }
    
    public String getTipoUsuario(){
        return tipoUsuario;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    public void setCelular(String celular){
        this.celular = celular;
    }
    
    public String getCelular(){
        return celular;
    }
        public void setSetor(String setor){
        this.setor = setor;
    }
    
    public String getSetor(){
        return setor;
    }
}
