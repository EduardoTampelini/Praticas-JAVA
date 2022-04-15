package exercicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
	private Connection connect;

	public AlunoDAO() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/javadb?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String senha = "root";
		connect = DriverManager.getConnection(url, user, senha);
	}

	public int maiorid() throws SQLException {
		int id = 0;
		ResultSet rs = connect.prepareStatement("select max(id) from aluno").executeQuery();
		while (rs.next()) {
			id = rs.getInt(1) + 1;
		}
		rs.close();

		return id;
	}

	public Boolean inserir(Aluno aluno) throws SQLException {

		String sql = "insert into aluno values(?,?,?)";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setInt(1, maiorid());
		ps.setString(2, aluno.getNome());
		ps.setString(3, aluno.getCurso());

		return ps.execute();
	}

	public Boolean atualizar(Aluno aluno)throws SQLException{
	
		String sql = "update aluno set nome= ? where id=?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setString(1, aluno.getNome());
		ps.setInt(2, aluno.getIdAluno());
		ps.execute();
		ps.close();
		return true;
	
	}

	public Boolean deletar(int id) throws SQLException {

		String sql = "delete from aluno where id=?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		ps.close();
		return true;
	}

	public Aluno consultar(int id) throws SQLException {
		String sql = "select * from aluno where id=?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			return new Aluno(rs.getInt("id"), rs.getString("nome"),rs.getString("curso"));
		}
		return null;
	}

	public List<Aluno> consultar() throws SQLException {
		List<Aluno> aluno = new ArrayList<>();
		String sql = "select * from aluno";
		ResultSet rs = connect.prepareStatement(sql).executeQuery();
		while (rs.next()) {
			aluno.add(new Aluno(rs.getInt("id"), rs.getString("nome"),rs.getString("curso")));
		}
		rs.close();
		return aluno;
	}

	public void closeConnection() throws SQLException {
		connect.close();
	}
}
