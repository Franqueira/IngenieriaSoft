package es.ucm.fdi.integracion.DAOs;

import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

/**
 * 
 * Contiene operaciones de acceso a memoria que trabajan con datos de usuarios
 * de la aplicación
 */

public interface UsuarioDAO extends DAO<UsuarioPOJO> {
	/**
	 * 
	 * @param nombreReal
	 *            nombreReal del usurio a buscar
	 * @return el POJO del usuario con el nombre nombreReal
	 */
	public UsuarioPOJO find(String nombreReal);

}
