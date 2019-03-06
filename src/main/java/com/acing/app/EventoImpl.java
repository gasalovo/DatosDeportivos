package com.acing.app;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import es.lanyu.commons.tiempo.DatableImpl;

public abstract class EventoImpl extends DatableImpl implements Evento {
	protected Collection<Suceso> sucesos;
	transient protected Collection<Participante> participantes;
	//protected Date fecha;
	
	protected Participante local;
	protected Participante visitante;
	
	public EventoImpl() {
		//sucesos = new ArrayList<>();
		participantes = new ArrayList<>();
		sucesos = new ArrayList<>();
	}

	public Collection<Suceso> getSucesos() {
		//if (sucesos == null)
		//	sucesos = new ArrayList<>();
		return sucesos;
	}
	
	
	
}
