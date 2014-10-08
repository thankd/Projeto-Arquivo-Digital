/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.TipoProcesso;
import Beans.TramitePadrao;
import Beans.TramiteSetor;
import DAO.*;
import DAO.sql;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edivania
 */
@WebServlet(name = "GerenciarTramite", urlPatterns = {"/GerenciarTramite"})
public class GerenciarTramite extends HttpServlet {
    
   @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            TramiteDAO tramiteDAO = null;
            
            try {
                tramiteDAO = new TramiteDAO();
                String acao = request.getParameter("acao");
                if(acao.equals("AdicionarTramite")){
                    TipoProcesso tipoProcesso = new TipoProcesso();
                    TramitePadrao tramitePadrao = new TramitePadrao();
                    TramiteSetor tramiteSetor = new TramiteSetor();

                    //pegando os valores do form
                    String nomeProcesso = request.getParameter("tipoProcesso");
                    //setando atributos
                    tipoProcesso.setNomeTipoProcesso(nomeProcesso);
                    //inserindo os atributos no DAO
                    tramiteDAO.InserirTipoProcesso(tipoProcesso);

                    String idUltimoIdTipoProcesso = sql.getCampo("SELECT MAX(`idtipoprocesso`) FROM `tipoprocesso`;");
                    tramitePadrao.setIdTipoProcesso(Integer.parseInt(idUltimoIdTipoProcesso));
                    tramiteDAO.InserirTramitePadrao(tramitePadrao);


                    String idUltimoIdTramitePadrao = sql.getCampo("SELECT MAX(`idtramitepadrao`) FROM `tramitepadrao`;");

                    for (int i = 1; i <= 15; i++) {
                        if(request.getParameter("str"+i)!=""){
                            tramiteSetor.setIdTramitePadrao(Integer.parseInt(idUltimoIdTramitePadrao));

                            String txtValue = request.getParameter("str"+i);
                            txtValue = txtValue.substring(txtValue.indexOf("[")+1, txtValue.indexOf("]"));
                            int idSetor = Integer.parseInt(txtValue);

                            tramiteSetor.setIdSetor(idSetor);
                            tramiteSetor.setSequencia(i);

                            tramiteDAO.InserirTramiteSetor(tramiteSetor);                            
                        }
                    }

                    response.sendRedirect("Tramites.jsp?tipoBusca=");
                } else if(acao.equals("ExcluirTramite")){
                    int idTipoProcesso = Integer.parseInt(request.getParameter("idTipoProcesso"));
                    int idTramitePadrao = Integer.parseInt(request.getParameter("idTramitePadrao"));
                    
                    tramiteDAO.ExcluirTramite(idTipoProcesso, idTramitePadrao);
                    
                    response.sendRedirect("Tramites.jsp?tipoBusca=");
                } else if(acao.equals("EnviarProcesso")){
                    BuscaProcessoDAO buscarProcessoDAO = new BuscaProcessoDAO();
                    String protocolo = request.getParameter("protocolo");
                    String data = request.getParameter("data");
                    String interessado = request.getParameter("interessado");
                    String assunto = request.getParameter("assunto");
                    String idsetor = "1";
                    String idstatual = "1";
                    String idtipo = request.getParameter("idtipo");
                    
                    buscarProcessoDAO.EnviarParaPrimeiroSetor(protocolo);
                    
                    response.sendRedirect("AcompanharProcessos.jsp?protocolo="+protocolo+"&data="+data+"&interessado="+interessado+"&assunto="+assunto+"&idsetor="+idsetor+"&idstatual="+idstatual+"&idtipo="+idtipo+"");
                }
                
            } catch (InstantiationException ex) {
                Logger.getLogger(GerenciarTramite.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {            
           Logger.getLogger(GerenciarTramite.class.getName()).log(Level.SEVERE, null, ex);
       } finally {            
            out.close();
        }
   }
}
