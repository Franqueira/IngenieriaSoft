package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.PreguntaClanPOJO;

/**
 * Contiene las operaciones de acceso a memoria que requieren datos que
 * relacionan preguntas con usuarios
 */

public interface PreguntaClanDAO extends DAO<PreguntaClanPOJO> {
	
	/**
	 * Obtiene la lista de ids de las preguntas de un clan
	 * 
	 * @param idClan
	 *            id del clan del que queremos obtener su lista de preguntas
	 * @return lista de preguntas del clan
	 */
	public ArrayList<String> getPreguntas(String idClan);

}
