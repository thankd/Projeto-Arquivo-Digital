<%@page import="Beans.Processo"%>
<%@page import="DAO.BuscaProcessoDAO"%>
<%@page import="java.util.List"%>
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
%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head><style type="text/css"> @import url("scripts/styleMaster.css")all; </style>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Arquivo Digital | Início</title>
			<link href="http://i.imgur.com/4TLP206.png" rel="shortcut icon"/>
	
		<script language="JavaScript">
            // para implementar essa bagaça
            //function Iniciar_Sessao(){
            //    alert(=tipo%>);
            //}              
            </script>
          <style type="text/css">
              #textoConteudo2 {
                  margin: 5px 5px 5px 5px;
	background-color: #56a8b8;
	padding: 10px;
        
                  
              }
            .meusProc{
                border: 1px solid #56a8b8;
                padding-bottom: 10px;
                border-radius: 10px;
                background-color: #56a8b8;
                padding-top: 20px;
            }
            .meusProc2{
                border: 1px solid #56a8b8;
                padding-left: 20px;
                padding-bottom: 10px;
                margin-left: 30px;
                margin-right: 30px;
                background-color: white;
            }
            .Proc{
                border: 3px solid black;
                border-radius: 6px;
                color: black;
                text-align: center;
                font-size: 16px;
                width: 150px;
                height: 150px;
                margin: auto;
                font-weight:bold;
            }
            .tb{
                border: none;
                
            }

a.procs:link, a.procs:visited {

text-decoration: none;
color: black;
             
}

a.procs:hover {
background-color: "black";
}

a.procs:active {

text-decoration: none;
color: white;
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
			<div class="textoConteudo2">
			 <a style=" text-shadow: #000 2px 2px 1px;color: white; font-size: 15px; padding-left:55px; font-weight:bold;">Bem vindo ao sistema integrado de gerenciamento de porcessos: Arquivo Digital.</a>
                         <%-- IMPLEMENTAR PARA PEGAR NO MAXIMO 3 PROCESSOS E DEPPOIS UM BOTAO DE VER MAIS DOS MEUS PROCESSOS --%>
                         <div class="meusProc"><h3 style="font-size: 20px;">Meus Processos</h3>
                             <div class="meusProc2">
                                
                                            
                                <%
                                 BuscaProcessoDAO BProcessoDAO = new BuscaProcessoDAO();
                                 List<Processo> processos = BProcessoDAO.ListarMeusProcessos(id);
                                %>                                
                                <table class="tb">
                                    <tr>
                                        <%
                                            int k = 0;
                                            for(int i = 0; i < processos.size(); i++){
                                              k++;
                                        %> 
                                        <td class="tb">
                                            <div class="Proc" onmouseover="this.style.border = '3px solid #56a8b8'" onmouseout="this.style.border = '3px solid black';">
                                                <a class="procs" href="AcompanharProcessos.jsp?protocolo=<%=processos.get(i).getIdProcesso()%>&data=<%=processos.get(i).getDataAbertura()%>&interessado=<%=processos.get(i).getInteressado()%>&assunto=<%=processos.get(i).getAssunto()%>&idsetor=<%=processos.get(i).getIdSetor()%>&idstatual=<%=processos.get(i).getIdSetorAtual()%>&idtipo=<%=processos.get(i).getIdTipoProcesso()%>">
                                                    <p><%=processos.get(i).getIdProcesso()%><br/><br/><%=processos.get(i).getTipoProcesso()%><br/><br/><%=processos.get(i).getDataAbertura()%></p>
                                                </a>
                                            </div> 
                                        </td>
                                        <%
                                            if(k % 3 == 0){
                                         %>
                                         </tr><tr>
                                        <%        
                                            }
                                          }
                                        %> 
                                        <%--<td class="tb">
                                                <p>VER MAIS</p> 
                                        </td>--%>
                                    </tr>
                                </table>
                            </div>
			</div>
                        </div>
		</div>

	</div>

	<div id="rodape">
	  <p id="textoRodape">Todos os direitos reservados © <img src="imagens/layout/Neo 5.1.png" id="neo"/></p>
	</div>
</div>
</body>

</html>