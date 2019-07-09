package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.dominio.UnidadeMedida;

public interface UnidadeMedidaRepositorio  extends JpaRepository<UnidadeMedida, Integer>{

}
