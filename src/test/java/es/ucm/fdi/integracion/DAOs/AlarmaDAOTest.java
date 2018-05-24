package es.ucm.fdi.integracion.DAOs;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.CreadorDAOs;
import es.ucm.fdi.InicializaAlarmaDAOImp1;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

public class AlarmaDAOTest {
	private AlarmaDAO alarmaDAO = new AlarmaDAOImp(new BDHashMap<AlarmaPOJO>());

	@Before
	public void setup() {
		new InicializaAlarmaDAOImp1().inicializa(alarmaDAO);
	}

	@Test
	public void getActiveTest() {
		ArrayList<AlarmaPOJO> activas = alarmaDAO.getActive();
		System.out.println(activas);
		ArrayList<AlarmaPOJO> esperadas = new ArrayList<>();
		esperadas.add((AlarmaPOJO) alarmaDAO.getFromId("al1"));
		esperadas.add((AlarmaPOJO) alarmaDAO.getFromId("al2"));
		esperadas.add((AlarmaPOJO) alarmaDAO.getFromId("al3"));
		esperadas.add((AlarmaPOJO) alarmaDAO.getFromId("al5"));
		for (AlarmaPOJO e : esperadas) {
			assertTrue(activas.contains(e));
		}
	}
}
