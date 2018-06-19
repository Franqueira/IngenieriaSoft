package es.ucm.fdi;

import es.ucm.fdi.integracion.DAOs.UsuarioClanDAO;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;

/**
 * Implementación de InicializaUsuarioClanDAO
 */
public class InicializaUsuarioClanDAOImp2 implements InicializaUsuarioClanDAO {
	public void inicializa(UsuarioClanDAO usuarioClanDAO) {
		usuarioClanDAO.save(new UsuarioClanPOJO("losPros", "Lolitofdez"));
		usuarioClanDAO.save(new UsuarioClanPOJO("losPros", "E Rubius"));
		usuarioClanDAO.save(new UsuarioClanPOJO("losPros", "Willyrex"));
		usuarioClanDAO.save(new UsuarioClanPOJO("losPros", "Ninja"));
		usuarioClanDAO.save(new UsuarioClanPOJO("losPros", "Faker"));
		usuarioClanDAO.save(new UsuarioClanPOJO("Los Matinfo", "_fran_"));
		usuarioClanDAO.save(new UsuarioClanPOJO("Los Matinfo", "MADRUGAD0R"));
		usuarioClanDAO
				.save(new UsuarioClanPOJO("Los Matinfo", "danimv"));
		usuarioClanDAO.save(new UsuarioClanPOJO("clanNuevo", "Creador"));
		usuarioClanDAO.save(new UsuarioClanPOJO("AlarmaSpain", "martin_1998"));
		usuarioClanDAO.save(new UsuarioClanPOJO("Los Matinfos", "javigm"));
		usuarioClanDAO.save(new UsuarioClanPOJO("Los Matinfos", "borisc"));
		usuarioClanDAO.save(new UsuarioClanPOJO("Los Matinfos", "franqui"));
		usuarioClanDAO.save(new UsuarioClanPOJO("Los Matinfos", "jc"));
		
	}
}