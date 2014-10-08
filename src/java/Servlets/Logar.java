/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.sql;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thales
 */
@WebServlet(name = "Logar", urlPatterns = {"/Logar"})
public class Logar extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           //Recogemos variables que son enviadas desde Index.jsp
            String matricula = request.getParameter("matricula");
            String senha = request.getParameter("senha");

            //Realizamos acceso a base de Datos
            String [] dados=sql.getFila("SELECT idUsuario, tipoUsuario, nome, idSetor FROM usuario WHERE idUsuario='"+matricula+"' AND senha='"+senha+"'");

            if(dados==null){
                
                response.sendRedirect("Erro.jsp");

            }else{

                //Capturamos las variables a mostrar
                String id=dados[0];
                String tipo=dados[1];
                String nome=dados[2];
                String idSetor=dados[3];
                //creamos nuestra sesion
                HttpSession session = request.getSession(true);

                //Obtenemos los obejtos a guardar en session
                session.setAttribute("id", id);
                session.setAttribute("tipo", tipo);
                session.setAttribute("nome", nome);
                session.setAttribute("idSetor", idSetor);
                //pagina a donde se enviara si se encuentra el usuario autenticado
                response.sendRedirect("Home.jsp");
            }
        } finally { 
            out.close();
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
