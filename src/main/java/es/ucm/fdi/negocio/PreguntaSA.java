package es.ucm.fdi.negocio;

/**
 * Contiene los servicios funcionales de la aplicación (a nivel de servidor)
 * que trabajan con preguntas.
 *
 */


import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;

public interface PreguntaSA {
	
	/**
	 * 
	 * @param idPregunta id de la pregunta a consultar.
	 * @param respuesta respuesta contestada de la pregunta.
	 * @return devuelve un boolean que representa si la pregunta ha sido contestada correctamente.
	 */
	
	public void desvincularCategoria(String categoria, String idUsuario);
	
	public void vincularCategoria(String categoria, String idUsuario);
	
	public void agregarPregunta(PreguntaPOJO pregunta);
	
	public void eliminarPregunta(String idPregunta);
	
}