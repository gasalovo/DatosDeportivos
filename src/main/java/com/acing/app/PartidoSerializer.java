package com.acing.app;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.AsyncBoxView.ChildLocator;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.JsonSerializer;
import com.esotericsoftware.jsonbeans.JsonValue;

public class PartidoSerializer implements JsonSerializer<Partido> {

	@Override
	public Partido read(Json json, JsonValue jsonValue, Class arg2) {
		Participante local;
		Participante visitante;
		if (Participante.mapaParticipanteId.containsKey(jsonValue.getString("local"))) {
			local = Participante.mapaParticipanteId.get(jsonValue.getString("local"));
		} else {
			local = new Participante();
			System.out.println("No se ha encontrado el participante: "+jsonValue.getString("local"));
		}
		if (Participante.mapaParticipanteId.containsKey(jsonValue.getString("visitante"))) {
			visitante = Participante.mapaParticipanteId.get(jsonValue.getString("visitante"));
		} else {
			visitante = new Participante();
			System.out.println("No se ha encontrado el participante: "+jsonValue.getString("visitante"));
		}
		//usamos el serializador de Date
		DateSerializer ds = new DateSerializer();
		Date fecha = ds.read(json, jsonValue.get("fecha"), Date.class);
		
		Partido partido = new Partido(local, visitante, fecha);
		partido.setResultado(jsonValue.getString("resultado"));
		
		return partido;
	}

	@Override
	public void write(Json json, Partido partido, Class arg2) {
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yy");
		SimpleDateFormat formater2 = new SimpleDateFormat("HH:mm");
		json.writeObjectStart();
        //json.writeValue("dia", formater.format(partido.getFecha()));
        //json.writeValue("hora", formater2.format(partido.getFecha()));
        json.writeValue("local", partido.local.getIdentificador());
        json.writeValue("visitante", partido.visitante.getIdentificador());
        json.writeValue("fecha", partido.getFecha());
        json.writeValue("resultado", partido.getResultado());
        json.writeObjectEnd();
		
	}

}
