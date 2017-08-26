<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<tag:template title="Cadastrar Pratos">
	<h1>Cadastrar</h1>
	<FORM action="cadastrar" method="post">
		<div class="form-group">
			<LABEL for="Nome">Nome</LABEL>
			<INPUT type="text" id="Nome" name="nome" class="form-control"/>
		</div>	
		
		<div class="form-group">
			<LABEL for="Preco">Preço</LABEL>
			<INPUT type="text" id="Preco" name="preco" class="form-control"/>			
		</div>	
		
		<div class="form-group">
			<LABEL for="Peso">Peso</LABEL>
			<INPUT type="text" id="Peso" name="peso" class="form-control"/>		
		</div>

		<div class="form-group">	
			<INPUT type="submit" value="CADASTRAR" class="btn btn-primary"/>
		</div>
	</FORM>
</tag:template>

