package es.ucm.fdi.negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.*;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.ClanDAOImp;
import es.ucm.fdi.integracion.DAOs.FactoriaDAOs;
import es.ucm.fdi.integracion.DAOs.PreguntaClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

/**
 * Clase que contiene los test que comprueban la funcionalidad de TestperclanSA
 */

@SuppressWarnings("unchecked")
public class TestperclanSATest {
	@SuppressWarnings("rawtypes")
	FactoriaDAOs factoria = new FactoriaDAOs();
	private UsuarioDAOImp usuarioDAO = (UsuarioDAOImp) factoria.creaDAO(6,
			new BDHashMap<UsuarioPOJO>());
	private ClanDAOImp clanDAO = (ClanDAOImp) factoria.creaDAO(2,
			new BDHashMap<ClanPOJO>());
	private PreguntaClanDAOImp preguntaClanDAO = (PreguntaClanDAOImp) factoria
			.creaDAO(3, new BDHashMap<PreguntaClanPOJO>());
	private UsuarioClanDAO usuarioClanDAO = (UsuarioClanDAO) factoria.creaDAO(
			7, new BDHashMap<UsuarioClanPOJO>());
	private TestperclanSAImp testperclanSA;

	/**
	 * Creación de los clanes y de sus usuarios
	 */
	@Before
	public void setup() {
		new InicializaClanDAOImp1().inicializa(clanDAO);
		new InicializaUsuarioDAOImp1().inicializa(usuarioDAO);
		new InicializaUsuarioClanDAOImp1().inicializa(usuarioClanDAO);
		new InicializaPreguntaClanDAOImp1().inicializa(preguntaClanDAO);

		testperclanSA = new TestperclanSAImp(clanDAO, usuarioClanDAO,
				usuarioDAO, preguntaClanDAO);

	}

	/**
	 * Comprueba que el sistema ordena los usuarios en el ranking correctamente
	 * según su puntuación
	 * 
	 * @see InicializaClanDAOImp1 , InicializaUsuarioClanDAOImp1
	 */
	@Test
	public void getRankingTest() {
		ArrayList<UsuarioPOJO> ranking = testperclanSA
				.getRanking("Los Matinfos");
		ArrayList<UsuarioPOJO> esperado = new ArrayList<UsuarioPOJO>();
		esperado.add((UsuarioPOJO) usuarioDAO.getFromId("borisc"));
		esperado.add((UsuarioPOJO) usuarioDAO.getFromId("franqui"));
		esperado.add((UsuarioPOJO) usuarioDAO.getFromId("javigm"));
		esperado.add((UsuarioPOJO) usuarioDAO.getFromId("jc"));

		assertEquals("Se comprueba que los usuarios estan bien ordenados",
				ranking, esperado);
	}

	/**
	 * Comprueba que el sistema sabe reconocer cuál es el usuario ganador
	 * 
	 * @see InicializaClanDAOImp1 , InicializaUsuarioClanDAOImp1
	 */
	@Test
	public void setGanadorTest() {
		testperclanSA.setGanador("Los Matinfos");
		UsuarioPOJO ganador = testperclanSA.getRanking("Los Matinfos").get(0);
		UsuarioPOJO esperado = (UsuarioPOJO) usuarioDAO.getFromId("borisc");

		assertTrue("Se comprueba que el ganador es el correcto",
				ganador.equals(esperado));
	}

	/**
	 * Comprueba que el sistema elimina a un usuario correctamente
	 */
	@Test
	public void eliminarUsuarioClanTest() {
		testperclanSA.crearClan("borisc", "Testperteros");
		testperclanSA.anadirUsuarioClan("franqui", "Testperteros");
		assertTrue(
				"El clan debe tener a franqui y boris",
				usuarioClanDAO.getMiembrosClan("Testperteros").contains(
						"borisc")
						&& usuarioClanDAO.getMiembrosClan("Testperteros")
								.contains("franqui"));
		testperclanSA.eliminarUsuarioClan("borisc");
		assertFalse("boris no debe estar en el clan", usuarioClanDAO
				.getMiembrosClan("Testperteros").contains("borisc"));
		assertEquals("franqui debe ser el lider del clan", "franqui",
				((ClanPOJO) clanDAO.getFromId("Testperteros")).getLider());
		testperclanSA.eliminarUsuarioClan("franqui");
		assertTrue("Ya no debería existir el clan",
				clanDAO.getFromId("Testperteros") == null);
	}

	/**
	 * Comprueba que el sistema anade a un usuario correctamente
	 */
	@Test
	public void añadirUsuarioClanTest() {
		testperclanSA.anadirUsuarioClan("daniv", "Los Matinfos");
		testperclanSA.anadirUsuarioClan("sergil", "Los Matinfos");
		assertTrue("Deberia contener al usuario añadido", usuarioClanDAO
				.getMiembrosClan("Los Matinfos").contains("daniv"));
		assertTrue("Deberia contener al usuario añadido", usuarioClanDAO
				.getMiembrosClan("Los Matinfos").contains("sergil"));
	}

	/**
	 * Comprueba que el clan se ha creado correctamente con su correspondiente
	 * lider
	 */
	@Test
	public void crearClanTest() {
		testperclanSA.crearClan("javigm", "IS");
		assertTrue("Se debe haber creado el clan y Javi debería ser el líder",
				((ClanPOJO) clanDAO.getFromId("IS")).getLider()
						.equals("javigm"));
	}

	/**
	 * Comprueba que el clan genera correctamente la lista de preguntas del clan
	 */
	@Test
	public void preguntasClanTest() {
		ArrayList<String> esperado = new ArrayList<String>();
		for (int i = 1; i < 13; i++) {
			esperado.add("al" + i);
		}
		ArrayList<String> salida = testperclanSA.preguntasClan("losPros");
		for (String s : esperado) {
			assertTrue("La salida deberia contener la pregunta " + s,
					salida.contains(s));
		}
		assertTrue("El tamaño de la salida deberia ser igual al esperado",
				salida.size() == esperado.size());
	}
}