package es.ucm.fdi.negocio;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

/**
 * 
 * Contiene los servicios funcionales de la aplicacion (a nivel de servidor) que
 * trabajan con los usuarios.
 *
 */

public interface UsuarioSA {

	/**
	 * 
	 * @param alarma
	 *            alarma a anadir.
	 * @param idUsuario
	 *            id del usuario al que se le va a anadir la alarma Anade una
	 *            nueva alarma en la base de datos de las alarmas.
	 */
	public void AnadirAlarma(AlarmaPOJO alarma, String idUsuario);

	/**
	 * 
	 * @param idAlarma
	 *            id de la alarma a eliminar. Elimina la alarma en cuestion.
	 */
	public void EliminarAlarma(String idAlarma);

	/**
	 * 
	 * @param usuario
	 *            usuario a anadir Anade un usuario a la base de datos de los
	 *            usuarios.
	 */
	public void AnadirUsuario(UsuarioPOJO usuario);

	/**
	 * Comprueba que la respuesta elegida por un usuario a una pregunta es
	 * correcta, y modifica su puntuacion en funcion de la correccion de la
	 * respuesta
	 * 
	 * @param idUsuario
	 *            id del usuario que ha respondido
	 * @param idPregunta
	 *            id de la pregunta que se ha respondido
	 * @param respuesta
	 *            posicion de la respuesta marcada
	 */

	public void informarRespuesta(String idUsuario, String idPregunta,
			int respuesta);

	/**
	 * @param usuario
	 *            id del usuario del que queremos obtener su lista de preguntas
	 * @return una lista con todas las preguntas asociadas al usuario
	 */

	public ArrayList<String> preguntasUsuario(String usuario);

	/**
	 * @param usuario
	 *            usuario del que queremos obtener todas las preguntas
	 *            vinculadas en su clan (que son el conjunto de las preguntas
	 *            vinculadas a cada usuario del clan)
	 * @return una lista con todas las preguntas vinculadas al clan del que es
	 *         miembro el usuario
	 */
	// public ArrayList<String> preguntasClan(String usuario);

	/**
	 * Elimina a un usuario de la base de datos de la aplicacion
	 * 
	 * @param idUsuario
	 *            id del usuario que se quiere eliminar
	 */
	public void EliminarUsuario(String idUsuario);

}
