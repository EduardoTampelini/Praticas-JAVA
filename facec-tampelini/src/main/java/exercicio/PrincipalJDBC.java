package exercicio;

import java.sql.SQLException;

public class PrincipalJDBC {
public static void main(String [] args) throws SQLException, ClassNotFoundException {
	
	AlunoDAO pd=new AlunoDAO();
	System.out.println("lista com nomes original");
	pd.consultar().forEach(p->{
		System.out.println(p.toString());
	});
	//inserção de Astolfo
	System.out.println("lista com o Astolfo");
	pd.inserir(new Aluno("Astolfo","ADS"));  pd.consultar().forEach(p->{
		System.out.println(p.toString());
	});
	
	System.out.println("lista alterada");
	Aluno altera= new Aluno (4,"altera","ADS");
	
	if(pd.atualizar(altera)) {
	pd.consultar().forEach(p->{
		System.out.println(p.toString());
	});}
	 System.out.println("Lista sem a alteração");
	 if(pd.deletar(4)) {
	 pd.consultar().forEach(p->{
			System.out.println(p.toString());
		});}
	pd.closeConnection();
	
	
}

}