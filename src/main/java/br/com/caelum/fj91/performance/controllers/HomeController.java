package br.com.caelum.fj91.performance.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.caelum.fj91.performance.models.Curso;
import br.com.caelum.fj91.performance.repositories.CursoRepository;

@Controller
public class HomeController {
	
	private final CursoRepository cursoRepository;

	public HomeController(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}

	@GetMapping({"/", "/home"})
	public String index(Model model) {
		List<Curso> cursos = cursoRepository.findAllByOrderByDataDeLancamentoDesc();
		List<Curso> ultimos = cursos.stream().limit(10).collect(Collectors.toList());
		
		model.addAttribute("ultimosCursos", ultimos);
		return "home/index";
	}
	
}
