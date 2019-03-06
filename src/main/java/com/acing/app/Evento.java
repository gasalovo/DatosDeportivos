package com.acing.app;

import java.util.Collection;

import es.lanyu.commons.tiempo.Datable;

public interface Evento extends Datable{
	Collection<Suceso> getSucesos();
	String getResultado();
	
	default void addSuceso(Suceso suceso) {
		getSucesos().add(suceso);
	}
}
