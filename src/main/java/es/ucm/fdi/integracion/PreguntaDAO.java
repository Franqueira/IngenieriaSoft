package es.ucm.fdi.integracion;

import java.util.ArrayList;
import java.util.stream.Collectors;

import es.ucm.fdi.datos.BD;

public class PreguntaDAO {
	private BD<PreguntaPOJO> BD;
	
	public PreguntaDAO(es.ucm.fdi.datos.BD<PreguntaPOJO> bD) {
		BD = bD;
	}

	public PreguntaPOJO getPregunta(String id){
		return BD.find(id);
	}
	
	public void savePregunta(PreguntaPOJO preg){
		BD.insert(preg, preg.getId());
	}
	
	public void removePregunta(PreguntaPOJO preg){
		BD.removeId(preg.getId());
	}
	
	public ArrayList<PreguntaPOJO> getAll(){
		ArrayList<String> list = BD.getIds();
		return list.stream()
				.map(id -> BD.find(id)) //Busca el PreguntaPOJO correspondiente
				.collect(Collectors.toCollection(ArrayList::new)); //Los guarda en un ArrayList
	}
}
