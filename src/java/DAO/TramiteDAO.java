/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Conexao;
import Beans.Setor;
import Beans.TipoProcesso;
import Beans.Tramite;
import Beans.TramitePadrao;
import Beans.TramiteSetor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edivania
 */
public class TramiteDAO {
    
    private Connection con;
    
    public TramiteDAO() throws InstantiationException{
        this.con = new Conexao().getConexao();
    }
    
    public void InserirTipoProcesso(TipoProcesso tipoProcesso){
        String sql = "INSERT INTO tipoprocesso(nome) VALUES (?)";
        
        try{
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, tipoProcesso.getNomeTipoProcesso());
            
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
     public void InserirTramitePadrao(TramitePadrao tramitePadrao){
        String sql = "INSERT INTO tramitepadrao(idtipoprocesso) VALUES (?);";
        
        try{
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, String.valueOf(tramitePadrao.getIdTipoProcesso()));
            
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
     
     public void InserirTramiteSetor(TramiteSetor tramiteSetor){
        String sql = "INSERT INTO tramitesetor(idtramitepadrao, idsetor, sequencia) VALUES (?, ?, ?)";
        
        try{
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, String.valueOf(tramiteSetor.getIdTramitePadrao()));
            stmt.setString(2, String.valueOf(tramiteSetor.getIdSetor()));
            stmt.setString(3, String.valueOf(tramiteSetor.getSequencia()));
            
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
     
        public List<Setor> ListarSetores(){
        String sql = "SELECT idSetor, nome, sigla FROM setor";
        try{
            List<Setor> setores = new ArrayList<Setor>();
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Setor objSetor = new Setor();
                objSetor.setIdSetor(rs.getInt("idSetor"));
                objSetor.setNomeSetor(rs.getString("nome"));
                objSetor.setSigla(rs.getString("sigla"));
                
                setores.add(objSetor);
            }       
            rs.close();
            stmt.close();
            return setores;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    } 
     
    public List<Tramite> ListarTramites(String tipob, String textob){
         String sql1 = "SELECT tipoprocesso.nome, tipoprocesso.idtipoprocesso, tramitepadrao.idtramitepadrao FROM tipoprocesso INNER JOIN tramitepadrao ON tipoprocesso.idtipoprocesso = tramitepadrao.idtipoprocesso;";
            
            if(tipob.equals("nometipo")){
                sql1 = "SELECT tipoprocesso.nome, tipoprocesso.idtipoprocesso, tramitepadrao.idtramitepadrao FROM tipoprocesso INNER JOIN tramitepadrao ON tipoprocesso.idtipoprocesso = tramitepadrao.idtipoprocesso WHERE tipoprocesso.nome LIKE '%"+ textob +"%';";
            }
                
        try{
            List<Tramite> tramites = new ArrayList<Tramite>();
            java.sql.PreparedStatement stmt1 = this.con.prepareStatement(sql1);
            ResultSet rs1 = stmt1.executeQuery();
            while(rs1.next()){
                Tramite tramite = new Tramite();
                String seq = "";
                tramite.setNomeTipoProcesso(rs1.getString("tipoprocesso.nome"));
                tramite.setIdTipoProcesso(rs1.getInt("tipoprocesso.idtipoprocesso"));
                tramite.setIdTramitePadrao(rs1.getInt("tramitepadrao.idtramitepadrao"));
                
                String sql2 = "";
                
                sql2 = "SELECT tramitesetor.idtramitepadrao, tramitesetor.idsetor, tramitesetor.sequencia, setor.sigla FROM tramitesetor INNER JOIN setor ON tramitesetor.idsetor = setor.idSetor  WHERE tramitesetor.idtramitepadrao = ? ORDER BY tramitesetor.sequencia ASC;";
                
                
                java.sql.PreparedStatement stmt2 = this.con.prepareStatement(sql2);
                stmt2.setString(1, String.valueOf(rs1.getString("tramitepadrao.idtramitepadrao")));
                ResultSet rs2= stmt2.executeQuery();
               
                while(rs2.next()){
                    seq += rs2.getString("setor.sigla") + " > ";
                }
                
                seq = seq.substring(0, seq.length() - 3);
                
                tramite.setSequencia(seq);
                
                tramites.add(tramite);
                 
                rs2.close();
                stmt2.close();
            }       
            
            rs1.close();           
            stmt1.close();            
            return tramites;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
     public void ExcluirTramite(int idTipoProcesso, int idTramitePadrao){
        String sql1 = "DELETE FROM tipoprocesso WHERE idtipoprocesso=?;";
        String sql2 = "DELETE FROM tramitepadrao WHERE idtramitepadrao=?;";
        String sql3 = "DELETE FROM tramitesetor WHERE idtramitepadrao=?;";
               
        try{
            java.sql.PreparedStatement stmt1 = this.con.prepareStatement(sql1);
            stmt1.setInt(1, idTipoProcesso);
            stmt1.execute();
            stmt1.close();
            java.sql.PreparedStatement stmt2 = this.con.prepareStatement(sql2);
            stmt2.setInt(1, idTramitePadrao);
            stmt2.execute();
            stmt2.close();
            java.sql.PreparedStatement stmt3 = this.con.prepareStatement(sql3);
            stmt3.setInt(1, idTramitePadrao);
            stmt3.execute();
            stmt3.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    // ------------- METODOS ABAIXOS NAO FORAM USADOS
    
     public List<TipoProcesso> ListarTipoProcesso(){
        String sql = "SELECT * FROM tipoprocesso";
        try{
            List<TipoProcesso> tipos = new ArrayList<TipoProcesso>();
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                TipoProcesso tipoProcesso = new TipoProcesso();
                tipoProcesso.setIdTipoProcesso(rs.getInt("idtipoprocesso"));
                tipoProcesso.setNomeTipoProcesso(rs.getString("nome"));
                
                
                tipos.add(tipoProcesso);
            }       
            rs.close();
            stmt.close();
            return tipos;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void EditarTipoProcesso(TipoProcesso novoTipoProcesso, int idAtual){
        String sql = "UPDATE tipoprocesso SET nome=? WHERE idtipoprocesso=?;";
        
        try{
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1, novoTipoProcesso.getNomeTipoProcesso());
            stmt.setString(2, String.valueOf(idAtual));
            
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);            
        }
    }
    
    public void ExcluirTipoProcesso(int idAtual){
        String sql = "DELETE FROM tipoprocesso WHERE idtipoprocesso=?;";
        
        try{
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, idAtual);
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void ExcluirTramitePadrao(int idAtual){
        String sql = "DELETE FROM tramitepadrao WHERE idtramitepadrao=?;";
        
        try{
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, idAtual);
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
       
        
    public List<TramitePadrao> ListarTramitePadrao(){
        String sql = "SELECT * FROM tramitepadrao";
        try{
            List<TramitePadrao> tramites = new ArrayList<TramitePadrao>();
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                TramitePadrao tramitePadrao = new TramitePadrao();
                tramitePadrao.setIdTipoProcesso(rs.getInt("idtipoprocesso"));
                tramitePadrao.setIdTramitePadrao(rs.getInt("idtipoprocesso"));
                
                
                tramites.add(tramitePadrao);
            }       
            rs.close();
            stmt.close();
            return tramites;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void EditarTramitePadrao(TramitePadrao novoTramitePadrao, int idAtual){
        String sql = "UPDATE tramitepadrao SET idtipoprocesso=? WHERE idtramitepadrao=?;";
        
        try{
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1, String.valueOf(novoTramitePadrao.getIdTipoProcesso()));
            stmt.setString(2, String.valueOf(idAtual));
            
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);            
        }
    }
    
    public List<TramiteSetor> ListarTramiteSetor(){
        String sql = "SELECT * FROM tramitesetor";
        try{
            List<TramiteSetor> tipos = new ArrayList<TramiteSetor>();
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                TramiteSetor tramiteSetor = new TramiteSetor();
                tramiteSetor.setIdTramitePadrao(rs.getInt("idtramitepadrao"));
                tramiteSetor.setIdSetor(rs.getInt("idsetor"));
                tramiteSetor.setSequencia(rs.getInt("sequencia"));
                
                tipos.add(tramiteSetor);
            }       
            rs.close();
            stmt.close();
            return tipos;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public String getSelectedSigla(int idSetor){
        String sql = "SELECT sigla FROM setor WHERE idSetor=?";
        try{
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            
            stmt.setString(1, String.valueOf(idSetor));      
            
            ResultSet rs = stmt.executeQuery();
            
            String sigla = rs.getString("sigla");
            
            stmt.close();
            return sigla;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}