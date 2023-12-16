package br.org.eternize.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.org.eternize.model.Cliente;
import br.org.eternize.model.Destino;
import br.org.eternize.model.Pacote;
import br.org.eternize.model.Reserva;
import br.org.eternize.repository.ClienteRepository;
import br.org.eternize.repository.DestinoRepository;
import br.org.eternize.repository.PacoteRepository;
import br.org.eternize.repository.ReservaRepository;


@Controller
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private DestinoRepository destinoRepository;
	
	@Autowired
	private PacoteRepository pacoteRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
 
	// lista todos os dados do banco cliente
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("reserva/index");
		List<Reserva> reservas = reservaRepository.findAll();
		modelAndView.addObject("novoReserva", new Reserva());
		modelAndView.addObject("reservas", reservas);
		
		List<Destino> destinos = destinoRepository.findAll();
		modelAndView.addObject("novoDestino", new Destino());
		modelAndView.addObject("destinos", destinos);
	
		List<Pacote> pacotes = pacoteRepository.findAll();
		modelAndView.addObject("novoPacote", new Pacote());
		modelAndView.addObject("pacotes", pacotes);
		
		List<Cliente> clientes = clienteRepository.findAll();
		modelAndView.addObject("novoCliente", new Cliente());
		modelAndView.addObject("clientes", clientes);
	 
		
		
		
		modelAndView.addObject("reservas", reservas);
		
		return modelAndView;
	}
	
	
	 @PostMapping("cadastrar")
	    public ModelAndView cadastrar(@ModelAttribute Reserva novoReserva) {
		 ModelAndView modelAndView = new ModelAndView("redirect:/reserva");  
		 
		 List<Destino> destinos = destinoRepository.findAll();
		 modelAndView.addObject("destinos", destinos);
		 
			List<Pacote> pacotes = pacoteRepository.findAll();
			modelAndView.addObject("novoPacote", new Pacote());
			modelAndView.addObject("pacotes", pacotes);
			
			List<Cliente> clientes = clienteRepository.findAll();
			modelAndView.addObject("novoCliente", new Cliente());
			modelAndView.addObject("clientes", clientes);
		 
	       
	        reservaRepository.save(novoReserva);
	        return modelAndView;
	    }
	
	 
	 
	 
	 @GetMapping("/{id}/editar")
	 public ModelAndView editar(@PathVariable Long id) {
	     ModelAndView modelAndView = new ModelAndView("reserva/edicao");

	     Reserva reserva = reservaRepository.findById(id).orElse(null);

	     if (reserva != null) {
	         modelAndView.addObject("reserva", reserva);
	     }

	     List<Destino> destinos = destinoRepository.findAll();
	     modelAndView.addObject("destinos", destinos);

	     List<Pacote> pacotes = pacoteRepository.findAll();
	     modelAndView.addObject("novoPacote", new Pacote());
	     modelAndView.addObject("pacotes", pacotes);

	     List<Cliente> clientes = clienteRepository.findAll();
	     modelAndView.addObject("novoCliente", new Cliente());
	     modelAndView.addObject("clientes", clientes);

	     return modelAndView;
	 }


	 @PostMapping("/{id}/editar")
	 public ModelAndView editar(@PathVariable Long id, Reserva reserva) {
	     ModelAndView page = new ModelAndView("redirect:/reserva");

	     Reserva reservaExistente = reservaRepository.findById(id).orElse(null);

	     if (reservaExistente != null) {
	    	 reservaExistente.setDestino(reserva.getDestino());
	    	 reservaExistente.setValor(reserva.getValor());
	    	 reservaExistente.setCliente(reserva.getCliente());
	    	 reservaExistente.setData_reserva(reserva.getData_reserva());
	    	 reservaExistente.setPacote(reserva.getPacote());
	    	 ;

	    	 reservaRepository.saveAndFlush(reservaExistente);
	     }

	     return page;
	 }
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/reserva");
 
		reservaRepository.deleteById(id);
 
		return modelAndView;
	}
	
	

	
}

