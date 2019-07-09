package br.com.senac.controllerRESTMAPA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.dominio.RegistroTrajeto;
import br.com.senac.service.RegistroTrajetoService;

@RestController
@RequestMapping("/MAPA")
public class MapaControllerREST {
	
	private RegistroTrajetoService registroTrajetoService;
	
	private Map<Integer, RegistroTrajeto> registroTrajetohas;
	
	@RequestMapping(value = "/trajeto", method = RequestMethod.GET)
	public ResponseEntity<List<RegistroTrajeto>> ObterOSPorProjeto(@RequestParam("projetoId") int projetoId) {
		System.out.println(projetoId);
		List<RegistroTrajeto> rt = new ArrayList<RegistroTrajeto>();
		rt = registroTrajetoService.listaTrajeto();	
		registroTrajetohas = new HashMap<Integer, RegistroTrajeto>();
		int cont = 1;
		for (RegistroTrajeto trajetos : rt) {			
			if ((trajetos.getProjeto().getId()) == projetoId) {					
				registroTrajetohas.put(cont, trajetos);	
				cont++;
			}			
		}
		return new ResponseEntity<List<RegistroTrajeto>>(new ArrayList<RegistroTrajeto>(registroTrajetohas.values()), HttpStatus.OK);		
	}

}
