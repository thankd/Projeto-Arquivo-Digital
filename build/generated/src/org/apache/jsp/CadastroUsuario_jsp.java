package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CadastroUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");

   String id   = (String) session.getAttribute("id");
   String tipo = (String) session.getAttribute("tipo");
   String nome = (String) session.getAttribute("nome");
   
   if((id==null)||(tipo==null)){
       response.sendRedirect("NoSession.jsp");
   }

      out.write("\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("\t<head><style type=\"text/css\"> @import url(\"scripts/styleMaster.css\")all; </style>\n");
      out.write("            <style type=\"text/css\"> \n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </style>\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("\t\t<title>Arquivo Digital | Início</title>\n");
      out.write("\t\t\t<link href=\"http://i.imgur.com/4TLP206.png\" rel=\"shortcut icon\"/>\n");
      out.write("                        \n");
      out.write("<style type=\"text/css\">\n");
      out.write("    #nomeU {\n");
      out.write("        margin-left: 27px;\n");
      out.write("        margin-top: 3px;\n");
      out.write("        \n");
      out.write("    }\n");
      out.write("    #senha {\n");
      out.write("        margin-left: 118px;\n");
      out.write("        margin-top: 3px;\n");
      out.write("    }\n");
      out.write("    #idSetor{\n");
      out.write("        margin-left: 125px;\n");
      out.write("        margin-top: 3px;\n");
      out.write("        \n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    #idTipoUsuario{\n");
      out.write("        margin-left: 39px;\n");
      out.write("        margin-top: 3px;\n");
      out.write("       \n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    #email{\n");
      out.write("        margin-left: 123px;\n");
      out.write("        margin-top: 3px;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    #telefone{\n");
      out.write("        margin-left: 99px;\n");
      out.write("        margin-top: 3px;\n");
      out.write("        \n");
      out.write("    }\n");
      out.write("    #concluir {\n");
      out.write("        margin-top: 30px;\n");
      out.write("        \n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("\t</head>\n");
      out.write("\n");
      out.write("   <body>\n");
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
      out.write("\t\t</div>\n");
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
      out.write("                    \n");
      out.write("\t\t\t\t\t<li><a id=\"gerenciar\" href=\"#\">Gerenciar Sistema</a>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"GerenciarUsuarios.jsp?string=&tipo_busca=normal\">Usuários</a></li>\n");
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
      out.write("\t\t\t<div class=\"textoConteudo\">\n");
      out.write("                             <p>&nbsp;</p>\n");
      out.write("                             <p> Cadastro de Usuário </p>\n");
      out.write("\t\t\t  <form id=\"formC\" name=\"formC\">\n");
      out.write("\t\t\t  <label> Matrícula do Usuário: </label>\n");
      out.write("\t\t\t  <input type=\"text\" id=\"idUsuario\" name=\"idUsuario\"/> <br/>\n");
      out.write("\t\t\t  <label> Nome do Usuário:  </label>\n");
      out.write("\t\t\t  <input type=\"text\" id=\"nomeU\" name=\"nome\"/><br/>\n");
      out.write("\t\t\t  <label> Senha: </label>\n");
      out.write("\t\t\t  <input type=\"text\" id=\"senha\" name=\"senha\"/><br/>\n");
      out.write("\t\t\t  <label> Setor: </label>\n");
      out.write("                          <select name=\"idSetor\" id=\"idSetor\"> </select><br/>\n");
      out.write("\t\t\t  <label> Tipo de Usuário: </label>\n");
      out.write("                          <select name=\"idTipoUsuario\" id=\"idTipoUsuario\"> </select><br/>\n");
      out.write("\t\t\t  <label> Email: </label>\n");
      out.write("\t\t\t  <input type=\"text\" id=\"email\" name=\"email\"/><br/>\n");
      out.write("\t\t\t  <label> Telefone: </label>\n");
      out.write("\t\t\t  <input type=\"text\" id=\"telefone\" name=\"telefone\"/><br/>\n");
      out.write("                          <input type=\"submit\" id=\"concluir\" name=\"concluir\" value=\"Concluir Cadastro\"> <br/>\n");
      out.write("\t\t\t  \n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div id=\"rodape\">\n");
      out.write("\t\n");
      out.write("\t\t<p id=\"textoRodape\">\n");
      out.write("\t\tTodos os direitos reservados © \t<img src=\"imagens/layout/Neo 5.1.png\" id=\"neo\"/>\n");
      out.write("\t    </p>\n");
      out.write("\t\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("\n");
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
