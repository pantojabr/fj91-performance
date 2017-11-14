package br.com.caelum.fj91.performance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caelum.fj91.performance.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
}
