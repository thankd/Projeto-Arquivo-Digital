/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thales
 */
public class Conexao {
        
              
    private String driver = "com.mysql.jdbc.Driver";
    private String uri = "jdbc:mysql://localhost:35/addb";
    private String login = "root";
    private String senha = "usbw";

    public Connection getConexao() throws InstantiationException {
        Connection cn = null;
        
        try{
            Class.forName(driver).newInstance();
            cn = DriverManager.getConnection(uri, login, senha);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            cn = null;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            cn = null;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            cn = null;
        }
        
        return cn;
    }
       
    
    
                   
}
