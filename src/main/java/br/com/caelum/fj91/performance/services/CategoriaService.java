package br.com.caelum.fj91.performance.services;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.caelum.fj91.performance.models.Categoria;
import br.com.caelum.fj91.performance.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	private final CategoriaRepository repository;
	
	public CategoriaService(CategoriaRepository repository) {
		this.repository = repository;
	}

	@Cacheable("categorias")
	public List<Categoria> buscarTodasOrdenadasPeloNome() {
		return repository.findAll(Sort.by("nome"));
	}

	@CacheEvict(value = "categorias", allEntries = true)
	public void salvar(Categoria categoria) {
		repository.save(categoria);
	}

	@CacheEvict(value = "categorias", allEntries = true)
	public void excluirPorId(Long id) {
		repository.deleteById(id);
	}
	
}
