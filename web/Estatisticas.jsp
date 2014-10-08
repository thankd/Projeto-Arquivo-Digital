<%-- 
    Document   : Estatisticas
    Created on : 18/11/2013, 17:18:25
    Author     : 20101064010663
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head><style type="text/css"> @import url("scripts/styleMaster.css")all; </style>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Arquivo Digital | Início</title>
			<link href="http://i.imgur.com/4TLP206.png" rel="shortcut icon"/>
                        
<style type="text/css">



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
        </p>
		<p id="equipe">Sair</p>
       

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
                             <p>Estátisticas</p>   
			  <form id="formC" name="formC">
                              <table border="0"> 
                                  <td> <input type="checkbox" id="checkTP" name="checkTP" > Tipo <br/>
                              <label> Tipo de Processo </label>
                                <select name="idTipoUsuario" id="idTipoProcesso"> </select><br/> </td> 
                                  <td> <input type="checkbox" id="checkTP" name="checkTP" /> Tipo <br/>
                              <label> Mês </label>
                              <input type="text" id="mes" name="mes"/> 
                              </table>
                              
                              <label> </label>
                          <input type="submit" id="concluir" name="concluir" value="Gerar Dados Estátisticos"> <br/>
			  
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

