<%@page import="org.apache.tomcat.util.http.fileupload.FileUploadException"%>
<%@page import="org.apache.tomcat.util.http.fileupload.FileItem"%>
<%@page import="org.apache.tomcat.util.http.fileupload.FileUpload"%>
<%@page import="Beans.TipoProcesso"%>
<%@page import="java.util.List"%>
<%@page import="Beans.Setor"%>
<%@page import="DAO.ProcessoDAO"%>
<%
   String id   = (String) session.getAttribute("id");
   String tipo = (String) session.getAttribute("tipo");
   String nome = (String) session.getAttribute("nome");
   String setor =(String) session.getAttribute("idSetor");
   
   if((id==null)||(tipo==null)){
       response.sendRedirect("NoSession.jsp");
   }
%>

  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
                        
            <style type="text/css"> @import url("scripts/styleMaster.css")all; </style>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Arquivo Digital | Abrir Processo</title>
			<link href="http://i.imgur.com/4TLP206.png" rel="shortcut icon"/>
	
        <style type="text/css">
#assunto {
	
	margin-left: 91px;
}
#tipo {
	margin-left: 19px;
}
#file{
        margin-left: 83px;
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
                     <h3>Abrir Processo</h3>
			<div class="textoConteudo">
			                             
                            <form method="post" enctype="multipart/form-data" action="<%= request.getContextPath() %>/GerenciarProcesso?id_user=<%= id %>&setor=<%= setor %>" >
                                <p>
                             <!-- 0 -->     <label>Assunto:    </label>
                                    <input type="text" name="assunto" id="assunto" required /> <br/>

                             <!-- 1 -->    <label>Tipo de Processo:  </label>
                                    <select name="tipo" id="tipo" required>
                                        <% 
                                        
                                            ProcessoDAO processoDAO = new ProcessoDAO();
                                            List<TipoProcesso> tiposProcesso = processoDAO.ListarTipoProcesso();
                                            for(TipoProcesso tipoProcesso : tiposProcesso){
                                                                                      
                                        %>
                                        <option value="<%=tipoProcesso.getIdTipoProcesso()%>"> <%=tipoProcesso.getNomeTipoProcesso()%></option>
                                        <% } %>
                                    </select> 
                                  
                                  <br/>
                                
                                <!-- 2 -->  <label for="file">Processo:</label>
                                    <input type="file" name="file" id="file" required/> <br/>
                                 
                                 <input type="submit" value="Abrir"/>
                                    <input type="reset" value ="Cancelar" />
                                </p>
                              </form> 
                            <p> 
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