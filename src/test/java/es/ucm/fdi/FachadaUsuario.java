package es.ucm.fdi;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

/**
 * Esta interfaz contiene todos los métodos que dependen del usuario que lo
 * llame, por lo tanto simplica la llamada a las funciones que contiene ya que
 * permite abstraerte de saber en que SA está implementada la función
 * 
 *
 */
public interface FachadaUsuario {

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
	 *            clan del que queremos obtener las preguntas
	 * @return una lista con todas las preguntas asociadas al clan pasado como
	 *         argumento
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
	 * Elimina a un usuario de la base de datos de la aplicacion
	 * 
	 * @param idUsuario
	 *            id del usuario que se quiere eliminar
	 */
	public void eliminarUsuario(String idUsuario);
	/**
	 * Desvinvula todas las preguntas de una categoria de un usuario
	 * 
	 * @param categoria
	 *            categoria de la que no queremos mas preguntas
	 * @param idUsuario
	 *            usuario del que queremos desvincular una categoria
	 */
	public void desvincularCategoria(String categoria, String idUsuario);

	/**
	 * Vincula todas las preguntas de la categoria categoria con el usuario
	 * idUsuario, haciendo asi que estas preguntas puedan ser las que aparezcan
	 * cuando suena la alarma
	 * 
	 * @param categoria
	 *            categoria de la que queremos que nos aparezcan preguntas
	 * @param idUsuario
	 *            usuario que quiere las preguntas de la categoria
	 */
	public void vincularCategoria(String categoria, String idUsuario);

	/**
	 * Agregar una nueva pregunta a la base de datos. La pregunta es agregada a
	 * la base de datos del usuario y del clan al que pertenece.
	 * 
	 * @param pregunta
	 *            pregunta a agregar
	 */
	public void agregarPregunta(PreguntaPOJO pregunta, String idUsuario);

	/**
	 * Elimina un apregunta de la base de datos
	 * 
	 * @param idPregunta
	 *            id de la pregunta a eliminar
	 */
	public void eliminarPregunta(String idPregunta, String idUsuario);
}
