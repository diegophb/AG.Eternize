package br.org.eternize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class HomeController {		
		@GetMapping
		public ModelAndView mostrar(HttpSession session) {
			ModelAndView page = new ModelAndView("home/index");
			return page;
		}
}
