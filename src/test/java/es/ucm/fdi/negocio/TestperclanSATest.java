package es.ucm.fdi.negocio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.ClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

public class TestperclanSATest {
	
	public void setup(UsuarioDAOImp usuarioDAO, ClanDAOImp clanDAO, UsuarioClanDAO usuarioClanDAO, TestperclanSA testperclanSA){
		//Creacion de usuarios
		usuarioDAO.save(new UsuarioPOJO("javigm", "Javier Guzman", 1001, "hola123", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("borisc", "Boris Carballa", 1244, "soyboris", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("franqui", "Miguel Franqueira", 1111, "soyFranqui", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("jc", "JC Villanueva", 108, "soyjc", "Spain"));
		
		//Creacion de clanes
		testperclanSA.crearClan("javigm", "Los Matinfos");
		testperclanSA.anadirUsuarioClan("borisc", "Los Matinfos");
		testperclanSA.anadirUsuarioClan("jc", "Los Matinfos");
		testperclanSA.anadirUsuarioClan("franqui", "Los Matinfos");
			
	}
	
	@Test
	public void getRankingTest() {
		UsuarioDAOImp usuarioDAO = new UsuarioDAOImp(new BDHashMap<UsuarioPOJO>());
		ClanDAOImp clanDAO = new ClanDAOImp(new BDHashMap<ClanPOJO>());
		UsuarioClanDAO usuarioClanDAO = new UsuarioClanDAOImp(new BDHashMap<UsuarioClanPOJO>());
		TestperclanSAImp testperclanSA = new TestperclanSAImp(clanDAO, usuarioClanDAO,usuarioDAO);
		setup(usuarioDAO, clanDAO, usuarioClanDAO, testperclanSA);
		
		ArrayList<UsuarioPOJO> ranking = testperclanSA.getRanking("Los Matinfos");
		ArrayList<UsuarioPOJO> esperado = new ArrayList<UsuarioPOJO>();
		esperado.add((UsuarioPOJO) usuarioDAO.getFromId("borisc"));
		esperado.add((UsuarioPOJO) usuarioDAO.getFromId("franqui"));
		esperado.add((UsuarioPOJO) usuarioDAO.getFromId("javigm"));
		esperado.add((UsuarioPOJO) usuarioDAO.getFromId("jc"));
	
		assertEquals("Se comprueba que los usuarios estan bien ordenados",ranking, esperado);
	}
	
	@Test
	public void setGanadorTest() {
		
	}
	
	@Test
	public void eliminarUsuarioClanTest() {
		UsuarioDAOImp usuarioDAO = new UsuarioDAOImp(new BDHashMap<UsuarioPOJO>());
		ClanDAOImp clanDAO = new ClanDAOImp(new BDHashMap<ClanPOJO>());
		UsuarioClanDAO usuarioClanDAO = new UsuarioClanDAOImp(new BDHashMap<UsuarioClanPOJO>());
		TestperclanSA testperClanSA = new TestperclanSAImp(clanDAO, usuarioClanDAO, usuarioDAO);
		setup(usuarioDAO, clanDAO, usuarioClanDAO, testperClanSA);
		testperClanSA.eliminarUsuarioClan("daniv");
		testperClanSA.eliminarUsuarioClan("sergil");
		assertFalse("No eberia contener al usuario añadido", usuarioClanDAO.getMiembrosClan("Los Matinfos").contains("daniv"));
		assertFalse("No deberia contener al usuario añadido", usuarioClanDAO.getMiembrosClan("Los Matinfos").contains("sergil"));
	}

	@Test
	public void añadirUsuarioClanTest() {
		UsuarioDAOImp usuarioDAO = new UsuarioDAOImp(new BDHashMap<UsuarioPOJO>());
		ClanDAOImp clanDAO = new ClanDAOImp(new BDHashMap<ClanPOJO>());
		UsuarioClanDAO usuarioClanDAO = new UsuarioClanDAOImp(new BDHashMap<UsuarioClanPOJO>());
		TestperclanSA testperClanSA = new TestperclanSAImp(clanDAO, usuarioClanDAO, usuarioDAO);
		setup(usuarioDAO, clanDAO, usuarioClanDAO, testperClanSA);
		
		testperClanSA.anadirUsuarioClan("daniv", "Los Matinfos");
		testperClanSA.anadirUsuarioClan("sergil", "Los Matinfos");
		assertTrue("Deberia contener al usuario añadido", usuarioClanDAO.getMiembrosClan("Los Matinfos").contains("daniv"));
		assertTrue("Deberia contener al usuario añadido", usuarioClanDAO.getMiembrosClan("Los Matinfos").contains("sergil"));
	}
	
	@Test
	public void crearClanTest() {
		
	}
}
