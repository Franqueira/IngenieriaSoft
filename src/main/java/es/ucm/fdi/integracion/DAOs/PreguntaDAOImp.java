package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;

/**
 * Implementación de la interfaz PreguntaDAO
 */
public class PreguntaDAOImp extends HashMapDAOImp<PreguntaPOJO> implements
		PreguntaDAO {

	public PreguntaDAOImp(BDHashMap<PreguntaPOJO> BD) {
		super(BD);
	}

	public ArrayList<PreguntaPOJO> getAll() {
		ArrayList<String> list = BD.getIds();
		return getFromIds(list.stream().map(id -> BD.find(id)) // Busca el
																// PreguntaPOJO
																// correspondiente
				.collect(Collectors.toCollection(ArrayList::new))); // Los
																	// guarda en
																	// un
																	// ArrayList
	}

	public ArrayList<PreguntaPOJO> getPreguntas(List<String> list) {
		ArrayList<PreguntaPOJO> preguntas = new ArrayList<>();
		list.forEach(id -> preguntas.add(BD.find(id)));
		return getFromIds(preguntas);
	}

	@Override
	public ArrayList<PreguntaPOJO> getPreguntasPorCategoria(String categoria) {
		ArrayList<PreguntaPOJO> preguntas = BD.getIds().stream()
				.map(id -> BD.find(id))
				.filter(p -> p.getCategoria().equals(categoria))
				.collect(Collectors.toCollection(ArrayList::new));
		return preguntas;
	}
}
