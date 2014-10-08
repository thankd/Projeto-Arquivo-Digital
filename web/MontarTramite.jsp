<%-- 
    Document   : MontarTramite
    Created on : 15/11/2013, 17:22:43
    Author     : Edivania
--%>

<%@page import="java.util.List"%>
<%@page import="Beans.Setor"%>
<%@page import="DAO.TramiteDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Beans.Conexao"%>
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
	<title>Arquivo Digital | Montar Trâmite</title>
	<link href="http://i.imgur.com/4TLP206.png" rel="shortcut icon"/>
        
        <script type="text/javascript">
            var k = 1;
            var numSelecionados = 0;
            
            function validacao(){
                document.getElementById('erro2').style.display = 'none';
                var ret = true;
                
                if(numSelecionados == 0){
                    document.getElementById('erro2').style.display = '';
                    ret = false;
                }
                return ret;
            }
            
            function escolherSetor(){
                var selectSetor = document.getElementById("setores");
                var selectedValue = selectSetor.options[selectSetor.selectedIndex].value;
               
               if(selectedValue != "Selecionar"){                    
                    document.getElementById("str"+k).style.display = '';
                    document.getElementById("exc"+k).style.display = '';
                    document.getElementById("br"+k).style.display = '';
                    document.getElementById("str"+k).value = selectedValue;
                    
                    numSelecionados++;    
                    k++;
                    
                    selectSetor.options.remove(selectSetor.selectedIndex);
                }
            }
            
            function excluirSetor(num){
                var selectSetor = document.getElementById("setores");
                var txtValue = document.getElementById("str"+num).value; 
                <%-- var idOption = txtValue.substring(txtValue.indexOf("[")+1, txtValue.indexOf("]")); --%>
                var txtOption = txtValue.substring(0, txtValue.indexOf("[")-1); 
                
                selectSetor.options[selectSetor.options.length] = new Option(txtOption, txtValue);
                                            
                var r = 0;
                r = parseInt(r);
                
                for (i = 1; i <= numSelecionados; i++){
                    if(i == num){
                        for (j = i; j <= numSelecionados; j++){
                            r = j +1; 
                            document.getElementById("str"+j).value = document.getElementById("str"+r).value;
                        }
                        document.getElementById("str"+numSelecionados).value = "";
                        document.getElementById("str"+numSelecionados).style.display = 'none';
                        document.getElementById("exc"+numSelecionados).style.display = 'none'; 
                        document.getElementById("br"+numSelecionados).style.display = 'none';
                        numSelecionados--;
                        k--;
                        document.getElementById("qts").value = numSelecionados;
                    }
                }  
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
                     <h3>Novo Tipo de Processo</h3>
                    <div class="textoConteudo">
                        <form id="cadastroTipoProc" name="cadastroTipoProc" method="post" action="GerenciarTramite?acao=AdicionarTramite" onsubmit="return validacao();">
                            <fieldset>
                                <legend>Processo</legend>
                                <label for="tipoProcesso">Nome do tipo de processo:</label>
                                <input type="text" name="tipoProcesso" id="tipoProcesso" style="font-size: 16px;" required=""/>
                            </fieldset>
                            <br/>
                            <fieldset>
                                <legend>Trâmite</legend>
                                
                                <label for="setores">Setores:</label>
                                <select style="font-size: 16px;" name="setores" id="setores" onchange="escolherSetor();"> 
                                    <option>Selecionar</option>
                                    <% 
                                    TramiteDAO tramiteDAO = new TramiteDAO();
                                    List<Setor> setores = tramiteDAO.ListarSetores();
                                            for(Setor setor : setores){
                                    %>
                                    <option value="<%=setor.getNomeSetor()%> [<%=setor.getIdSetor()%>]"><%=setor.getNomeSetor()%>  </option>
                                    <% } %>
                                </select>
                                <label style="display:none; color: red; font-size:10pt;" id="erro2">* selecione os setores.</label>
                                <br/><br/>
                                
                                <input type="button" name="exc1" id="exc1" value="x" style="font-size: 13px; display: none;" onclick="excluirSetor(1);"/>
                                <input type="text" name="str1" id="str1" style="font-size: 14px; width: 320px; display: none;"/><br id="br1" style="display: none;"/>
                                <input type="button" name="exc2" id="exc2" value="x" style="font-size: 13px; display: none;" onclick="excluirSetor(2);"/>
                                <input type="text" name="str2" id="str2" style="font-size: 14px; width: 320px; display: none;"/><br id="br2" style="display: none;"/>
                                <input type="button" name="exc3" id="exc3" value="x" style="font-size: 13px; display: none;" onclick="excluirSetor(3);"/>
                                <input type="text" name="str3" id="str3" style="font-size: 14px; width: 320px; display: none;"/><br id="br3" style="display: none;"/>
                                <input type="button" name="exc4" id="exc4" value="x" style="font-size: 13px; display: none;" onclick="excluirSetor(4);"/>
                                <input type="text" name="str4" id="str4" style="font-size: 14px; width: 320px; display: none;"/><br id="br4" style="display: none;"/>
                                <input type="button" name="exc5" id="exc5" value="x" style="font-size: 13px; display: none;" onclick="excluirSetor(5);"/>
                                <input type="text" name="str5" id="str5" style="font-size: 14px; width: 320px; display: none;"/><br id="br5" style="display: none;"/>
                                    
                                <input type="button" name="exc6" id="exc6" value="x" style="font-size: 13px; display: none;" onclick="excluirSetor(6);"/>
                                <input type="text" name="str6" id="str6" style="font-size: 14px; width: 320px; display: none;"/><br id="br6" style="display: none;"/>
                                <input type="button" name="exc7" id="exc7" value="x" style="font-size: 13px; display: none;" onclick="excluirSetor(7);"/>
                                <input type="text" name="str7" id="str7" style="font-size: 14px; width: 320px; display: none;"/><br id="br7" style="display: none;"/>
                                <input type="button" name="exc8" id="exc8" value="x" style="font-size: 13px; display: none;" onclick="excluirSetor(8);"/>
                                <input type="text" name="str8" id="str8" style="font-size: 14px; width: 320px; display: none;"/><br id="br8" style="display: none;"/>
                                <input type="button" name="exc9" id="exc9" value="x" style="font-size: 13px; display: none;" onclick="excluirSetor(9);"/>
                                <input type="text" name="str9" id="str9" style="font-size: 14px; width: 320px; display: none;"/><br id="br9" style="display: none;"/>
                                <input type="button" name="exc10" id="exc10" value="x" style="font-size: 13px; display: none;" onclick="excluirSetor(10);"/>
                                <input type="text" name="str10" id="str10" style="font-size: 14px; width: 320px; display: none;"/><br id="br10" style="display: none;"/>
                                    
                                <input type="button" name="exc11" id="exc11" value="x" style="font-size: 13px; display: none;" onclick="excluirSetor(11);"/>
                                <input type="text" name="str11" id="str11" style="font-size: 14px; width: 320px; display: none;"/><br id="br11" style="display: none;"/>
                                <input type="button" name="exc12" id="exc12" value="x" style="font-size: 13px; display: none;" onclick="excluirSetor(12);"/>
                                <input type="text" name="str12" id="str12" style="font-size: 14px; width: 320px; display: none;"/><br id="br12" style="display: none;"/>
                                <input type="button" name="exc13" id="exc13" value="x" style="font-size: 13px; display: none;" onclick="excluirSetor(13);"/>
                                <input type="text" name="str13" id="str13" style="font-size: 14px; width: 320px; display: none;"/><br id="br13" style="display: none;"/>
                                <input type="button" name="exc14" id="exc14" value="x" style="font-size: 13px; display: none;" onclick="excluirSetor(14);"/>
                                <input type="text" name="str14" id="str14" style="font-size: 14px; width: 320px; display: none;"/><br id="br14" style="display: none;"/>
                                <input type="button" name="exc15" id="exc15" value="x" style="font-size: 13px; display: none;" onclick="excluirSetor(15);"/>
                                <input type="text" name="str15" id="str15" style="font-size: 14px; width: 320px; display: none;"/><br id="br15" style="display: none;"/>                                                   
                            </fieldset>
                            
                            <input type="submit" name="cadastrar" id="cadastrar" value="Cadastrar"/>
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
