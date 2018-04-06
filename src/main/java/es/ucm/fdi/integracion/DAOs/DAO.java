package es.ucm.fdi.integracion.DAOs;

import es.ucm.fdi.integracion.POJOs.POJO;

public interface DAO<T> {
	public void save(T t);
	
	public void update(T t);
	
	public POJO getFromId(String id);
	
	public void remove(String id);
}
