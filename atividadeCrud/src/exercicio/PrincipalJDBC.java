package exercicio;

import java.sql.SQLException;

public class PrincipalJDBC {
public static void main(String [] args) throws SQLException, ClassNotFoundException {
	
	PessoaDAO pd=new PessoaDAO();
	System.out.println("lista com nomes original");
	pd.consultar().forEach(p->{
		System.out.println(p.toString());
	});
	//inserção de Astolfo
	System.out.println("lista com o Astolfo");
	pd.inserir(new Pessoa("Astolfo"));  pd.consultar().forEach(p->{
		System.out.println(p.toString());
	});
	
	System.out.println("lista alterada");
	Pessoa altera= new Pessoa (4,"altera");
	
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