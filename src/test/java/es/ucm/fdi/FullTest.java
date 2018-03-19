package es.ucm.fdi;

import es.ucm.fdi.datos.BD;
import es.ucm.fdi.integracion.AlarmaDAO;
import es.ucm.fdi.integracion.AlarmaPOJO;
import es.ucm.fdi.negocio.AlarmaSA;

public class FullTest {
	
	private BD<AlarmaPOJO> BDalarma;
	//private BD<TonoPOJO> BDtono;
	//private BD<PreguntaPOJO> BDpregunta;
	//private BD<UsuarioPOJO> BDusuario;
	
	public FullTest(){
		this.BDalarma = new BD<>();
		//this.BDtono = new BD<>();
		//this.BDpregunta = new BD<>();
		//this.BDusuario = new BD<>();
		
		inicializar();
	}

	private void inicializar(){
		
		AlarmaDAO alarmaDAO = new AlarmaDAO(BDalarma);
		alarmaDAO.saveAlarm(new AlarmaPOJO("al1", 12, 23, true, "aleat"));
		alarmaDAO.saveAlarm(new AlarmaPOJO("al2", 5, 0, false, "aleat"));
		alarmaDAO.saveAlarm(new AlarmaPOJO("al3", 16, 47, true, "song1.mp3"));
		alarmaDAO.saveAlarm(new AlarmaPOJO("al4", 0, 0, false, "song2.mp3"));
		
		//inicializar los demas para luego hacer el test
		
	}
	
	//@Test
	public void Testpertar(){
		AlarmaDAO alarmaDAO = new AlarmaDAO(BDalarma);
		TonoDAO tonoDAO= new TonoDAO(BDtono);
		AlarmaSA alarmaSA = new AlarmaSA(alarmaDAO, tonoDAO);
		
		AlarmaPOJO a = alarmaDAO.getAlarma("al1");
		assertTrue("La alarma al1 debería existir", a!=null); //No se por que no va
		alarmaSA.reproducirAlarma(a);
	}

}
