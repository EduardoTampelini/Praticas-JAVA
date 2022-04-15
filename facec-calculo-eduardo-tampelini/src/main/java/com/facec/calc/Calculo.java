package com.facec.calc;

import java.math.BigDecimal;

public class Calculo {

	private BigDecimal vlr1;
	private BigDecimal vlr2;
	private BigDecimal resultado;
	
	
	public BigDecimal getVlr1() {
		return vlr1;
	}
	public void setVlr1(BigDecimal vlr1) {
		this.vlr1 = vlr1;
	}
	public BigDecimal getVlr2() {
		return vlr2;
	}
	public void setVlr2(BigDecimal vlr2) {
		this.vlr2 = vlr2;
	}
	public BigDecimal getResultado() {
		return resultado;
	}
	public void setResultado(BigDecimal resultado) {
		this.resultado = resultado;
	}
	public BigDecimal somar(BigDecimal vlr1, BigDecimal vlr2) {
		resultado=vlr1.add(vlr2);
		
		return resultado;
	}
	public BigDecimal subtrair(BigDecimal vlr1, BigDecimal vlr2) {
		resultado=vlr1.subtract(vlr2);
		
		return resultado;
	}
	public BigDecimal multiplicar(BigDecimal vlr1, BigDecimal vlr2) {
		resultado=vlr1.multiply(vlr2);
		
		return resultado;
	}
	public BigDecimal dividir(BigDecimal vlr1, BigDecimal vlr2) {
		resultado=vlr1.divide(vlr2);
		
		return resultado;
	}
}
