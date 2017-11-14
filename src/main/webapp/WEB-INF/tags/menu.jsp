<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" 
				data-target="#menu" aria-expanded="false">
				<span class="sr-only">Menu</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value='/' />">Performance</a>
		</div>

		<div class="collapse navbar-collapse" id="menu">
			<ul class="nav navbar-nav">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li>
							<a href="<c:url value='/cursos' />">Cursos</a>
						</li>

						<li>
							<a href="<c:url value='/instrutores' />">Instrutores</a>
						</li>

						<li>
							<a href="<c:url value='/categorias' />">Categorias</a>
						</li>

						<li>
							<a href="<c:url value='/tags' />">Tags</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>
