package es.ucm.fdi;

import es.ucm.fdi.integracion.DAOs.ClanDAO;

/**
 * Clase encargada de inicializar un ClanDAO
 */
public interface InicializaClanDAO {
	
	/**
	 * Función inicializadora del ClanDAO
	 * 
	 * @param clanDAO
	 */
	public void inicializa(ClanDAO clanDAO);
}
