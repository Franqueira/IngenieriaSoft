package es.ucm.fdi.negocio;

/**
 * Contiene los servicios funcionales de la aplicación (a nivel de servidor)
 * que trabajan con preguntas.
 *
 */

import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;

public interface PreguntaSA {
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
	 * Agregar una nueva pregunta a la base de datos
	 * La pregunta es agregada a la base de datos del usuario 
	 * y del clan al que pertenece.
	 * 
	 * @param pregunta
	 *            pregunta a agregar
	 */
	public void agregarPregunta(PreguntaPOJO pregunta,String idUsuario);

	/**
	 * Elimina un apregunta de la base de datos
	 * 
	 * @param idPregunta
	 *            id de la pregunta a eliminar
	 */
	public void eliminarPregunta(String idPregunta,String idUsuario);

}