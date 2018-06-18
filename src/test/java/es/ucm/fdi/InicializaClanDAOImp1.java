package es.ucm.fdi;

import es.ucm.fdi.integracion.DAOs.ClanDAO;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;

/**
 * Implementación de InicializaClanDAO
 */
public class InicializaClanDAOImp1 implements InicializaClanDAO {

	@Override
	public void inicializa(ClanDAO clanDAO) {
		clanDAO.save(new ClanPOJO("losPros", "miguel"));
		clanDAO.save(new ClanPOJO("Los Matinfos", "jc"));
	}

}
