<%-- 
    Document   : AcompanharProcessos
    Created on : 15/11/2013, 16:58:35
    Author     : Edivania
--%>

<%@page import="Beans.LinhaSetor"%>
<%@page import="java.util.List"%>
<%@page import="DAO.BuscaProcessoDAO"%>
<%@page import="DAO.sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
   String id   = (String) session.getAttribute("id");
   String tipo = (String) session.getAttribute("tipo");
   String nome = (String) session.getAttribute("nome");
   
   if((id==null)||(tipo==null)){
       response.sendRedirect("NoSession.jsp");
   }
%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <style type="text/css"> @import url("scripts/styleMaster.css")all; </style>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Arquivo Digital | Acompanhar Processo</title>
	<link href="http://i.imgur.com/4TLP206.png" rel="shortcut icon"/>
        <style type="text/css">
            .btn_enviar {
                border-radius: 6px;
                border: 2px solid black;
                padding: 5px;
                background-color: white;
                text-decoration: none;
                padding-left: 25px;
                padding-right: 25px;
                color: black
            }
        </style>
        
        <script type="text/javascript">
            function ocultar(id){
                var x = document.getElementById(id);
                x.style.display = "none";
            }
            function exibir(id){
                var x = document.getElementById(id);
                x.style.display = "block";
            }
            function mudarConteudo(nomeSetor, siglaSetor, passouSetor){
                
                if(passouSetor == "origem"){
                    if(document.getElementById("idstatual").value == "0"){
            document.getElementById("divAcoes").innerHTML = "<br/>" + nomeSetor + "<br/>"+ siglaSetor +"<br/><br/>" +
                    "Processo criado neste Setor! <br/><br/>" +
                    "<a class='btn_enviar' href='GerenciarTramite?acao=EnviarProcesso&protocolo=${param.protocolo}&data=${param.data}&interessado=${param.interessado}&assunto=${param.assunto}&idsetor=${param.idsetor}&idstatual=${param.idstatual}&idtipo=${param.idtipo}'>Enviar</a>" +
                    "<br/> <br/><img src='imagens/tramitacao/oclt.jpg' class='oclt' onclick='apagarConteudo();'/>";
            }else{
              document.getElementById("divAcoes").innerHTML = "<br/>" + nomeSetor + "<br/>"+ siglaSetor +"<br/><br/>" +
                    "Processo criado neste Setor! <br/><br/>" +
                    "<br/> <br/><img src='imagens/tramitacao/oclt.jpg' class='oclt' onclick='apagarConteudo();'/>";
            }
                }else{
                     document.getElementById("divAcoes").innerHTML = "<br/>" + nomeSetor + "<br/>"+ siglaSetor +"<br/><br/>" +
                    "ACOES TOMANDAS NESTE SETOR<br/> Ação 1<br/>Ação 2<br/> Ação 3<br/><br/>" +
                    "<img src='imagens/tramitacao/oclt.jpg' class='oclt' onclick='apagarConteudo();'/>";
                }
            }
            function apagarConteudo(){
                document.getElementById("divAcoes").innerHTML = "";
            }
            function mudarNomeSetor(nome){
                document.getElementById("nomeSetor").innerHTML = nome;
            }
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
                    <h3>Acompanhamento de Processo</h3>
                    <div class="textoConteudo">
                        <p style="text-align: right;"> Protocolo Nº: <input type="text" style="border:none; color: #003399;" name="protocolo" id="protocolo" value="${param.protocolo}" readonly="readonly"/></p>
                        <p>
                            Data: <input type="text" style="border:none; color: #003399;" name="data" id="data" value="${param.data}" readonly="readonly"/><br/>
                            Interessado: <input type="text" style="border:none; color: #003399;" name="interessado" id="interessado" value="${param.interessado}" readonly="readonly"/><br/>
                            Assunto: <input type="text" style="border:none; color: #003399; width:670px;" name="assunto" id="assunto" value="${param.assunto}" readonly="readonly"/><br/>
                        </p>
                                
                        <p>
                        <fieldset>
                                <legend>TRAMITAÇÃO</legend>
                               
                                <div style="height: 20px;">
                                    <div id="nomeSetor" style="display:none; text-align: center;">
                                        [NOME DO SETOR SELECIONADO]
                                    </div>
                                </div>
                                
                                <p style="text-align: center;"> 
                                
                                <%
                                    BuscaProcessoDAO BProcessoDAO = new BuscaProcessoDAO();
                                    List<LinhaSetor> linhas = BProcessoDAO.ListarLinha(request.getParameter("protocolo"),request.getParameter("idsetor"),request.getParameter("idstatual"),request.getParameter("idtipo"));
                                
                               for (LinhaSetor linha : linhas){
                                    if(linha.getPassouSetor().equals("nao")){
                                %> 
                                 <img src="imagens/tramitacao/line2.gif" class="tramit"/>
                                <img src="imagens/tramitacao/not.gif" class="tramit" onmouseover="this.src='imagens/tramitacao/sel2.gif'; exibir('nomeSetor'); mudarNomeSetor('<%=linha.getNomeSetor()%>');" onmouseout="this.src='imagens/tramitacao/not.gif'; ocultar('nomeSetor');"/>
                                <%
                                }else if(linha.getPassouSetor().equals("origem")){
                                %>
                                <img src="imagens/tramitacao/yes.gif" class="tramit" 
                                     onmouseover="this.src='imagens/tramitacao/sel1.gif'; exibir('nomeSetor'); mudarNomeSetor('<%=linha.getNomeSetor()%>');"
                                     onmouseout="this.src='imagens/tramitacao/yes.gif'; ocultar('nomeSetor');"
                                     onclick="mudarConteudo('<%=linha.getNomeSetor()%>', '<%=linha.getSiglaSetor()%>', '<%=linha.getPassouSetor()%>'); exibir('divAcoes');"/>
                                <%
                                }else{
                                %> 
                                 <img src="imagens/tramitacao/line1.gif" class="tramit"/>
                                <img src="imagens/tramitacao/yes.gif" class="tramit" 
                                     onmouseover="this.src='imagens/tramitacao/sel1.gif'; exibir('nomeSetor'); mudarNomeSetor('<%=linha.getNomeSetor()%>');"
                                     onmouseout="this.src='imagens/tramitacao/yes.gif'; ocultar('nomeSetor');"
                                     onclick="mudarConteudo('<%=linha.getNomeSetor()%>', '<%=linha.getSiglaSetor()%>', ''); exibir('divAcoes');"/>
                                
                                <%
                                    }
                                }
                                %> 
                                </p>
                             
                                <div style="height: 300px;">
                                    <div id="divAcoes" style="width: 500px; margin: auto; text-align: center; border: 2px groove #003399;">
                                    </div>  
                                </div>
                                <%-- INPUTS PARA O LISTAR LINHA --%>
                                <input type="hidden" name="idsetor" id="idsetor" value="${param.idsetor}" readonly="readonly"/>
                                <input type="hidden" name="idstatual" id="idstatual" value="${param.idstatual}" readonly="readonly"/>
                                <input type="hidden" name="idtipo" id="idtipo" value="${param.idtipo}" readonly="readonly"/>
                                <%-- ----------------------- --%>
                        </fieldset>
                        </p>
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