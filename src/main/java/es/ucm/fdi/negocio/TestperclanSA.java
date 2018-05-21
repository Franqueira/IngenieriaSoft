package es.ucm.fdi.negocio;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

/**
 * 
 * Contiene las funcionalidades de la aplicacion (a nivel de servidor) que
 * trabajan con todo lo que respecta al clan.
 *
 */
public interface TestperclanSA {
	/**
	 * 
	 * @param nombreClan
	 *            Cadena que contiene el nombre del clan
	 * @return Devuelve el ranking, una lista ordenada de usuarios.
	 */
	public ArrayList<UsuarioPOJO> getRanking(String nombreClan);

	/**
	 * 
	 * @param nombreClan
	 *            nombre del clan al que se va a asignar el ganador. Asigna el
	 *            primer usuario del ranking como el ganador.
	 */
	public void setGanador(String nombreClan);

	/**
	 * 
	 * @param idUsuario
	 *            id del usuario que va a ser eliminado. Elimina al usuario del
	 *            clan. Si no quedan miembros restantes. elimina el clan, y si
	 *            el usuario es el lider, cambia el lider del clan.
	 */
	public void eliminarUsuarioClan(String idUsuario);

	/**
	 * 
	 * @param idUsuario
	 *            id del usuario a añadir.
	 * @param idClan
	 *            id del clan al que se va a añadir el usuario. Añade un usuario
	 *            concreto al clan idClan.
	 */
	public void anadirUsuarioClan(String idUsuario, String idClan);

	/**
	 * 
	 * 
	 * @param idClan
	 * @return
	 */
	public ArrayList<String> preguntasClan(String idClan);

	/**
	 * 
	 * @param idUsuario
	 *            id del usuario que se convertira en el lider del clan.
	 * @param idClan
	 *            id del clan que se va a crear. Crea un nuevo clan con el
	 *            idUsuario como lider de este.
	 */
	public void crearClan(String idUsuario, String idClan);
}
