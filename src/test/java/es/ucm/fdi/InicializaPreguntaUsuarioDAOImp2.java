package es.ucm.fdi;

import es.ucm.fdi.integracion.DAOs.PreguntaUsuarioDAO;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;

/**
 * Implementación de InicializaPreguntaUsuarioDAO
 */
public class InicializaPreguntaUsuarioDAOImp2 implements
		InicializaPreguntaUsuarioDAO {

	@Override
	public void inicializa(PreguntaUsuarioDAO preguntaUsuarioDAO) {
		for (int i = 1; i < 13; i++) {
			preguntaUsuarioDAO
					.save(new PreguntaUsuarioPOJO("a" + i, "franqui"));
		}
	}

}
