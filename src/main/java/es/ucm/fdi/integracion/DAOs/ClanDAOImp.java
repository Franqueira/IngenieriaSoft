package es.ucm.fdi.integracion.DAOs;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;

/**
 * 
 * Operaciones relacionadas con el acceso a memoria de datos de los
 * diferentes clanes de la aplicación.
 *
 */
public class ClanDAOImp extends HashMapDAOImp<ClanPOJO> implements DAO<ClanPOJO>{

	public ClanDAOImp(BDHashMap<ClanPOJO> BD) {
		super(BD);
	}
	
}
