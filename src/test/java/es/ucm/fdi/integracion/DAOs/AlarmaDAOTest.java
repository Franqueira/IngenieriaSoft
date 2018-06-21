package es.ucm.fdi.integracion.DAOs;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.InicializaAlarmaDAOImp1;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

/**
 * Clase que prueba AlarmaDAO
 */
public class AlarmaDAOTest {
	@SuppressWarnings("rawtypes")
	FactoriaDAOs factoria = new FactoriaDAOs();
	@SuppressWarnings("unchecked")
	private AlarmaDAO alarmaDAO = (AlarmaDAO) factoria.creaDAO(0,new BDHashMap<AlarmaPOJO>());
	@Before
	public void setup() {
		new InicializaAlarmaDAOImp1().inicializa(alarmaDAO);
	}

	/**
	 * @see InicializaAlarmaDAOImp1
	 */
	@Test
	public void getActiveTest() {
		ArrayList<AlarmaPOJO> activas = alarmaDAO.getActive();
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
