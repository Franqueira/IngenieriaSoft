package es.ucm.fdi;

import es.ucm.fdi.integracion.DAOs.AlarmaDAO;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

/**
 * Implementación de InicializaAlarmaDAO
 */
public class InicializaAlarmaDAOImp2 implements InicializaAlarmaDAO {

	@Override
	public void inicializa(AlarmaDAO alarmaDAO) {
		alarmaDAO.save(new AlarmaPOJO("a1", 12, 23, true, "mytone1.mp3"));
		alarmaDAO
				.save(new AlarmaPOJO("a2", 5, 0, true, "whatsapp_audio3.mp3"));
		alarmaDAO.save(new AlarmaPOJO("a3", 16, 47, true, "song1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("a4", 0, 0, false, "song2.mp3"));
		alarmaDAO.save(new AlarmaPOJO("a5", 9, 10, false, "song3.mp3"));
		for (int i = 6; i < 17; i++) {
			alarmaDAO.save(new AlarmaPOJO("a" + i, 12, 23, true, "mytone1.mp3"));
		}

	}

}
