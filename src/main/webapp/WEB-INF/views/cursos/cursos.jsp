<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>

<custom:template title="Cursos cadastrados">
	<jsp:body>
		<div class="container">
			<h1 class="text-center">Cursos cadastrados</h1>
			
			<a href="<c:url value='/cursos/form' />" class="btn btn-primary">Novo</a>
			
			<div class="table-responsive">
				<table class="table table-stripped table-hover">
					<thead>
						<tr>
							<th>NOME</th>
							<th>LANÇADO EM</th>
							<th>DURAÇÃO</th>
							<th>NÍVEL</th>
							<th>CATEGORIA</th>
							<th>INSTRUTOR</th>
							<th>TAGS</th>
							<th>REMOVER</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${cursos}" var="curso">
							<tr>
								<td>
									<c:out value="${curso.nome}" />
								</td>
								
								<td>
									<c:out value="${curso.dataDeLancamentoFormatada()}" />
								</td>
								
								<td>
									<c:out value="${curso.duracaoEmMinutos} (Minutos)" />
								</td>
								
								<td>
									<c:out value="${curso.nivel.descricao}" />
								</td>
								
								<td>
									<c:out value="${curso.categoria.nome}" />
								</td>
								
								<td>
									<c:out value="${curso.instrutor.nome}" />
								</td>
								
								<td>
									<c:forEach items="${curso.tags}" var="tag">
										<span class="label label-info">${tag.nome}</span>
									</c:forEach>
								</td>
								
								<td>
									<form method="post" action="<c:url value='/cursos/${curso.id}' />">
										<input type="hidden" name="_method" value="DELETE">
										<input type="hidden" name="id" value="${curso.id}">
										
										<button type="submit" class="btn btn-danger">
											<span class="glyphicon glyphicon-trash"></span> Remover
										</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</jsp:body>
</custom:template>
