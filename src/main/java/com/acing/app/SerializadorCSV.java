package com.acing.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.OutputType;


public class SerializadorCSV implements PartidoDAO {
	
	static String ruta;
	
	public SerializadorCSV(String ruta) {
		SerializadorCSV.ruta = ruta;
	}
	
	public static Collection<Partido> getPartidos(String rutaArchivo){
		
		Collection<Partido> partidos = new ArrayList<>();
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(rutaArchivo), "UTF8"))){
			String line = reader.readLine();
			while((line = reader.readLine()) != null) {
				partidos.add(deserializarPartido(line));
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return partidos;
	}
	
	//linea CSV to Partido
	public static Partido deserializarPartido(String linea){
		String[] campos = linea.split(",");
		String fechaString = campos[1];
		String localString = campos[2];
		String visitanteString = campos[3];
		String golesLocal = campos[4];
		String golesVisitante = campos[5];
		Date fecha;

		
		SimpleDateFormat sdFormat = new SimpleDateFormat("dd/MM/yy");
		try {
			fecha = sdFormat.parse(fechaString);
		} catch (ParseException e) {
			fecha = new Date();
			e.printStackTrace();
		}
		String resultado = golesLocal + "-" + golesVisitante;
		Participante local, visitante;
		
		//locales
		if (!Participante.mapaParticipanteIdPorNombre.containsKey(localString)) { //no esta en el Map
			local = new Participante(localString);
			Participante.mapaParticipanteIdPorNombre.put(localString, local);
		} else {
			local = Participante.mapaParticipanteIdPorNombre.get(localString);
		}
		//visitante
		if (!Participante.mapaParticipanteIdPorNombre.containsKey(visitanteString)) { //no esta en el Map
			visitante = new Participante(visitanteString);
			Participante.mapaParticipanteIdPorNombre.put(visitanteString, local);
		} else {
			visitante = Participante.mapaParticipanteIdPorNombre.get(visitanteString);
		}
		
		Partido evento = new Partido(local, visitante, fecha);
		evento.setResultado(resultado);
		
		return evento;
		
	}

	@Override
	public Collection<? extends Partido> getEventos() {
		return getPartidos(ruta);
	}

	@Override
	public Collection<? extends Partido> getEventos(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Partido> void guardarEvento(T partido) {
		
	}

	@Override
	public <T extends Partido> T removeEvento(T partido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Partido> boolean actualizarEvento(T partido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T extends Partido> int guardarEventos(T... partidos) {
		// TODO Auto-generated method stub
		return 0;
	}

}

