
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

import br.com.senac.dominio.Usuario;
import br.com.senac.service.UsuarioService;
import br.com.senac.servico.exception.ObjectNotFoundException;
import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
@RequestMapping("/usuario") // view
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;	
	
	@GetMapping("/listarUsuario")//anotacao URL
	public ModelAndView listaUsuarios() {
		ModelAndView mv = new ModelAndView("usuario/paginaUsuario");//nome do arquivo Html
		mv.addObject("usuarios",usuarioService.listaUsuario());
		System.out.println(usuarioService.listaUsuario());
		return mv;
		
	}
	
	//@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins="http://localhost:8080")
	@GetMapping(value="/usuarios", produces = { "application/json" })
	public String allUsuarios(){
		return "Teste";
	} 
	
	
	@GetMapping("/adicionarUsuario")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("usuario/paginaUsuario");
		mv.addObject("usuario", new Usuario());
		mv.addObject("usuarios",usuarioService.listaUsuario());
		return mv;
	}
		
	@PostMapping("/salvarUsuario")
	public String inserir(Usuario usuario) {
		usuarioService.inserir(usuario);
		return "redirect:adicionarUsuario";
	}
	
	@RequestMapping(value = "/excluirUsuario/{id}")	
	public String excluirUsuario(@PathVariable("id") String id) {	
		usuarioService.excluir(new Integer(Integer.parseInt(id)));		
		return "redirect:/usuario/adicionarUsuario";
	}
	
	/*=====[Método para excluir usuário pelo Id]=====*/
	@RequestMapping(value = "/excluirUsuarioPorId")	
	public String excluirUsuarioporId(@RequestParam("idExcluir") String id) {	
		usuarioService.excluir(new Integer(Integer.parseInt(id)));		
		return "redirect:/usuario/adicionarUsuario";
	}
	
	@RequestMapping(value = "/updateUsuario")	
	public ModelAndView updateUsuario
	(		@RequestParam("id") String usuarioid , 
			@RequestParam("nome") String usuarionome,
			@RequestParam("sobrenome") String usuariosobrenome,
			@RequestParam("apelido") String usuarioapelido,
			@RequestParam("telefone") String usuariotelefone,
			@RequestParam("status") String usuariostatus,
			@RequestParam("senha") String usuariosenha){
		Usuario us = new Usuario();
		us.setId(new Integer(Integer.parseInt(usuarioid)));
		us.setNome(usuarionome);
		us.setSobrenome(usuariosobrenome);
		us.setApelido(usuarioapelido);
		us.setTelefone(usuariotelefone);
		us.setStatus(usuariostatus);
		us.setSenha(usuariosenha);
		alterar(us);
		ModelAndView mv = new ModelAndView("usuario/paginaUsuario");
		mv.addObject("usuario", new Usuario());
		mv.addObject("usuarios",usuarioService.listaUsuario());
		return mv;
	}
	
	@GetMapping("alterarUsuario/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id){
		ModelAndView mv = new ModelAndView ("usuario/paginaUsuario");
		mv.addObject("usuario", usuarioService.buscar(id));
		return mv;
		
	}
	@PostMapping("/alterarUsuario")
	public ModelAndView alterar (Usuario usuario) throws ObjectNotFoundException{
		usuarioService.alterar(usuario);
		return listaUsuarios();
	}
}
