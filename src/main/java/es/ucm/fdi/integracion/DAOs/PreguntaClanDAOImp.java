package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;
import java.util.stream.Collectors;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.PreguntaClanPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;

/**
 * 
 * Implementación de la interfaz PreguntaClan
 *
 */
public class PreguntaClanDAOImp extends HashMapDAOImp<PreguntaClanPOJO>
		implements PreguntaClanDAO {

	public PreguntaClanDAOImp(BDHashMap<PreguntaClanPOJO> BD) {
		super(BD);
	}

	public ArrayList<String> getPreguntas(String idClan) {
		return BD.getIds().stream()
				.filter(id -> BD.find(id).getIdClan() == idClan)
				.collect(Collectors.toCollection(ArrayList::new));
	}
}