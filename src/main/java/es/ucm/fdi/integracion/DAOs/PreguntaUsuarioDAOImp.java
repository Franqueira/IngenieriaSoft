package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;
import java.util.stream.Collectors;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;

/**
 * 
 * Implementación de la interfaz PreguntaUsuario
 *
 */
public class PreguntaUsuarioDAOImp extends HashMapDAOImp<PreguntaUsuarioPOJO>
		implements PreguntaUsuarioDAO {

	public PreguntaUsuarioDAOImp(BDHashMap<PreguntaUsuarioPOJO> BD) {
		super(BD);
	}

	public ArrayList<String> getPreguntas(String idUsuario) {
		return BD.getIds().stream()
				.filter(id -> BD.find(id).getIdUsuario() == idUsuario)
				.collect(Collectors.toCollection(ArrayList::new));
	}
}