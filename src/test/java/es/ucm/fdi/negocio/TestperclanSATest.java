package es.ucm.fdi.negocio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.AlarmaDAOImp;
import es.ucm.fdi.integracion.DAOs.ClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

public class TestperclanSATest {
	
	public void setup(UsuarioDAOImp usuarioDAO, ClanDAOImp clanDAO, UsuarioClanDAO usuarioClanDAO){
		//Creacion de usuarios
		usuarioDAO.save(new UsuarioPOJO("javigm", "Javier Guzman", 1001, "hola123", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("peter_hy", "Peter Stones", 147, "hello321", "England"));
		usuarioDAO.save(new UsuarioPOJO("xu_xu", "Xu Xin Chao", 2099, "yoselchinito", "China"));
		usuarioDAO.save(new UsuarioPOJO("Wiledk7", "Wilson Eduardo Lopez", 1365, "holamamasita", "Colombia"));
		usuarioDAO.save(new UsuarioPOJO("borisc", "Boris Carballa", 1244, "soyboris", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("franqui", "Miguel Franqueira", 1111, "soyFranqui", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("sergil", "Sergio Gil", 823, "soysergi", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("daniv", "Dani Valverde", 730, "soydani", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("pablitos", "Pablo Sanz", 545, "soypablo", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("jc", "JC Villanueva", 108, "soyjc", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("jaime123", "Jaime Fernandez", 109, "soyjaime", "Spain"));
		
		//Creacion de clanes
		TestperclanSAImp testperclanSA = new TestperclanSAImp(clanDAO, usuarioClanDAO,usuarioDAO);
		testperclanSA.crearClan("javigm", "Los Matinfos");
		testperclanSA.anadirUsuarioClan("borisc", "Los Matinfos");
		testperclanSA.anadirUsuarioClan("jc", "Los Matinfos");
		testperclanSA.anadirUsuarioClan("franqui", "Los Matinfos");
			
	}
	
	@Test
	public void getRankingTest() {
	}
	
	@Test
	public void setGanadorTest() {
		
	}
	
	@Test
	public void eliminarUsuarioClanTest() {
		UsuarioDAOImp usuarioDAO = new UsuarioDAOImp(new BDHashMap<UsuarioPOJO>());
		ClanDAOImp clanDAO = new ClanDAOImp(new BDHashMap<ClanPOJO>());
		UsuarioClanDAO usuarioClanDAO = new UsuarioClanDAOImp(new BDHashMap<UsuarioClanPOJO>());
		setup(usuarioDAO, clanDAO, usuarioClanDAO);
		TestperclanSA testperClanSA = new TestperclanSAImp(clanDAO, usuarioClanDAO, usuarioDAO);
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
		setup(usuarioDAO, clanDAO, usuarioClanDAO);
		TestperclanSA testperClanSA = new TestperclanSAImp(clanDAO, usuarioClanDAO, usuarioDAO);
		testperClanSA.anadirUsuarioClan("daniv", "Los Matinfos");
		testperClanSA.anadirUsuarioClan("sergil", "Los Matinfos");
		assertTrue("Deberia contener al usuario añadido", usuarioClanDAO.getMiembrosClan("Los Matinfos").contains("daniv"));
		assertTrue("Deberia contener al usuario añadido", usuarioClanDAO.getMiembrosClan("Los Matinfos").contains("sergil"));
	}
	
	@Test
	public void crearClanTest() {
		
	}
}
