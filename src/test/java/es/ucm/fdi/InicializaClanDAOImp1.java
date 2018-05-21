package es.ucm.fdi;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.ClanDAO;
import es.ucm.fdi.integracion.DAOs.ClanDAOImp;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;

public class InicializaClanDAOImp1 implements InicializaClanDAO {

	@Override
	public void inicializa(ClanDAO clanDAO) {
		clanDAO = new ClanDAOImp(new BDHashMap<ClanPOJO>());
		clanDAO.save(new ClanPOJO("losPros", "miguel"));
	}

}
