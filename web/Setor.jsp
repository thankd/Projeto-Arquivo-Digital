<%@page import="java.util.List"%>
<%@page import="Beans.Setor"%>
<%@page import="DAO.SetorDAO"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
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
		<title>Arquivo Digital | Gerenciar Setores</title>
			<link href="http://i.imgur.com/4TLP206.png" rel="shortcut icon"/>
	
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
        #formulario_adicionar_setor {
	position: absolute;
	width: 350px;
	height: 300px;
	z-index: 2;
	left: 470px;
	top: 400px;
	background-color: white;
	border-radius: 10px;
	padding-left:40px;	
	border: solid;
        display: none;
        }
        #nome {
		margin-left:30px;	
	}
	#sigla {
		margin-left:36px;	
	}
	#chefe {
		margin-left:28px;	
	}
	#telefone {
		margin-left: 5px;	
	}
        #fechar {
		float:right;	
	}
                            </style>
                            		<script language="JavaScript">
            // para implementar essa bagaça
            //function Iniciar_Sessao(){
            //    alert(=tipo%>);
            //}              
function ocultar(erro){
			x = document.getElementById(erro);
			x.style.display = "none";
}
			
function exibir(erro){
			x = document.getElementById(erro);
			x.style.display = "block";
}
            </script>
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
                    <h3>Gerenciar Setores <img id="icon" src="imagens/img_setores.png"></h3>
			<div class="textoConteudo"> 
                              
			  <div id="btn_adicionar" onclick="exibir('formulario_adicionar_setor');"> <h3><img src="imagens/add.png" width="30" height="28" /> Cadastrar</h3></div></br>
			
                       <div id="formulario_adicionar_setor">      
                           <img id="fechar" src="imagens/botao-fechar.jpg" width="97" height="26" onclick="ocultar('formulario_adicionar_setor');"/><br />
                    	<a id="legend_add">Cadastrar Setor </a><img  src="imagens/add.jpg" width="39" height="40" />
               
                           <form method="post" action="AdicionarSetor?acao=AdicionarSetor">
                                Nome: <input type="text" id="nome" name="nome" /> <br/>
                                Sigla: <input type="text"  id="sigla" name="sigla"/><br/>
                                Chefe: <input type="text" id="chefe" name="chefe"/><br/>
                                Telefone: <input type="text" id="telefone" name="telefone"/><br/>
                                
                                <input type="submit" name="criar" value="Adicionar"/>
                                <input type="reset" name="cancelar" value="Cancelar" />   
                                
                            </form>
                       </div>

                            <%
                                SetorDAO setorDAO = new SetorDAO();
                                List<Setor> setores = setorDAO.ListarSetores();
                            %>    
                            
                            <table border="1px">
                            <tr>
                                <th> Nome </th>
                                <th> Sigla </th>
                                <th> Chefe </th>
                                <th> Telefone </th>
                                <th colspan="2"> Gerenciamento </th>
                            </tr>
                            <%
                            for (Setor setor : setores){
                            %>
                            <tr>
                                <td><%= setor.getNome() %></td>
                                <td><%= setor.getSigla()%></td>
                                <td><%= setor.getChefe() %></td>
                                <td><%= setor.getTelefone() %></td>
                                <td><a href="ModificarSetor.jsp?nome=<%= setor.getNome()%>&sigla=<%= setor.getSigla() %>&chefe=<%= setor.getChefe() %>&telefone=<%= setor.getTelefone()%>¨&idSetor=<%= setor.getIdSetor() %>"><img src='imagens/editar.png' width='25px' height='25px' /></a></td>
                                <td><a href="AdicionarSetor?acao=ExcluirSetor&idSetor=<%= setor.getIdSetor() %>"> <img src='imagens/excluir.png' width='25px' height='25px' /> </a></td>
                            </tr>
                            <%
                            }
                            %>
                        </table>      
			</div>
		</div>
	</div>

	<div id="rodape">
	  <p id="textoRodape">Todos os direitos reservados © <img src="imagens/layout/Neo 5.1.png" id="neo"/></p>
	</div>
</div>
</body>

</html>