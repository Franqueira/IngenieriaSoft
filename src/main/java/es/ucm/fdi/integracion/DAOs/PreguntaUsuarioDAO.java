package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;

/**
 * Contiene las operaciones de acceso a memoria que requieren datos que
 * relacionan preguntas con usuarios
 */
public interface PreguntaUsuarioDAO extends DAO<PreguntaUsuarioPOJO>{
	
	/**
	 * Obtiene una lista con las preguntas de un usuario
	 * 
	 * @param idUsuario
	 *            id del usuario del que queremos obtener su lista de preguntas
	 * @return lista de preguntas que el usuario ha guardado como suyas
	 */
	public ArrayList<String> getPreguntas(String idUsuario);

}
