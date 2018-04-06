package es.ucm.fdi.integracion.DAOs;

import junit.framework.TestCase;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

public class UsuarioDAOTest extends TestCase {
	private BDHashMap<UsuarioPOJO> BDUsuario;
	
	public UsuarioDAOTest(String testName){
		super(testName);
		this.BDUsuario = new BDHashMap<UsuarioPOJO>();
		setup();
	}
	
	public void setup(){
		UsuarioDAOImp usuarioDAO = new UsuarioDAOImp(BDUsuario);
		
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
		usuarioDAO.save(new UsuarioPOJO("jaime123", "Jaime Fernandez", 3090, "soyjaime", "Spain"));
	}
	
	public void testFind(){
		UsuarioDAOImp usuarioDAO = new UsuarioDAOImp(BDUsuario);
		assertEquals("El nombre real debería coincidir","Javier Guzman",usuarioDAO.find("Javier Guzman").getNombreReal());
		assertEquals("El nombre real debería coincidir","Peter Stones",usuarioDAO.find("Peter Stones").getNombreReal());
		assertEquals("El nombre real debería coincidir","Xu Xin Chao",usuarioDAO.find("Xu Xin Chao").getNombreReal());
		assertEquals("El nombre real debería coincidir","Wilson Eduardo Lopez",usuarioDAO.find("Wilson Eduardo Lopez").getNombreReal());
		assertEquals("El nombre real debería coincidir","Boris Carballa",usuarioDAO.find("Boris Carballa").getNombreReal());
		assertEquals("El nombre real debería coincidir","Miguel Franqueira",usuarioDAO.find("Miguel Franqueira").getNombreReal());
		assertEquals("El nombre real debería coincidir","Sergio Gil",usuarioDAO.find("Sergio Gil").getNombreReal());
		assertEquals("El nombre real debería coincidir","Dani Valverde",usuarioDAO.find("Dani Valverde").getNombreReal());
		assertEquals("El nombre real debería coincidir","Pablo Sanz",usuarioDAO.find("Pablo Sanz").getNombreReal());
		assertEquals("El nombre real debería coincidir","JC Villanueva",usuarioDAO.find("JC Villanueva").getNombreReal());
		assertEquals("El nombre real debería coincidir","Jaime Fernandez",usuarioDAO.find("Jaime Fernandez").getNombreReal());
	}
}
