package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Beans.LinhaSetor;
import java.util.List;
import DAO.BuscaProcessoDAO;
import DAO.sql;

public final class AcompanharProcessos_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("    <head>\n");
      out.write("        <style type=\"text/css\"> @import url(\"scripts/styleMaster.css\")all; </style>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("\t<title>Arquivo Digital | Acompanhar Processo</title>\n");
      out.write("\t<link href=\"http://i.imgur.com/4TLP206.png\" rel=\"shortcut icon\"/>\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function ocultar(id){\n");
      out.write("                var x = document.getElementById(id);\n");
      out.write("                x.style.display = \"none\";\n");
      out.write("            }\n");
      out.write("            function exibir(id){\n");
      out.write("                var x = document.getElementById(id);\n");
      out.write("                x.style.display = \"block\";\n");
      out.write("            }\n");
      out.write("            function mudarConteudo(nomeSetor, siglaSetor, passouSetor){\n");
      out.write("                \n");
      out.write("                if(passouSetor == \"origem\"){\n");
      out.write("                    document.getElementById(\"divAcoes\").innerHTML = \"<br/>\" + nomeSetor + \"<br/>\"+ siglaSetor +\"<br/><br/>\" +\n");
      out.write("                    \"Processo criado neste Setor! <br/><br/>\" +\n");
      out.write("                    \"<a href='GerenciarTramite?acao=EnviarProcesso&protocolo=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.protocolo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&data=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.data}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&interessado=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.interessado}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&assunto=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.assunto}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&idsetor=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.idsetor}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&idstatual=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.idstatual}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&idtipo=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.idtipo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'>Enviar</a>\" +\n");
      out.write("                    \"<img src='imagens/tramitacao/oclt.jpg' class='oclt' onclick='apagarConteudo();'/>\";\n");
      out.write("                }else{\n");
      out.write("                     document.getElementById(\"divAcoes\").innerHTML = \"<br/>\" + nomeSetor + \"<br/>\"+ siglaSetor +\"<br/><br/>\" +\n");
      out.write("                    \"ACOES TOMANDAS NESTE SETOR<br/> Ação 1<br/>Ação 2<br/> Ação 3<br/><br/>\" +\n");
      out.write("                    \"<img src='imagens/tramitacao/oclt.jpg' class='oclt' onclick='apagarConteudo();'/>\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function apagarConteudo(){\n");
      out.write("                document.getElementById(\"divAcoes\").innerHTML = \"\";\n");
      out.write("            }\n");
      out.write("            function mudarNomeSetor(nome){\n");
      out.write("                document.getElementById(\"nomeSetor\").innerHTML = nome;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div id=\"c\">\n");
      out.write("            <div id=\"cabecalho\">\n");
      out.write("                <img src=\"imagens/logo.png\" id=\"adCabecalho\"/>\n");
      out.write("                <img src=\"imagens/logo_ifrn.png\" id=\"ifCabecalho\"/>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div id=\"descricao\">\n");
      out.write("                <p class=\"textoDescricao\">\n");
      out.write("                    <p id=\"hello\">");
      out.print( nome );
      out.write("</p>\n");
      out.write("                </p>\n");
      out.write("            \n");
      out.write("            <p id=\"equipe\"><a id=\"\" href=\"\">Meus dados</a> | <a id=\"sair_btn\" href=\"Sair.jsp\">Sair</a></p>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div>\n");
      out.write("                <div id=\"menu\" >\n");
      out.write("                    <h3>MENU</h3>\n");
      out.write("                    \n");
      out.write("                   <ul>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<li><a href=\"Home.jsp\">Início</a></li>  \n");
      out.write("                              \n");
      out.write("\t\t\t\t\t<li><a href=\"novoProcesso.jsp\">Abrir Processo</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<li><a href=\"ProcessosCriados.jsp?tipoBusca=normal&txtBusca=\">Processos Criados</a></li>                  \n");
      out.write("\n");
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
      out.write("                    <h3>Acompanhamento de Processo</h3>\n");
      out.write("                    <div class=\"textoConteudo\">\n");
      out.write("                        <p style=\"text-align: right;\"> Protocolo Nº: <input type=\"text\" style=\"border:none; color: #003399;\" name=\"protocolo\" id=\"protocolo\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.protocolo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly=\"readonly\"/></p>\n");
      out.write("                        <p>\n");
      out.write("                            Data: <input type=\"text\" style=\"border:none; color: #003399;\" name=\"data\" id=\"data\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.data}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly=\"readonly\"/><br/>\n");
      out.write("                            Interessado: <input type=\"text\" style=\"border:none; color: #003399;\" name=\"interessado\" id=\"interessado\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.interessado}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly=\"readonly\"/><br/>\n");
      out.write("                            Assunto: <input type=\"text\" style=\"border:none; color: #003399; width:670px;\" name=\"assunto\" id=\"assunto\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.assunto}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly=\"readonly\"/><br/>\n");
      out.write("                        </p>\n");
      out.write("                                \n");
      out.write("                        <p>\n");
      out.write("                        <fieldset>\n");
      out.write("                                <legend>TRAMITAÇÃO</legend>\n");
      out.write("                               \n");
      out.write("                                <div style=\"height: 20px;\">\n");
      out.write("                                    <div id=\"nomeSetor\" style=\"display:none; text-align: center;\">\n");
      out.write("                                        [NOME DO SETOR SELECIONADO]\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                \n");
      out.write("                                <p style=\"text-align: center;\"> \n");
      out.write("                                \n");
      out.write("                                ");

                                    BuscaProcessoDAO BProcessoDAO = new BuscaProcessoDAO();
                                    List<LinhaSetor> linhas = BProcessoDAO.ListarLinha(request.getParameter("protocolo"),request.getParameter("idsetor"),request.getParameter("idstatual"),request.getParameter("idtipo"));
                                
                               for (LinhaSetor linha : linhas){
                                    if(linha.getPassouSetor().equals("nao")){
                                
      out.write(" \n");
      out.write("                                 <img src=\"imagens/tramitacao/line2.gif\" class=\"tramit\"/>\n");
      out.write("                                <img src=\"imagens/tramitacao/not.gif\" class=\"tramit\" onmouseover=\"this.src='imagens/tramitacao/sel2.gif'; exibir('nomeSetor'); mudarNomeSetor('");
      out.print(linha.getNomeSetor());
      out.write("');\" onmouseout=\"this.src='imagens/tramitacao/not.gif'; ocultar('nomeSetor');\"/>\n");
      out.write("                                ");

                                }else if(linha.getPassouSetor().equals("origem")){
                                
      out.write("\n");
      out.write("                                <img src=\"imagens/tramitacao/yes.gif\" class=\"tramit\" \n");
      out.write("                                     onmouseover=\"this.src='imagens/tramitacao/sel1.gif'; exibir('nomeSetor'); mudarNomeSetor('");
      out.print(linha.getNomeSetor());
      out.write("');\"\n");
      out.write("                                     onmouseout=\"this.src='imagens/tramitacao/yes.gif'; ocultar('nomeSetor');\"\n");
      out.write("                                     onclick=\"mudarConteudo('");
      out.print(linha.getNomeSetor());
      out.write("', '");
      out.print(linha.getSiglaSetor());
      out.write("', '");
      out.print(linha.getPassouSetor());
      out.write("'); exibir('divAcoes');\"/>\n");
      out.write("                                ");

                                }else{
                                
      out.write(" \n");
      out.write("                                 <img src=\"imagens/tramitacao/line1.gif\" class=\"tramit\"/>\n");
      out.write("                                <img src=\"imagens/tramitacao/yes.gif\" class=\"tramit\" \n");
      out.write("                                     onmouseover=\"this.src='imagens/tramitacao/sel1.gif'; exibir('nomeSetor'); mudarNomeSetor('");
      out.print(linha.getNomeSetor());
      out.write("');\"\n");
      out.write("                                     onmouseout=\"this.src='imagens/tramitacao/yes.gif'; ocultar('nomeSetor');\"\n");
      out.write("                                     onclick=\"mudarConteudo('");
      out.print(linha.getNomeSetor());
      out.write("', '");
      out.print(linha.getSiglaSetor());
      out.write("', ''); exibir('divAcoes');\"/>\n");
      out.write("                                \n");
      out.write("                                ");

                                    }
                                }
                                
      out.write(" \n");
      out.write("                                </p>\n");
      out.write("                             \n");
      out.write("                                <div style=\"height: 300px;\">\n");
      out.write("                                    <div id=\"divAcoes\" style=\"width: 500px; margin: auto; text-align: center; border: 2px groove #003399;\">\n");
      out.write("                                    </div>  \n");
      out.write("                                </div>\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                <input type=\"hidden\" name=\"idsetor\" id=\"idsetor\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.idsetor}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly=\"readonly\"/>\n");
      out.write("                                <input type=\"hidden\" name=\"idstatual\" id=\"idstatual\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.idstatual}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly=\"readonly\"/>\n");
      out.write("                                <input type=\"hidden\" name=\"idtipo\" id=\"idtipo\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.idtipo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly=\"readonly\"/>\n");
      out.write("                                ");
      out.write("\n");
      out.write("                        </fieldset>\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("\t\t</div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div id=\"rodape\">\t\n");
      out.write("\t\t<p id=\"textoRodape\">\n");
      out.write("\t\tTodos os direitos reservados © \t<img src=\"imagens/layout/Neo 5.1.png\" id=\"neo\"/>\n");
      out.write("                 </p>\t\n");
      out.write("            </div>            \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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
