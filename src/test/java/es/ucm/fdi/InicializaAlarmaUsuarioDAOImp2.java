package es.ucm.fdi;

import es.ucm.fdi.integracion.DAOs.AlarmaUsuarioDAO;
import es.ucm.fdi.integracion.POJOs.AlarmaUsuarioPOJO;

/**
 * Implementación de InicializaAlarmaUsuarioDAO
 */
public class InicializaAlarmaUsuarioDAOImp2 implements
		InicializaAlarmaUsuarioDAO {

	@Override
	public void inicializa(AlarmaUsuarioDAO alarmaUsuarioDAO) {
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("a1", "javigm"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("a2", "peter_hy"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("a3", "franqui"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("a4", "Wiledk7"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("a5", "borisc"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("a6", "franqui"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("a7", "sergil"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("a8", "daniv"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("a9", "pablitos"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("a10", "jc"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("a11", "jaime123"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("a12", "borisc"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("a13", "franqui"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("a14", "franqui"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("a15", "jc"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("a16", "franqui"));

	}

}
