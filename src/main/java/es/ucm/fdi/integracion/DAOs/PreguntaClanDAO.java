package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.PreguntaClanPOJO;


/**
 * 
 * Contiene las operaciones de acceso a memoria 
 * que requieren datos que realcionan preguntas con usuarios
 *
 */
public interface PreguntaClanDAO extends DAO<PreguntaClanPOJO>{
	/**
	 * @param idUsuario id del usuario del que queremos obtener su listade preguntas.
	 * @return lista de preguntas que el usuario ha guardado como suyas.
	 */
	public ArrayList<String> getPreguntas(String idClan);

}
