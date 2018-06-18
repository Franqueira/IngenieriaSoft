package es.ucm.fdi.integracion.DAOs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.InicializaUsuarioDAOImp1;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

/**
 * Clase encargada de probar UsuarioDAO
 */
public class UsuarioDAOTest {
	private UsuarioDAOImp usuarioDAO = new UsuarioDAOImp(
			new BDHashMap<UsuarioPOJO>());

	@Before
	public void setup() {
		new InicializaUsuarioDAOImp1().inicializa(usuarioDAO);
	}
	
	/**
	 * @see InicializaUsuarioDAOImp1
	 */
	@Test
	public void testFind() {
		assertEquals("El nombre real debería coincidir", "Javier Guzman",
				usuarioDAO.find("Javier Guzman").getNombreReal());
		assertEquals("El nombre real debería coincidir", "Peter Stones",
				usuarioDAO.find("Peter Stones").getNombreReal());
		assertEquals("El nombre real debería coincidir", "Xu Xin Chao",
				usuarioDAO.find("Xu Xin Chao").getNombreReal());
		assertEquals("El nombre real debería coincidir",
				"Wilson Eduardo Lopez", usuarioDAO.find("Wilson Eduardo Lopez")
						.getNombreReal());
		assertEquals("El nombre real debería coincidir", "Boris Carballa",
				usuarioDAO.find("Boris Carballa").getNombreReal());
		assertEquals("El nombre real debería coincidir", "Miguel Franqueira",
				usuarioDAO.find("Miguel Franqueira").getNombreReal());
		assertEquals("El nombre real debería coincidir", "Sergio Gil",
				usuarioDAO.find("Sergio Gil").getNombreReal());
		assertEquals("El nombre real debería coincidir", "Dani Valverde",
				usuarioDAO.find("Dani Valverde").getNombreReal());
		assertEquals("El nombre real debería coincidir", "Pablo Sanz",
				usuarioDAO.find("Pablo Sanz").getNombreReal());
		assertEquals("El nombre real debería coincidir", "JC Villanueva",
				usuarioDAO.find("JC Villanueva").getNombreReal());
	}
}
