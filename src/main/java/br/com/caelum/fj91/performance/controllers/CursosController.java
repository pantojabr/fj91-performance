package br.com.caelum.fj91.performance.controllers;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.caelum.fj91.performance.models.Curso;
import br.com.caelum.fj91.performance.models.Nivel;
import br.com.caelum.fj91.performance.repositories.CategoriaRepository;
import br.com.caelum.fj91.performance.repositories.CursoRepository;
import br.com.caelum.fj91.performance.repositories.InstrutorRepository;
import br.com.caelum.fj91.performance.repositories.TagRepository;

@Controller
@RequestMapping("/cursos")
public class CursosController {
	
	private static final String PAGINA_CURSOS = "cursos/cursos";
	private static final String PAGINA_CADASTRO_CURSO = "cursos/curso-form";
	private static final String REDIRECT_PAGINA_CURSOS = "redirect:/cursos";
	
	private static final Sort SORT_BY_NOME = Sort.by("nome");
	
	private final CursoRepository cursoRepository;
	private final CategoriaRepository categoriaRepository;
	private final InstrutorRepository instrutorRepository;
	private final TagRepository tagRepository;

	public CursosController(CursoRepository cursoRepository, CategoriaRepository categoriaRepository, InstrutorRepository instrutorRepository, TagRepository tagRepository) {
		this.cursoRepository = cursoRepository;
		this.categoriaRepository = categoriaRepository;
		this.instrutorRepository = instrutorRepository;
		this.tagRepository = tagRepository;
	}

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("cursos", cursoRepository.findAll());
		return PAGINA_CURSOS;
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("niveis", Nivel.values());
		model.addAttribute("categorias", categoriaRepository.findAll(SORT_BY_NOME));
		model.addAttribute("instrutores", instrutorRepository.findAll(SORT_BY_NOME));
		model.addAttribute("tags", tagRepository.findAll(SORT_BY_NOME));
		return PAGINA_CADASTRO_CURSO;
	}
	
	@PostMapping
	@Transactional
	public String adicionar(Curso curso, RedirectAttributes redirectModel) {
		this.cursoRepository.save(curso);
		redirectModel.addFlashAttribute("msg", "Curso cadastrado com sucesso!");
		return REDIRECT_PAGINA_CURSOS;
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public String remover(@PathVariable("id") Long id, RedirectAttributes redirectModel) {
		this.cursoRepository.deleteById(id);
		redirectModel.addFlashAttribute("msg", "Curso removido com sucesso!");
		return REDIRECT_PAGINA_CURSOS;
	}
	
}
