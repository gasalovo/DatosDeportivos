package com.acing.app;
import java.util.Collection;
import java.util.Date;

public abstract class EventoImpl implements Evento {
	protected Collection<Suceso> sucesos;
	protected Collection<Participante> participantes;
	protected Date fecha;
	
	transient protected Participante local;
	transient protected Participante visitante;
	
//	public EventoImpl(Participante local, Participante visitante, Date fecha) {
//		this.local = local;
//		this.visitante = visitante;
//		this.fecha = fecha;
//	}
	
	
	
}
