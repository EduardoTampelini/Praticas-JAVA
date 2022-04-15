package Exercicio;

public class FabricaBiscoito {
public static void main(String[]args) {
    
	Biscoito bischoco=new Biscoito("Biscoito de chocolate",30,SaborBiscoito.CHOCOLATE );
	Biscoito bismora=new Biscoito("Biscoito de morango",30,SaborBiscoito.MORANGO );
	Biscoito bisfran=new Biscoito("Biscoito de franboesa",50,SaborBiscoito.FRAMBOESA );
	System.out.println("Estão sendo feitos 3 biscoitos");
	System.out.println("                                                            ");
	System.out.println("O primeiro deles é o: "+bischoco.getNome());
	System.out.println("Receita seguida: "+mostrarReceita(new ReceitaChocolate()));
	System.out.println("/////////////////////////////////////////////////////////");
	System.out.println("Como biscoito foi entregue ");
	System.out.println("Nome: "+bischoco.getNome());
	System.out.println("Tempo de forno: "+bischoco.getTempoForno());
	System.out.println("Sabor: "+bischoco.sabor);
	System.out.println("/////////////////////////////////////////////////////////");
	System.out.println("                                                         ");
	System.out.println("O segundo deles é o: "+bismora.getNome());
	System.out.println("Receita seguida: "+mostrarReceita(new ReceitaMorango()));
	System.out.println("/////////////////////////////////////////////////////////");
	System.out.println("Como biscoito foi entregue ");
	System.out.println("Nome: "+bismora.getNome());
	System.out.println("Tempo de forno: "+bismora.getTempoForno());
	System.out.println("Sabor: "+bismora.sabor);
	System.out.println("/////////////////////////////////////////////////////////");
	System.out.println("                                                            ");
	System.out.println("O terceiro deles é o: "+bisfran.getNome());
	System.out.println("Receita seguida: "+mostrarReceita(new ReceitaFramboesa()));
	System.out.println("/////////////////////////////////////////////////////////");
	System.out.println("Como biscoito foi entregue ");
	System.out.println("Nome: "+bisfran.getNome());
	try {
	if(bisfran.getTempoForno()>30) {
		throw new TempoFornoException();
	}
	
	
	}catch(Exception e) {
		System.out.println("Tempo de forno: "+bisfran.getTempoForno());
		System.out.println("Aviso: "+e.toString()+"!");
		System.out.println("Sabor: "+"Queimando");
	System.out.println("/////////////////////////////////////////////////////////");
	}
	
	
}

private static String mostrarReceita(Receita receita) {
	return receita.mostrarIngredientes()+"\n Pegar todos os ingrediente colocar em uma travessa misturar"
			+ " Após isso leve ao fogo por um tempo de 30 minutos.";
}
}
