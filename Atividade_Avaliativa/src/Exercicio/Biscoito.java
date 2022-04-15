package Exercicio;

public class Biscoito {
String nome;
int tempoForno;
SaborBiscoito sabor;

public Biscoito(String nome, int tempoForno, SaborBiscoito sabor) {
	this.nome=nome;
	this.tempoForno=tempoForno;
	this.sabor=sabor;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public int getTempoForno() {
	return tempoForno;
}

public void setTempoForno(int tempoForno) {
	this.tempoForno = tempoForno;
}

}
