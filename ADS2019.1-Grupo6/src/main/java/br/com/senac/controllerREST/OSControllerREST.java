package br.com.senac.controllerREST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.dominio.OrdemServico;
import br.com.senac.service.OrdemServicoService;

/**
 * 
 * @author rodrigo.moreira em 19/06/2019
 *
 */

@RestController
@RequestMapping("/OSAPI")
public class OSControllerREST {
	
	@Autowired
	private OrdemServicoService ordemservicoService;
	
	private Map<Integer, OrdemServico> oshas;
	
	@RequestMapping(value = "/todasOS", method = RequestMethod.GET)
	public ResponseEntity<List<OrdemServico>> ObterTodasAsOS() {
		List<OrdemServico> os = new ArrayList<OrdemServico>();
		os = ordemservicoService.listaOrdemServico();	
		oshas = new HashMap<Integer, OrdemServico>();
		int cont = 1;
		for (OrdemServico ordemServicoItem : os) {							
			oshas.put(cont, ordemServicoItem);	
			cont++;							
		}
		return new ResponseEntity<List<OrdemServico>>(new ArrayList<OrdemServico>(oshas.values()), HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/os", method = RequestMethod.GET)
	public ResponseEntity<List<OrdemServico>> ObterOSPorProjeto(@RequestParam("projetoId") int projetoId) {
		List<OrdemServico> os = new ArrayList<OrdemServico>();
		os = ordemservicoService.listaOrdemServico();		
		oshas = new HashMap<Integer, OrdemServico>();
		int cont = 1;
		for (OrdemServico ordemServicoItem : os) {			
			if ((ordemServicoItem.getProjeto().getId()) == projetoId) {					
				oshas.put(cont, ordemServicoItem);	
				cont++;
			}			
		}
		return new ResponseEntity<List<OrdemServico>>(new ArrayList<OrdemServico>(oshas.values()), HttpStatus.OK);		
	}

}
