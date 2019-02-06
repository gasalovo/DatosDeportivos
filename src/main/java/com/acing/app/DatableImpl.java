package com.acing.app;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;


public abstract class DatableImpl implements Datable {
	
	Date fechaDate;
	Long timeStamp;
	DiaHora fecha;
	
	//protected Date fecha;
	transient protected Participante local;
	transient protected Participante visitante;
	protected Collection<Suceso> sucesos;
	protected Collection<Participante> participantes;
	
	public DatableImpl() {
		super();
	}
	
	void setFecha(Date fecha) {
		this.fechaDate = fecha;
		String dia = new SimpleDateFormat("dd/MM/yyyy").format(fecha);
		String hora = new SimpleDateFormat("HH:mm").format(fecha);
		this.fecha = new DiaHora(dia, hora);
	}
	
	public Date getFecha() {
		return fechaDate;
	}
	
	void setTimeStramp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	@Override
	public int compareTo(Datable o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Long getTimeStamp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<Datable> getComparatorDatable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean antesDe(Datable datable) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean despuesDe(Datable datable) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//clase interna. Se pone static para que exista al crear DatableImpl
	static class DiaHora {
		String dia;
		String hora;
		
		public DiaHora() {}
		
		public DiaHora(String dia, String hora) {
			super();
			this.dia = dia;
			this.hora = hora;
		}
	}

}
