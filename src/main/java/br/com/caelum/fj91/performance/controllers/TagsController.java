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

import br.com.caelum.fj91.performance.models.Tag;
import br.com.caelum.fj91.performance.repositories.TagRepository;

@Controller
@RequestMapping("/tags")
public class TagsController {
	
	private static final String PAGINA_TAGS = "tags/tags";
	private static final String PAGINA_CADASTRO_TAG = "tags/tag-form";
	private static final String REDIRECT_PAGINA_TAGS = "redirect:/tags";
	
	private static final Sort SORT_BY_NOME = Sort.by("nome");
	
	private final TagRepository tagRepository;

	public TagsController(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("tags", tagRepository.findAll(SORT_BY_NOME));
		return PAGINA_TAGS;
	}
	
	@GetMapping("/form")
	public String form() {
		return PAGINA_CADASTRO_TAG;
	}
	
	@PostMapping
	@Transactional
	public String adicionar(Tag tag, RedirectAttributes redirectModel) {
		this.tagRepository.save(tag);
		redirectModel.addFlashAttribute("msg", "Tag adicionada com sucesso!");
		return REDIRECT_PAGINA_TAGS;
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public String remover(@PathVariable("id") Long id, RedirectAttributes redirectModel) {
		this.tagRepository.deleteById(id);
		redirectModel.addFlashAttribute("msg", "Tag removida com sucesso!");
		return REDIRECT_PAGINA_TAGS;
	}
	
}
