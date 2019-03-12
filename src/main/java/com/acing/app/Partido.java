package com.acing.app;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import com.google.common.graph.SuccessorsFunction;

import es.lanyu.commons.tiempo.Datable;
import es.lanyu.commons.tiempo.DatableImpl;

public class Partido extends EventoImpl {
	private final static SimpleDateFormat sdfToString = new SimpleDateFormat("dd/MM/yy HH:mm");
	
	protected Participante local;
	protected Participante visitante;
	
	public Partido(Participante local, Participante visitante, Date fecha) {
		super();
		this.local = local;
		this.visitante = visitante;
		//setFecha(fecha);
//		if (fecha == null) {
//			setFecha(new Date(getTimeStamp()));
//		}
//		else {
//			setFecha(fecha);
//		}
		setFecha(fecha);
		getFecha();
		
	}
	
	public Partido(Participante local, Participante visitante, Date fecha, Long timestamp) {
		this(local, visitante, fecha);
		this.timeStamp = timestamp;
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
		//return "Partido [resultado=" + getResultado() + ", fecha=" + sdfToString.format(getFecha()) + ", local=" + local + ", visitante=" + visitante + "]";
		return "Partido [resultado=" + getResultado() + ", fecha=" + getFecha() + ", local=" + local + ", visitante=" + visitante + "]";

	}

	public void setSucesos(Collection<Suceso> sucesos) {
		super.sucesos = sucesos;
		
	}

	public Participante getLocal() {
		return local;
	}

	public Participante getVisitante() {
		return visitante;
	}
	
	
}
