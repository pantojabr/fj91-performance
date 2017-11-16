<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>

<custom:template title="Instrutores cadastrados">
	<jsp:attribute name="extraScripts">
		<script type="text/javascript" src="<c:url value='/assets/vendor/sweetAlert/sweetAlert.js' />"></script>
		<script type="text/javascript" src="<c:url value='/assets/js/mensagens.js' />"></script>
	</jsp:attribute>
	
	<jsp:body>
		<div class="container">
			<h1 class="text-center">Instrutores cadastrados</h1>
			
			<a href="<c:url value='/instrutores/form' />" class="btn btn-primary">Novo</a>
			
			<div class="table-responsive">
				<table class="table table-stripped table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>NOME</th>
							<th>REMOVER</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${instrutores}" var="instrutor">
							<tr>
								<td>
									<c:out value="${instrutor.id}" />
								</td>
								
								<td>
									<c:out value="${instrutor.nome}" />
								</td>
								
								<td>
									<form method="post" action="<c:url value='/instrutores/${instrutor.id}' />">
										<input type="hidden" name="_method" value="DELETE">
										<input type="hidden" name="id" value="${instrutor.id}">
										
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
