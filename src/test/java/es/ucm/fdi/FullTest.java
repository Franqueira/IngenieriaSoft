package es.ucm.fdi;

import junit.framework.Assert;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.AlarmaDAOImp;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.negocio.AlarmaSAImp;

public class FullTest {
	
	private BDHashMap<AlarmaPOJO> BDalarma;
	//private BD<PreguntaPOJO> BDpregunta;
	//private BD<UsuarioPOJO> BDusuario;
	
	public FullTest(){
		this.BDalarma = new BDHashMap<AlarmaPOJO>();
		//this.BDpregunta = new BD<>();
		//this.BDusuario = new BD<>();
		
		setup();
	}

	private void setup(){
		
		AlarmaDAOImp alarmaDAO = new AlarmaDAOImp(BDalarma);
		alarmaDAO.saveAlarm(new AlarmaPOJO("al1", 12, 23, true, "aleat"));
		alarmaDAO.saveAlarm(new AlarmaPOJO("al2", 5, 0, false, "aleat"));
		alarmaDAO.saveAlarm(new AlarmaPOJO("al3", 16, 47, true, "song1.mp3"));
		alarmaDAO.saveAlarm(new AlarmaPOJO("al4", 0, 0, false, "song2.mp3"));
		
		//inicializar los demas para luego hacer el test
		
	}
	
	//@Test
	public void Testpertar(){
		AlarmaDAOImp alarmaDAO = new AlarmaDAOImp(BDalarma);
		AlarmaSAImp alarmaSA = new AlarmaSAImp(alarmaDAO);
		
		AlarmaPOJO a = alarmaDAO.getAlarma("al1");
		Assert.assertTrue("La alarma al1 debería existir", a!=null); //No se por que no va
		alarmaSA.reproducirAlarma(a);
	}

}
