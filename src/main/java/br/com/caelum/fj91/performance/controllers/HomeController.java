package br.com.caelum.fj91.performance.controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.caelum.fj91.performance.repositories.CursoRepository;

@Controller
public class HomeController {
	
	private static final PageRequest DEZ_ULTIMOS = new PageRequest(0, 10);
	private final CursoRepository cursoRepository;

	public HomeController(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}

	@GetMapping({"/", "/home"})
	public String index(Model model) {
		model.addAttribute("ultimosCursos", cursoRepository.ultimosLancamentos(DEZ_ULTIMOS));
		return "home/index";
	}
	
}
