package Exercicio;

public class TempoFornoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TempoFornoException() {
		
	}
	public String toString(){
		return "O tempo de forno foi excedido ";
	}
}
