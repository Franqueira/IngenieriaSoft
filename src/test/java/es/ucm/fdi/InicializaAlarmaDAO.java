package es.ucm.fdi;

import es.ucm.fdi.integracion.DAOs.AlarmaDAO;

/**
 * Clase encargada de inicializar un AlarmaDAO
 */
public interface InicializaAlarmaDAO {
	
	/**
	 * Función inicializadora del AlarmaDAO
	 * 
	 * @param alarmaDAO	
	 */
	public void inicializa(AlarmaDAO alarmaDAO);
}
