package br.vemprafam.pojo;

import java.util.Date;

public class Funcionario {
	private Integer re;
	private String nome;
	private Date dataAdmissao;
	private Double salario;
	public Funcionario() {
		super();
	}
	public Funcionario(Integer re, String nome, Date dataAdmissao, Double salario) {
		super();
		this.re = re;
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
	}
	public Integer getRe() {
		return re;
	}
	public void setRe(Integer re) {
		this.re = re;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Funcionario [re=" + re + ", nome=" + nome + ", dataAdmissao=" + dataAdmissao + ", salario=" + salario
				+ "]";
	}
}
