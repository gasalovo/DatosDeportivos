package com.acing.app;

import java.util.Collection;
import java.util.Date;

public interface PartidoDAO {
	Collection<? extends Partido> getEventos();
    Collection<? extends Partido> getEventos(Date fecha);
    <T extends Partido> void guardarEvento(T partido);
    //un numero indeterminado de parametros
    <T extends Partido> int guardarEventos(T... partidos);
    <T extends Partido> T removeEvento(T partido);
    <T extends Partido> boolean actualizarEvento(T partido);
}
