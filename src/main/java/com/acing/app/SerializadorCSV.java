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


public class SerializadorCSV {
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
	
	public static void guardarStringEnFichero(String rutaArchivo, String cadena) {
		try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rutaArchivo), "UTF8"))){
			writer.write(cadena);
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
			
       
	}


	public static Collection<Partido> jsonToPartidos(String rutaArchivo) throws UnsupportedEncodingException, FileNotFoundException {
		 
		Collection<Partido> partidos = new ArrayList<>();
		// Serializador JSON
    	Json json = new Json(OutputType.json);
    	json.setSerializer(Date.class, new DateSerializer());
    	json.setSerializer(Partido.class, new PartidoSerializer());
    	
    	try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(rutaArchivo), "UTF8"))){
			String line = reader.readLine();
			while((line = reader.readLine()) != null) {
				partidos.add(json.fromJson(Partido.class, line));
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
}

