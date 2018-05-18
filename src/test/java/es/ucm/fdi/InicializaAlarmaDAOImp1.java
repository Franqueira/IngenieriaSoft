package es.ucm.fdi;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.AlarmaDAO;
import es.ucm.fdi.integracion.DAOs.AlarmaDAOImp;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

public class InicializaAlarmaDAOImp1 implements InicializaAlarmaDAO{

	@Override
	public void inicializa(AlarmaDAO alarmaDAO) {
		alarmaDAO=new AlarmaDAOImp(new BDHashMap<AlarmaPOJO>());
		alarmaDAO.save(new AlarmaPOJO("al1", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al2", 5, 0, true, "whatsapp_audio3.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al3", 16, 47, true, "song1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al4", 0, 0, false, "song2.mp3"));
		for(int i = 5; i<17;i++){
			alarmaDAO.save(new AlarmaPOJO("al"+i, 12, 23, true, "mytone1.mp3"));
		}
		
	}

}
