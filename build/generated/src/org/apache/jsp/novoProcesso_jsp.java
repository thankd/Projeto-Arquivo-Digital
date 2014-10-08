package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import Beans.TipoProcesso;
import java.util.List;
import Beans.Setor;
import DAO.ProcessoDAO;

public final class novoProcesso_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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

   String id   = (String) session.getAttribute("id");
   String tipo = (String) session.getAttribute("tipo");
   String nome = (String) session.getAttribute("nome");
   String setor =(String) session.getAttribute("idSetor");
   
   if((id==null)||(tipo==null)){
       response.sendRedirect("NoSession.jsp");
   }

      out.write("\n");
      out.write("\n");
      out.write("  \n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("\t<head>\n");
      out.write("                        \n");
      out.write("            <style type=\"text/css\"> @import url(\"scripts/styleMaster.css\")all; </style>\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("\t\t<title>Arquivo Digital | Abrir Processo</title>\n");
      out.write("\t\t\t<link href=\"http://i.imgur.com/4TLP206.png\" rel=\"shortcut icon\"/>\n");
      out.write("\t\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("#assunto {\n");
      out.write("\t\n");
      out.write("\tmargin-left: 91px;\n");
      out.write("}\n");
      out.write("#tipo {\n");
      out.write("\tmargin-left: 19px;\n");
      out.write("}\n");
      out.write("#file{\n");
      out.write("        margin-left: 83px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("        \n");
      out.write("        </head>\n");
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
      out.write("        \n");
      out.write("           <p class=\"textoDescricao\">\n");
      out.write("           <p id=\"hello\">");
      out.print( nome );
      out.write("</p>\n");
      out.write("        </p>\n");
      out.write("\t\t<p id=\"equipe\"><a id=\"\" href=\"\">Meus dados</a> | <a id=\"sair_btn\" href=\"Sair.jsp\">Sair</a></p>\n");
      out.write("       \n");
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
      out.write("\t\t\t\t\t<li><a href=\"novoProcesso.jsp\">Abrir Processo</a></li>\n");
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
      out.write("                     <h3>Abrir Processo</h3>\n");
      out.write("\t\t\t<div class=\"textoConteudo\">\n");
      out.write("\t\t\t                             \n");
      out.write("                            <form method=\"post\" enctype=\"multipart/form-data\" action=\"");
      out.print( request.getContextPath() );
      out.write("/GerenciarProcesso?id_user=");
      out.print( id );
      out.write("&setor=");
      out.print( setor );
      out.write("\" >\n");
      out.write("                                <p>\n");
      out.write("                             <!-- 0 -->     <label>Assunto:    </label>\n");
      out.write("                                    <input type=\"text\" name=\"assunto\" id=\"assunto\" required /> <br/>\n");
      out.write("\n");
      out.write("                             <!-- 1 -->    <label>Tipo de Processo:  </label>\n");
      out.write("                                    <select name=\"tipo\" id=\"tipo\" required>\n");
      out.write("                                        ");
 
                                        
                                            ProcessoDAO processoDAO = new ProcessoDAO();
                                            List<TipoProcesso> tiposProcesso = processoDAO.ListarTipoProcesso();
                                            for(TipoProcesso tipoProcesso : tiposProcesso){
                                                                                      
                                        
      out.write("\n");
      out.write("                                        <option value=\"");
      out.print(tipoProcesso.getIdTipoProcesso());
      out.write("\"> ");
      out.print(tipoProcesso.getNomeTipoProcesso());
      out.write("</option>\n");
      out.write("                                        ");
 } 
      out.write("\n");
      out.write("                                    </select> \n");
      out.write("                                  \n");
      out.write("                                  <br/>\n");
      out.write("                                \n");
      out.write("                                <!-- 2 -->  <label for=\"file\">Processo:</label>\n");
      out.write("                                    <input type=\"file\" name=\"file\" id=\"file\" required/> <br/>\n");
      out.write("                                 \n");
      out.write("                                 <input type=\"submit\" value=\"Enviar Processo\"/>\n");
      out.write("                                    <input type=\"reset\" value =\"Cancelar\" />\n");
      out.write("                                </p>\n");
      out.write("                              </form> \n");
      out.write("                            <p> \n");
      out.write("                            </p>\n");
      out.write("\n");
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
