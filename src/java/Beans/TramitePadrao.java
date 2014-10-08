/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Edivania
 */
public class TramitePadrao {
    
    private int idTramitePadrao;
    private int idTipoProcesso;
    
    public TramitePadrao(){
        idTramitePadrao = 0;
        idTipoProcesso = 0;
    }
    
    public void setIdTramitePadrao(int idTramitePadrao){
        this.idTramitePadrao = idTramitePadrao;
    }
    
    public int getIdTramitePadrao(){
        return idTramitePadrao;
    }
    
    public void setIdTipoProcesso(int idTipoProcesso){
        this.idTipoProcesso = idTipoProcesso;
    }
   
    public int getIdTipoProcesso(){
        return idTipoProcesso;
    }
}
