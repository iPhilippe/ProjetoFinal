package br.com.senac.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import br.com.senac.dominio.OrdemServico;
import br.com.senac.dominio.Usuario;
import br.com.senac.service.OrdemServicoService;
import br.com.senac.service.UsuarioService;

@Controller
@RequestMapping("/OS") // view
public class OrdemServicoController {

	@Autowired
	private OrdemServicoService ordemservicoService;
	
	@Autowired
	private UsuarioService usuarioService;	

	@GetMapping("/listarOrdem") // anotacao URL
	public ModelAndView listaOrdem() {
		ModelAndView mv = new ModelAndView("OS/paginaOrdem");// nome do arquvo Html
		mv.addObject("ordemdeservico", ordemservicoService.listaOrdemServico());
		return mv;

	}

	@GetMapping("/adicionarOrdem")
	public ModelAndView addordem() {
		ModelAndView mv2 = new ModelAndView("OS/paginaAdicionarOrdem");
		mv2.addObject("ordemdeservico", new OrdemServico());
		mv2.addObject("ordemDeServicos", ordemservicoService.listaOrdemServico());
		mv2.addObject("usuariolista", usuarioService.listaUsuario());
		return mv2;
	}

	@PostMapping("/salvarOrdem")	
	public String inserir(OrdemServico ordemdeservico) throws ParseException {		
		ordemservicoService.inserir(ordemdeservico);
		return "redirect:adicionarOrdem";
	}

	@PostMapping("/excluirOrdem/{id}")
	public String delete(@RequestParam("id") String OSid) {
		ordemservicoService.excluir(new Integer(Integer.parseInt(OSid)));
		return "redirect:adicionarOrdem";
	}


	
	@RequestMapping(value = "/updateOrdem")	
	public String updateUsuario
	(		@RequestParam("osid") String OSid , 
			@RequestParam("osdescricao") String OSdescricao,
			@RequestParam("oslocal") String OSlocal,
			@RequestParam("osdatainicio") String OSdataDeAbertura,
			@RequestParam("osdatafim") String OSdataDeFechamento,
			@RequestParam("oscontratista") String OScontratista,
			@RequestParam("osstatus") String OSstatus,
			@RequestParam("osusuario") Usuario OSUsuario){
		OrdemServico os = new OrdemServico();
		os.setId(new Integer(Integer.parseInt(OSid)));
		os.setDescricao(OSdescricao);
		os.setLocal(OSlocal);
		os.setDataDeAbertura(OSdataDeAbertura);
		os.setDataDeFechamento(OSdataDeFechamento);
		os.setContratista(OScontratista);
		os.setStatus(OSstatus);
		os.setUsuario(OSUsuario);
		alterar(os);
		return "redirect:adicionarOrdem";
	}
	
	
	@GetMapping("alterarOrdem/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id){
		ModelAndView mv = new ModelAndView ("OS/paginaAdicionarOrdem");
		mv.addObject("OS", usuarioService.buscar(id));
		return mv;
		
	}
	
	
	@GetMapping("/alterarOrdem")
	public ModelAndView alterar(OrdemServico os) {
		ModelAndView mv = new ModelAndView("OS/paginaAdicionarOrdem");
		mv.addObject("OS", ordemservicoService.alterar(os));
		return mv;

	}
	
	
}
