/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Edivania
 */
public class Tramite {
    
    private String nomeTipoProcesso;
    private String sequencia;
    private int idTipoProcesso;
    private int idTramitePadrao;
	
    public Tramite(){
        nomeTipoProcesso = "";
        sequencia = "";        
    }

    public String getNomeTipoProcesso() {
        return nomeTipoProcesso;
    }

    public void setNomeTipoProcesso(String nomeTipoProcesso) {
        this.nomeTipoProcesso = nomeTipoProcesso;
    }

    public String getSequencia() {
        return sequencia;
    }

    public void setSequencia(String sequencia) {
        this.sequencia = sequencia;
    }

    public int getIdTipoProcesso() {
        return idTipoProcesso;
    }

    public void setIdTipoProcesso(int idTipoProcesso) {
        this.idTipoProcesso = idTipoProcesso;
    }

    public int getIdTramitePadrao() {
        return idTramitePadrao;
    }

    public void setIdTramitePadrao(int idTramitePadrao) {
        this.idTramitePadrao = idTramitePadrao;
    }
}
