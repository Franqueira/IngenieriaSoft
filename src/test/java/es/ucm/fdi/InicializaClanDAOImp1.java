package es.ucm.fdi;

import es.ucm.fdi.integracion.DAOs.ClanDAO;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;

public class InicializaClanDAOImp1 implements InicializaClanDAO {

	@Override
	public void inicializa(ClanDAO clanDAO) {
		clanDAO.save(new ClanPOJO("losPros", "miguel"));
		clanDAO.save(new ClanPOJO("Los Matinfos", "jc"));
	}

}
