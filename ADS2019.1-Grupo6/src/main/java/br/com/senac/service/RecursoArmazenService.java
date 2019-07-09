package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.RecursoArmazen;
import br.com.senac.repositorio.RecursoArmazenRepositorio;

@Service
public class RecursoArmazenService {
	
	@Autowired
	private RecursoArmazenRepositorio rar;
	
	public List<RecursoArmazen> listarRecursosArmazen(){
		System.out.println(rar.findAll().toString());
		return rar.findAll();

	}
}
