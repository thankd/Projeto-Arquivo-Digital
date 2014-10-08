package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Beans.Tramite;
import java.util.List;
import DAO.TramiteDAO;
import javax.servlet.http.HttpServletRequest;

public final class Tramites_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");


   String id   = (String) session.getAttribute("id");
   String tipo = (String) session.getAttribute("tipo");
   String nome = (String) session.getAttribute("nome");
   
   if((id==null)||(tipo==null)){
       response.sendRedirect("NoSession.jsp");
   }
   
   String tipob = "nometipo";
   String textob = "";

      out.write("\n");
      out.write("\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("\t<head><style type=\"text/css\"> @import url(\"scripts/styleMaster.css\")all; </style>\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("\t\t<title>Arquivo Digital | Tipos de Processos</title>\n");
      out.write("\t\t\t<link href=\"http://i.imgur.com/4TLP206.png\" rel=\"shortcut icon\"/>\n");
      out.write("\t\n");
      out.write("\t\t<script language=\"JavaScript\">\n");
      out.write("            // para implementar essa bagaça\n");
      out.write("            //function Iniciar_Sessao(){\n");
      out.write("            //    alert(=tipo%>);\n");
      out.write("            //}              \n");
      out.write("            </script>\n");
      out.write("            <style type=\"text/css\">\n");
      out.write("            #trh{\n");
      out.write("                background: #56A8B8;    \n");
      out.write("            }\n");
      out.write("            #trd1{\n");
      out.write("                background: #BBBBBB;    \n");
      out.write("            }\n");
      out.write("            #trd2{\n");
      out.write("                background: #CCCCCC;    \n");
      out.write("            }\n");
      out.write("            th{\n");
      out.write("                padding: 5px;\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 12pt;\n");
      out.write("                alignment-adjust: middle;\n");
      out.write("                font-style: oblique;\n");
      out.write("            }\n");
      out.write("            td{\n");
      out.write("                padding: 5px;\n");
      out.write("                text-align: justify;\n");
      out.write("                font-size: 10pt;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            #txtBusca{\n");
      out.write("                font-size: 12pt; \n");
      out.write("            }\n");
      out.write("            .btn{\n");
      out.write("                font-size: 10pt;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("   <body onload=\"//Iniciar_Sessao();\">\n");
      out.write("<div id=\"c\">\n");
      out.write("       <div id=\"cabecalho\">\n");
      out.write("\t\t\t<img src=\"imagens/logo.png\" id=\"adCabecalho\"/>\n");
      out.write("            <img src=\"imagens/logo_ifrn.png\" id=\"ifCabecalho\"/>\n");
      out.write("       </div>\n");
      out.write("\n");
      out.write("       <div id=\"descricao\">\n");
      out.write("\n");
      out.write("        <p class=\"textoDescricao\">\n");
      out.write("           <p id=\"hello\">");
      out.print( nome );
      out.write("</p>\n");
      out.write("        </p>\n");
      out.write("            \n");
      out.write("            <p id=\"equipe\"><a id=\"\" href=\"\">Meus dados</a> | <a id=\"sair_btn\" href=\"Sair.jsp\">Sair</a></p>\n");
      out.write("       \n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t\t<div>\n");
      out.write("\n");
      out.write("\t\t<div id=\"menu\" >\n");
      out.write("\n");
      out.write("\t\t\t<h3>MENU</h3>\n");
      out.write("\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Início</a></li>  \n");
      out.write("                              \n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Novo Processo</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Buscar Processo</a></li>                  \n");
      out.write("\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Processos Criados</a></li>\n");
      out.write("                    \n");
      out.write("\t\t\t\t\t<li><a id=\"gerenciar\" href=\"#\">Gerenciar Sistema</a>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Usuários</a></li>\n");
      out.write("                            \n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Setores</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Trâmites</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Arquivamento</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<div id=\"conteudo\">\n");
      out.write("                    <h3>Tipos de Processos</h3>\n");
      out.write("\t\t\t<div class=\"textoConteudo\">\n");
      out.write("\t\t\t \n");
      out.write("                             ");

                                 TramiteDAO tramiteDAO = new TramiteDAO();
                                 List<Tramite> tramites = tramiteDAO.ListarTramites(request.getParameter("tipoBusca"),request.getParameter("txtBusca"));
                            
      out.write("\n");
      out.write("                             <fieldset>\n");
      out.write("                                    <legend>Pesquisar</legend>\n");
      out.write("                                    <form method=\"get\">\n");
      out.write("                                    <input type=\"text\" name=\"txtBusca\" id=\"txtBusca\"/>                                    \n");
      out.write("                                    <select name=\"tipoBusca\" id=\"tipoBusca\">\n");
      out.write("                                        <option value=\"nometipo\">Tipo de Processo</option>\n");
      out.write("                                    </select>\n");
      out.write("                                    <input type=\"submit\" value=\"Buscar\"/>\n");
      out.write("                                    </form>\n");
      out.write("                                </fieldset>\n");
      out.write("                             \n");
      out.write("                            <p style=\"text-align: right;\"><a href=\"MontarTramite.jsp\"><input type=\"button\" name=\"novo\" id=\"novo\" value=\"Cadastrar Novo\"/></a></p>  \n");
      out.write("                          \n");
      out.write("                            <input type=\"text\" style=\"border:none; color: #003399; width:300px; font-size: 14px;\" name=\"sucesso\" id=\"sucesso\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.sucesso}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly=\"readonly\"/><br/>\n");
      out.write("                        \n");
      out.write("                            <p style=\"text-align: center;\">\n");
      out.write("                                <center>\n");
      out.write("                                <table>\n");
      out.write("                                <tr id=\"trh\">\n");
      out.write("                                     <th>Tipo de Processo</th>\n");
      out.write("                                        <th>Setores</th>\n");
      out.write("                                        <th colspan=\"\">Gerenciamento</th>\n");
      out.write("                                </tr>\n");
      out.write("                                ");

                                   for(int i = 0; i < tramites.size(); i++){
                                       if(i%2 == 0){
                                
      out.write("                            \n");
      out.write("                                <tr id=\"trd1\">\n");
      out.write("                                        <td>");
      out.print(tramites.get(i).getNomeTipoProcesso());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(tramites.get(i).getSequencia());
      out.write("</td>                                   \n");
      out.write("                                        <td><a href=\"GerenciarTramite?acao=ExcluirTramite&idTipoProcesso=");
      out.print(tramites.get(i).getIdTipoProcesso());
      out.write("&idTramitePadrao=");
      out.print(tramites.get(i).getIdTramitePadrao());
      out.write("\"><input type=\"button\" class=\"btn\" name=\"remover\" id=\"remover");
      out.print(i);
      out.write("\" value=\"Remover\"/></a></td>\n");
      out.write("                                </tr>\n");
      out.write("                                ");

                                       }else{
                                
      out.write("\n");
      out.write("                                <tr id=\"trd2\">\n");
      out.write("                                        <td>");
      out.print(tramites.get(i).getNomeTipoProcesso());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(tramites.get(i).getSequencia());
      out.write("</td>                                   \n");
      out.write("                                        <td><a href=\"GerenciarTramite?acao=ExcluirTramite&idTipoProcesso=");
      out.print(tramites.get(i).getIdTipoProcesso());
      out.write("&idTramitePadrao=");
      out.print(tramites.get(i).getIdTramitePadrao());
      out.write("\"><input type=\"button\" class=\"btn\" name=\"remover\" id=\"remover");
      out.print(i);
      out.write("\" value=\"Remover\"/></a></td>\n");
      out.write("                                </tr>\n");
      out.write("                                ");

                                       }
                                   }
                                
      out.write(" \n");
      out.write("                                 </table>\n");
      out.write("                                 </center>\n");
      out.write("                            </p>\n");
      out.write("                        </div>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div id=\"rodape\">\n");
      out.write("\t  <p id=\"textoRodape\">Todos os direitos reservados © <img src=\"imagens/layout/Neo 5.1.png\" id=\"neo\"/></p>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
