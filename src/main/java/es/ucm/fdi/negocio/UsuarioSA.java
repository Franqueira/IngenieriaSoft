package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

/**
 * 
 * Contiene los servicios funcionales de la aplicacion (a nivel de servidor)
 * que trabajan con los usuarios.
 *
 */

public interface UsuarioSA {

	/**
	 * 
	 * @param alarma alarma a anadir.
	 * @param idUsuario id del usuario al que se le va a anadir la alarma
	 * Anade una nueva alarma en la base de datos de las alarmas.
	 */
	public void AnadirAlarma(AlarmaPOJO alarma, String idUsuario);

	/**
	 * 
	 * @param idAlarma id de la alarma a eliminar.
	 * Elimina la alarma en cuestion.
	 */
	public void EliminarAlarma(String idAlarma);

	/**
	 * 
	 * @param usuario usuario a anadir
	 * Anade un usuario a la base de datos de los usuarios.
	 */
	public void AnadirUsuario(UsuarioPOJO usuario);
	
	/**
	 * 
	 * @param idUsuario id del usuario a eliminar.
	 * Elimina al usuario en cuestion
	 */
	public void EliminarUsuario(String idUsuario);

	/**
	 * 
	 * @param pregunta pregunta a anadir
	 * @param idUsuario id del usuario al que se le va a anadir la pregunta
	 * Anade la pregunta en la base de datos de las preguntas y preguntasUsuario.
	 */
	public void AnadirPregunta(PreguntaPOJO pregunta,String idUsuario);
	
	/**
	 * 
	 * @param idPregunta id de la pregunta a eliminar.
	 * @param idUsuario id del usuario al que se le va a eliminar la pregunta.
	 * Elimina la pregunta en cuestion del usuario concreto.
	 */
	public void EliminarPregunta(String idPregunta,String idUsuario);

}
