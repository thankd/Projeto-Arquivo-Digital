<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><style type="text/css"> @import url("scripts/styleMaster.css")all; </style>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Arquivo Digital | Efetuar Login</title>
			<link href="http://i.imgur.com/4TLP206.png" rel="shortcut icon"/>
</head>

   <body>
<div id="c">
  	
    
    <div id="logo_if_login">
	            <img src="imagens/logo_ifrn.png" id="ifCabecalho"/>
    </div>
    
	<div id="login_bg_login">
    	
   	  <div class="Conteudo_login">
	    <div class="logo_ad"> 
        <img src="imagens/logo.png" id="adCabecalho_login"/> 
	    </div>
        	      <div id="linha">            
                  <hr size="310" width="1" color="#56a8b8" /> 	
                  </div>
        <div id="form_login">
        	<fieldset>
            <legend> Efetuar Login </legend>
            <form id="login" method="post" action="<%= request.getContextPath() + "/Logar" %>">
                    <label for="matricula">Matrícula:</label>
                    <input name="matricula" type="text" required id="matricula" style="text-align: center;" size="15" /> <br />
                    <label for="senha">Senha:</label>
                    <input name="senha" type="password" required id="senha" style="text-align: center;" size="15" /> <br />
                    <input type="submit" value="Entrar" id="btn_logar"/>
                </form>
            </fieldset>
        </div>
	  </div>
      		<p id="textoRodape">
		Todos os direitos reservados © 	<img src="imagens/layout/Neo 5.1.png" id="neo"/>
	    </p>
	</div>
</div>


</body>

</html>

