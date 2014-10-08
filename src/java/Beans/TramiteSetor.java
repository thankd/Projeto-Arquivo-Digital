/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Edivania
 */
public class TramiteSetor {
    
    private int idTramitePadrao;
    private int idSetor;
    private int sequencia;
    
    public TramiteSetor(){
        idTramitePadrao = 0;
        idSetor = 0;
        sequencia = 0;
    }
    
    public void setIdTramitePadrao(int idTramitePadrao){
        this.idTramitePadrao = idTramitePadrao;
    }
    
    public int getIdTramitePadrao(){
        return idTramitePadrao;
    }
    
    public void setIdSetor(int idSetor){
        this.idSetor = idSetor;
    }
    
    public int getIdSetor(){
        return idSetor;
    }
   
    public void setSequencia(int sequencia){
        this.sequencia = sequencia;
    }
    
    public int getSequencia(){
        return sequencia;
    }
}
