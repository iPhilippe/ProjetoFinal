package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.Recurso;
import br.com.senac.service.RecursoService;
import br.com.senac.servico.exception.ObjectNotFoundException;

@Controller
@RequestMapping("/recurso")
public class RecursoController {
/*
	@Autowired
	private RecursoService recursoService;
	
	@GetMapping("/listarRecurso")//anotacao URL
	public ModelAndView listaRecurso() {
		ModelAndView mv = new ModelAndView("recurso/paginaAdicionarRecurso");//nome do arquvo Html
		mv.addObject("recurso",recursoService.listaRecurso());
		return mv;
		
	}
	@GetMapping("/adicionarRecurso")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("recurso/paginaAdicionarRecurso");
		mv.addObject("recurso", new Recurso());
		mv.addObject("recurso",recursoService.listaRecurso());
		return mv;
	}
	@PostMapping("/salvarRecurso")
	public ModelAndView inserir(Recurso recurso) {
		recursoService.inserir(recurso);
		return listaRecurso();
	}
	@GetMapping("excluirRecurso/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id){
		recursoService.excluir(id);
		return listaRecurso();
	}
	@GetMapping("alterarRecurso/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id){
		ModelAndView mv = new ModelAndView ("recurso/paginaAdicionarRecurso");
		mv.addObject("recurso", recursoService.buscar(id));
		return mv;
		
	}
	@PostMapping("/alterarRecurso")
	public ModelAndView alterar (Recurso recurso) throws ObjectNotFoundException{
		recursoService.alterar(recurso);
		return listaRecurso();
	}*/
	}


