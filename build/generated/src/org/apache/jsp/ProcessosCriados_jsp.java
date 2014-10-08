package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Beans.Processo;
import java.util.List;
import DAO.BuscaProcessoDAO;
import javax.servlet.http.HttpServletRequest;

public final class ProcessosCriados_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

   String id   = (String) session.getAttribute("id");
   String tipo = (String) session.getAttribute("tipo");
   String nome = (String) session.getAttribute("nome");
   
   if((id==null)||(tipo==null)){
       response.sendRedirect("NoSession.jsp");
   }
   
   //HttpServletRequest realRequest = PortalUtil.getHttpServletRequest(request);
   
String tipob = "normal";
String textob = "";

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head><style type=\"text/css\"> @import url(\"scripts/styleMaster.css\")all; </style>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Arquivo Digital | Processos Criados</title>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("           th{\n");
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
      out.write("                background-color: #CCCCCC;\n");
      out.write("            }\n");
      out.write("            select{\n");
      out.write("                margin-left: 1px;\n");
      out.write("                font-size: 12pt;\n");
      out.write("            }\n");
      out.write("            .btn{\n");
      out.write("                font-size: 10pt;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("          \n");
      out.write("        </script>\n");
      out.write("    \n");
      out.write("    </head>\n");
      out.write("        <body>\n");
      out.write("            <div id=\"c\">\n");
      out.write("           <div id=\"cabecalho\">\n");
      out.write("                <img src=\"imagens/logo.png\" id=\"adCabecalho\"/>\n");
      out.write("                <img src=\"imagens/logo_ifrn.png\" id=\"ifCabecalho\"/>\n");
      out.write("           </div>\n");
      out.write("\n");
      out.write("           <div id=\"descricao\">\n");
      out.write("                <p class=\"textoDescricao\">\n");
      out.write("                  <p id=\"hello\">");
      out.print( nome );
      out.write("</p>\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("                <p id=\"equipe\"><a id=\"\" href=\"\">Meus dados</a> | <a id=\"sair_btn\" href=\"Sair.jsp\">Sair</a></p>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("\n");
      out.write("                    <div id=\"menu\" >\n");
      out.write("\n");
      out.write("                        <h3>MENU</h3>\n");
      out.write("\n");
      out.write("                            <ul>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<li><a href=\"Home.jsp\">Início</a></li>  \n");
      out.write("                              \n");
      out.write("\t\t\t\t\t<li><a href=\"novoProcesso.jsp\">Enviar Processo</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<li><a href=\"ProcessosCriados.jsp?tipoBusca=normal&txtBusca=\">Processos Criados</a></li>                  \n");
      out.write("\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">-----------------</a></li>\n");
      out.write("                    \n");
      out.write("\t\t\t\t\t<li><a id=\"gerenciar\" href=\"#\">Gerenciar Sistema</a>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"GerenciarUsuarios.jsp?string=&tipo_busca=nome\">Usuários</a></li>\n");
      out.write("                            \n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"Setor.jsp\">Setores</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"Tramites.jsp?tipoBusca=\">Trâmites</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Arquivamento</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div id=\"conteudo\">\n");
      out.write("                        <h3>Processos Criados</h3>\n");
      out.write("                        <div class=\"textoConteudo\">\n");
      out.write("                             ");

                                 BuscaProcessoDAO BProcessoDAO = new BuscaProcessoDAO();
                                 List<Processo> processos = BProcessoDAO.ListarProcessos(request.getParameter("tipoBusca"),request.getParameter("txtBusca"));
                            
      out.write("\n");
      out.write("                            \n");
      out.write("                                <fieldset>\n");
      out.write("                                    <legend>Pesquisar</legend>\n");
      out.write("                                    <form method=\"get\">\n");
      out.write("                                    <input type=\"text\" name=\"txtBusca\" id=\"txtBusca\"/>                                    \n");
      out.write("                                    <select name=\"tipoBusca\" id=\"tipoBusca\">\n");
      out.write("                                        <option value=\"normal\"> Tudo </option>\n");
      out.write("                                        <option value=\"processo.idProcesso\">Protocolo</option>\n");
      out.write("                                        <option value=\"usuario.nome\">Interessado</option>\n");
      out.write("                                        <option value=\"setor.sigla\">Setor Atual</option>\n");
      out.write("                                        <option value=\"processo.dataAbertura\">Data</option>\n");
      out.write("                                    </select>\n");
      out.write("                                    <input type=\"submit\" value=\"Buscar\"/>\n");
      out.write("                                    </form>\n");
      out.write("                                </fieldset>\n");
      out.write("                                <br/>\n");
      out.write("                            \n");
      out.write("                           \n");
      out.write("                            <table>\n");
      out.write("                            <tr>\n");
      out.write("                                 <th>Nº Protocolo</th>\n");
      out.write("                                    <th>Interessado</th>\n");
      out.write("                                    <th>Setor Atual</th>\n");
      out.write("                                    <th>Data de Criação</th>\n");
      out.write("                                    <th colspan=\"3\">Gerenciamento</th>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                               for(int i = 0; i < processos.size(); i++){
                                   if(i%2 == 0){
                            
      out.write("                            \n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(processos.get(i).getIdProcesso());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(processos.get(i).getInteressado());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(processos.get(i).getSiglaSetorAtual());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(processos.get(i).getDataAbertura());
      out.write("</td>\n");
      out.write("                                    <td><a href=\"AcompanharProcessos.jsp?protocolo=");
      out.print(processos.get(i).getIdProcesso());
      out.write("&data=");
      out.print(processos.get(i).getDataAbertura());
      out.write("&interessado=");
      out.print(processos.get(i).getInteressado());
      out.write("&assunto=");
      out.print(processos.get(i).getAssunto());
      out.write("\"><input type=\"button\" class=\"btn\" name=\"detalhar\" id=\"detalhar");
      out.print(i);
      out.write("\" value=\"Ver Detalhes\"/></a></td>\n");
      out.write("                                    <td><a href=\"\"><input type=\"button\" class=\"btn\" name=\"editar\" id=\"editar");
      out.print(i);
      out.write("\" value=\"Editar\"/></a></td>\n");
      out.write("                                    <td><a href=\"\"><input type=\"button\" class=\"btn\" name=\"remover\" id=\"remover");
      out.print(i);
      out.write("\" value=\"Remover\"/></a></td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                                   }else{
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(processos.get(i).getIdProcesso());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(processos.get(i).getInteressado());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(processos.get(i).getSiglaSetorAtual());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(processos.get(i).getDataAbertura());
      out.write("</td>\n");
      out.write("                                    <td><a href=\"AcompanharProcessos.jsp?protocolo=");
      out.print(processos.get(i).getIdProcesso());
      out.write("&data=");
      out.print(processos.get(i).getDataAbertura());
      out.write("&interessado=");
      out.print(processos.get(i).getInteressado());
      out.write("&assunto=");
      out.print(processos.get(i).getAssunto());
      out.write("\"><input type=\"button\" class=\"btn\" name=\"detalhar\" id=\"detalhar");
      out.print(i);
      out.write("\" value=\"Ver Detalhes\"/></a></td>\n");
      out.write("                                    <td><a href=\"\"><input type=\"button\" class=\"btn\" name=\"editar\" id=\"editar");
      out.print(i);
      out.write("\" value=\"Editar\"/></a></td>\n");
      out.write("                                    <td><a href=\"\"><input type=\"button\" class=\"btn\" name=\"remover\" id=\"remover");
      out.print(i);
      out.write("\" value=\"Remover\"/></a></td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                                   }
                               }
                            
      out.write(" \n");
      out.write("                             </table>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"rodape\">\n");
      out.write("\n");
      out.write("                    <p id=\"textoRodape\">\n");
      out.write("                    Todos os direitos reservados © \t<img src=\"imagens/layout/Neo 5.1.png\" id=\"neo\"/>\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("    </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
