package br.com.caelum.fj91.performance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.caelum.fj91.performance.models.Categoria;
import br.com.caelum.fj91.performance.services.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	private static final String PAGINA_CATEGORIAS = "categorias/categorias";
	private static final String PAGINA_CADASTRO_CATEGORIA = "categorias/categoria-form";
	private static final String REDIRECT_PAGINA_CATEGORIAS = "redirect:/categorias";
	
	private final CategoriaService categoriaService;

	public CategoriasController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("categorias", categoriaService.buscarTodasOrdenadasPeloNome());
		return PAGINA_CATEGORIAS;
	}
	
	@GetMapping("/form")
	public String form() {
		return PAGINA_CADASTRO_CATEGORIA;
	}
	
	@PostMapping
	@Transactional
	public String adicionar(Categoria categoria, RedirectAttributes redirectModel) {
		this.categoriaService.salvar(categoria);
		redirectModel.addFlashAttribute("msg", "Categoria adicionada com sucesso!");
		return REDIRECT_PAGINA_CATEGORIAS;
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public String remover(@PathVariable("id") Long id, RedirectAttributes redirectModel) {
		this.categoriaService.excluirPorId(id);
		redirectModel.addFlashAttribute("msg", "Categoria removida com sucesso!");
		return REDIRECT_PAGINA_CATEGORIAS;
	}
	
}
