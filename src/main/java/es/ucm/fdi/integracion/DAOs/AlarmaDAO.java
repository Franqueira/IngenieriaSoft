package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

/**
 * 
 * Realiza las acciones de acceso a memoria relacionadas
 * con las alarmas de la aplicacion
 *
 */
public interface AlarmaDAO extends DAO<AlarmaPOJO>{
	/**
	 * @return una lista con todas las alarmas activas en el servidor
	 */
	
	public ArrayList<AlarmaPOJO> getActive();
	
}
