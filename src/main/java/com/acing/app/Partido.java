package com.acing.app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.JsonSerializable;
import com.esotericsoftware.jsonbeans.JsonValue;

public class Partido extends DatableImpl {
	
	protected String resultado;

	public Partido(Participante local, Participante visitante, Date fecha) {
		super.local = local;
		super.visitante = visitante;
		super.fechaDate = fecha;
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
		return "Partido [resultado=" + resultado + ", fecha=" + fechaDate + ", local=" + local + ", visitante=" + visitante
				+ "]";
	}

	
}
