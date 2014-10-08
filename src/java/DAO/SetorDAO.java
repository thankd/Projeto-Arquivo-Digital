package DAO;

    import Beans.Conexao;
    import Beans.Setor;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;
    import java.util.List;

    public class SetorDAO {
    
        private Connection con;
        
        public SetorDAO() throws InstantiationException{
            this.con = new Conexao().getConexao();
        }
        
        public void AdicionarSetor(Setor setor){
            String sql = "INSERT INTO setor (nome, sigla, chefe, telefone) VALUES (?, ?, ?, ?);";
        
              try{
                PreparedStatement stmt = con.prepareStatement(sql);
                
                stmt.setString(1, setor.getNome());
                stmt.setString(2, setor.getSigla());
                stmt.setString(3, setor.getChefe());
                stmt.setString(4, setor.getTelefone());
                
                stmt.execute();
                stmt.close();
                
                 }catch (SQLException e){
                    throw  new RuntimeException(e);
                }
              
            }

        public List<Setor> ListarSetores(){
                       
            try{
                List<Setor> setores = new ArrayList<Setor>();
                PreparedStatement stmt = this.con.prepareStatement("select * from setor");
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()){
                    Setor objsetor = new Setor();
                    objsetor.setIdSetor(rs.getInt("idSetor"));
                    objsetor.setNome(rs.getString("nome"));
                    objsetor.setSigla(rs.getString("sigla"));
                    objsetor.setChefe(rs.getString("chefe"));
                    objsetor.setTelefone(rs.getString("telefone"));
                    
                    setores.add(objsetor);
                }
                    rs.close();
                    stmt.close();
                    return setores;
                    
                    } catch(SQLException e) 
                            { throw new RuntimeException(e);}
        }
        
        public void ModificarSetor(Setor setor){
            String sql = "UPDATE setor SET nome = ?, sigla = ?, chefe = ?, telefone = ? WHERE idSetor =?";
        
            try{
                PreparedStatement stmt = this.con.prepareStatement(sql);
                
                
                stmt.setString(1, setor.getNome());
                stmt.setString(2, setor.getSigla());
                stmt.setString(3, setor.getChefe());
                stmt.setString(4, setor.getTelefone());
                stmt.setInt(5, setor.getIdSetor());
                
                 stmt.execute();       
                 stmt.close();            
            }catch(SQLException e) { 
                throw new RuntimeException(e); 
            }
            
        }
        
        public void ExcluirSetor(Setor setor){
            String sql = "DELETE FROM setor WHERE idSetor=?";
            
            try{
                PreparedStatement stmt = this.con.prepareStatement(sql);
                stmt.setInt(1, setor.getIdSetor());
                
                stmt.execute();
                stmt.close();
                
                
            }catch(SQLException e)
            { throw new RuntimeException(e); }
        
        }
        
    }        
                
      
        