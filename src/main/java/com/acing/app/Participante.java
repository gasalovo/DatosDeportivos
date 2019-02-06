package com.acing.app;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import com.esotericsoftware.jsonbeans.Json;

public class Participante extends AbstractNombrable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private String nombre;
	public static Map<String, Participante> mapaParticipanteIdPorNombre = new HashMap<>();
	public static Map<String, Participante> mapaParticipanteId = new HashMap<>();
	private String generadorIdentificadores;
	private static String id = "0";
	

	
	public String getId() {
		String id = getKeyByValue(mapaParticipanteId, this);
		if (id != null) {
			return id;
		}
		System.out.println("El id es NULL");
		return "0";
	}
	
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
		Participante.mapaParticipanteId.put(Participante.id, this);
		
		//update static id
		int id = Integer.parseInt(Participante.id);
		id++;
		Participante.id = Integer.toString(id);
	}
	
	public Collection<Participante> getParticipantesRegistrados() {
		return null;
		
	}
	
	private void registrarParticipante(Participante participante) {
		
	}
	
	private void registrarNombre(Participante participante) {
		
	}
	
	public Participante getIdentificable(String identificable) {
		return null;
		
	}
	
	public Participante getParticipantePorNombre(String nombre) {
		return mapaParticipanteIdPorNombre.get(nombre);
		
	}

	@Override
	public String getIdentificador() {
		return getId();
	}

	@Override
	public <K extends Comparable<K>, T extends Identificable<K>> void cargarIdentificables(Json json, String nombre,
			Map<K, T> map, Class<T> cls) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <K extends Comparable<K>> Comparator<Identificable<K>> getComparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <K extends Comparable<K>, T extends Identificable<K>> T getIdentificablePorIndiceOrdenado(int indice,
			Collection<T> identificables) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(Identificable<String> o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
}
