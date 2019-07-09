package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senac.dominio.Projeto;

@Repository
public interface ProjetoRepositorio extends JpaRepository<Projeto, Integer> {

	@Query("Select a from Projeto a where a.nome=?1")
	Projeto findByNome(String nome);
	
	
}
