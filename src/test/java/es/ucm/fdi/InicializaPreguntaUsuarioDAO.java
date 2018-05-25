package es.ucm.fdi;

import es.ucm.fdi.integracion.DAOs.PreguntaUsuarioDAO;

/**
 * Clase encargada de inicializar un PreguntaUsuarioDAO
 */
public interface InicializaPreguntaUsuarioDAO {
	
	/**
	 * Función inicializadora del PreguntaUsuarioDAO
	 * 
	 * @param preguntaUsuarioDAO
	 */
	public void inicializa(PreguntaUsuarioDAO preguntaUsuarioDAO);
}
