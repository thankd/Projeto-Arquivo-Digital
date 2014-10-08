package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import Beans.Setor;
import DAO.TramiteDAO;
import java.sql.ResultSet;
import Beans.Conexao;

public final class MontarTramite_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head><style type=\"text/css\"> @import url(\"scripts/styleMaster.css\")all; </style>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("\t<title>Arquivo Digital | Montar Trâmite</title>\n");
      out.write("\t<link href=\"http://i.imgur.com/4TLP206.png\" rel=\"shortcut icon\"/>\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            var k = 1;\n");
      out.write("            var numSelecionados = 0;\n");
      out.write("            \n");
      out.write("            function validacao(){\n");
      out.write("                document.getElementById('erro2').style.display = 'none';\n");
      out.write("                var ret = true;\n");
      out.write("                \n");
      out.write("                if(numSelecionados == 0){\n");
      out.write("                    document.getElementById('erro2').style.display = '';\n");
      out.write("                    ret = false;\n");
      out.write("                }\n");
      out.write("                return ret;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function escolherSetor(){\n");
      out.write("                var selectSetor = document.getElementById(\"setores\");\n");
      out.write("                var selectedValue = selectSetor.options[selectSetor.selectedIndex].value;\n");
      out.write("               \n");
      out.write("               if(selectedValue != \"Selecionar\"){                    \n");
      out.write("                    document.getElementById(\"str\"+k).style.display = '';\n");
      out.write("                    document.getElementById(\"exc\"+k).style.display = '';\n");
      out.write("                    document.getElementById(\"br\"+k).style.display = '';\n");
      out.write("                    document.getElementById(\"str\"+k).value = selectedValue;\n");
      out.write("                    \n");
      out.write("                    numSelecionados++;    \n");
      out.write("                    k++;\n");
      out.write("                    \n");
      out.write("                    selectSetor.options.remove(selectSetor.selectedIndex);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function excluirSetor(num){\n");
      out.write("                var selectSetor = document.getElementById(\"setores\");\n");
      out.write("                var txtValue = document.getElementById(\"str\"+num).value; \n");
      out.write("                ");
      out.write("\n");
      out.write("                var txtOption = txtValue.substring(0, txtValue.indexOf(\"[\")-1); \n");
      out.write("                \n");
      out.write("                selectSetor.options[selectSetor.options.length] = new Option(txtOption, txtValue);\n");
      out.write("                                            \n");
      out.write("                var r = 0;\n");
      out.write("                r = parseInt(r);\n");
      out.write("                \n");
      out.write("                for (i = 1; i <= numSelecionados; i++){\n");
      out.write("                    if(i == num){\n");
      out.write("                        for (j = i; j <= numSelecionados; j++){\n");
      out.write("                            r = j +1; \n");
      out.write("                            document.getElementById(\"str\"+j).value = document.getElementById(\"str\"+r).value;\n");
      out.write("                        }\n");
      out.write("                        document.getElementById(\"str\"+numSelecionados).value = \"\";\n");
      out.write("                        document.getElementById(\"str\"+numSelecionados).style.display = 'none';\n");
      out.write("                        document.getElementById(\"exc\"+numSelecionados).style.display = 'none'; \n");
      out.write("                        document.getElementById(\"br\"+numSelecionados).style.display = 'none';\n");
      out.write("                        numSelecionados--;\n");
      out.write("                        k--;\n");
      out.write("                        document.getElementById(\"qts\").value = numSelecionados;\n");
      out.write("                    }\n");
      out.write("                }  \n");
      out.write("            }\n");
      out.write("         </script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
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
      out.write("\t\t <p id=\"equipe\"><a id=\"\" href=\"\">Meus dados</a> | <a id=\"sair_btn\" href=\"Sair.jsp\">Sair</a></p>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div>\n");
      out.write("                <div id=\"menu\" >\n");
      out.write("                    <h3>MENU</h3>\n");
      out.write("                    \n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"#\">Início</a></li> \n");
      out.write("                        <li><a href=\"#\">Novo Processo</a></li>\n");
      out.write("                        <li><a href=\"#\">Buscar Processo</a></li>  \n");
      out.write("                        <li><a href=\"#\">Processos Criados</a></li>\n");
      out.write("                        <li><a href=\"#\">Gerenciar Sistema</a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#\">Usuários</a></li>\n");
      out.write("                                <li><a href=\"#\">Setores</a></li>\n");
      out.write("                                <li><a href=\"#\">Trâmites</a></li>\n");
      out.write("                                <li><a href=\"#\">Arquivamento</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\t\t\t\t\t\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<div id=\"conteudo\">\n");
      out.write("                     <h3>Novo Tipo de Processo</h3>\n");
      out.write("                    <div class=\"textoConteudo\">\n");
      out.write("                        <form id=\"cadastroTipoProc\" name=\"cadastroTipoProc\" method=\"post\" action=\"GerenciarTramite?acao=AdicionarTramite\" onsubmit=\"return validacao();\">\n");
      out.write("                            <fieldset>\n");
      out.write("                                <legend>Processo</legend>\n");
      out.write("                                <label for=\"tipoProcesso\">Nome do tipo de processo:</label>\n");
      out.write("                                <input type=\"text\" name=\"tipoProcesso\" id=\"tipoProcesso\" style=\"font-size: 16px;\" required=\"\"/>\n");
      out.write("                            </fieldset>\n");
      out.write("                            <br/>\n");
      out.write("                            <fieldset>\n");
      out.write("                                <legend>Trâmite</legend>\n");
      out.write("                                \n");
      out.write("                                <label for=\"setores\">Setores:</label>\n");
      out.write("                                <select style=\"font-size: 16px;\" name=\"setores\" id=\"setores\" onchange=\"escolherSetor();\"> \n");
      out.write("                                    <option>Selecionar</option>\n");
      out.write("                                    ");
 
                                    TramiteDAO tramiteDAO = new TramiteDAO();
                                    List<Setor> setores = tramiteDAO.ListarSetores();
                                            for(Setor setor : setores){
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print(setor.getNomeSetor());
      out.write(' ');
      out.write('[');
      out.print(setor.getIdSetor());
      out.write("]\">");
      out.print(setor.getNomeSetor());
      out.write("  </option>\n");
      out.write("                                    ");
 } 
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                                <label style=\"display:none; color: red; font-size:10pt;\" id=\"erro2\">* selecione os setores.</label>\n");
      out.write("                                <br/><br/>\n");
      out.write("                                \n");
      out.write("                                <input type=\"button\" name=\"exc1\" id=\"exc1\" value=\"x\" style=\"font-size: 13px; display: none;\" onclick=\"excluirSetor(1);\"/>\n");
      out.write("                                <input type=\"text\" name=\"str1\" id=\"str1\" style=\"font-size: 14px; width: 320px; display: none;\"/><br id=\"br1\" style=\"display: none;\"/>\n");
      out.write("                                <input type=\"button\" name=\"exc2\" id=\"exc2\" value=\"x\" style=\"font-size: 13px; display: none;\" onclick=\"excluirSetor(2);\"/>\n");
      out.write("                                <input type=\"text\" name=\"str2\" id=\"str2\" style=\"font-size: 14px; width: 320px; display: none;\"/><br id=\"br2\" style=\"display: none;\"/>\n");
      out.write("                                <input type=\"button\" name=\"exc3\" id=\"exc3\" value=\"x\" style=\"font-size: 13px; display: none;\" onclick=\"excluirSetor(3);\"/>\n");
      out.write("                                <input type=\"text\" name=\"str3\" id=\"str3\" style=\"font-size: 14px; width: 320px; display: none;\"/><br id=\"br3\" style=\"display: none;\"/>\n");
      out.write("                                <input type=\"button\" name=\"exc4\" id=\"exc4\" value=\"x\" style=\"font-size: 13px; display: none;\" onclick=\"excluirSetor(4);\"/>\n");
      out.write("                                <input type=\"text\" name=\"str4\" id=\"str4\" style=\"font-size: 14px; width: 320px; display: none;\"/><br id=\"br4\" style=\"display: none;\"/>\n");
      out.write("                                <input type=\"button\" name=\"exc5\" id=\"exc5\" value=\"x\" style=\"font-size: 13px; display: none;\" onclick=\"excluirSetor(5);\"/>\n");
      out.write("                                <input type=\"text\" name=\"str5\" id=\"str5\" style=\"font-size: 14px; width: 320px; display: none;\"/><br id=\"br5\" style=\"display: none;\"/>\n");
      out.write("                                    \n");
      out.write("                                <input type=\"button\" name=\"exc6\" id=\"exc6\" value=\"x\" style=\"font-size: 13px; display: none;\" onclick=\"excluirSetor(6);\"/>\n");
      out.write("                                <input type=\"text\" name=\"str6\" id=\"str6\" style=\"font-size: 14px; width: 320px; display: none;\"/><br id=\"br6\" style=\"display: none;\"/>\n");
      out.write("                                <input type=\"button\" name=\"exc7\" id=\"exc7\" value=\"x\" style=\"font-size: 13px; display: none;\" onclick=\"excluirSetor(7);\"/>\n");
      out.write("                                <input type=\"text\" name=\"str7\" id=\"str7\" style=\"font-size: 14px; width: 320px; display: none;\"/><br id=\"br7\" style=\"display: none;\"/>\n");
      out.write("                                <input type=\"button\" name=\"exc8\" id=\"exc8\" value=\"x\" style=\"font-size: 13px; display: none;\" onclick=\"excluirSetor(8);\"/>\n");
      out.write("                                <input type=\"text\" name=\"str8\" id=\"str8\" style=\"font-size: 14px; width: 320px; display: none;\"/><br id=\"br8\" style=\"display: none;\"/>\n");
      out.write("                                <input type=\"button\" name=\"exc9\" id=\"exc9\" value=\"x\" style=\"font-size: 13px; display: none;\" onclick=\"excluirSetor(9);\"/>\n");
      out.write("                                <input type=\"text\" name=\"str9\" id=\"str9\" style=\"font-size: 14px; width: 320px; display: none;\"/><br id=\"br9\" style=\"display: none;\"/>\n");
      out.write("                                <input type=\"button\" name=\"exc10\" id=\"exc10\" value=\"x\" style=\"font-size: 13px; display: none;\" onclick=\"excluirSetor(10);\"/>\n");
      out.write("                                <input type=\"text\" name=\"str10\" id=\"str10\" style=\"font-size: 14px; width: 320px; display: none;\"/><br id=\"br10\" style=\"display: none;\"/>\n");
      out.write("                                    \n");
      out.write("                                <input type=\"button\" name=\"exc11\" id=\"exc11\" value=\"x\" style=\"font-size: 13px; display: none;\" onclick=\"excluirSetor(11);\"/>\n");
      out.write("                                <input type=\"text\" name=\"str11\" id=\"str11\" style=\"font-size: 14px; width: 320px; display: none;\"/><br id=\"br11\" style=\"display: none;\"/>\n");
      out.write("                                <input type=\"button\" name=\"exc12\" id=\"exc12\" value=\"x\" style=\"font-size: 13px; display: none;\" onclick=\"excluirSetor(12);\"/>\n");
      out.write("                                <input type=\"text\" name=\"str12\" id=\"str12\" style=\"font-size: 14px; width: 320px; display: none;\"/><br id=\"br12\" style=\"display: none;\"/>\n");
      out.write("                                <input type=\"button\" name=\"exc13\" id=\"exc13\" value=\"x\" style=\"font-size: 13px; display: none;\" onclick=\"excluirSetor(13);\"/>\n");
      out.write("                                <input type=\"text\" name=\"str13\" id=\"str13\" style=\"font-size: 14px; width: 320px; display: none;\"/><br id=\"br13\" style=\"display: none;\"/>\n");
      out.write("                                <input type=\"button\" name=\"exc14\" id=\"exc14\" value=\"x\" style=\"font-size: 13px; display: none;\" onclick=\"excluirSetor(14);\"/>\n");
      out.write("                                <input type=\"text\" name=\"str14\" id=\"str14\" style=\"font-size: 14px; width: 320px; display: none;\"/><br id=\"br14\" style=\"display: none;\"/>\n");
      out.write("                                <input type=\"button\" name=\"exc15\" id=\"exc15\" value=\"x\" style=\"font-size: 13px; display: none;\" onclick=\"excluirSetor(15);\"/>\n");
      out.write("                                <input type=\"text\" name=\"str15\" id=\"str15\" style=\"font-size: 14px; width: 320px; display: none;\"/><br id=\"br15\" style=\"display: none;\"/>                                                   \n");
      out.write("                            </fieldset>\n");
      out.write("                            \n");
      out.write("                            <input type=\"submit\" name=\"cadastrar\" id=\"cadastrar\" value=\"Cadastrar\"/>\n");
      out.write("                        </form>\n");
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
