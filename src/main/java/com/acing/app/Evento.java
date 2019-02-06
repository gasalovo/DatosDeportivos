package com.acing.app;
import java.util.Date;
import java.util.Collection;

public interface Evento {
	Date getFecha();
	Collection<Suceso> getSucesos();
	String getResultado();
	Participante getGanador();
}
