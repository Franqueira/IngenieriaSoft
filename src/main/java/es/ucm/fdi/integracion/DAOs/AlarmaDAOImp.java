package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;
import java.util.stream.Collectors;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

public class AlarmaDAOImp extends HashMapDAOImp<AlarmaPOJO> implements AlarmaDAO {
	
	public AlarmaDAOImp(BDHashMap<AlarmaPOJO> BD) {
		super(BD);
	}

	public ArrayList<AlarmaPOJO> getActive(){
		ArrayList<String> list = BD.getIds();
		return getFromIds(list.stream()
				.map(id -> BD.find(id)) //Busca el AlarmaPOJO correspondiente
				.filter(a -> a.isActive()) //Mira los que estan activos
				.collect(Collectors.toCollection(ArrayList::new))); //Los guarda en un ArrayList
	}
}
