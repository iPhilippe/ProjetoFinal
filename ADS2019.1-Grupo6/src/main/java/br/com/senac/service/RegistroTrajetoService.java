package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.senac.dominio.RegistroTrajeto;
import br.com.senac.repositorio.RegistroTrajetoRepositorio;
import br.com.senac.servico.exception.ObjectNotFoundException;

@Service
public class RegistroTrajetoService {
	
	@Autowired
	private RegistroTrajetoRepositorio repoRegistroTrajeto;
	
	public RegistroTrajeto buscar(Integer id) throws ObjectNotFoundException {
		Optional<RegistroTrajeto> objRegistroTrajeto = repoRegistroTrajeto.findById(id);
		return objRegistroTrajeto.orElseThrow(()-> new ObjectNotFoundException("Usuario não encontrado! id: " + id +", Tipo: "+RegistroTrajeto.class.getName()));
	}
	
	public RegistroTrajeto inserir(RegistroTrajeto registroTrajeto) {
		registroTrajeto.setId(null);
		return repoRegistroTrajeto.save(registroTrajeto);
	}
	public RegistroTrajeto alterar(RegistroTrajeto objRegistroTrajeto) throws ObjectNotFoundException{
		RegistroTrajeto objRegistroTrajetoEncontrado = buscar(objRegistroTrajeto.getId());
		objRegistroTrajetoEncontrado.setLat(objRegistroTrajeto.getLat());
		objRegistroTrajetoEncontrado.setLongitude(objRegistroTrajeto.getLongitude());
		objRegistroTrajetoEncontrado.setOrdem(objRegistroTrajeto.getOrdem());
		objRegistroTrajetoEncontrado.setOrdemServico(objRegistroTrajeto.getOrdemServico());
		objRegistroTrajetoEncontrado.setProjeto(objRegistroTrajeto.getProjeto());
		objRegistroTrajetoEncontrado.setTipoTrajeto(objRegistroTrajeto.getTipoTrajeto());
		objRegistroTrajetoEncontrado.setTrajetotipo(objRegistroTrajeto.getTrajetotipo());		
		return repoRegistroTrajeto.save(objRegistroTrajetoEncontrado);
		
}

public void excluir(Integer id) {
	repoRegistroTrajeto.deleteById(id);
	
}

public List<RegistroTrajeto> listaTrajeto(){
	return repoRegistroTrajeto.findAll();
}

}
