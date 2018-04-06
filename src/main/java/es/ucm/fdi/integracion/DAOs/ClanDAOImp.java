package es.ucm.fdi.integracion.DAOs;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;

public class ClanDAOImp extends HashMapDAO<ClanPOJO> implements DAO<ClanPOJO>{

	public ClanDAOImp(BDHashMap<ClanPOJO> BD) {
		super(BD);
	}
	
}
