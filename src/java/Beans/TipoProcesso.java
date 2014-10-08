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

public class TipoProcesso {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
     private int idTipoProcesso;
    private String nomeTipoProcesso;
   
	
    public TipoProcesso(){
        nomeTipoProcesso = "";
        
    }

    public void setIdTipoProcesso(int idTipoProcesso) {
        this.idTipoProcesso = idTipoProcesso;
    }
    
    public int getIdTipoProcesso() {
        return idTipoProcesso;
    }

    public String getNomeTipoProcesso() {
        return nomeTipoProcesso;
    }

    public void setNomeTipoProcesso(String nomeTipoProcesso) {
        this.nomeTipoProcesso = nomeTipoProcesso;
    }
}
