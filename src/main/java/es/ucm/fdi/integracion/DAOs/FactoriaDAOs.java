package es.ucm.fdi.integracion.DAOs;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.integracion.POJOs.AlarmaUsuarioPOJO;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;
import es.ucm.fdi.integracion.POJOs.POJO;
import es.ucm.fdi.integracion.POJOs.PreguntaClanPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

/**
 * Clase factoría de DAOs
 */
public class FactoriaDAOs<T extends POJO> {

	/**
	 * Método que se encarga de devolver el DAO pedido.
	 * 
	 * @param tipo
	 * 0 para devolver AlarmaDAOImp
	 * 1 para devolver AlarmaUsuarioDAOImp
	 * 2 para devolver ClanDAOImp
	 * 3 para devolver PreguntaClanDAOImp
	 * 4 para devolver PreguntaDAOImp
	 * 5 para devolver PreguntaUsuarioDAOImp
	 * 6 para devolver UsuarioDAOImp
	 * 7 para devolver UsuarioClanDAOImp
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DAO creaDAO(int tipo,BDHashMap<T> BD){
		/* también podría haber quitado el parámetro tipo 
		 * y mirar a que clase pertenece con instanceof pero creo que así queda más claro */
		switch(tipo){
		case 0:
		return new AlarmaDAOImp((BDHashMap<AlarmaPOJO>) BD);
		case 1:
		return new AlarmaUsuarioDAOImp((BDHashMap<AlarmaUsuarioPOJO>) BD);
		case 2:
		return new ClanDAOImp((BDHashMap<ClanPOJO>) BD);
		case 3:
		return new PreguntaClanDAOImp((BDHashMap<PreguntaClanPOJO>) BD);
		case 4:
		return new PreguntaDAOImp((BDHashMap<PreguntaPOJO>) BD);
		case 5:
		return new PreguntaUsuarioDAOImp((BDHashMap<PreguntaUsuarioPOJO>) BD);
		case 6:
		return new UsuarioDAOImp((BDHashMap<UsuarioPOJO>) BD);
		case 7:
		return new UsuarioClanDAOImp((BDHashMap<UsuarioClanPOJO>) BD);
		}
		
		return null;
	}
}
