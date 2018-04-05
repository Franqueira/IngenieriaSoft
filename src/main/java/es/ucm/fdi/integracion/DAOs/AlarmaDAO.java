package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

public interface AlarmaDAO {
	
	public AlarmaPOJO getAlarma(String id);
	
	public void saveAlarm(AlarmaPOJO alarm);
	
	public void removeAlarm(AlarmaPOJO alarm);
	
	public ArrayList<AlarmaPOJO> getActive();
	
}
