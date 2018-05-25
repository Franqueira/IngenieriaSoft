package es.ucm.fdi;

import es.ucm.fdi.integracion.DAOs.UsuarioClanDAO;

/**
 * Clase encargada de inicializar un UsuarioClanDAO
 */
public interface InicializaUsuarioClanDAO {
	
	/**
	 * Función inicializadora del UsuarioClanDAO
	 * 
	 * @param usuarioClanDAO
	 */
	public void inicializa(UsuarioClanDAO usuarioClanDAO);
}
