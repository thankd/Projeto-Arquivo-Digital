/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Beans.Conexao;
import java.sql.*;
import java.util.Vector;
/**
 *
 * @author Thales
 */
public class sql {
    
    static public String executar(String sql){
        String manage = null;
        
        try {
            Conexao db = new Conexao();
            Connection cn = db.getConexao();
            
            if(cn == null){
                manage = "Não tem conexão";
            } else {
                Statement st = cn.createStatement();
                st.execute(sql);
                st.close();
                cn.close();
            }
        } catch(SQLException e){
            manage = e.getMessage();
        } catch(Exception e){
            manage = e.getMessage();
        }
        return manage;
    }
    
    
        static public Vector consulta(String sql) {
        Vector regs = new Vector();

        try	{
            Conexao 		db = new Conexao();
            Connection		cn = db.getConexao();

            if (cn == null) {
            	regs = null;
            } else {
	            Statement  		st = cn.createStatement();
	            ResultSet		rs = st.executeQuery(sql);
	            ResultSetMetaData	rm = rs.getMetaData();
	            int 		numCols = rm.getColumnCount();

	           
	            String[] titCols= new String[numCols];
	            for(int i=0; i<numCols; ++i)
	                titCols[i]= rm.getColumnName(i+1);

	            
	            regs.add(titCols);

	            
	            while(rs.next()) {
	                String[] reg= new String[numCols];

	                for(int i=0; i<numCols; i++) {
	                    reg[i] = rs.getString(i + 1);
	                }

	                regs.add(reg);
	            }

	            rs.close();
	            st.close();
	            cn.close();
            }

        } catch(SQLException e) {
            regs= null;
        } catch(Exception e) {
            regs= null;
        }

        return regs;
    }


    static public String[] getFila(String sql) {
        Vector vector = consulta(sql);
        String[] fila = null;

        if(vector!=null)				
            if(vector.size()>1)				
                fila = (String[]) vector.get(1);

        return fila;
    }


    static public String getCampo(String sql) {
        String[] fila = getFila(sql);
        String campo = null;

        if(fila!=null)		
            campo = fila[0];

        return campo;
    }
    
}
