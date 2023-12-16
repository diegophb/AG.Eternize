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

import br.org.eternize.model.Cliente;
import br.org.eternize.repository.ClienteRepository;


@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
 
	// lista todos os dados do banco cliente
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("cliente/index");
		List<Cliente> clientes = clienteRepository.findAll();
		modelAndView.addObject("novoCliente", new Cliente());
		modelAndView.addObject("clientes", clientes);
		
		return modelAndView;
	}
	
	
	 @PostMapping("cadastrar")
	    public ModelAndView cadastrar(@ModelAttribute Cliente novoCliente) {
	        // Lógica para cadastrar o cliente
	     
	        ModelAndView modelAndView = new ModelAndView("redirect:/cliente");
	        clienteRepository.save(novoCliente);
	        return modelAndView;
	    }
	
	 
	 
	 
	 @GetMapping("/{id}/editar")
	 public ModelAndView editar(@PathVariable Long id){
	     ModelAndView modelAndView = new ModelAndView("cliente/edicao");
	     
	     Cliente cliente = clienteRepository.getReferenceById(id);
	     modelAndView.addObject("cliente", cliente);
	     
	     return modelAndView;
	 }

	 @PostMapping("/{id}/editar")
	 public ModelAndView editar(@PathVariable Long id, Cliente cliente) {
	     ModelAndView page = new ModelAndView("redirect:/cliente");

	     Cliente clienteExistente = clienteRepository.findById(id).orElse(null);

	     if (clienteExistente != null) {
	         clienteExistente.setNome(cliente.getNome());
	         clienteExistente.setEmail(cliente.getEmail());
	         clienteExistente.setTelefone(cliente.getTelefone());

	         clienteRepository.saveAndFlush(clienteExistente);
	     }

	     return page;
	 }
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/cliente");
 
		clienteRepository.deleteById(id);
 
		return modelAndView;
	}
	

	
}

