package es.ucm.fdi.negocio;

/**
 * 
 * Contiene los servicios funcionales de la aplicación (a nivel de servidor)
 * que trabajan con preguntas.
 *
 */
public interface PreguntaSA {
	
	/**
	 * 
	 * @param idPregunta id de la pregunta a consultar.
	 * @param respuesta respuesta contestada de la pregunta.
	 * @return devuelve un boolean que representa si la pregunta ha sido contestada correctamente.
	 */
	public boolean comprobarRespuesta(String idPregunta, int respuesta);
	
}
