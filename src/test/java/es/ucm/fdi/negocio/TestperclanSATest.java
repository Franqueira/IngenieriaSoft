package es.ucm.fdi.negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.*;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.ClanDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

/**
 * 
 * Clase que contiene los test que comprueban la funcionalidad de TestperclanSA
 *
 */

public class TestperclanSATest {
	private UsuarioDAOImp usuarioDAO = new UsuarioDAOImp(
			new BDHashMap<UsuarioPOJO>());
	private ClanDAOImp clanDAO = new ClanDAOImp(new BDHashMap<ClanPOJO>());
	private PreguntaClanDAOImp preguntaClanDAO = new PreguntaClanDAOImp(
			new BDHashMap<PreguntaClanPOJO>());
	private UsuarioClanDAO usuarioClanDAO = new UsuarioClanDAOImp(
			new BDHashMap<UsuarioClanPOJO>());
	private TestperclanSAImp testperclanSA;

	/**
	 * Creacion de los clanes y de sus usuarios
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
	 * Comprueba que el sistema añade a un usuario correctamente
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
}