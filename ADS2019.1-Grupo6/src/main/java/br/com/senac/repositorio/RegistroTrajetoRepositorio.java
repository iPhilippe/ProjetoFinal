package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.dominio.RegistroTrajeto;

@Repository
public interface RegistroTrajetoRepositorio extends JpaRepository<RegistroTrajeto, Integer>{

}
