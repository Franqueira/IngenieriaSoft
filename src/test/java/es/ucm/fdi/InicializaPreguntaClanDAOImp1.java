package es.ucm.fdi;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.PreguntaClanDAO;
import es.ucm.fdi.integracion.DAOs.PreguntaClanDAOImp;
import es.ucm.fdi.integracion.POJOs.PreguntaClanPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;

public class InicializaPreguntaClanDAOImp1 implements InicializaPreguntaClanDAO{

	public void inicializa(PreguntaClanDAO preguntaClanDAO) {
		for (int i = 1; i < 13; i++) {
			preguntaClanDAO
					.save(new PreguntaClanPOJO("a" + i, "losPros"));
		}
		
	}

}
