package es.ucm.fdi.integracion.DAOs;

import java.util.List;

import es.ucm.fdi.integracion.POJOs.POJO;

/**
 * Interfaz con las operaciones comunes a todos los DAO
 *
 * @param <T> POJO al que va asociado el DAO
 */
public interface DAO<T> {
	
	/**
	 * Guarda el elemento t en la base de datos
	 * 
	 * @param t	objeto que va a ser guardado
	 */
	public void save(T t);

	/**
	 * Cambia el elemento t que había en la base de datos por el pasado
	 * como argumento
	 * 
	 * @param t	objeto a actualizar
	 */
	public void update(T t);

	/**
	 * Devuelve el POJO cuya id coincide
	 * 
	 * @param id	id del POJO buscado
	 * 
	 * @return		devuelve el POJO correspondiente o null
	 * 				si no lo encuentra
	 */
	public POJO getFromId(String id);

	/**
	 * Devuelve una lista con los elementos de la original clonados
	 * 
	 * @param pojos		POJOs originales
	 * 
	 * @return			los POJOs originales clonados
	 */
	public List<T> getFromIds(List<T> pojos);

	/**
	 * Elimina el POJO cuya id coincida de la BD
	 * 
	 * @param id	id del POJO
	 */
	public void remove(String id);
}
