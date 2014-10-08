/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Conexao;
import Beans.LinhaSetor;
import Beans.Processo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cleiton
 */
public class BuscaProcessoDAO {
private Connection con;
    
    public BuscaProcessoDAO() throws InstantiationException{
        this.con = new Conexao().getConexao();
    }
    
    public List<Processo> ListarProcessos(String tipob, String textob){
            
            String sql = "";
            
            if(tipob.equals("normal")){
                sql = "select processo.idProcesso, usuario.nome, setor.sigla, processo.assunto, processo.dataAbertura, processo.idSetor, processo.setorAtual, processo.tipoprocesso from processo inner join usuario on processo.idUsuario = usuario.idUsuario inner join setor on processo.idSetor = setor.idSetor;";
            } else {
                sql = "select processo.idProcesso,processo.setorAtual,setor.sigla,processo.dataAbertura,processo.assunto,usuario.nome, processo.idSetor, processo.setorAtual, processo.tipoprocesso from processo inner join usuario on (processo.idUsuario= usuario.idUsuario) inner join setor on (processo.idsetor= setor.idsetor) where "+ tipob +" like '%"+ textob +"%';";
            }
            
            try{
            List<Processo> processos = new ArrayList<Processo>();
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Processo processo = new Processo();
                processo.setIdProcesso(rs.getInt("processo.idProcesso"));
                processo.setInteressado(rs.getString("usuario.nome"));
                processo.setSiglaSetorOrigem(rs.getString("setor.sigla"));
                processo.setAssunto(rs.getString("processo.assunto"));
                processo.setDataAbertura(rs.getString("processo.dataAbertura"));
                
                processo.setIdSetor(rs.getInt("processo.idSetor"));
                processo.setIdSetorAtual(rs.getInt("processo.setorAtual"));
                processo.setIdTipoProcesso(rs.getInt("processo.tipoprocesso"));
                
                processos.add(processo);
            }       
            rs.close();
            stmt.close();
            return processos;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Processo> ListarProcessosArquivados(String tipob, String textob){
            
            String sql = "";
            
            if(tipob.equals("normal")){
                sql = "select processo.idProcesso, usuario.nome, setor.sigla, processo.assunto, processo.dataAbertura, processo.idSetor, processo.setorAtual, processo.tipoprocesso from processo inner join usuario on processo.idUsuario = usuario.idUsuario inner join setor on processo.idSetor = setor.idSetor WHERE processo.situacao = 'arquivado';";
            } else {
                sql = "select processo.idProcesso,processo.setorAtual,setor.sigla,processo.dataAbertura,processo.assunto,usuario.nome, processo.idSetor, processo.setorAtual, processo.tipoprocesso from processo inner join usuario on (processo.idUsuario= usuario.idUsuario) inner join setor on (processo.idsetor= setor.idsetor)  where processo.situacao = 'arquivado' and "+ tipob +" like '%"+ textob +"%';";
            }
            
            try{
            List<Processo> processos = new ArrayList<Processo>();
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Processo processo = new Processo();
                processo.setIdProcesso(rs.getInt("processo.idProcesso"));
                processo.setInteressado(rs.getString("usuario.nome"));
                processo.setSiglaSetorOrigem(rs.getString("setor.sigla"));
                processo.setAssunto(rs.getString("processo.assunto"));
                processo.setDataAbertura(rs.getString("processo.dataAbertura"));
                
                processo.setIdSetor(rs.getInt("processo.idSetor"));
                processo.setIdSetorAtual(rs.getInt("processo.setorAtual"));
                processo.setIdTipoProcesso(rs.getInt("processo.tipoprocesso"));
                
                processos.add(processo);
            }       
            rs.close();
            stmt.close();
            return processos;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Processo> ListarMeusProcessos(String idUsuario){
            
            String sql = "select processo.idProcesso, usuario.nome, processo.assunto, processo.dataAbertura, processo.idSetor, processo.setorAtual, processo.tipoprocesso, tipoprocesso.nome from processo inner join usuario on processo.idUsuario = usuario.idUsuario inner join tipoprocesso on processo.tipoprocesso = tipoprocesso.idtipoprocesso where processo.idUsuario = "+ idUsuario +";";
            
            try{
            List<Processo> processos = new ArrayList<Processo>();
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Processo processo = new Processo();
                processo.setIdProcesso(rs.getInt("processo.idProcesso"));
                processo.setDataAbertura(rs.getString("processo.dataAbertura"));
                processo.setTipoProcesso(rs.getString("tipoprocesso.nome"));
                
                processo.setInteressado(rs.getString("usuario.nome"));
                processo.setAssunto(rs.getString("processo.assunto"));
                
                processo.setIdSetor(rs.getInt("processo.idSetor"));
                processo.setIdSetorAtual(rs.getInt("processo.setorAtual"));
                processo.setIdTipoProcesso(rs.getInt("processo.tipoprocesso"));
                
                processos.add(processo);
            }       
            rs.close();
            stmt.close();
            return processos;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    
    public List<LinhaSetor> ListarLinha(String idProcesso, String idSetor, String idSetorAtual, String idTramite){
        String sql = "SELECT setor.nome, setor.sigla, setor.idSetor FROM tramitesetor INNER JOIN setor "
                + "ON tramitesetor.idsetor = setor.idSetor WHERE tramitesetor.idtramitepadrao = "+ idTramite +" "
                + "ORDER BY tramitesetor.sequencia ASC;";
        
        String sql1 = "SELECT nome, sigla FROM setor WHERE idSetor = "+ idSetor +";";
        
        try{
            List<LinhaSetor> linhas = new ArrayList<LinhaSetor>();
           LinhaSetor linha = null;
            
            //SQL1
           java.sql.PreparedStatement stmt1 = this.con.prepareStatement(sql1);
           ResultSet rs1 = stmt1.executeQuery();
            
             while(rs1.next()){
                linha = new LinhaSetor();
                linha.setNomeSetor(rs1.getString("nome"));
                linha.setSiglaSetor(rs1.getString("sigla"));
                linha.setPassouSetor("origem");
                linhas.add(linha);
            }
            ///////////////////////////////////////////
             
           int k = 0;
           //SQL 
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                linha = new LinhaSetor();
                k++;
                linha.setNomeSetor(rs.getString("setor.nome"));
                linha.setSiglaSetor(rs.getString("setor.sigla"));
                
                if(k < Integer.parseInt(idSetorAtual)){
                    linha.setPassouSetor("sim");
                } else if(k == Integer.parseInt(idSetorAtual)){
                    linha.setPassouSetor("aqui");
                } else {
                    linha.setPassouSetor("nao");
                }
                
                /*String sql3 = "SELECT acoes.nome FROM acoes INNER JOIN acaosetor ON acoes.idAcao = acaosetor.idacao "
                        + "WHERE acaosetor.idsetor = "+ rs.getString("setor.idSetor") +";";
                 //SQL3
                  java.sql.PreparedStatement stmt3 = this.con.prepareStatement(sql3);
                  ResultSet rs3 = stmt3.executeQuery();
                  List<String> acoesSetor = new ArrayList<String>();
                  while(rs3.next()){
                     String acao = rs3.getString("acoes.nome");
                     acoesSetor.add(acao);
                  }
                 /////////////////////////////////////////// 
                linha.setNomeAcoes(acoesSetor);*/
                        
                linhas.add(linha);
                //rs3.close();
                //stmt3.close();
            }       
            rs.close();
            stmt.close();
            ///////////////////////////////////////
            rs1.close();
            stmt1.close();
            return linhas;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
      public void EnviarParaPrimeiroSetor(String idProcesso) throws SQLException{
            String sql = "UPDATE processo SET setorAtual = '1' WHERE idProcesso ="+ idProcesso;
        
              try{
                PreparedStatement stmt = con.prepareStatement(sql);
               
                stmt.execute();
                stmt.close();
                
                 }catch (SQLException e){
                    throw  new RuntimeException(e);
                }
        }
    
}
