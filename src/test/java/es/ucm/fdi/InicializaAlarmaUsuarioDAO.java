package es.ucm.fdi;

import es.ucm.fdi.integracion.DAOs.AlarmaUsuarioDAO;

/**
 * Clase encargada de inicializar un AlarmaUsuarioDAO
 */
public interface InicializaAlarmaUsuarioDAO {
	
	/**
	 * Función inicializadora del AlarmaUsuarioDAO
	 * 
	 * @param alarmaUsuarioDAO	
	 */
	public void inicializa(AlarmaUsuarioDAO alarmaUsuarioDAO);
}
