package es.ucm.fdi.negocio;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

/**
 * Contiene los servicios funcionales de la aplicacion (a nivel de servidor) que
 * trabajan con los usuarios.
 */

public interface UsuarioSA {


	/**
	 * Anade un usuario a la base de datos de los usuarios.
	 * 
	 * @param usuario	usuario a anadir 
	 */
	public void anadirUsuario(UsuarioPOJO usuario);

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
	 * Obtiene una lista con todas las preguntas asociadas al usuario
	 * 
	 * @param usuario
	 *            id del usuario del que queremos obtener su lista de preguntas
	 * @return la lista de preguntas
	 */
	public ArrayList<String> preguntasUsuario(String usuario);

	/**
	 * Elimina a un usuario de la base de datos de la aplicacion
	 * 
	 * @param idUsuario
	 *            id del usuario que se quiere eliminar
	 */
	public void eliminarUsuario(String idUsuario);
	

}
