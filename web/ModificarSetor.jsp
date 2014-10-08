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
		<title>Arquivo Digital | Início</title>
			<link href="http://i.imgur.com/4TLP206.png" rel="shortcut icon"/>
                        <style type="text/css">
                            #sigla {
                                margin-left: 30px;
                            }
                            #nome {
                                margin-left: 25px;
                            }
                            #chefe {
                                margin-left: 25px;
                            }
                            form {
                                padding-left: 200px;
                            }
                        </style>>
		<script language="JavaScript">
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

                    <!-- MENU !! -->
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
			                        <p id="gerenciar_title_setores">Editar Setor <img id="icon" src="imagens/img_setores.png"></p>
			  
                           <form action="AdicionarSetor?acao=ModificarSetor&idSetor=${param.idSetor}" method="post">
                                Nome: <input type="text" id="nome" name="nome" value="${param.nome}" /> <br/>
                                Sigla: <input type="text"  id="sigla" name="sigla" value="${param.sigla}" /><br/>
                                Chefe: <input type="text" id="chefe" name="chefe" value="${param.chefe}"/><br/>
                                Telefone: <input type="text" id="telefone" name="telefone" value="${param.telefone}"/><br/>
 
                                <input type="submit" name="alterar" value="Alterar"/>
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