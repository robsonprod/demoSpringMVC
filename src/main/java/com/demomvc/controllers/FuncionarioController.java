package com.demomvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demomvc.domain.Cargo;
import com.demomvc.domain.Funcionario;
import com.demomvc.domain.UF;
import com.demomvc.service.CargoService;
import com.demomvc.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcService;
	@Autowired
	private CargoService cargoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "/funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionarios", funcService.buscarTodos());
		return "/funcionario/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario, RedirectAttributes attr) {
		funcService.salvar(funcionario);
		attr.addFlashAttribute("success", "Funcionario inserido com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionario", funcService.buscaPorId(id));
		
		return "funcionario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Funcionario funcionario, RedirectAttributes attr) {
		funcService.editar(funcionario);
		attr.addFlashAttribute("success","Funcionário editado com sucesso.");
		
		return "redirect:/funcionarios/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		funcService.excluir(id);
		attr.addFlashAttribute("success", "Funcionário removido com sucesso");
		
		return "redirect:/funcionarios/listar";
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> getCargos(){
		return cargoService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUfs() {
		return UF.values();
	}
}
