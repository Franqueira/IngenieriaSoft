package es.ucm.fdi;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.UsuarioDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

public class InicializaUsuarioDAOImp1 implements InicializaUsuarioDAO {
	public void inicializa(UsuarioDAO usuarioDAO) {
		usuarioDAO.save(new UsuarioPOJO("javigm", "Javier Guzman", 1001,
				"hola123", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("peter_hy", "Peter Stones", 147,
				"hello321", "England"));
		usuarioDAO.save(new UsuarioPOJO("xu_xu", "Xu Xin Chao", 2099,
				"yoselchinito", "China"));
		usuarioDAO.save(new UsuarioPOJO("Wiledk7", "Wilson Eduardo Lopez",
				1365, "holamamasita", "Colombia"));
		usuarioDAO.save(new UsuarioPOJO("borisc", "Boris Carballa", 1244,
				"soyboris", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("franqui", "Miguel Franqueira", 1111,
				"soyFranqui", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("sergil", "Sergio Gil", 823,
				"soysergi", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("daniv", "Dani Valverde", 730,
				"soydani", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("pablitos", "Pablo Sanz", 545,
				"soypablo", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("jc", "JC Villanueva", 108, "soyjc",
				"Spain"));

	}
}
