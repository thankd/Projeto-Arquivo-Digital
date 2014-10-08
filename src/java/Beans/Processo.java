package Beans;
    public class Processo {
      private int idProcesso; // gerado automaticamete
      private int idUsuario; // vai puxar de acordo com o usuário logado
      private int idSetor; // selecionar o setor? (select)
      private String assunto; // campo de texto
      private String caminhoArquivo; //  
      private String dataAbertura; // usar uma função para puxar a data de abertura
      private String situacao; // alterada automaticamente
      private String setorAtual; 
      private String tipoProcesso; // select com os tipos
      
      private String interessado;
      private String siglaSetorAtual;
       private int idSetorAtual;
      private int idTipoProcesso;
      private String siglaSetorOrigem;
      
      public Processo(){
          assunto = "";
          caminhoArquivo = "";
          dataAbertura = "";
          situacao = "";
          setorAtual = "";
          tipoProcesso = "";
          interessado = "";
          siglaSetorAtual = "";
          idSetorAtual = 0;
          idTipoProcesso = 0;
          siglaSetorOrigem = "";
      }
        
    public int getIdProcesso() {
        return idProcesso;
    }
        // precisa do SET?!
    public void setIdProcesso(int idProcesso) {
        this.idProcesso = idProcesso;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }


    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getSetorAtual() {
        return setorAtual;
    }

    public void setSetorAtual(String setorAtual) {
        this.setorAtual = setorAtual;
    }

    public String getTipoProcesso() {
        return tipoProcesso;
    }

    public void setTipoProcesso(String tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
    }
         ///////////////////////////////////////////////////////////////////////////////
    public String getInteressado() {
        return interessado;
    }

    public void setInteressado(String interessado) {
        this.interessado = interessado;
    }

    public String getSiglaSetorAtual() {
        return siglaSetorAtual;
    }

    public void setSiglaSetorAtual(String siglaSetorAtual) {
        this.siglaSetorAtual = siglaSetorAtual;
    }
      
     /////////////////////////////////////////////////////////////////////////////// 
     public int getIdSetorAtual() {
        return idSetorAtual;
    }

    public void setIdSetorAtual(int idSetorAtual) {
        this.idSetorAtual = idSetorAtual;
    }

    public int getIdTipoProcesso() {
        return idTipoProcesso;
    }

    public void setIdTipoProcesso(int idTipoProcesso) {
        this.idTipoProcesso = idTipoProcesso;
    }

    public String getSiglaSetorOrigem() {
        return siglaSetorOrigem;
    }

    public void setSiglaSetorOrigem(String siglaSetorOrigem) {
        this.siglaSetorOrigem = siglaSetorOrigem;
    }
}
