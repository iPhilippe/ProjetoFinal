package br.com.senac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.RecursoArmazen;
import br.com.senac.service.RecursoArmazenService;

@Controller
@RequestMapping("/recursosArmazen")
public class RecursoArmazenController {
	
	private RecursoArmazenService ras;
	
	@GetMapping("listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("recurso/paginaAdicionarRecurso");
		mv.addObject("recursosArmazem", new RecursoArmazen());
		mv.addObject("recursoArmazenlista", ras.listarRecursosArmazen());
		
		return mv;
	}

}
