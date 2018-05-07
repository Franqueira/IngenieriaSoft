package es.ucm.fdi.negocio;

/**
 * 
 * Contiene las funcionalidades de la aplicación (a 
 *
 */
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;

public interface PreguntaSA {
	public boolean comprobarRespuesta(String idPregunta, int respuesta);
	
	public void ElminarPregunta(String idPregunta,String idUsuario);
	
	public void AnadirPregunta(PreguntaPOJO pregunta,String idUsuario);
	
}
