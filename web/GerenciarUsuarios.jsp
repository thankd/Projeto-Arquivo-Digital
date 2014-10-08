<%@page import="Beans.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="Beans.Setor"%>
<%@page import="java.util.List"%>
<%@page import="DAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
   String id   = (String) session.getAttribute("id");
   String tipo = (String) session.getAttribute("tipo");
   String nome = (String) session.getAttribute("nome");
   
   if((id==null)||(tipo==null)){
       response.sendRedirect("NoSession.jsp");
   }
   
   String tipo_filtro = "normal";
   String str_filtro = "";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head><style type="text/css"> @import url("scripts/styleMaster.css")all; </style>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Arquivo Digital | Gerenciar Usuários</title>
			<link href="http://i.imgur.com/4TLP206.png" rel="shortcut icon"/>
			<style type="text/css">
			#apDiv1 {
	position: absolute;
	width: 490px;
	height: 75px;
	z-index: 1;
	left: 569px;
	top: 384px;
}
            #formulario_adicionar {
	position: absolute;
	width: 445px;
	height: 380px;
	z-index: 2;
	left: 446px;
	top: 273px;
	background-color: white;
	border-radius: 10px;
	padding-left:40px;	
	border: solid;
        display: none;
        }
	#nome {
		margin-left:26px;	
	}
	#senha {
		margin-left:23px;	
	}
	#setor {
		margin-left:30px;	
	}
	#tipo {
		margin-left:38px;	
	}
	#email {
		margin-left:28px;	
	}
	#fechar {
		float:right;	
	}
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
                     <h3>Gerenciar Usuários <img id="icon" src="imagens/user_icon.png"></h3>
		  <div class="textoConteudo">
			 
			  <div id="btn_adicionar" onclick="exibir('formulario_adicionar');"> <h3><img src="imagens/add.png" width="30" height="28" /> Cadastrar</h3></div><br/>
			
                  
                 <fieldset>
                <legend> Pesquisar </legend>
                <form method="get">
                    	<input type="text" name="string" id="string" />
                        <select name="tipo_busca" id="tipo_busca" >
                            <option value="normal"> Tudo </option>
                            <option value="nome"> Nome </option>
                            <option value="matricula"> Matricula </option>
                            <option value="tipo"> Tipo </option>
                            <input type="submit" value="Pesquisar">
                        </select>
                    </form>
                </fieldset>
            	            
                  <div id="tabela">
                      <br />  
                      <%
                                UsuarioDAO usuarioDAO = new UsuarioDAO();
                                List<Usuario> usuarios = usuarioDAO.ListarUsuario(request.getParameter("string"),request.getParameter("tipo_busca"));
                      %>    
                            
                            <table border="1px">
                            <tr>
                                <th> Matrícula </th>
                                <th> Nome </th>
                                <th> Setor </th>
                                <th> Tipo </th>
                                <th> E-mail </th>
                                <th colspan="2"> Gerenciamento </th>
                            </tr>
                            <%
                            for (Usuario usuario : usuarios){
                            %>
                            <tr>
                                <td><%= usuario.getIdUsuario()%></td>
                                <td><%= usuario.getNome()%></td>
                                <td><%= usuario.getSetor()%></td>
                                <td><%= usuario.getTipoUsuario()%></td>
                                <td><%= usuario.getEmail()%></td>
                                <td><a href="${pageContext.request.contextPath}/EditarUsuario.jsp?matricula=<%= usuario.getIdUsuario() %>&nome=<%= usuario.getNome()%>&senha=<%= usuario.getSenha()%>&email=<%= usuario.getEmail()%>&telefone=<%= usuario.getCelular()%>&string=<%= request.getParameter("string") %>&tipo_busca=<%= request.getParameter("tipo_busca") %>"><img src='imagens/editar.png' width='25px' height='25px' /></a></td>
                                <td><a href="${pageContext.request.contextPath}/CadastrarUsuario?action=delete&idUsuario=<%= usuario.getIdUsuario()%>"><img src='imagens/excluir.png' width='25px' height='25px'/></a></td>
                            </tr>
                            <%
                            }
                            %>
                    </table>
                            
                            
</div>
            </div>   
            <div id="formulario_adicionar">
            <img id="fechar" src="imagens/botao-fechar.jpg" width="97" height="26" onclick="ocultar('formulario_adicionar');"/><br />
                    	<a id="legend_add">Cadastrar Usuário </a><img  src="imagens/add.jpg" width="39" height="40" />
                   	  <form action="<%= request.getContextPath() + "/CadastrarUsuario?action=Adicionar" %>"  method="post" id="add_usuario"><br />
                              <label for="setor"> Setor: </label>
                            <select name="setor" id="setor" required/>
                                <% 
                                            usuarioDAO = new UsuarioDAO();
                                            List<Setor> setores = usuarioDAO.ListarSetores();
                                            for(Setor setor : setores){
                                                                                      
                                        %>
                                        <option value="<%=setor.getIdSetor()%>"><%= setor.getNomeSetor()%></option>
                                <% } %>
                            </select><br />
                   	    <label for="matricula"> Matricula: </label>
                            <input name="matricula" type="text" id="matricula" size="15"  required/> <br />
                            <label for="nome"> Nome: </label>
                            <input name="nome" type="text" id="nome" size="15" required/> <br /> 
                            <label for="senha"> Senha: </label>
                            <input name="senha" type="password" id="senha" size="15" required/> <br />
                            <label for="tipo"> Tipo: </label>
                            <select name="tipo" id="tipo" required>
                            	<option value="user"> Usuário </option>
                                <option value="admin"> Administrador </option>
                            </select> <br />
                            <label for="email"> Email: </label>
                            <input name="email" type="text" id="email" size="15" required/> <br />
                            <label for="telefone"> Telefone: </label>
                          <input name="telefone" type="text" id="telefone" size="15" required/><br />
                          <input type="submit" value="Cadastrar" />
                          <input type="reset" value="Limpar" />
                      	<br />
                      </form>
          </div>
            
            	
     
                            
	</div>
  </div>

	<div id="rodape">
	  <p id="textoRodape">Todos os direitos reservados © <img src="imagens/layout/Neo 5.1.png" id="neo"/></p>
	</div>
</div>
</body>

</html>