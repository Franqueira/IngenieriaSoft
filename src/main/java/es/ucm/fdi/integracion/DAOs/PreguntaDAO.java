package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;
import java.util.List;

import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;

/**
 * Contiene las operaciones relacionadas con el acceso a memoria con datos de
 * las preguntas de la aplicación.
 */
public interface PreguntaDAO extends DAO<PreguntaPOJO> {
	
	/**
	 * Devuelve una lista con los POJOS correspondientes a los identificadores
	 * de las preguntas de list
	 * 
	 * @param list
	 *            lista con los ids de las preguntas
	 * @return una lista con los POJOS asociados a los ids de list
	 */
	public ArrayList<PreguntaPOJO> getPreguntas(List<String> list);

	/**
	 * Obtiene todas las preguntas de la aplicación
	 * 
	 * @return una lista con todos los POJOS de las preguntas
	 */
	public ArrayList<PreguntaPOJO> getAll();

	/**
	 * Obtiene una lista con todas las preguntas de la categoria pasada
	 * 
	 * @param categoria
	 *            categoria de la que queremos obtener sus preguntas
	 * @return todas las preguntas de la categoria
	 */
	public ArrayList<PreguntaPOJO> getPreguntasPorCategoria(String categoria);

}
