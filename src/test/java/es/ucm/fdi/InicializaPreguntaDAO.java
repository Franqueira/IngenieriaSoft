package es.ucm.fdi;

import es.ucm.fdi.integracion.DAOs.PreguntaDAO;

/**
 * Clase encargada de inicializar un preguntaDAO
 */
public interface InicializaPreguntaDAO {
	
	/**
	 * Función inicializadora del PreguntaDAO
	 * 
	 * @param preguntaDAO
	 */
	public void inicializa(PreguntaDAO preguntaDAO);
}
