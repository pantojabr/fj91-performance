package br.com.caelum.fj91.performance.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.caelum.fj91.performance.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	@Query("SELECT DISTINCT(c) FROM Curso c JOIN FETCH c.categoria JOIN FETCH c.instrutor LEFT JOIN FETCH c.tags")
	List<Curso> findAll();

	@Query("SELECT DISTINCT(c) FROM Curso c JOIN FETCH c.categoria LEFT JOIN FETCH c.tags ORDER BY c.dataDeLancamento DESC")
	List<Curso> ultimosLancamentos(Pageable limite);

}
