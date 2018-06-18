package es.ucm.fdi;

import es.ucm.fdi.integracion.DAOs.UsuarioDAO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

/**
 * Implementación de InicializaUsuarioDAO
 */
public class InicializaUsuarioDAOImp1 implements InicializaUsuarioDAO {
	public void inicializa(UsuarioDAO usuarioDAO) {
		UsuarioPOJO javi = new UsuarioPOJO("javigm", "Javier Guzman", 1001,
				"hola123", "Spain");
		usuarioDAO.save(javi);
		javi.setIdClan("Los Matinfos");
		usuarioDAO.update(javi);
		
		usuarioDAO.save(new UsuarioPOJO("peter_hy", "Peter Stones", 147,
				"hello321", "England"));
		
		usuarioDAO.save(new UsuarioPOJO("xu_xu", "Xu Xin Chao", 2099,
				"yoselchinito", "China"));
		
		usuarioDAO.save(new UsuarioPOJO("Wiledk7", "Wilson Eduardo Lopez",
				1365, "holamamasita", "Colombia"));
		
		UsuarioPOJO boris = new UsuarioPOJO("borisc", "Boris Carballa", 1120,
				"soyboris", "Spain");
		usuarioDAO.save(boris);
		boris.setIdClan("Los Matinfos");
		usuarioDAO.update(boris);
		
		UsuarioPOJO franqui = new UsuarioPOJO("franqui", "Miguel Franqueira", 1111,
				"soyFranqui", "Spain");
		usuarioDAO.save(franqui);
		franqui.setIdClan("Los Matinfos");
		usuarioDAO.update(franqui);
		
		UsuarioPOJO sergio = new UsuarioPOJO("sergil", "Sergio Gil", 823,
				"soysergi", "Spain");
		usuarioDAO.save(sergio);
		sergio.setIdClan("Los Matinfos");
		usuarioDAO.update(sergio);
		
		UsuarioPOJO dani =  new UsuarioPOJO("daniv", "Dani Valverde", 730,
				"soydani", "Spain");
		usuarioDAO.save(dani);
		dani.setIdClan("Los Matinfos");
		usuarioDAO.update(dani);
		
		usuarioDAO.save(new UsuarioPOJO("pablitos", "Pablo Sanz", 545,
				"soypablo", "Spain"));
		
		UsuarioPOJO jc = new UsuarioPOJO("jc", "JC Villanueva", 108, "soyjc",
				"Spain");
		usuarioDAO.save(jc);
		jc.setIdClan("Los Matinfos");
		usuarioDAO.update(jc);

	}
}
