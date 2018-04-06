package es.ucm.fdi.integracion.DAOs;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

public class AlarmaDAOTest {
	
	
	public void setup(AlarmaDAOImp alarmaDAO){
		
		alarmaDAO.save(new AlarmaPOJO("al1", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al2", 5, 0, false, "whatsapp_audio3.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al3", 16, 47, true, "song1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al4", 0, 0, false, "song2.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al5", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al6", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al7", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al8", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al9", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al10", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al11", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al13", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al14", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al15", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al16", 12, 23, true, "mytone1.mp3"));
		AlarmaPOJO al1 =  (AlarmaPOJO) alarmaDAO.getFromId("al1");
		al1.setActiva(true);
		AlarmaPOJO al2 =  (AlarmaPOJO) alarmaDAO.getFromId("al2");
		al2.setActiva(true);
		AlarmaPOJO al3 =  (AlarmaPOJO) alarmaDAO.getFromId("al3");
		al3.setActiva(true);
		AlarmaPOJO al4 =  (AlarmaPOJO) alarmaDAO.getFromId("al4");
		al4.setActiva(true);
		
	}
	@Test
	public void getAlarmaTest(){
	
	}
	
	@Test
	public void saveAlarmTest(){
		
	}
	@Test
	public void removeAlarmTest(){
		
	}
	@Test
	public void getActiveTest(){
		AlarmaDAOImp alarmaDAO = new AlarmaDAOImp(new BDHashMap<AlarmaPOJO>());
		setup(alarmaDAO);
		ArrayList<AlarmaPOJO> activas = alarmaDAO.getActive();
		ArrayList<AlarmaPOJO> esperadas = new ArrayList<>();
		esperadas.add((AlarmaPOJO) alarmaDAO.getFromId("al1"));
		esperadas.add((AlarmaPOJO) alarmaDAO.getFromId("al2"));
		esperadas.add((AlarmaPOJO) alarmaDAO.getFromId("al3"));
		esperadas.add((AlarmaPOJO) alarmaDAO.getFromId("al4"));
		assertEquals("Se esperaba que las alarmas activas fuesen al1, al2, al3, al4", esperadas, activas);
		
	}
}
