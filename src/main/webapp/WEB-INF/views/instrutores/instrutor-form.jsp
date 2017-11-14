<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>

<custom:template title="Cadastrar novo Instrutor">
	<jsp:body>
		<div class="container">
			<h1 class="text-center">Cadastrar novo Instrutor</h1>
			
			<form method="post" action="<c:url value='/instrutores' />">
				<div class="form-group">
					<label for="nome">Nome</label>
					<input id="nome" name="nome" class="form-control" required="required">
				</div>
				
				<input type="submit" value="Gravar" class="btn btn-primary">
				<a href="<c:url value='/instrutores' />" class="btn btn-default">Cancelar</a>
			</form>
		</div>
	</jsp:body>
</custom:template>
