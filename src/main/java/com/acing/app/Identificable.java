package com.acing.app;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import com.esotericsoftware.jsonbeans.Json;

public interface Identificable<K> extends Comparable<Identificable<K>>{
	K getIdentificador();
	<K extends Comparable<K>, T extends Identificable<K>>  void cargarIdentificables(Json json, String nombre, Map<K, T> map, Class<T> cls);
	<K extends Comparable<K>> Comparator<Identificable<K>> getComparator();
	<K extends Comparable<K>, T extends Identificable<K>> T getIdentificablePorIndiceOrdenado(int indice, Collection<T> identificables);

}
