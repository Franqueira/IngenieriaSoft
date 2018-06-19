package es.ucm.fdi;

import es.ucm.fdi.integracion.DAOs.PreguntaClanDAO;
import es.ucm.fdi.integracion.POJOs.PreguntaClanPOJO;

/**
 * Implementación de InicializaPreguntaClanDAO
 */
public class InicializaPreguntaClanDAOImp1 implements InicializaPreguntaClanDAO{

	public void inicializa(PreguntaClanDAO preguntaClanDAO) {
		for (int i = 1; i < 13; i++) {
			preguntaClanDAO.save(new PreguntaClanPOJO("al" + i, "losPros"));
		}
		
	}

}
