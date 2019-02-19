package com.acing.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Date;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.OutputType;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    
    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
    	
    	String fichero = "SP1.csv";
    	PartidoDAO partidoDAO = new SerializadorCSV(fichero);
        
        // Abrimos conexion al fichero
        URLConnection urlCon;
        File file = new File(fichero);
        
        if (!file.exists()) { //si el fichero no existe lo bajamos
	        System.out.println("El fichero "+fichero+" no existe. Bajando!");
        	try {
	        	   URL url = new URL("http://www.football-data.co.uk/mmz4281/1819/SP1.csv");
	        	   urlCon = url.openConnection();
	        	   // Guardamos el fichero
	               // acceso al contenido web
	               InputStream is = urlCon.getInputStream();
	               // Fichero en el que queremos guardar el contenido
	               FileOutputStream fos = new FileOutputStream(fichero);
	               // buffer para ir leyendo.
	               byte [] array = new byte[1000];

	               // Primera lectura y bucle hasta el final
	               int leido = is.read(array);
	               while (leido > 0) {
	                  fos.write(array,0,leido);
	                  leido=is.read(array);
	               }

	               // Cierre de conexion y fichero.
	               is.close();
	               fos.close();
	        } catch (Exception e) {
	        	System.out.println("No ha sido posible la descarga");
	        }
        
        } else {
        	System.out.println("El fichero ya existe. Leyendo");
        }
		//deserializamos del CSV
		Collection<? extends Partido> partidos;
		partidos = partidoDAO.getEventos();
		
		File file_json = new File("eventos.json");
	    if (file_json.exists()) { //si el fichero existe me lo cargo
	    	file_json.delete();
	    }
		
		//serializamos cada partido a JSON
		partidoDAO = new SerializadorJSON("eventos.json");
		for (Partido partido: partidos) {
			partidoDAO.guardarEvento(partido);
		}
        
	  // deserializamos el json
	  partidos = partidoDAO.getEventos();
	  //Imprimimos los partidos
//	    for (Partido partido : partidos) {
//			System.out.println(partido);
//		}
	  //partidos.stream().forEach(e->System.out.println(e));
	  //usamos el lambda printn ya que admite un parametro por cada uno
	  partidos.stream().filter(e->e.getResultado().equals("3-0")).map(e2->e2.getResultado()+" palizon").forEach(System.out::println);
    	
    }
}
