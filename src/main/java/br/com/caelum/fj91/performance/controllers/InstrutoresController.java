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

import br.com.caelum.fj91.performance.models.Instrutor;
import br.com.caelum.fj91.performance.repositories.InstrutorRepository;

@Controller
@RequestMapping("/instrutores")
public class InstrutoresController {
	
	private static final String PAGINA_INSTRUTORES = "instrutores/instrutores";
	private static final String PAGINA_CADASTRO_INSTRUTOR = "instrutores/instrutor-form";
	private static final String REDIRECT_PAGINA_INSTRUTORES = "redirect:/instrutores";
	
	private static final Sort SORT_BY_NOME = Sort.by("nome");
	
	private final InstrutorRepository instrutorRepository;

	public InstrutoresController(InstrutorRepository instrutorRepository) {
		this.instrutorRepository = instrutorRepository;
	}

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("instrutores", instrutorRepository.findAll(SORT_BY_NOME));
		return PAGINA_INSTRUTORES;
	}
	
	@GetMapping("/form")
	public String form() {
		return PAGINA_CADASTRO_INSTRUTOR;
	}
	
	@PostMapping
	@Transactional
	public String adicionar(Instrutor instrutor, RedirectAttributes redirectModel) {
		this.instrutorRepository.save(instrutor);
		redirectModel.addFlashAttribute("msg", "Instrutor adicionado com sucesso!");
		return REDIRECT_PAGINA_INSTRUTORES;
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public String remover(@PathVariable("id") Long id, RedirectAttributes redirectModel) {
		this.instrutorRepository.deleteById(id);
		redirectModel.addFlashAttribute("msg", "Instrutor removido com sucesso!");
		return REDIRECT_PAGINA_INSTRUTORES;
	}
	
}
