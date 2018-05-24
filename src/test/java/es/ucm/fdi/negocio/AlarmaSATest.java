package es.ucm.fdi.negocio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.InicializaAlarmaDAOImp1;
import es.ucm.fdi.InicializaAlarmaUsuarioDAOImp1;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.AlarmaDAO;
import es.ucm.fdi.integracion.DAOs.AlarmaDAOImp;
import es.ucm.fdi.integracion.DAOs.AlarmaUsuarioDAO;
import es.ucm.fdi.integracion.DAOs.AlarmaUsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.integracion.POJOs.AlarmaUsuarioPOJO;

/**
 * 
 * Contiene los test que que prueban la funcionalidad de la alarma
 *
 */

public class AlarmaSATest {
	private AlarmaDAOImp alarmaDAO = new AlarmaDAOImp(
			new BDHashMap<AlarmaPOJO>());
	private AlarmaUsuarioDAOImp alarmaUsuarioDAO = new AlarmaUsuarioDAOImp(
			new BDHashMap<AlarmaUsuarioPOJO>());
	private AlarmaSAImp alarmaSA;

	/**
	 * Creacion de las alarmas
	 */
	@Before
	public void setup() {
		new InicializaAlarmaDAOImp1().inicializa(alarmaDAO);
		new InicializaAlarmaUsuarioDAOImp1().inicializa(alarmaUsuarioDAO);
		alarmaSA = new AlarmaSAImp(alarmaDAO, alarmaUsuarioDAO);
	}

	/**
	 * @see InicializaAlarmaDAOImp1
	 */
	@Test
	public void getToneTest() {
		assertTrue("Debería estar la alarma",
				alarmaDAO.getFromId("al1") != null);
		assertEquals("Deberia ser el tono mytone1.mp3", "mytone1.mp3",
				alarmaSA.getTone("al1"));
		assertTrue("Deberia estar la alarma",
				alarmaDAO.getFromId("al2") != null);
		assertEquals("Deberia ser el tono whatsapp_audio3.mp3",
				"whatsapp_audio3.mp3", alarmaSA.getTone("al2"));
	}
	/**
	 * @see InicializaAlarmaDAOImp1
	 */
	@Test
	public void posponerAlarmaTest() {
		assertTrue("Debería estar la alarma",
				alarmaDAO.getFromId("al2") != null);
		alarmaSA.posponerAlarma("al2");
		AlarmaPOJO alarma2 = (AlarmaPOJO) alarmaDAO.getFromId("al2");
		assertTrue("Deberia haberse pospuesto hasta las 5:05",
				alarma2.getHoras() == 5 && alarma2.getMinutos() == 5);
		assertTrue("Deberia estar la alarma",
				alarmaDAO.getFromId("al3") != null);
		alarmaSA.posponerAlarma("al3");
		AlarmaPOJO alarma3 = (AlarmaPOJO) alarmaDAO.getFromId("al3");
		assertTrue("Deberia haberse pospuesto hasta las 16:52",
				alarma3.getHoras() == 16 && alarma3.getMinutos() == 52);
		alarmaSA.posponerAlarma("al3");
		alarma3 = (AlarmaPOJO) alarmaDAO.getFromId("al3");
		assertTrue("Deberia haberse pospuesto hasta las 16:57",
				alarma3.getHoras() == 16 && alarma3.getMinutos() == 57);
		alarmaSA.posponerAlarma("al3");
		alarma3 = (AlarmaPOJO) alarmaDAO.getFromId("al3");
		assertTrue("Deberia haberse pospuesto hasta las 17:02",
				alarma3.getHoras() == 17 && alarma3.getMinutos() == 2);
	}

	@Test
	public void anadirAlarmaTest() {
		alarmaSA.anadirAlarma(new AlarmaPOJO("mi_alarma", 10, 30, true,
				"mySong.mp3"), "javigm");
		assertTrue(
				"Deberia contenerla",
				alarmaUsuarioDAO.getAlarmasUsuario("javigm").contains(
						"mi_alarma"));
		alarmaSA.anadirAlarma(new AlarmaPOJO("alarm", 0, 0, true,
				"music123.mp3"), "franqui");
		assertTrue("Deberia contenerla",
				alarmaUsuarioDAO.getAlarmasUsuario("franqui").contains("alarm"));
	}

	/**
	 * @see InicializaAlarmaDAOImp1
	 */
	@Test
	public void eliminarAlarmaTest() {
		alarmaSA.eliminarAlarma("al1");
		assertTrue(!alarmaDAO.getActive().contains("al1"));
		assertTrue(!alarmaUsuarioDAO.getAlarmasUsuario("javigm")
				.contains("al1"));
	}

}
