package es.ucm.fdi.negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.*;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.ClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

/**
 * Clase que contiene los test que comprueban la funcionalidad de PreguntaSA
 */

public class TestperclanSATest {
	UsuarioDAOImp usuarioDAO;
	ClanDAOImp clanDAO;
	UsuarioClanDAO usuarioClanDAO;
	TestperclanSAImp testperclanSA;
	
	/**
	 * Creaccion de los clanes y de sus usuarios
	 */
	@Before
	public void setup(){
		new InicializaClanDAOImp1().inicializa(clanDAO);
		new InicializaUsuarioDAOImp1().inicializa(usuarioDAO);
		new InicializaUsuarioClanDAOImp1().inicializa(usuarioClanDAO);
		testperclanSA = new TestperclanSAImp(clanDAO, usuarioClanDAO,usuarioDAO);
		
			
	}
	
	/**
	 * Comprueba que el sistema ordena los usuarios en el ranking correctamente según su puntuación
	 */
	@Test
	public void getRankingTest() {
		ArrayList<UsuarioPOJO> ranking = testperclanSA.getRanking("Los Matinfos");
		ArrayList<UsuarioPOJO> esperado = new ArrayList<UsuarioPOJO>();
		esperado.add((UsuarioPOJO) usuarioDAO.getFromId("borisc"));
		esperado.add((UsuarioPOJO) usuarioDAO.getFromId("franqui"));
		esperado.add((UsuarioPOJO) usuarioDAO.getFromId("javigm"));
		esperado.add((UsuarioPOJO) usuarioDAO.getFromId("jc"));
	
		assertEquals("Se comprueba que los usuarios estan bien ordenados",ranking, esperado);
	}
	
	/**
	 * Comprueba que el sistema sabe reconocer cuál es el usuario ganador
	 */
	@Test
	public void setGanadorTest() {
		testperclanSA.setGanador("Los Matinfos");
		UsuarioPOJO ganador = testperclanSA.getRanking("Los Matinfos").get(0); 
		UsuarioPOJO esperado = (UsuarioPOJO) usuarioDAO.getFromId("borisc");
		
		assertTrue("Se comprueba que el ganador es el correcto", ganador.equals(esperado));
	}
	
	/**
	 * Comprueba que el sistema elimina a un usuario correctamente
	 */
	@Test
	public void eliminarUsuarioClanTest() {
		testperclanSA.eliminarUsuarioClan("borisc");
		testperclanSA.eliminarUsuarioClan("franqui");
		assertFalse("No eberia contener al usuario añadido", usuarioClanDAO.getMiembrosClan("Los Matinfos").contains("borisc"));
		assertFalse("No deberia contener al usuario añadido", usuarioClanDAO.getMiembrosClan("Los Matinfos").contains("franqui"));
	}

	/**
	 * Comprueba que el sistema añade a un usuario correctamente
	 */
	@Test
	public void añadirUsuarioClanTest() {
		testperclanSA.anadirUsuarioClan("daniv", "Los Matinfos");
		testperclanSA.anadirUsuarioClan("sergil", "Los Matinfos");
		assertTrue("Deberia contener al usuario añadido", usuarioClanDAO.getMiembrosClan("Los Matinfos").contains("daniv"));
		assertTrue("Deberia contener al usuario añadido", usuarioClanDAO.getMiembrosClan("Los Matinfos").contains("sergil"));
	}
	
	/**
	 * Comprueba que el clan se ha creado correctamente con su correspondiente lider
	 */
	@Test
	public void crearClanTest() {
		assertTrue("Se debe haber creado el clan y Javi debería ser el líder",((ClanPOJO)clanDAO.getFromId("Los Matinfos")).getLider().equals("javigm"));
	}
}