<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de pratos</title>
</head>
<body>
	<FORM action="cadastrar" method="post">
		<div>
			<LABEL for="Nome">Nome</LABEL>
			<INPUT type="text" id="Nome" name="nome"/>
		</div>	
		
		<div>
			<LABEL for="Preco">Preço</LABEL>
			<INPUT type="text" id="Preco" name="preco"/>			
		</div>	
		
		<div>
			<LABEL for="Peso">Peso</LABEL>
			<INPUT type="text" id="Peso" name="peso"/>		
		</div>

		<div>	
			<INPUT type="submit" value="CADASTRAR"/>
		</div>
	</FORM>
</body>
</html>