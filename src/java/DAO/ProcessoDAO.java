package DAO;

import Beans.Conexao;
import Beans.Processo;
import Beans.Setor;
import Beans.TipoProcesso;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcessoDAO {
    
    private Connection con;
    
    public ProcessoDAO() throws InstantiationException{
        this.con = new Conexao().getConexao();
    }
    
    public void AdicionaProcesso(Processo processo){
        String sql = "INSERT INTO processo (IdUsuario, IdSetor, assunto, caminhoArquivo, dataAbertura, situacao, setorAtual, tipoprocesso) VALUES (?,?,?,?,?,?,?,?);";
        
        try{
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, Integer.toString(processo.getIdUsuario()));
            stmt.setString(2, Integer.toString(processo.getIdSetor()));
            stmt.setString(3, processo.getAssunto());
            stmt.setString(4, processo.getCaminhoArquivo());
            stmt.setString(5, processo.getDataAbertura());
            stmt.setString(6, processo.getSituacao());
            stmt.setString(7, processo.getSetorAtual());
            stmt.setString(8, processo.getTipoProcesso());
            
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
	public List<Processo> ListarProcesso(){
        String sql = "Select * FROM Processo";
        try{
            List<Processo> processos = new ArrayList<Processo>();
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Processo objProcesso = new Processo();
                objProcesso.setIdProcesso(rs.getInt("idProcesso"));
                objProcesso.setIdUsuario(rs.getInt("idSetor"));
                objProcesso.setIdSetor(rs.getInt("idSetor"));
                objProcesso.setAssunto(rs.getString("ssunto")); 
                objProcesso.setCaminhoArquivo(rs.getString("caminhoArquivo")); 
                objProcesso.setDataAbertura(rs.getString("dataAbertura"));  
                objProcesso.setSituacao(rs.getString("situacao")); 
                objProcesso.setSetorAtual(rs.getString("setorAtual")); 
                objProcesso.setTipoProcesso(rs.getString("tipoprocesso")); 
                
                processos.add(objProcesso);
            }       
            rs.close();
            stmt.close();
            return processos;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void EditarProcesso(Processo processo){
        String sql = "UPDATE processo SET idUsuario =?, idSetor=?, assunto=?, caminhoArquivo=?, dataAbertura=?, situacao=?, setorAtual=?, tipprocesso=? WHERE idProcesso =?";
        
        try{
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1, Integer.toString(processo.getIdUsuario()));
            stmt.setString(2, Integer.toString(processo.getIdSetor()));
            stmt.setString(3, processo.getAssunto());
            stmt.setString(4, processo.getCaminhoArquivo());
            stmt.setString(5, processo.getDataAbertura());
            stmt.setString(6, processo.getSituacao());
            stmt.setString(7, processo.getSetorAtual());
            stmt.setString(8, processo.getTipoProcesso());
            stmt.setString(9, Integer.toString(processo.getIdProcesso()));
            
            
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);            
        }
    }
    
    public void ExcluirProcesso(Processo processo){
        String sql = "DELETE FROM Processo WHERE idProcesso=?";
        
        try{
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, processo.getIdProcesso());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Setor> ListarSetores(){
        String sql = "Select IdSetor, nome FROM setor";
        try{
            List<Setor> setores = new ArrayList<Setor>();
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Setor objSetor = new Setor();
                objSetor.setIdSetor(rs.getInt("idSetor"));
                objSetor.setNomeSetor(rs.getString("nome"));
                
                setores.add(objSetor);
            }       
            rs.close();
            stmt.close();
            return setores;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
        public List<TipoProcesso> ListarTipoProcesso(){
        String sql = "Select idtipoprocesso, nome FROM tipoprocesso";
        try{
            List<TipoProcesso> tiposProcesso = new ArrayList<TipoProcesso>();
            java.sql.PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                TipoProcesso objtipoProcesso = new TipoProcesso();
                objtipoProcesso.setIdTipoProcesso(rs.getInt("idtipoprocesso"));
                objtipoProcesso.setNomeTipoProcesso(rs.getString("nome"));
                
                tiposProcesso.add(objtipoProcesso);
            }       
            rs.close();
            stmt.close();
            return tiposProcesso;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
