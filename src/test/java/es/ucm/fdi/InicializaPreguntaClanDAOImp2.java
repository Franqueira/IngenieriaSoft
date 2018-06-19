package es.ucm.fdi;

import es.ucm.fdi.integracion.DAOs.PreguntaClanDAO;
import es.ucm.fdi.integracion.POJOs.PreguntaClanPOJO;

/**
 * Implementación de InicializaPreguntaClanDAO
 */
public class InicializaPreguntaClanDAOImp2 implements InicializaPreguntaClanDAO {

	@Override
	public void inicializa(PreguntaClanDAO preguntaClanDAO) {
		for (int i = 1; i < 13; i++) {
			preguntaClanDAO.save(new PreguntaClanPOJO("a" + i, "Los Matinfos"));
		}
	}

}
