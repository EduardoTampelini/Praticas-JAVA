package exercicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
	private Connection connect;

	public PessoaDAO() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/javadb?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String senha = "root";
		connect = DriverManager.getConnection(url, user, senha);
	}

	public int maiorid() throws SQLException {
		int id = 0;
		ResultSet rs = connect.prepareStatement("select max(idpessoa) from pessoa").executeQuery();
		while (rs.next()) {
			id = rs.getInt(1) + 1;
		}
		rs.close();

		return id;
	}

	public Boolean inserir(Pessoa pessoa) throws SQLException {

		String sql = "insert into pessoa values(?,?)";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setInt(1, maiorid());
		ps.setString(2, pessoa.getNome());

		return ps.execute();
	}

	public Boolean atualizar(Pessoa pessoa)throws SQLException{
	
		String sql = "update pessoa set nome= ? where idpessoa=?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setString(1, pessoa.getNome());
		ps.setInt(2, pessoa.getIdPessoa());
		ps.execute();
		ps.close();
		return true;
	
	}

	public Boolean deletar(int id) throws SQLException {

		String sql = "delete from pessoa where idpessoa=?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		ps.close();
		return true;
	}

	public Pessoa consultar(int id) throws SQLException {
		String sql = "select * from pessoa where idpessoa=?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			return new Pessoa(rs.getInt("idpessoa"), rs.getString("nome"));
		}
		return null;
	}

	public List<Pessoa> consultar() throws SQLException {
		List<Pessoa> pessoas = new ArrayList<>();
		String sql = "select * from pessoa";
		ResultSet rs = connect.prepareStatement(sql).executeQuery();
		while (rs.next()) {
			pessoas.add(new Pessoa(rs.getInt("idpessoa"), rs.getString("nome")));
		}
		rs.close();
		return pessoas;
	}

	public void closeConnection() throws SQLException {
		connect.close();
	}
}
