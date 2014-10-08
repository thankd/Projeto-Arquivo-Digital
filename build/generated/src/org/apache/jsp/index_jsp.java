package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head><style type=\"text/css\"> @import url(\"scripts/styleMaster.css\")all; </style>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\t\t<title>Arquivo Digital | Efetuar Login</title>\r\n");
      out.write("\t\t\t<link href=\"http://i.imgur.com/4TLP206.png\" rel=\"shortcut icon\"/>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("   <body>\r\n");
      out.write("<div id=\"c\">\r\n");
      out.write("  \t\r\n");
      out.write("    \r\n");
      out.write("    <div id=\"logo_if_login\">\r\n");
      out.write("\t            <img src=\"imagens/logo_ifrn.png\" id=\"ifCabecalho\"/>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("\t<div id=\"login_bg_login\">\r\n");
      out.write("    \t\r\n");
      out.write("   \t  <div class=\"Conteudo_login\">\r\n");
      out.write("\t    <div class=\"logo_ad\"> \r\n");
      out.write("        <img src=\"imagens/logo.png\" id=\"adCabecalho_login\"/> \r\n");
      out.write("\t    </div>\r\n");
      out.write("        \t      <div id=\"linha\">            \r\n");
      out.write("                  <hr size=\"310\" width=\"1\" color=\"#56a8b8\" /> \t\r\n");
      out.write("                  </div>\r\n");
      out.write("        <div id=\"form_login\">\r\n");
      out.write("        \t<fieldset>\r\n");
      out.write("            <legend> Efetuar Login </legend>\r\n");
      out.write("            <form id=\"login\" method=\"post\" action=\"");
      out.print( request.getContextPath() + "/Logar" );
      out.write("\">\r\n");
      out.write("                    <label for=\"matricula\">Matrícula:</label>\r\n");
      out.write("                    <input name=\"matricula\" type=\"text\" required id=\"matricula\" style=\"text-align: center;\" size=\"15\" /> <br />\r\n");
      out.write("                    <label for=\"senha\">Senha:</label>\r\n");
      out.write("                    <input name=\"senha\" type=\"password\" required id=\"senha\" style=\"text-align: center;\" size=\"15\" /> <br />\r\n");
      out.write("                    <input type=\"submit\" value=\"Entrar\" id=\"btn_logar\"/>\r\n");
      out.write("                </form>\r\n");
      out.write("            </fieldset>\r\n");
      out.write("        </div>\r\n");
      out.write("\t  </div>\r\n");
      out.write("      \t\t<p id=\"textoRodape\">\r\n");
      out.write("\t\tTodos os direitos reservados © \t<img src=\"imagens/layout/Neo 5.1.png\" id=\"neo\"/>\r\n");
      out.write("\t    </p>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
