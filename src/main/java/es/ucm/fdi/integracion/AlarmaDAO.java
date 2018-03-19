package es.ucm.fdi.integracion;

import java.util.ArrayList;
import java.util.stream.Collectors;

import es.ucm.fdi.datos.BD;

public class AlarmaDAO {
	
	private BD<AlarmaPOJO> BD;

	public AlarmaDAO(BD<AlarmaPOJO> BD) {
		this.BD = BD;
	}
	
	public AlarmaPOJO getAlarma(String id){
		return BD.find(id);
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
