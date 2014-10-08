<%-- 
    Document   : MontarTramiteConfirm
    Created on : 21/11/2013, 00:07:34
    Author     : Edivania
--%>

<%@page import="Beans.Tramite"%>
<%@page import="java.util.List"%>
<%@page import="DAO.TramiteDAO"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%

   String id   = (String) session.getAttribute("id");
   String tipo = (String) session.getAttribute("tipo");
   String nome = (String) session.getAttribute("nome");
   
   if((id==null)||(tipo==null)){
       response.sendRedirect("NoSession.jsp");
   }
   
   String tipob = "nometipo";
   String textob = "";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head><style type="text/css"> @import url("scripts/styleMaster.css")all; </style>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Arquivo Digital | Tipos de Processos</title>
			<link href="http://i.imgur.com/4TLP206.png" rel="shortcut icon"/>
	
		<script language="JavaScript">
            // para implementar essa bagaça
            //function Iniciar_Sessao(){
            //    alert(=tipo%>);
            //}              
            </script>
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
            #txtBusca{
                font-size: 12pt; 
            }
            .btn{
                font-size: 10pt;
            }
        </style>
</head>

   <body onload="//Iniciar_Sessao();">
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
                    <h3>Tipos de Processos</h3>
			<div class="textoConteudo">
                            <a href="MontarTramite.jsp" style="text-decoration: none;"><div id="btn_adicionar"> <h3><img src="imagens/add.png" width="30" height="28" /> Cadastrar</h3></a></div></br>
                             <%
                                 TramiteDAO tramiteDAO = new TramiteDAO();
                                 List<Tramite> tramites = tramiteDAO.ListarTramites(request.getParameter("tipoBusca"),request.getParameter("txtBusca"));
                            %>
                             <fieldset>
                                    <legend>Pesquisar</legend>
                                    <form method="get">
                                    <input type="text" name="txtBusca" id="txtBusca"/>                                    
                                    <select name="tipoBusca" id="tipoBusca">
                                        <option value="nometipo">Tipo de Processo</option>
                                    </select>
                                    <input type="submit" value="Buscar"/>
                                    </form>
                                </fieldset>
                                                                              
                            <p style="text-align: center;">
                                <center>
                                <table>
                                <tr id="trh">
                                     <th>Tipo de Processo</th>
                                        <th>Setores</th>
                                        <th colspan="">Gerenciamento</th>
                                </tr>
                                <%
                                   for(int i = 0; i < tramites.size(); i++){
                                %>                            
                                <tr>
                                        <td><%=tramites.get(i).getNomeTipoProcesso()%></td>
                                        <td><%=tramites.get(i).getSequencia()%></td>                                   
                                        <td><a href="GerenciarTramite?acao=ExcluirTramite&idTipoProcesso=<%=tramites.get(i).getIdTipoProcesso()%>&idTramitePadrao=<%=tramites.get(i).getIdTramitePadrao()%>"><img src='imagens/excluir.png' width='25px' height='25px'/></a></td>
                                </tr>
                                <%
                                   }
                                %> 
                                 </table>
                                 </center>
                            </p>
                        </div>
		</div>

	</div>

	<div id="rodape">
	  <p id="textoRodape">Todos os direitos reservados © <img src="imagens/layout/Neo 5.1.png" id="neo"/></p>
	</div>
</div>
</body>

</html>