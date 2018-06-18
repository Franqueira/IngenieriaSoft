package es.ucm.fdi;

import es.ucm.fdi.integracion.DAOs.UsuarioDAO;

/**
 * Clase encargada de inicializar un UsuarioDAO
 */
public interface InicializaUsuarioDAO {
	
	/**
	 * Función inicializadora del UsuarioDAO
	 * 
	 * @param usuario
	 */
	public void inicializa(UsuarioDAO usuario);
}
