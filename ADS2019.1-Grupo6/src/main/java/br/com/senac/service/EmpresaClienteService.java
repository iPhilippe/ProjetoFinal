package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.senac.dominio.EmpresaCliente;
import br.com.senac.repositorio.EmpresaClienteRepositorio;
import br.com.senac.servico.exception.ObjectNotFoundException;

@Service
public class EmpresaClienteService {
	
	private EmpresaClienteRepositorio repoEmpresaCliente;
	
	public EmpresaCliente buscar(Integer id) throws ObjectNotFoundException {
		Optional<EmpresaCliente> objEmpresaCliente = repoEmpresaCliente.findById(id);
		return objEmpresaCliente.orElseThrow(()-> new ObjectNotFoundException("Usuario não encontrado! id: " + id +", Tipo: "+EmpresaCliente.class.getName()));
	}
	
	public EmpresaCliente inserir(EmpresaCliente projeto) {
		projeto.setId(null);
		return repoEmpresaCliente.save(projeto);
	}
	public EmpresaCliente alterar(EmpresaCliente objEmpresaCliente) throws ObjectNotFoundException{
		EmpresaCliente objEmpresaClienteEncontrado = buscar(objEmpresaCliente.getId());
		objEmpresaClienteEncontrado.setNome(objEmpresaCliente.getNome());
		return repoEmpresaCliente.save(objEmpresaCliente);
		
}

public void excluir(Integer id) {
	repoEmpresaCliente.deleteById(id);
	
}

public List< EmpresaCliente> listaProjeto(){
	return repoEmpresaCliente.findAll();
}

}
