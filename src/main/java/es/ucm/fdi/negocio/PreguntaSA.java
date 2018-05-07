package es.ucm.fdi.negocio;

/**
 * 
<<<<<<< HEAD
 * Contiene las funcionalidades de la aplicación (a 
 *
 */
=======
 * Contiene los servicios funcionales de la aplicación (a nivel de servidor)
 * que trabajan con preguntas.
 *
 */

>>>>>>> branch 'master' of https://github.com/Franqueira/IngenieriaSoft.git
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;

public interface PreguntaSA {
	
	/**
	 * 
	 * @param idPregunta id de la pregunta a consultar.
	 * @param respuesta respuesta contestada de la pregunta.
	 * @return devuelve un boolean que representa si la pregunta ha sido contestada correctamente.
	 */
	public boolean comprobarRespuesta(String idPregunta, int respuesta);
	
	public void ElminarPregunta(String idPregunta,String idUsuario);
	
	public void AnadirPregunta(PreguntaPOJO pregunta,String idUsuario);
	
}
