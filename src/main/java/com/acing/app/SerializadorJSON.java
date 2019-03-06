package com.acing.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.OutputType;

public class SerializadorJSON implements PartidoDAO {
	
	String ruta;
	Json json;
	
	public SerializadorJSON(String ruta) {
		this.ruta = ruta;
		json = new Json(OutputType.json);
		json.setSerializer(Date.class, new DateSerializer());
    	//json.setSerializer(Partido.class, new PartidoSerializer());
	}
	
	public void guardarPartido(Partido partido) {
    	String eventosJson = "";
    	
    	eventosJson += json.toJson(partido);
    	eventosJson += "\n";
    	
    	//Guardamos el json
    	guardarStringEnFichero(ruta, eventosJson);
	}
	
	public void guardarStringEnFichero(String rutaArchivo, String cadena) {
	    try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rutaArchivo, true), "UTF8"))){
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
	
	public Collection<Partido> jsonToPartidos(String rutaArchivo) throws UnsupportedEncodingException, FileNotFoundException {
		 
		Collection<Partido> partidos = new ArrayList<>();
    	
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
	
	@Override
	public Collection<? extends Partido> getEventos() {
		try {
			return jsonToPartidos(ruta);
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Collection<? extends Partido> getEventos(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Partido> void guardarEvento(T partido) {
		guardarPartido(partido);

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
		int count = 0;
		for (T t : partidos) {
			guardarEvento(t);
			count++;
		}
		return count;
	}

}
