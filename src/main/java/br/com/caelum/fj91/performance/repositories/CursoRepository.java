package br.com.caelum.fj91.performance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caelum.fj91.performance.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	List<Curso> findAllByOrderByDataDeLancamentoDesc();

}
