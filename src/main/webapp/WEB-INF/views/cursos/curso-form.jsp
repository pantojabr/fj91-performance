<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>


<custom:template title="Cadastrar novo Curso">
	<jsp:attribute name="extraStyles">
		<link rel="stylesheet" href="<c:url value='/assets/vendor/select2/select2.min.css' />">
	</jsp:attribute>

	<jsp:attribute name="extraScripts">
		<script type="text/javascript" src="<c:url value='/assets/vendor/tinymce/tinymce.min.js' />"></script>
		<script type="text/javascript" src="<c:url value='/assets/vendor/select2/select2.min.js' />"></script>
		<script type="text/javascript" src="<c:url value='/assets/js/editor.js' />"></script>
		<script type="text/javascript" src="<c:url value='/assets/js/combos.js' />"></script>
	</jsp:attribute>
	
	<jsp:body>
		<div class="container">
			<h1 class="text-center">Cadastrar novo Curso</h1>
			
			<form method="post" action="<c:url value='/cursos' />">
				<div class="form-group">
					<label for="nome">Nome</label>
					<input id="nome" name="nome" class="form-control" required="required">
				</div>
				
				<div class="form-group">
					<label for="duracao">Duração(Minutos)</label>
					<input type="number" id="duracao" name="duracaoEmMinutos" class="form-control" required="required">
				</div>
				
				<div class="form-group">
					<label for="descricao">Descrição detalhada</label>
					<textarea rows="5" cols="5" id="descricao" name="descricao" class="form-control"></textarea>
				</div>
				
				<div class="form-group">
					<label for="nivel">Nível</label>
					<select id="nivel" name="nivel" class="form-control" required="required">
						<c:forEach items="${niveis}" var="nivel">
							<option value="${nivel}">
								<c:out value="${nivel.descricao}" />
							</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="categoria">Categoria</label>
					<select id="categoria" name="categoria.id" class="form-control" required="required">
						<c:forEach items="${categorias}" var="categoria">
							<option value="${categoria.id}">
								<c:out value="${categoria.nome}" />
							</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="instrutor">Instrutor</label>
					<select id="instrutor" name="instrutor.id" class="form-control" required="required">
						<c:forEach items="${instrutores}" var="instrutor">
							<option value="${instrutor.id}">
								<c:out value="${instrutor.nome}" />
							</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="tags">Tags</label>
					<select id="tags" name="tags" class="form-control" multiple="multiple">
						<c:forEach items="${tags}" var="tag">
							<option value="${tag.id}">
								<c:out value="${tag.nome}" />
							</option>
						</c:forEach>
					</select>
				</div>
				
				<input type="submit" value="Gravar" class="btn btn-primary">
				<a href="<c:url value='/cursos' />" class="btn btn-default">Cancelar</a>
			</form>
		</div>
	</jsp:body>
</custom:template>
