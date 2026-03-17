package br.vemprafam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.vemprafam.pojo.Funcionario;

public class DaoFuncionario {

	private String url = "jdbc:hsqldb:hsql://localhost/";
	private String user = "SA";
	private String password = "";

	private Connection conn;

	public DaoFuncionario() {
		try {
			conn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(Funcionario funcionario) {
		String sql = "INSERT INTO FUNCIONARIOS VALUES(?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, funcionario.getRe());
			pstmt.setString(2, funcionario.getNome());
			pstmt.setDate(4,
			  new java.sql.Date(funcionario.getDataAdmissao().getTime()));
			pstmt.setDouble(3, funcionario.getSalario());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Funcionario funcionario) {
		String sql = "UPDATE FUNCIONARIOS "
				+ "SET nome=?, dataAdmissao=?, salario=? WHERE re=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, funcionario.getNome());
			pstmt.setDate(2,
			  new java.sql.Date(funcionario.getDataAdmissao().getTime()));
			pstmt.setDouble(3, funcionario.getSalario());
			pstmt.setInt(4, funcionario.getRe());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Funcionario funcionario) {
		String sql = "DELETE FROM FUNCIONARIOS WHERE re=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, funcionario.getRe());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Funcionario> getLista() {
		List<Funcionario> result = new ArrayList<>();
		String sql = "SELECT * FROM FUNCIONARIOS";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int re = rs.getInt(1);
				String nome = rs.getString(2);
				Date dataAdmissao = rs.getDate(4);
				double salario = rs.getDouble(3);
				result.add(new Funcionario(re,nome,dataAdmissao,salario));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Funcionario buscarPeloRe(int re) {
		String sql = "SELECT * FROM FUNCIONARIOS WHERE re=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, re);
			ResultSet rs = pstmt.executeQuery();
			 if (rs.next()) {
				String nome = rs.getString(2);
				Date dataAdmissao = rs.getDate(4);
				double salario = rs.getDouble(3);
				return new Funcionario(re,nome,dataAdmissao,salario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		DaoFuncionario dao = new DaoFuncionario();
		dao.delete(new Funcionario(3,null,null,null));
	}
}
