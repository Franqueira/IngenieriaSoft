package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.AlarmaUsuarioPOJO;

/**
 * Operaciones con BD que requieren datos de usuarios y alarmas, tales como
 * obtener la lista de alaramas de un usuario
 */
public interface AlarmaUsuarioDAO extends DAO<AlarmaUsuarioPOJO> {

	/**
	 * Obtiene todas las alarmas de un usuario
	 * 
	 * @param idUsuario
	 *            usuario del que queremos obtener su lista de alarmas
	 * @return lista de alarmas del usuario con id idUsuario
	 */
	public ArrayList<String> getAlarmasUsuario(String idUsuario);

}
