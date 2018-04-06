package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;
import java.util.stream.Collectors;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;

public class PreguntaUsuarioDAOImp implements PreguntaUsuarioDAO {
	
	private BDHashMap<PreguntaUsuarioPOJO> BD;

	public PreguntaUsuarioDAOImp(BDHashMap<PreguntaUsuarioPOJO> BD){
		this.BD = BD;
	}
	
	public ArrayList<String> getPreguntas(String idUsuario){
		return BD.getIds().stream()
				.filter(id -> BD.find(id).getIdUsuario()==idUsuario)
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public void savePreguntaUsuario(PreguntaUsuarioPOJO pu){
		BD.insert(pu,pu.getIdPregunta());
	}
	
	public void removePreguntaUsuario(String idPU){
		BD.removeId(idPU);
	}

}