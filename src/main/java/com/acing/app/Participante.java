package com.acing.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import es.lanyu.commons.identificable.AbstractNombrable;


public class Participante extends AbstractNombrable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2940586655097058073L;
	/**
	 * 
	 */
	//private String nombre;
	public static Map<String, Participante> mapaParticipanteIdPorNombre = new HashMap<>();
	public static Map<String, Participante> mapaParticipanteId = new HashMap<>();
	//private String generadorIdentificadores;
	private static String nextId = "0";
	

	
//	public String getId() {
//		String id = getKeyByValue(mapaParticipanteId, this);
//		if (id != null) {
//			return id;
//		}
//		System.out.println("El id es NULL");
//		return "0";
//	}
	
	//Dado un valor, itera el Map en busca de key y devuelve la primera ocurrencia, porque es única
	public <T, E> T getKeyByValue(Map<T, E> map, E value) {
	    for (Entry<T, E> entry : map.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
	
	public Participante() {
	}
	
	public Participante(String nombre) {
		this.nombre = nombre;
		Participante.mapaParticipanteId.put(Participante.nextId, this);
		
		//last id given
		int id = Integer.parseInt(Participante.nextId);
		this.id = Integer.toString(id);
		
		//update next id
		id++;
		Participante.nextId = Integer.toString(id);
	}
	
	public Participante getParticipantePorNombre(String nombre) {
		return mapaParticipanteIdPorNombre.get(nombre);
		
	}


	@Override
	public String toString() {
		return nombre;
	}
	
	
}
