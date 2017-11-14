<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>

<custom:template title="Home">
	<jsp:body>
		<img class="img-responsive" src="<c:url value='/assets/img/alura.png' />" alt="Alura">
		
		<section class="carousel-ultimos-cursos">
			<div class="container">
				<h2 class="text-center">Últimos cursos lançados</h2>
				
				<div class="owl-carousel owl-theme">
					<c:forEach items="${ultimosCursos}" var="curso">
						<div class="card-curso">
							<h3 class="card-curso-nome">${curso.nome}</h3>
							<p class="card-curso-categoria">${curso.categoria.nome}</p>
							<c:forEach items="${curso.tags}" var="tag">
								<span class="label label-info">${tag.nome}</span>
							</c:forEach>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>
	</jsp:body>
</custom:template>
