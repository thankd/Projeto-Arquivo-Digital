/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.BuscaProcessoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edivania
 */
@WebServlet(name = "BuscarProcesso", urlPatterns = {"/BuscarProcesso"})
public class BuscarProcesso {
     protected void service (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
            String n = request.getParameter("nome");
        }   
}
