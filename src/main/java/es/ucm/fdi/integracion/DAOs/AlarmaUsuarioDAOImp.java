package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.AlarmaUsuarioPOJO;
import es.ucm.fdi.datos.*;

/**
 * 
 * @author Javier Guzmán
 *
 */
public class AlarmaUsuarioDAOImp implements AlarmaUsuarioDAO{
	private BDHashMap<AlarmaUsuarioPOJO> BD;
	

	
	
	public AlarmaUsuarioDAOImp(BDHashMap<AlarmaUsuarioPOJO> bD) {
		super();
		BD = bD;
	}
	
	@Override
	public ArrayList<String> getAlarmasUsuario(String idUsuario) {
		ArrayList<String> listaAlarmas = new ArrayList<>();
		for(String a: BD.getIds()){
			if(BD.find(a).getIdUsuario().equals(idUsuario)){
				listaAlarmas.add(a);
			}
		}
		return listaAlarmas;
	}

	@Override
	public void removeAlarmaUsuario(String idAlarma) {
		BD.removeId(idAlarma);
		
	}

	@Override
	public void addAlarmaUsuario(AlarmaUsuarioPOJO au) {
		BD.insert(au, au.getIdAlarma());
	}
	
}
