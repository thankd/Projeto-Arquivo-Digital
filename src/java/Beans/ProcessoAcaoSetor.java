package Beans;
    public class ProcessoAcaoSetor {
        private int idSetor;
        private int idAcao;
        private int idProcesso;
        private String estado;

        public ProcessoAcaoSetor(){
        idSetor = 0;
        idAcao = 0;
        idProcesso = 0;
        }

    public int getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }

    public int getIdAcao() {
        return idAcao;
    }

    public void setIdAcao(int idAcao) {
        this.idAcao = idAcao;
    }

    public int getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(int idProcesso) {
        this.idProcesso = idProcesso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
        
        
        
    
                
}
