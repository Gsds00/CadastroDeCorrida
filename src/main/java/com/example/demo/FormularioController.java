package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormularioController {

	@Autowired
	private formularioDAO dao;
	
	@GetMapping("/exibirFormulario")
	public String exibirFormulario(Formulario formulario) {
		return"formulario-form";
	}
	
	@PostMapping("/salvarFormulario")
	public String salvarFormulario(Formulario formulario, Model model) {
		dao.save(formulario);
		model.addAttribute("nome", formulario.getNome());
		model.addAttribute("ca", formulario.getCa());
		model.addAttribute("numeroInscricao", formulario.getNumeroInscricao());
		System.out.println(formulario);
	      return"formulario-list";
	}
}
