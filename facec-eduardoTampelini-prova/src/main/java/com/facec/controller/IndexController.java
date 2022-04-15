package com.facec.controller;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.facec.model.Veiculo;
import com.facec.repository.VeiculoRepository;


@Controller
public class IndexController {
	
	@Autowired
	VeiculoRepository veiculoRepo;
	
	@RequestMapping("/")
	public String iniciar(Model model) {
		model.addAttribute("mensagem", "Welcome");
		
		
		
		
		model.addAttribute("veiculo", veiculoRepo.findAll());
		
		
		return "index";
		
	}
	@RequestMapping("formulario")
	public String abrirForm(Model model,Veiculo veiculo) {
		model.addAttribute("mensagem", "Formulario");
		return "formulario";
	}
	
	@PostMapping("salvar")
	public String salvar(Veiculo veiculo){
				
		veiculoRepo.save(veiculo);
		
		return "redirect:/";
	}
	
	@GetMapping("editar")
	public String editar(@PathParam(value="id")Long id, Model model){
		model.addAttribute("mensagem", "Formulario");		
		
		model.addAttribute("veiculo",veiculoRepo.getById(id));
		
		
		return "formulario";
	}
	
	@GetMapping("deletar")
	public String deletar(@PathParam(value="id")Long id, Model model){
				
		
		veiculoRepo.deleteById(id);
		
		
		return "redirect:/";
	}
	@PostMapping("editar/salvar")
	public String atualizar(Veiculo veiculo){
				
		veiculoRepo.save(veiculo);
		
		return "redirect:/";
	}
	
	
}
