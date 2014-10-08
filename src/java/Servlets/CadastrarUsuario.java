/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Usuario;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Thales
 */
@WebServlet (name = "CadastrarUsuario", urlPatterns = {"/CadastrarUsuario"})
public class CadastrarUsuario extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            UsuarioDAO usuarioDAO = null;
            try {
                 usuarioDAO = new UsuarioDAO();
                 String action = request.getParameter("action");
            
            if(action.equals("Adicionar")){
            Usuario usuario = new Usuario();
            System.out.println(request.getParameter("matricula"));
            int idUsuario = Integer.parseInt(request.getParameter("matricula"));
            int idSetor = Integer.parseInt(request.getParameter("setor"));
            String nome = request.getParameter("nome");
            String senha = request.getParameter("senha");
            String tipo  = request.getParameter("tipo");
            String email  = request.getParameter("email");
            String telefone  = request.getParameter("telefone");
            
            usuario.setIdUsuario(idUsuario);
            usuario.setIdSetor(idSetor);
            usuario.setNome(nome);
            usuario.setSenha(senha);
            usuario.setTipoUsuario(tipo);
            usuario.setEmail(email);
            usuario.setCelular(telefone);
            
            usuarioDAO.AdicionarUsuario(usuario);
            response.sendRedirect(request.getContextPath() + "/GerenciarUsuarios.jsp?string=&tipo_busca=normal");
            
            } else if(action.equals("delete")){
                    int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(idUsuario);
                    
                    usuarioDAO.ExcluirUsuario(usuario);
                    response.sendRedirect(request.getContextPath() + "/GerenciarUsuarios.jsp?string=&tipo_busca=normal");
                } else if(action.equals("Editar")){
                    
            Usuario usuario = new Usuario();
            
            String idEdit = request.getParameter("idEdit");
            int idUsuario = Integer.parseInt(request.getParameter("matricula"));
            int idSetor = Integer.parseInt(request.getParameter("setor"));
            String nome = request.getParameter("nome");
            String tipo  = request.getParameter("tipo");
            String email  = request.getParameter("email");
            String telefone  = request.getParameter("telefone");
            
            usuario.setIdUsuario(idUsuario);
            usuario.setIdSetor(idSetor);
            usuario.setNome(nome);
            usuario.setTipoUsuario(tipo);
            usuario.setEmail(email);
            usuario.setCelular(telefone);
            
            usuarioDAO.EditarUsuario(usuario, idEdit);
            response.sendRedirect(request.getContextPath() + "/GerenciarUsuarios.jsp?string=&tipo_busca=normal");
                }
                 
            } catch (InstantiationException ex) {
                Logger.getLogger(GerenciarProcesso.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    
    
            
            }

