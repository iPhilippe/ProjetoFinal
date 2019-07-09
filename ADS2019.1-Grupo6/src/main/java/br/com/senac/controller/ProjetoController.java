package br.com.senac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import br.com.senac.dominio.Projeto;
import br.com.senac.service.ProjetoService;
import br.com.senac.servico.exception.ObjectNotFoundException;
import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
@RequestMapping("/projeto") // view

public class ProjetoController {
	@Autowired
	private ProjetoService projetoService;	
	
	@GetMapping("/listarProjeto")//anotacao URL
	public ModelAndView listaProjeto() {
		ModelAndView mv = new ModelAndView("projeto/paginaProjeto");//nome do arquivo Html
		mv.addObject("projetos",projetoService.listaProjeto());
		System.out.println(projetoService.listaProjeto());
		return mv;
		
	}
	
	//@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins="http://localhost:8080")
	@GetMapping(value="/projeto", produces = { "application/json" })
	public String allProjeto(){
		return "Teste";
	} 
	
	
	@GetMapping("/adicionarProjeto")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("projeto/paginaProjeto");
		mv.addObject("projeto", new Projeto());
		mv.addObject("projetos",projetoService.listaProjeto());
		return mv;
	}
		
	@PostMapping("/salvarProjeto")
	public String inserir(Projeto projeto) {
		projetoService.inserir(projeto);
		return "redirect:adicionarProjeto";
	}
	
	@RequestMapping(value = "/excluirProjeto/{id}")	
	public String excluirProjeto(@PathVariable("id") String id) {	
		projetoService.excluir(new Integer(Integer.parseInt(id)));		
		return "redirect:/projeto/adicionarProjeto";
	}
	
	
	@RequestMapping(value = "/excluirProjetoPorId")	
	public String excluirpProjetoporId(@RequestParam("idExcluir") String id) {	
		projetoService.excluir(new Integer(Integer.parseInt(id)));		
		return "redirect:/projeto/adicionarProjeto";
	}
	
	@RequestMapping(value = "/updateProjeto")	
	public ModelAndView updateProjeto
	(		@RequestParam("id") String projetoid , 
			@RequestParam("nome") String projetonome,
			@RequestParam("descricao") String projetodescricao,
			@RequestParam("local") String projetolocal,
			@RequestParam("dataInicio") String projetodtinicio,
			@RequestParam("dataFim") String projetodtfim,
			@RequestParam("status") String projetostatus,
			@RequestParam("geojson") String projetogeojson){
		Projeto pro = new Projeto();
		pro.setId(new Integer(Integer.parseInt(projetoid)));
		pro.setNome(projetonome);
		pro.setDescricao(projetodescricao);
		pro.setLocal(projetolocal);
		pro.setDataInicio(projetodtinicio);
		pro.setDataFim(projetodtfim);
		pro.setStatus(projetostatus);
		pro.setGeojson(projetogeojson);
		alterar(pro);
		
		ModelAndView mv = new ModelAndView("projeto/paginaProjeto");
		mv.addObject("projeto", new Projeto());
		mv.addObject("projetos",projetoService.listaProjeto());
		return mv;
	}
	
	@GetMapping("alterarProjeto/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id){
		ModelAndView mv = new ModelAndView ("projeto/paginaProjeto");
		mv.addObject("projeto", projetoService.buscar(id));
		return mv;
		
	}
	@PostMapping("/alterarProjeto")
	public ModelAndView alterar (Projeto projeto) throws ObjectNotFoundException{
		projetoService.alterar(projeto);
		return listaProjeto();
	}
	
	
		
}
