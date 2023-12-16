package br.org.eternize.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



import br.org.eternize.model.Destino;
import br.org.eternize.repository.DestinoRepository;


@Controller
@RequestMapping("/destino")
public class DestinoController {

	@Autowired
	private DestinoRepository destinoRepository;
 
	// lista todos os dados do banco cliente
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("destino/index");
		List<Destino> destinos = destinoRepository.findAll();
		modelAndView.addObject("novoDestino", new Destino());
		modelAndView.addObject("destinos", destinos);
		
		return modelAndView;
	}
	
	
	 @PostMapping("cadastrar")
	    public ModelAndView cadastrar(@ModelAttribute Destino novoDestino ,@RequestParam("fileDestino") MultipartFile file) {
			try {
				novoDestino.setImagem(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
	        ModelAndView modelAndView = new ModelAndView("redirect:/destino");
	        destinoRepository.save(novoDestino);
	        return modelAndView;
	    }
	
	 
	 @GetMapping("/imagem/{id}")
		@ResponseBody
		public byte[] exibirImagen(@PathVariable("id") Long id) {
			Destino destino = this.destinoRepository.getReferenceById(id);
			return destino.getImagem();
		}
	 
	 @GetMapping("/{id}/editar")
	 public ModelAndView editar(@PathVariable Long id){
	     ModelAndView modelAndView = new ModelAndView("destino/edicao");
	     
	     Destino destino = destinoRepository.getReferenceById(id);
	     modelAndView.addObject("destino", destino);
	     
	     return modelAndView;
	 }

	 @PostMapping("/{id}/editar")
	 public ModelAndView editar(@PathVariable Long id, Destino destino,@RequestParam("fileDestino") MultipartFile file) {
		 try {
				destino.setImagem(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		 
		 ModelAndView page = new ModelAndView("redirect:/destino");

	     Destino destinoExistente = destinoRepository.findById(id).orElse(null);

	     if (destinoExistente != null) {
	    	 destinoExistente.setNome(destino.getNome());
	    	 destinoExistente.setValor(destino.getValor());
	    	 destinoExistente.setImagem(destino.getImagem());
	    	 ;

	         destinoRepository.saveAndFlush(destinoExistente);
	     }

	     return page;
	 }
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/destino");
 
		destinoRepository.deleteById(id);
 
		return modelAndView;
	}
	

	
}

