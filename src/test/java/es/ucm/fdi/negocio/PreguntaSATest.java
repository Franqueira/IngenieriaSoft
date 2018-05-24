package es.ucm.fdi.negocio;

/**
 * 
 * Contiene los test que comprueban la funcionalidad de PreguntaSA
 * 
 */

import es.ucm.fdi.*;
import es.ucm.fdi.integracion.POJOs.PreguntaClanPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.PreguntaClanDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaDAO;
import es.ucm.fdi.integracion.DAOs.PreguntaDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaUsuarioDAO;
import es.ucm.fdi.integracion.DAOs.PreguntaUsuarioDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;

public class PreguntaSATest {
	private PreguntaDAOImp preguntaDAO = new PreguntaDAOImp(
			new BDHashMap<PreguntaPOJO>());
	private PreguntaClanDAOImp preguntaClanDAO = new PreguntaClanDAOImp(
			new BDHashMap<PreguntaClanPOJO>());
	private UsuarioDAOImp usuarioDAO = new UsuarioDAOImp(
			new BDHashMap<UsuarioPOJO>());
	private PreguntaUsuarioDAO preguntaUsuarioDAO = new PreguntaUsuarioDAOImp(
			new BDHashMap<PreguntaUsuarioPOJO>());
	private PreguntaSA preguntaSA;

	/**
	 * Creaccion de las preguntas
	 */
	@Before
	public void setup() {
		new InicializaPreguntaDAOImp1().inicializa(preguntaDAO);
		new InicializaPreguntaUsuarioDAOImp1().inicializa(preguntaUsuarioDAO);
		// preguntaSA = new PreguntaSAImp(preguntaDAO);
		preguntaSA = new PreguntaSAImp(preguntaDAO, preguntaUsuarioDAO,
				usuarioDAO, preguntaClanDAO);

	}
	/**
	 * @see InicializaPreguntaDAOImp1
	 */
	@Test
	public void vincularCategoriaTest() {
		preguntaSA.vincularCategoria("geografía", "javigm");
		ArrayList<PreguntaPOJO> l1 = preguntaDAO
				.getPreguntasPorCategoria("geografía");
		ArrayList<PreguntaPOJO> l2 = preguntaDAO
				.getPreguntas(preguntaUsuarioDAO.getPreguntas("javigm"));
		for (PreguntaPOJO p : l1) {
			assertTrue(l2.contains(p));
		}
		for (PreguntaPOJO p : l2) {
			assertTrue(l1.contains(p));
		}

		// Si vinculamos las preguntas de una categoria inexistente,
		// no hacemos nada.
		preguntaSA.vincularCategoria("deportes", "borisc");
		assertTrue("Se esperaba una lista vacia", preguntaUsuarioDAO
				.getPreguntas("borisc").isEmpty());
	}

	/**
	 * @see InicializaPreguntaDAOimp1
	 */
	@Test
	public void desvincularCategoriaTest() {
		ArrayList<PreguntaPOJO> l1 = preguntaDAO
				.getPreguntasPorCategoria("geografía");
		ArrayList<PreguntaPOJO> l2 = preguntaDAO
				.getPreguntas(preguntaUsuarioDAO.getPreguntas("peter_hy"));
		for (PreguntaPOJO p : l1)
			assertTrue(l2.contains(p));
		for (PreguntaPOJO p : l2)
			assertTrue(l1.contains(p));

		preguntaSA.desvincularCategoria("geografía", "peter_hy");
		assertTrue("Se esperaba que no tuviese preguntas vinculadas",
				preguntaUsuarioDAO.getPreguntas("peter_hy").isEmpty());
		preguntaSA.vincularCategoria("geografia", "franqui");
		preguntaSA.vincularCategoria("historia", "franqui");
		ArrayList<PreguntaPOJO> preguntasFranqui = new ArrayList<>();
		for (PreguntaPOJO p : preguntaDAO.getPreguntasPorCategoria("geografia"))
			preguntasFranqui.add(p);
		for (PreguntaPOJO p : preguntaDAO.getPreguntasPorCategoria("historia"))
			preguntasFranqui.add(p);
		l1.clear();
		l1 = preguntaDAO.getPreguntas(preguntaUsuarioDAO
				.getPreguntas("franqui"));
		for (PreguntaPOJO p : preguntasFranqui)
			assertTrue(l1.contains(p));
		for (PreguntaPOJO p : l1)
			assertTrue(preguntasFranqui.contains(p));

		// Desvinculamos geografia, se queda solo con las de historia
		preguntaSA.desvincularCategoria("geografía", "franqui");
		l1.clear();
		l2.clear();
		l1 = preguntaDAO.getPreguntasPorCategoria("historia");
		l2 = preguntaDAO.getPreguntas(preguntaUsuarioDAO
				.getPreguntas("franqui"));
		for (PreguntaPOJO p : l1)
			assertTrue(l2.contains(p));
		for (PreguntaPOJO p : l2)
			assertTrue(l1.contains(p));
	}

}
