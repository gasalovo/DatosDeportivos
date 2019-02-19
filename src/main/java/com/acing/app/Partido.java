package com.acing.app;

import java.util.Collection;
import java.util.Date;
import es.lanyu.commons.tiempo.DatableImpl;

public class Partido extends DatableImpl {
	
	protected String resultado;
	transient protected Participante local;
	transient protected Participante visitante;
	protected Collection<Suceso> sucesos;
	protected Collection<Participante> participantes;

	public Partido(Participante local, Participante visitante, Date fecha) {
		this.local = local;
		this.visitante = visitante;
		super.fecha = fecha;
	}
	
	public Partido() {
		//super(null, null, null);
	}
	
	public void setResultado(String resultado) {
		this.resultado = resultado;

	}
	
	public Collection<Suceso> getSucesos() {
		return sucesos;
	}

	
	public String getResultado() {
		return resultado;
	}

	
	public Participante getGanador() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String toString() {
		return "Partido [resultado=" + resultado + ", fecha=" + fecha + ", local=" + local + ", visitante=" + visitante
				+ "]";
	}

	
}
