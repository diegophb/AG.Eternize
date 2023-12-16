package br.org.eternize.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.org.eternize.model.Pacote;
import br.org.eternize.repository.PacoteRepository;


@Controller
@RequestMapping("/pacote")
public class PacoteController {

	@Autowired
	private PacoteRepository pacoteRepository;
 

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("pacote/index");
		List<Pacote> pacotes = pacoteRepository.findAll();
		modelAndView.addObject("novoPacote", new Pacote());
		modelAndView.addObject("pacotes", pacotes);
		
		return modelAndView;
	}
	
	
	 @PostMapping("cadastrar")
	    public ModelAndView cadastrar(@ModelAttribute Pacote novoPacote) {
	       
	        ModelAndView modelAndView = new ModelAndView("redirect:/pacote");
	        pacoteRepository.save(novoPacote);
	        return modelAndView;
	    }
	
	 	 
	 @GetMapping("/{id}/editar")
	 public ModelAndView editar(@PathVariable Long id){
	     ModelAndView modelAndView = new ModelAndView("pacote/edicao");
	     
	     Pacote pacote = pacoteRepository.getReferenceById(id);
	     modelAndView.addObject("pacote", pacote);
	     
	     return modelAndView;
	 }

	 @PostMapping("/{id}/editar")
	 public ModelAndView editar(@PathVariable Long id, Pacote pacote) {
	     ModelAndView page = new ModelAndView("redirect:/pacote");

	     Pacote pacoteExistente = pacoteRepository.findById(id).orElse(null);

	     if (pacoteExistente != null) {
	    	 pacoteExistente.setNome(pacote.getNome());
	    	 pacoteExistente.setValor(pacote.getValor());
	    	 ;

	         pacoteRepository.saveAndFlush(pacoteExistente);
	     }

	     return page;
	 }
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/pacote");
 
		pacoteRepository.deleteById(id);
 
		return modelAndView;
	}
	

	
}

