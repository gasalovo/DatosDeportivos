package com.acing.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.JsonSerializer;
import com.esotericsoftware.jsonbeans.JsonValue;

public class DateSerializer implements JsonSerializer<Date> {

	@Override
	public Date read(Json json, JsonValue values, Class arg2) {
		Date fecha = null;
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yy HH:mm");
		try {
			fecha = formater.parse(values.getString("dia")+" "+values.getString("hora"));
			//fecha = formater.parse(values.child().name());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fecha;
	}

	@Override
	public void write(Json json, Date date, Class arg2) {
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yy");
		SimpleDateFormat formater2 = new SimpleDateFormat("HH:mm");
		json.writeObjectStart();
        json.writeValue("dia", formater.format(date));
        json.writeValue("hora", formater2.format(date));
        json.writeObjectEnd();
		
	}
}
