package es.ucm.fdi.integracion;

import java.util.ArrayList;
import java.util.stream.Collectors;

import es.ucm.fdi.datos.BDNueva;

public class AlarmaDAO {
	
	private BDNueva<AlarmaPOJO> BD;

	public AlarmaDAO(BDNueva<AlarmaPOJO> BD) {
		this.BD = BD;
	}
	
	public void saveAlarm(AlarmaPOJO alarm){
		BD.insert(alarm, alarm.getIdAlarma());
	}
	
	public void removeAlarm(AlarmaPOJO alarm){
		BD.removeId(alarm.getIdAlarma());
	}
	
	public ArrayList<AlarmaPOJO> getActive(){
		ArrayList<String> list = BD.getIds();
		return list.stream()
				.map(id -> BD.find(id)) //Busca el AlarmaPOJO correspondiente
				.filter(a -> a.isActive()) //Mira los que estan activos
				.collect(Collectors.toCollection(ArrayList::new)); //Los guarda en un ArrayList
	}
}
