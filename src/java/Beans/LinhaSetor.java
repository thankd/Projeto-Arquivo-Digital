/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.List;

/**
 *
 * @author Edivania
 */
public class LinhaSetor {
    private String nomeSetor;
    private String siglaSetor;
    private List<String> nomeAcoes; 
    private List<String> estadoAcoes;
    private String passouSetor;
    //private List<int> idsAcao;

    public LinhaSetor() {
        this.nomeSetor = "";
        this.siglaSetor = "";
        this.nomeAcoes = null;
        this.estadoAcoes = null;
        this.passouSetor = "";
    }

    public List<String> getEstadoAcoes() {
        return estadoAcoes;
    }

    public void setEstadoAcoes(List<String> estadoAcoes) {
        this.estadoAcoes = estadoAcoes;
    }

    public List<String> getNomeAcoes() {
        return nomeAcoes;
    }

    public void setNomeAcoes(List<String> nomeAcoes) {
        this.nomeAcoes = nomeAcoes;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public String getSiglaSetor() {
        return siglaSetor;
    }

    public void setSiglaSetor(String siglaSetor) {
        this.siglaSetor = siglaSetor;
    }

    public String getPassouSetor() {
        return passouSetor;
    }

    public void setPassouSetor(String passouSetor) {
        this.passouSetor = passouSetor;
    }   
}
