<%-- 
    Document   : CadastroUsuario
    Created on : 18/11/2013, 11:20:40
    Author     : 20101064010663
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
            <style type="text/css"> 
                
                
            </style>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Arquivo Digital | Início</title>
			<link href="http://i.imgur.com/4TLP206.png" rel="shortcut icon"/>
                        
<style type="text/css">
    #nomeU {
        margin-left: 27px;
        margin-top: 3px;
        
    }
    #senha {
        margin-left: 118px;
        margin-top: 3px;
    }
    #idSetor{
        margin-left: 125px;
        margin-top: 3px;
        
    }
    
    #idTipoUsuario{
        margin-left: 39px;
        margin-top: 3px;
       
    }
    
    #email{
        margin-left: 123px;
        margin-top: 3px;
    }
    
    #telefone{
        margin-left: 99px;
        margin-top: 3px;
        
    }
    #concluir {
        margin-top: 30px;
        
    }
</style>
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
			<div class="textoConteudo">
                             <p>&nbsp;</p>
                             <p> Cadastro de Usuário </p>
			  <form id="formC" name="formC">
			  <label> Matrícula do Usuário: </label>
			  <input type="text" id="idUsuario" name="idUsuario"/> <br/>
			  <label> Nome do Usuário:  </label>
			  <input type="text" id="nomeU" name="nome"/><br/>
			  <label> Senha: </label>
			  <input type="text" id="senha" name="senha"/><br/>
			  <label> Setor: </label>
                          <select name="idSetor" id="idSetor"> </select><br/>
			  <label> Tipo de Usuário: </label>
                          <select name="idTipoUsuario" id="idTipoUsuario"> </select><br/>
			  <label> Email: </label>
			  <input type="text" id="email" name="email"/><br/>
			  <label> Telefone: </label>
			  <input type="text" id="telefone" name="telefone"/><br/>
                          <input type="submit" id="concluir" name="concluir" value="Concluir Cadastro"> <br/>
			  
				</form>
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
