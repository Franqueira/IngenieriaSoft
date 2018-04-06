package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;
import java.util.stream.Collectors;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;

public class PreguntaUsuarioDAOImp extends HashMapDAO<PreguntaUsuarioPOJO> implements PreguntaUsuarioDAO {
	
	public PreguntaUsuarioDAOImp(BDHashMap<PreguntaUsuarioPOJO> BD) {
		super(BD);
	}

	public ArrayList<String> getPreguntas(String idUsuario){
		return BD.getIds().stream()
				.filter(id -> BD.find(id).getIdUsuario()==idUsuario)
				.collect(Collectors.toCollection(ArrayList::new));
	}
}