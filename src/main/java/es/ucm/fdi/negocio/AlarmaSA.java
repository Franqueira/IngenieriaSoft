package es.ucm.fdi.negocio;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

/**
 * 
 * Contiene las funcionalidades de la aplicación (a nivel de servidor) que
 * trabajan con alarmas.
 *
 */
public interface AlarmaSA {
	/**
	 * 
	 * @param alarma
	 *            alarma de la que queremos conocer su tono para reproducir.
	 * @return el nombre del archivo .mp3 con el tono a reproducir.
	 */
	public String getTone(String alarma);

	/**
	 * 
	 * @param alarma
	 *            alarma que queremos posponer. Pospone la alarma en cinco
	 *            minutos.
	 */
	public void posponerAlarma(String alarma);

	/**
	 * 
	 * @param alarma
	 *            alarma a anadir.
	 * @param idUsuario
	 *            id del usuario al que se le va a anadir la alarma Anade una
	 *            nueva alarma en la base de datos de las alarmas.
	 */
	public void anadirAlarma(AlarmaPOJO alarma, String idUsuario);

	/**
	 * 
	 * @param idAlarma
	 *            id de la alarma a eliminar. Elimina la alarma en cuestion.
	 */
	public void eliminarAlarma(String idAlarma);
}
