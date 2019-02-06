package com.acing.app;
import java.util.Comparator;

public abstract class AbstractNombrable extends IdentificableString implements Nombrable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombre;
	
	@Override
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	Comparator<AbstractNombrable> getComparadorPorNombre(){
		return null;
		
	}
}
