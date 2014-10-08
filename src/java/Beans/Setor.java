/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;



/**
 *
 * @author 20101064010663
 */
/*@Stateless*/
public class Setor {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private int idSetor;
    private String nomeSetor;
    private String sigla;
    private String chefe;
    private String telefone;
	
    public Setor(){
        nomeSetor = "";
        sigla = "";
        chefe = "";
	telefone = "";
    }

    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }
    
    public int getIdSetor() {
        return idSetor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }
    public String getNome() {
        return nomeSetor;
    }

    public void setNome(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getChefe() {
        return chefe;
    }

    public void setChefe(String chefe) {
        this.chefe = chefe;
    }
	
	public String getTelefone(){
		return telefone;
	}
	
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
    
    
}
