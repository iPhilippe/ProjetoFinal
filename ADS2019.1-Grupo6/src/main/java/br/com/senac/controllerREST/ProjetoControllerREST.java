package br.com.senac.controllerREST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.dominio.OrdemServico;
import br.com.senac.dominio.Usuario;
import br.com.senac.service.UsuarioService;

/**
 * 
 * @author rodrigo.moreira em 21/06/2019
 *
 */

@RestController
@RequestMapping("/projetosAPI")
public class ProjetoControllerREST {
	
	/*
	private Map<Integer, Projeto> projetohas;
	
	
	@RequestMapping(value = "/todosProjetos", method = RequestMethod.GET)
	public ResponseEntity<List<Projeto>> ObterTodasAsOS() {
		List<Projeto> pj = new ArrayList<Projeto>();
		pj = ordemservicoService.listaOrdemServico();	
		projetohas = new HashMap<Integer, Projeto>();
		int cont = 1;
		for (Projeto projetoItem : pj) {							
			projetohas.put(cont, projetoItem);	
			cont++;				
						
		}
		return new ResponseEntity<List<Projeto>>(new ArrayList<Projeto>(projetohas.values()), HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/projetos", method = RequestMethod.GET)
	public ResponseEntity<List<Projeto>> ObterOSPorProjeto(@RequestParam("projetoId") int projetoId) {
		List<Projeto> pj = new ArrayList<Projeto>();
		pj = ordemservicoService.listaOrdemServico();		
		oshas = new HashMap<Integer, Projeto>();
		int cont = 1;
		for (Projeto projetoItem : pj) {			
			if ((projetoItem.getProjeto_id()) == projetoId) {					
				projetohas.put(cont, projetoItem);	
				cont++;
			}			
		}
		return new ResponseEntity<List<Projeto>>(new ArrayList<Projeto>(projetohas.values()), HttpStatus.OK);		
	}*/
}
