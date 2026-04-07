package br.vemprafam.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.vemprafam.dao.DaoAluno;
import br.vemprafam.dao.DaoFuncionario;
import br.vemprafam.pojo.Aluno;
import br.vemprafam.pojo.Funcionario;

@Controller
@RequestMapping("/alunos")
public class AlunosController {
	@GetMapping
	String showAlunosHomeVazio(Model model) {
		return "alunos";
	}
	@GetMapping("/")
	String showAlunosHome(Model model) {
		return "alunos";
	}
	@GetMapping("/new")
	public String showFormAlunos(Model model) {
		Aluno aluno = new Aluno();
		model.addAttribute("aluno", aluno );
		return "create-aluno";
	}
	DaoAluno dao = new DaoAluno();
	@PostMapping
	public String insert(@ModelAttribute Aluno aluno) {
		dao.insert(aluno);
		return "redirect:alunos";
	}
	@GetMapping("/list")
	public String showAlunosList(Model model) {
		List<Aluno> alunos = dao.getLista();
		model.addAttribute("alunos", alunos);
		return "alunos-list";
	}
}
