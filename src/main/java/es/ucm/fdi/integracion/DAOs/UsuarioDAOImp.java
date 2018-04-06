package es.ucm.fdi.integracion.DAOs;
import es.ucm.fdi.datos.*;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

public class UsuarioDAOImp extends HashMapDAO<UsuarioPOJO> implements UsuarioDAO{
	
	
	public UsuarioDAOImp(BDHashMap<UsuarioPOJO> BD) {
		super(BD);
	}

	public UsuarioPOJO find(String nombreReal){
		for(String id: BD.getIds()){
			UsuarioPOJO user = (UsuarioPOJO) getFromId(id);
			if(user.getNombreReal().equals(nombreReal)){
				return user;
			}
		}
		return null;
	}
	
}
