package es.ucm.fdi.negocio;

/**
 * Contiene los test que comprueban la funcionalidad de PreguntaSA
 */

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.InicializaPreguntaDAOImp1;
import es.ucm.fdi.InicializaPreguntaUsuarioDAOImp1;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.FactoriaDAOs;
import es.ucm.fdi.integracion.DAOs.PreguntaClanDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaUsuarioDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.PreguntaClanPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

@SuppressWarnings("unchecked")
public class PreguntaSATest {
	@SuppressWarnings("rawtypes")
	FactoriaDAOs factoria = new FactoriaDAOs();
	private PreguntaDAOImp preguntaDAO = (PreguntaDAOImp) factoria.creaDAO(4,
			new BDHashMap<PreguntaPOJO>());
	private PreguntaClanDAOImp preguntaClanDAO = (PreguntaClanDAOImp) factoria
			.creaDAO(3, new BDHashMap<PreguntaClanPOJO>());
	private UsuarioDAOImp usuarioDAO = (UsuarioDAOImp) factoria.creaDAO(6,
			new BDHashMap<UsuarioPOJO>());
	private PreguntaUsuarioDAO preguntaUsuarioDAO = (PreguntaUsuarioDAO) factoria
			.creaDAO(5, new BDHashMap<PreguntaUsuarioPOJO>());
	private PreguntaSA preguntaSA;

	/**
	 * Creación de las preguntas
	 */
	@Before
	public void setup() {
		new InicializaPreguntaDAOImp1().inicializa(preguntaDAO);
		new InicializaPreguntaUsuarioDAOImp1().inicializa(preguntaUsuarioDAO);
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
