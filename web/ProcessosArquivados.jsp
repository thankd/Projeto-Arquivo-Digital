<%-- 
    Document   : ProcessosAqruivados
    Created on : 03/12/2013, 15:35:10
    Author     : Edivania
--%>

<%@page import="Beans.Processo"%>
<%@page import="java.util.List"%>
<%@page import="DAO.BuscaProcessoDAO"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   String id   = (String) session.getAttribute("id");
   String tipo = (String) session.getAttribute("tipo");
   String nome = (String) session.getAttribute("nome");
   
   if((id==null)||(tipo==null)){
       response.sendRedirect("NoSession.jsp");
   }
   
   //HttpServletRequest realRequest = PortalUtil.getHttpServletRequest(request);
   
String tipob = "normal";
String textob = "";
%>
<html>
    <head><style type="text/css"> @import url("scripts/styleMaster.css")all; </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arquivo Digital | Processos Arquivados</title>
        <style type="text/css">
            th{
                text-align: center;
                font-size: 12pt;
                alignment-adjust: middle;
                font-style: oblique;
            }
            td{
                padding: 5px;
                text-align: justify;
                font-size: 10pt;
                text-align: center;
                background-color: #CCCCCC;
            }
            select{
                margin-left: 1px;
                font-size: 12pt;
            }
            .btn{
                font-size: 10pt;
            }
        </style>
        <script>
          
        </script>
    
    </head>
        <body>
            <div id="c">
           <div id="cabecalho">
                <img src="imagens/logo.png" id="adCabecalho"/>
                <img src="imagens/logo_ifrn.png" id="ifCabecalho"/>
           </div>

           <div id="descricao">
                <p class="textoDescricao">
                  <p id="hello"><%= nome %></p>
                </p>

                <p id="equipe"><a id="" href="">Meus dados</a> | <a id="sair_btn" href="Sair.jsp">Sair</a></p>
            </div>
            <div>

                    <div id="menu" >

                        <h3>MENU</h3>

                            <ul>

					<li><a href="Home.jsp">Início</a></li>  
                              
					<li><a href="novoProcesso.jsp">Abrir Processo</a></li>

					<li><a href="ProcessosCriados.jsp?tipoBusca=normal&txtBusca=">Processos Criados</a></li>                  

					<li><a id="gerenciar" href="#">Gerenciar Sistema</a>

						<ul>

							<li><a href="GerenciarUsuarios.jsp?string=&tipo_busca=normal">Usuários</a></li>
                            
							<li><a href="Setor.jsp">Setores</a></li>

							<li><a href="Tramites.jsp?tipoBusca=">Trâmites</a></li>

							<li><a href="ProcessosArquivados.jsp?tipoBusca=normal&txtBusca=">Arquivamento</a></li>

						</ul>

				</li>

				</ul>

                    </div>

                    <div id="conteudo">
                        <h3>Processos Arquivados</h3>
                        <div class="textoConteudo">
                             <%
                                 BuscaProcessoDAO BProcessoDAO = new BuscaProcessoDAO();
                                 List<Processo> processos = BProcessoDAO.ListarProcessosArquivados(request.getParameter("tipoBusca"),request.getParameter("txtBusca"));
                            %>
                            
                                <fieldset>
                                    <legend>Pesquisar</legend>
                                    <form method="get">
                                    <input type="text" name="txtBusca" id="txtBusca"/>                                    
                                    <select name="tipoBusca" id="tipoBusca">
                                        <option value="normal"> Todos </option>
                                        <option value="processo.idProcesso">Protocolo</option>
                                        <option value="usuario.nome">Interessado</option>
                                        <option value="setor.sigla">Setor</option>
                                        <option value="processo.dataAbertura">Data</option>
                                    </select>
                                    <input type="submit" value="Buscar"/>
                                    </form>
                                </fieldset>
                                <br/>
                           
                            <table border="1">
                            <tr>
                                 <th>Nº Protocolo</th>
                                    <th>Interessado</th>
                                    <th>Setor</th>
                                    <th>Data</th>
                                    <th colspan="3">Gerenciamento</th>
                            </tr>
                            <%
                               for (Processo processo : processos){
                            %>                            
                            <tr>
                                <td><%=processo.getIdProcesso()%></td>
                                    <td><%=processo.getInteressado()%></td>
                                    <td><%=processo.getSiglaSetorOrigem()%></td>
                                    <td><%=processo.getDataAbertura()%></td>
                                    <td><a href="AcompanharProcessos.jsp?protocolo=<%=processo.getIdProcesso()%>&data=<%=processo.getDataAbertura()%>&interessado=<%=processo.getInteressado()%>&assunto=<%=processo.getAssunto()%>&idsetor=<%=processo.getIdSetor()%>&idstatual=<%=processo.getIdSetorAtual()%>&idtipo=<%=processo.getIdTipoProcesso()%>"><img src='imagens/arq_info.png' width='25px' height='25px'/></a></td>
                                    <td><a href=""><img src='imagens/arq_editar.png' width='25px' height='25px' /></a></td>
                                    <td><a href=""><img src='imagens/arq_excluir.png' width='25px' height='25px'/></a></td>
                            </tr>
                            <%
                               }
                            %> 
                             </table>
                        </div>
                    </div>

            </div>

            <div id="rodape">

                    <p id="textoRodape">
                    Todos os direitos reservados © 	<img src="imagens/layout/Neo 5.1.png" id="neo"/>
                </p>

            </div>
    </div>
    </body>
</html>
