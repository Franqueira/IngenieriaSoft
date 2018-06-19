package es.ucm.fdi;

import es.ucm.fdi.integracion.DAOs.ClanDAO;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;

/**
 * Implementación de InicializaClanDAO
 */
public class InicializaClanDAOImp2 implements InicializaClanDAO {

	@Override
	public void inicializa(ClanDAO clanDAO) {
		clanDAO.save(new ClanPOJO("losPros", "franqui"));
		clanDAO.save(new ClanPOJO("Los Matinfos", "javigm"));
	}

}
