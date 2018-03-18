package es.ucm.fdi.integracion;

import java.util.ArrayList;
import java.util.Vector;

import es.ucm.fdi.datos.BDMemoria;

public class AlarmaDAO {
	
	private BDMemoria<AlarmaPOJO> BD;

	public AlarmaDAO(BDMemoria<AlarmaPOJO> BD) {
		this.BD = BD;
	}
	
	public void saveAlarm(AlarmaPOJO alarm){
		BD.insert(alarm, alarm.getIdAlarma());
	}
	
	public void removeAlarm(AlarmaPOJO alarm){
		BD.removeId(alarm.getIdAlarma());
	}
	
	public AlarmaPOJO[] getActive(){ //Revisar
		ArrayList<AlarmaPOJO> list = new ArrayList<AlarmaPOJO>();
		Vector<String> ids = BD.getIds();
		for(String id : ids){
			AlarmaPOJO alarma = BD.find(id);
			if(alarma.isActive()) list.add(alarma);
		}
		return (AlarmaPOJO[]) list.toArray();
	}
	

}
