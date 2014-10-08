package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Beans.Processo;
import DAO.BuscaProcessoDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");

   String id   = (String) session.getAttribute("id");
   String tipo = (String) session.getAttribute("tipo");
   String nome = (String) session.getAttribute("nome");
   
   if((id==null)||(tipo==null)){
       response.sendRedirect("NoSession.jsp");
   }

      out.write("\n");
      out.write("\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("\t<head><style type=\"text/css\"> @import url(\"scripts/styleMaster.css\")all; </style>\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("\t\t<title>Arquivo Digital | Início</title>\n");
      out.write("\t\t\t<link href=\"http://i.imgur.com/4TLP206.png\" rel=\"shortcut icon\"/>\n");
      out.write("\t\n");
      out.write("\t\t<script language=\"JavaScript\">\n");
      out.write("            // para implementar essa bagaça\n");
      out.write("            //function Iniciar_Sessao(){\n");
      out.write("            //    alert(=tipo%>);\n");
      out.write("            //}              \n");
      out.write("            </script>\n");
      out.write("          <style type=\"text/css\">\n");
      out.write("              #textoConteudo2 {\n");
      out.write("                  margin: 5px 5px 5px 5px;\n");
      out.write("\tbackground-color: #56a8b8;\n");
      out.write("\tpadding: 10px;\n");
      out.write("        \n");
      out.write("                  \n");
      out.write("              }\n");
      out.write("            .meusProc{\n");
      out.write("                border: 1px solid #56a8b8;\n");
      out.write("                padding-bottom: 10px;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                background-color: #56a8b8;\n");
      out.write("                padding-top: 20px;\n");
      out.write("            }\n");
      out.write("            .meusProc2{\n");
      out.write("                border: 1px solid #56a8b8;\n");
      out.write("                padding-left: 20px;\n");
      out.write("                padding-bottom: 10px;\n");
      out.write("                margin-left: 30px;\n");
      out.write("                margin-right: 30px;\n");
      out.write("                background-color: white;\n");
      out.write("            }\n");
      out.write("            .Proc{\n");
      out.write("                border: 3px solid black;\n");
      out.write("                border-radius: 6px;\n");
      out.write("                color: black;\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 16px;\n");
      out.write("                width: 150px;\n");
      out.write("                height: 150px;\n");
      out.write("                margin: auto;\n");
      out.write("                font-weight:bold;\n");
      out.write("            }\n");
      out.write("            .tb{\n");
      out.write("                border: none;\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("\n");
      out.write("a.procs:link, a.procs:visited {\n");
      out.write("\n");
      out.write("text-decoration: none;\n");
      out.write("color: black;\n");
      out.write("             \n");
      out.write("}\n");
      out.write("\n");
      out.write("a.procs:hover {\n");
      out.write("background-color: \"black\";\n");
      out.write("}\n");
      out.write("\n");
      out.write("a.procs:active {\n");
      out.write("\n");
      out.write("text-decoration: none;\n");
      out.write("color: white;\n");
      out.write("}\n");
      out.write("\n");
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
      out.write("\t\t\t\t\t<li><a href=\"Home.jsp\">Início</a></li>  \n");
      out.write("                              \n");
      out.write("\t\t\t\t\t<li><a href=\"novoProcesso.jsp\">Abrir Processo</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<li><a href=\"ProcessosCriados.jsp?tipoBusca=normal&txtBusca=\">Processos Criados</a></li>                  \n");
      out.write("\n");
      out.write("                                        <li><a id=\"gerenciar\" href=\"#\">Gerenciar Sistema</a>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"GerenciarUsuarios.jsp?string=&tipo_busca=normal\">Usuários</a></li>\n");
      out.write("                            \n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"Setor.jsp\">Setores</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"Tramites.jsp?tipoBusca=\">Trâmites</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"ProcessosArquivados.jsp?tipoBusca=normal&txtBusca=\">Arquivamento</a></li>\n");
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
      out.write("\t\t\t<div class=\"textoConteudo2\">\n");
      out.write("\t\t\t <a style=\" text-shadow: #000 2px 2px 1px;color: white; font-size: 15px; padding-left:55px; font-weight:bold;\">Bem vindo ao sistema integrado de gerenciamento de porcessos: Arquivo Digital.</a>\n");
      out.write("                         ");
      out.write("\n");
      out.write("                         <div class=\"meusProc\"><h3 style=\"font-size: 20px;\">Meus Processos</h3>\n");
      out.write("                             <div class=\"meusProc2\">\n");
      out.write("                                \n");
      out.write("                                            \n");
      out.write("                                ");

                                 BuscaProcessoDAO BProcessoDAO = new BuscaProcessoDAO();
                                 List<Processo> processos = BProcessoDAO.ListarMeusProcessos(id);
                                
      out.write("                                \n");
      out.write("                                <table class=\"tb\">\n");
      out.write("                                    <tr>\n");
      out.write("                                        ");

                                            int k = 0;
                                            for(int i = 0; i < processos.size(); i++){
                                              k++;
                                        
      out.write(" \n");
      out.write("                                        <td class=\"tb\">\n");
      out.write("                                            <div class=\"Proc\" onmouseover=\"this.style.border = '3px solid #56a8b8'\" onmouseout=\"this.style.border = '3px solid black';\">\n");
      out.write("                                                <a class=\"procs\" href=\"AcompanharProcessos.jsp?protocolo=");
      out.print(processos.get(i).getIdProcesso());
      out.write("&data=");
      out.print(processos.get(i).getDataAbertura());
      out.write("&interessado=");
      out.print(processos.get(i).getInteressado());
      out.write("&assunto=");
      out.print(processos.get(i).getAssunto());
      out.write("&idsetor=");
      out.print(processos.get(i).getIdSetor());
      out.write("&idstatual=");
      out.print(processos.get(i).getIdSetorAtual());
      out.write("&idtipo=");
      out.print(processos.get(i).getIdTipoProcesso());
      out.write("\">\n");
      out.write("                                                    <p>");
      out.print(processos.get(i).getIdProcesso());
      out.write("<br/><br/>");
      out.print(processos.get(i).getTipoProcesso());
      out.write("<br/><br/>");
      out.print(processos.get(i).getDataAbertura());
      out.write("</p>\n");
      out.write("                                                </a>\n");
      out.write("                                            </div> \n");
      out.write("                                        </td>\n");
      out.write("                                        ");

                                            if(k % 3 == 0){
                                         
      out.write("\n");
      out.write("                                         </tr><tr>\n");
      out.write("                                        ");
        
                                            }
                                          }
                                        
      out.write(" \n");
      out.write("                                        ");
      out.write("\n");
      out.write("                                    </tr>\n");
      out.write("                                </table>\n");
      out.write("                            </div>\n");
      out.write("\t\t\t</div>\n");
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
