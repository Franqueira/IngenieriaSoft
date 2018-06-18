package es.ucm.fdi.integracion.DAOs;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.InicializaPreguntaUsuarioDAOImp1;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;

/**
 * Clase encargada de probar PreguntaUsuarioDAO
 */
public class PreguntaUsuarioDAOTest {
	private PreguntaUsuarioDAOImp preguntaUsuarioDAO = new PreguntaUsuarioDAOImp(
			new BDHashMap<PreguntaUsuarioPOJO>());

	@Before
	public void setup() {
		new InicializaPreguntaUsuarioDAOImp1().inicializa(preguntaUsuarioDAO);
	}
	
	/**
	 * @see InicializaPreguntaUsuarioDAOImp1
	 */
	@Test
	public void getPreguntasTest() {
		ArrayList<String> preguntas = preguntaUsuarioDAO
				.getPreguntas("peter_hy");
		assertTrue("Deberia contener la pregunta con el id",
				preguntas.contains("a1"));
		assertTrue("Deberia contener la pregunta con el id",
				preguntas.contains("a7"));
		assertFalse("No deberia contener la pregunta con el id",
				preguntas.contains("b1"));
	}

}
