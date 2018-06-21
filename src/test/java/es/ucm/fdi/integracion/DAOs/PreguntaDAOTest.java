package es.ucm.fdi.integracion.DAOs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.InicializaPreguntaDAOImp1;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;

/**
 * Clase encargada de probar PreguntaDAO
 */
public class PreguntaDAOTest {
	FactoriaDAOs<PreguntaPOJO> factoria = new FactoriaDAOs<PreguntaPOJO>();
	private PreguntaDAO preguntaDAO = (PreguntaDAO) factoria.creaDAO(4,
			new BDHashMap<PreguntaPOJO>());

	@Before
	public void setup() {
		new InicializaPreguntaDAOImp1().inicializa(preguntaDAO);
	}
	/**
	 * @see InicializaPreguntaDAOImp1
	 */
	@Test
	public void getAllTest() {
		ArrayList<PreguntaPOJO> todas = preguntaDAO.getAll();
		ArrayList<PreguntaPOJO> esperadas = new ArrayList<>();

		for (int i = 1; i < 17; i++) {
			esperadas.add((PreguntaPOJO) preguntaDAO.getFromId("al" + i));
		}

		for (PreguntaPOJO a : todas) {
			assertTrue(esperadas.contains(a));
		}
	}
	/**
	 * @see InicializaPreguntaDAOImp1
	 */
	@Test
	public void getPreguntasTest() {

		ArrayList<String> lista = new ArrayList<String>();
		lista.add("al1");
		lista.add("al5");
		lista.add("al11");
		ArrayList<PreguntaPOJO> preguntas = preguntaDAO.getPreguntas(lista);
		ArrayList<PreguntaPOJO> esperadas = new ArrayList<>();

		esperadas.add((PreguntaPOJO) preguntaDAO.getFromId("al1"));
		esperadas.add((PreguntaPOJO) preguntaDAO.getFromId("al5"));
		esperadas.add((PreguntaPOJO) preguntaDAO.getFromId("al11"));

		assertEquals("Se esperaban las preguntas al1, al5 y al11", esperadas,
				preguntas);
	}
}
