package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Projeto;
import br.com.senac.repositorio.ProjetoRepositorio;
import br.com.senac.servico.exception.ObjectNotFoundException;

@Service
public class ProjetoService {
	
	@Autowired
	private ProjetoRepositorio repoProj;
	
	public Projeto buscar(Integer id) throws ObjectNotFoundException {
		Optional<Projeto> objUsuario = repoProj.findById(id);
		return objUsuario.orElseThrow(()-> new ObjectNotFoundException("Usuario não encontrado! id: " + id +", Tipo: "+Projeto.class.getName()));
	}
	
	public Projeto inserir(Projeto projeto) {
		projeto.setId(null);
		return repoProj.save(projeto);
	}
	public Projeto alterar(Projeto objUsuario) throws ObjectNotFoundException{
		Projeto objProjetoEncontrado = buscar(objUsuario.getId());
		objProjetoEncontrado.setNome(objUsuario.getNome());
		objProjetoEncontrado.setDescricao(objUsuario.getDescricao());
		objProjetoEncontrado.setLocal(objUsuario.getLocal());
		objProjetoEncontrado.setDataInicio(objUsuario.getDataInicio());
		objProjetoEncontrado.setDataFim(objUsuario.getDataFim());
		objProjetoEncontrado.setStatus(objUsuario.getStatus());
		objProjetoEncontrado.setGeojson(objUsuario.getGeojson());
		return repoProj.save(objProjetoEncontrado);
		
}

public void excluir(Integer id) {
	repoProj.deleteById(id);
	
}

public List< Projeto> listaProjeto(){
	return repoProj.findAll();
}
	
	

}
