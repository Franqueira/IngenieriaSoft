package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;

public class PreguntaDAOImp implements PreguntaDAO{
	private BDHashMap<PreguntaPOJO> BD;
	
	public PreguntaDAOImp(BDHashMap<PreguntaPOJO> BD) {
		this.BD = BD;
	}

	public PreguntaPOJO getPregunta(String id){
		return BD.find(id);
	}
	
	public ArrayList<PreguntaPOJO> getAll(){
		ArrayList<String> list = BD.getIds();
		return list.stream()
				.map(id -> BD.find(id)) //Busca el PreguntaPOJO correspondiente
				.collect(Collectors.toCollection(ArrayList::new)); //Los guarda en un ArrayList
	}
	
	public ArrayList<PreguntaPOJO> getPreguntas(List<String> list){
		ArrayList<PreguntaPOJO> preguntas = new ArrayList<>();
		list.forEach(id -> preguntas.add(BD.find(id)));
		return preguntas;
	}
	
	public void savePregunta(PreguntaPOJO preg){
		BD.insert(preg, preg.getId());
	}
	
	public void removePregunta(PreguntaPOJO preg){
		BD.removeId(preg.getId());
	}
	
}
