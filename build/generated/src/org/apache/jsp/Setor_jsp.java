package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import Beans.Setor;
import DAO.SetorDAO;

public final class Setor_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=ISO-8859-1");
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
      out.write("                        <style type=\"text/css\">\n");
      out.write("                             th{\n");
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
      out.write("                            </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("   <body onload=\"//Iniciar_Sessao();\">             \n");
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
      out.write("\t\t\t\t\t\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<div id=\"conteudo\">\n");
      out.write("\t\t\t<div class=\"textoConteudo\"> \n");
      out.write("                            <form method=\"post\" action=\"AdicionarSetor?acao=AdicionarSetor\">\n");
      out.write("                                Nome: <input type=\"text\" id=\"nome\" name=\"nome\" /> <br/>\n");
      out.write("                                Sigla: <input type=\"text\"  id=\"sigla\" name=\"sigla\"/><br/>\n");
      out.write("                                Chefe: <input type=\"text\" id=\"chefe\" name=\"chefe\"/><br/>\n");
      out.write("                                Telefone: <input type=\"text\" id=\"telefone\" name=\"telefone\"/><br/>\n");
      out.write("                                \n");
      out.write("                                <input type=\"submit\" name=\"criar\" value=\"Adicionar\"/>\n");
      out.write("                                <input type=\"reset\" name=\"cancelar\" value=\"Cancelar\" />   \n");
      out.write("                                \n");
      out.write("                            </form>\n");
      out.write("\n");
      out.write("                            ");

                                SetorDAO setorDAO = new SetorDAO();
                                List<Setor> setores = setorDAO.ListarSetores();
                            
      out.write("    \n");
      out.write("                            \n");
      out.write("                            <table border=\"1px\">\n");
      out.write("                            <tr>\n");
      out.write("                                <th> Nome </th>\n");
      out.write("                                <th> Sigla </th>\n");
      out.write("                                <th> Chefe </th>\n");
      out.write("                                <th> Telefone </th>\n");
      out.write("                                <th colspan=\"2\"> Gerenciamento </th>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                            for (Setor setor : setores){
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print( setor.getNome() );
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( setor.getSigla());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( setor.getChefe() );
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( setor.getTelefone() );
      out.write("</td>\n");
      out.write("                                <td><a href=\"ModificarSetor.jsp?nome=");
      out.print( setor.getNome());
      out.write("&sigla=");
      out.print( setor.getSigla() );
      out.write("&chefe=");
      out.print( setor.getChefe() );
      out.write("&telefone=");
      out.print( setor.getTelefone());
      out.write("¨&idSetor=");
      out.print( setor.getIdSetor() );
      out.write("\">Editar</a></td>\n");
      out.write("                                <td><a href=\"AdicionarSetor?acao=ExcluirSetor&idSetor=");
      out.print( setor.getIdSetor() );
      out.write("\"> Excluir  </a></td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                            }
                            
      out.write("\n");
      out.write("                        </table>      \n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
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
