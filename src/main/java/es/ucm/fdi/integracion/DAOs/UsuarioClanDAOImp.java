package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;

/**
 * 
 * Implementación de la interfaz UsuarioClanDAO
 *
 */
public class UsuarioClanDAOImp extends HashMapDAOImp<UsuarioClanPOJO> implements UsuarioClanDAO {
	
	public UsuarioClanDAOImp(BDHashMap<UsuarioClanPOJO> BD) {
		super(BD);
	}
	
	public ArrayList<String> getMiembrosClan(String clan){
		ArrayList<String> miembrosClan =  new ArrayList<String>();
		for(String id : BD.getIds()){
			if(BD.find(id).getIdClan().equals(clan))
				miembrosClan.add(id);
		}
		return miembrosClan;
	}
}
