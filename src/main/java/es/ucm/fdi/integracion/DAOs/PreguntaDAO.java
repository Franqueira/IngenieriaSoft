package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;
import java.util.List;

import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;

/**
 * 
 * Contiene las operaciones relacionadas con el acceso a memoria
 * con datos de las preguntas de la aplicación.
 * 
 */
public interface PreguntaDAO extends DAO<PreguntaPOJO>{
	
	public ArrayList<PreguntaPOJO> getPreguntas(List<String> list);
	
	public ArrayList<PreguntaPOJO> getAll();
	
}
