package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

/**
 * Contiene las funcionalidades de la aplicación (a nivel de servidor) que
 * trabajan con alarmas
 */
public interface AlarmaSA {
	/**
	 * Obtiene el tono de una alarma
	 * 
	 * @param alarma
	 *            alarma de la que queremos conocer su tono para reproducir
	 * @return el nombre del archivo .mp3 con el tono a reproducir
	 */
	public String getTone(String alarma);

	/**
	 * Pospone la alarma pasada en cinco minutos
	 * 
	 * @param alarma
	 *            alarma que queremos posponer.
	 */
	public void posponerAlarma(String alarma);

	/**
	 * Anade una nueva alarma en la base de datos de las alarmas conectandola al ususario pasado
	 * 
	 * @param alarma
	 *            alarma a anadir.
	 * @param idUsuario
	 *            id del usuario al que se le va a anadir la alarma 
	 */
	public void anadirAlarma(AlarmaPOJO alarma, String idUsuario);

	/**
	 * Elimina la alarma pasada
	 * 
	 * @param idAlarma
	 *            id de la alarma a eliminar. 
	 */
	public void eliminarAlarma(String idAlarma);
}
