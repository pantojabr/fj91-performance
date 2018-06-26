package br.com.caelum.fj91.performance.services;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.caelum.fj91.performance.models.Instrutor;
import br.com.caelum.fj91.performance.repositories.InstrutorRepository;

@Service
public class InstrutorService {
	
	private final InstrutorRepository repository;
	
	public InstrutorService(InstrutorRepository repository) {
		this.repository = repository;
	}

	@Cacheable("instrutores")
	public List<Instrutor> buscarTodosOrdenadosPeloNome() {
		return repository.findAll(Sort.by("nome"));
	}

	@CacheEvict(value = "instrutores", allEntries = true)
	public void salvar(Instrutor instrutor) {
		repository.save(instrutor);
	}

	@CacheEvict(value = "instrutores", allEntries = true)
	public void excluirPorId(Long id) {
		repository.deleteById(id);
	}
	
}
