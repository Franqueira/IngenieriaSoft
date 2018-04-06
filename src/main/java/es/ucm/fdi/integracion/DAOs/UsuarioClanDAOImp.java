package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;

public class UsuarioClanDAOImp implements UsuarioClanDAO {
	private BDHashMap<UsuarioClanPOJO> miembros; 
	// el ID de cada UsuarioClanPOJO en la BD es el ID del usuario, ya que solo puede tener 1 clan

	public UsuarioClanDAOImp(BDHashMap<UsuarioClanPOJO> miembros) {
		this.miembros = miembros;
	}
	
	public String getClan(String id){
		return miembros.find(id).getIdClan();
	}
	
	public ArrayList<String> getMiembrosClan(String clan){
		ArrayList<String> miembrosClan =  new ArrayList<String>();
		for(String id : miembros.getIds()){
			if(getClan(id).equals(clan))
				miembrosClan.add(id);
		}
		return miembrosClan;
	}
	
	public void guardaUsuarioClan(UsuarioClanPOJO uclan){
		miembros.insert(uclan, uclan.getIdUsuario());
	}
	
	public void eliminaUsuarioClan(String idUsuario){
		miembros.removeId(idUsuario);
	}
}
