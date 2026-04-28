package br.vemprafam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.vemprafam.dao.DaoFuncionario;
import br.vemprafam.pojo.Funcionario;

@Controller
@RequestMapping("/funcionarios")
public class FuncionariosController {
    @Autowired
	DaoFuncionario dao;
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
	@GetMapping("/excluir")
	public String showExcluir() {
		return "excluir-funcionario";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam int re) {
		Funcionario f = dao.buscarPeloRe(re);
		dao.delete(f);
		return "funcionarios";
	}
	@GetMapping("/busca")
	public String showBusca() {
		return "buscar-funcionario";
	}

	@GetMapping("/showUpdate")
	public String showUpdate(@RequestParam int re, Model model) {
		Funcionario funcionario = dao.buscarPeloRe(re);
		model.addAttribute("funcionario", funcionario);
		return "alterar-funcionario";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute Funcionario funcionario) {
		dao.update(funcionario);
		return "funcionarios";
	}
}
