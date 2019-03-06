package com.acing.app;

import java.util.Collection;
import java.util.Date;

import com.google.common.graph.SuccessorsFunction;

import es.lanyu.commons.tiempo.DatableImpl;

public class Partido extends EventoImpl {

	public Partido(Participante local, Participante visitante, Date fecha) {
		super();
		this.local = local;
		this.visitante = visitante;
		setFecha(fecha);
	}
	
	public Partido() {
		//super(null, null, null);
	}
	
	public void setResultado(String resultado) {
		//this.resultado = resultado;

	}
	
	public Collection<Suceso> getSucesos() {
		return sucesos;
	}

	
	public String getResultado() {
		long golesLocal = getSucesos().stream().filter(s->s.getParticipante().equals(local)).count();
		long golesVisitante = getSucesos().stream().filter(s->s.getParticipante().equals(visitante)).count();
		String resultado = (int)golesLocal +"-"+ (int)golesVisitante;
		
		return resultado;
	}

	
	public Participante getGanador() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String toString() {
		return "Partido [resultado=" + getResultado() + ", fecha=" + fecha + ", local=" + local + ", visitante=" + visitante
				+ "]";
	}

	public void setSucesos(Collection<Suceso> sucesos) {
		super.sucesos = sucesos;
		
	}

	
}
