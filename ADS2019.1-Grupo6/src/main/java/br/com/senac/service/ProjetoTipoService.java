package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.ProjetoTipo;
import br.com.senac.repositorio.ProjetoTipoRepositorio;
import br.com.senac.servico.exception.ObjectNotFoundException;

@Service
public class ProjetoTipoService {
	
	@Autowired
	private ProjetoTipoRepositorio repoProjTipo;
	
	public ProjetoTipo buscar(Integer id) throws ObjectNotFoundException {
		Optional<ProjetoTipo> objProjetoTipo = repoProjTipo.findById(id);
		return objProjetoTipo.orElseThrow(()-> new ObjectNotFoundException("Projeto Tipo não encontrado! id: " + id +", Tipo: "+ProjetoTipo.class.getName()));
	}
	
	public ProjetoTipo inserir(ProjetoTipo projeto) {
		projeto.setId(null);
		return repoProjTipo.save(projeto);
	}
	
	public ProjetoTipo alterar(ProjetoTipo objProjetoTipo) throws ObjectNotFoundException{
		ProjetoTipo objProjetoTipoEncontrado = buscar(objProjetoTipo.getId());
		objProjetoTipoEncontrado.setDescricao(objProjetoTipo.getDescricao());
		objProjetoTipoEncontrado.setStatus(objProjetoTipo.getStatus());
		
		return repoProjTipo.save(objProjetoTipoEncontrado);
		
}

public void excluir(Integer id) {
	repoProjTipo.deleteById(id);
	
}

public List<ProjetoTipo> listaProjeto(){
	return repoProjTipo.findAll();
}

}
