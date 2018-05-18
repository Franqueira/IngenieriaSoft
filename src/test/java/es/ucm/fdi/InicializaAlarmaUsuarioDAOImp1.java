package es.ucm.fdi;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.AlarmaUsuarioDAO;
import es.ucm.fdi.integracion.DAOs.AlarmaUsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.AlarmaUsuarioPOJO;

public class InicializaAlarmaUsuarioDAOImp1 implements InicializaAlarmaUsuarioDAO{

	@Override
	public void inicializa(AlarmaUsuarioDAO alarmaUsuarioDAO) {
		alarmaUsuarioDAO= new AlarmaUsuarioDAOImp(new BDHashMap<AlarmaUsuarioPOJO>());
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al1", "javigm"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al2", "peter_hy"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al3", "xu_xu"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al4", "Wiledk7"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al5", "borisc"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al6", "franqui"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al7", "sergil"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al8", "daniv"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al9", "pablitos"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al10", "jc"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al11", "jaime123"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al12", "borisc"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al13", "javigm"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al14", "javigm"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al15", "jc"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al16", "franqui"));
		
	}

}
