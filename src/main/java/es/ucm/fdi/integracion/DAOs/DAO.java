package es.ucm.fdi.integracion.DAOs;

import java.util.List;

import es.ucm.fdi.integracion.POJOs.POJO;

/**
 * 
 * Interfaz con las operaciones comunes a todos los DAO
 *
 * @param <T> POJO al que va asociado el DAO
 */
public interface DAO<T> {
	public void save(T t);

	public void update(T t);

	public POJO getFromId(String id);

	public List<T> getFromIds(List<T> pojos);

	public void remove(String id);
}
