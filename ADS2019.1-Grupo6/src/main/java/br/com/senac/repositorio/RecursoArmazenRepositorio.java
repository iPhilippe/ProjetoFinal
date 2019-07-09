package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.dominio.RecursoArmazen;

@Repository
public interface RecursoArmazenRepositorio extends JpaRepository<RecursoArmazen, Integer>{

}
