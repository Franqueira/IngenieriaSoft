package es.ucm.fdi.negocio;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

/**
 * 
 * Contiene las funcionalidades de la aplicación (a nivel de servidor)
 * que trabajan con alarmas.
 *
 */
public interface AlarmaSA {
	/**
	 * 
	 * @param alarma alarma de la que queremos conocer su tono para reproducir
	 * @return el nombre del archivo .mp3 con el tono a reproducir.
	 */
	public String getTone(String alarma);
	public void postponerAlarma(String alarma);
}
