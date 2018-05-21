package es.ucm.fdi;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAOImp;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;

public class InicializaUsuarioClanDAOImp1 implements InicializaUsuarioClanDAO {
	public void inicializa(UsuarioClanDAO usuarioClanDAO) {
		usuarioClanDAO = new UsuarioClanDAOImp(new BDHashMap<UsuarioClanPOJO>());
		usuarioClanDAO.save(new UsuarioClanPOJO("losPros", "pepitoXD"));
		usuarioClanDAO.save(new UsuarioClanPOJO("losPros", "juanito123"));
		usuarioClanDAO.save(new UsuarioClanPOJO("losPros", "TheFirePro"));
		usuarioClanDAO.save(new UsuarioClanPOJO("losPros", "CarlosGM"));
		usuarioClanDAO.save(new UsuarioClanPOJO("losPros", "Mery_8"));
		usuarioClanDAO.save(new UsuarioClanPOJO("AlarmaSpain", "_fran_"));
		usuarioClanDAO.save(new UsuarioClanPOJO("AlarmaSpain", "MADRUGAD0R"));
		usuarioClanDAO
				.save(new UsuarioClanPOJO("AlarmaSpain", "Admlnistrador"));
		usuarioClanDAO.save(new UsuarioClanPOJO("clanNuevo", "Creador"));
		usuarioClanDAO.save(new UsuarioClanPOJO("AlarmaSpain", "martin_1998"));
	}
}
