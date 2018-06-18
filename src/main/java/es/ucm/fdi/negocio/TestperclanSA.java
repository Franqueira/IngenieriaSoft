package es.ucm.fdi.negocio;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

/**
 * Contiene las funcionalidades de la aplicación (a nivel de servidor) que
 * trabajan con todo lo que respecta al clan
 */
public interface TestperclanSA {
	/**
	 * Obtiene el ranking
	 * 
	 * @param nombreClan
	 *            Cadena que contiene el nombre del clan
	 * @return Devuelve el ranking
	 */
	public ArrayList<UsuarioPOJO> getRanking(String nombreClan);

	/**
	 * Establece como ganador del clan pasado al primero del ranking
	 * 
	 * @param nombreClan
	 *            nombre del clan al que se va a asignar el ganador. Asigna el
	 *            primer usuario del ranking como el ganador
	 */
	public void setGanador(String nombreClan);

	/**
	 * Elimina al usuario del clan. Si no quedan miembros restantes, elimina el clan, 
	 * y si el usuario es el líder, cambia el líder del clan
	 * 
	 * @param idUsuario
	 *            id del usuario que va a ser eliminado. 
	 */
	public void eliminarUsuarioClan(String idUsuario);

	/**
	 * Anade un usuario concreto al clan idClan
	 * 
	 * @param idUsuario
	 *            id del usuario a añadir
	 * @param idClan
	 *            id del clan al que se va a anadir el usuario.
	 */
	public void anadirUsuarioClan(String idUsuario, String idClan);

	/**
	 * Obtiene una lista con todas las preguntas asociadas al clan pasado como
	 * argumento
	 * 
	 * @param idClan
	 *            clan del que queremos obtener las preguntas
	 *            
	 * @return una lista con todas las preguntas del clan
	 */
	public ArrayList<String> preguntasClan(String idClan);

	/**
	 * Crea un nuevo clan con el idUsuario como líder de este
	 * 
	 * @param idUsuario
	 *            id del usuario que se convertira en el líder del clan
	 * @param idClan
	 *            id del clan que se va a crear
	 */
	public void crearClan(String idUsuario, String idClan);
}
