package es.ucm.fdi.integracion.DAOs;

import es.ucm.fdi.datos.*;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

/**
 * 
 * Implementación de la interfaz UsuarioDAO
 *
 */

public class UsuarioDAOImp extends HashMapDAOImp<UsuarioPOJO> implements
		UsuarioDAO {

	public UsuarioDAOImp(BDHashMap<UsuarioPOJO> BD) {
		super(BD);
	}

	public UsuarioPOJO find(String nombreReal) {
		UsuarioPOJO user = null;
		for (String id : BD.getIds()) {
			UsuarioPOJO aux = BD.find(id);
			if (aux.getNombreReal().equals(nombreReal)) {
				user = aux;
			}
		}
		return user;
	}

}
