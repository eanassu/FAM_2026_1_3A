package br.vemprafam.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.vemprafam.dao.DaoFuncionario;
import br.vemprafam.pojo.Funcionario;

@Controller
@RequestMapping("/funcionarios")
public class FuncionariosController {

	@GetMapping
	String showFuncionariosHomeVazio(Model model) {
		return "funcionarios";
	}
	@GetMapping("/")
	String showFuncionariosHome(Model model) {
		return "funcionarios";
	}
	@GetMapping("/new")
	public String showFormFuncionarios(Model model) {
		Funcionario func = new Funcionario();
		model.addAttribute("funcionario", func );
		return "create-funcionario";
	}
	DaoFuncionario dao = new DaoFuncionario();
	@PostMapping
	public String insert(@ModelAttribute Funcionario func) {
		dao.insert(func);
		return "redirect:funcionarios";
	}
	@GetMapping("/list")
	public String getList(Model model) {
		List<Funcionario> funcionarios = dao.getLista();
		model.addAttribute("funcionarios", funcionarios);
		return "funcionarios-list";
	}
}
