package com.acing.app;
import java.io.Serializable;
import java.util.Comparator;

public abstract class IdentificableString implements Identificable<String>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String id;
	
	private Comparator<Identificable<String>> comparador;
	public Comparator<Identificable<String>> getComparadorPorIdentificador(){
		return comparador;
		
	}
	public void setIdentificador(String id) {
		this.id = id;
	}
}
