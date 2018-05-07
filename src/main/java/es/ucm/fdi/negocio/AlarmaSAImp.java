package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.DAOs.AlarmaDAO;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

/**
 * 
 * Implementación de la interfaz AlarmaSA
 *
 */
public class AlarmaSAImp implements AlarmaSA{
	private AlarmaDAO alarmaDAO;
	@Override
	public String getTone(String alarma) {
		return ((AlarmaPOJO) alarmaDAO.getFromId(alarma)).getTono();
	}
	@Override
	public void postponerAlarma(String alarma) {
		AlarmaPOJO alarmaPOJO = (AlarmaPOJO) alarmaDAO.getFromId(alarma);
		if(alarmaPOJO.getMinutos() >= 55){
			alarmaPOJO.setMinutos(alarmaPOJO.getMinutos() - 55);
			if(alarmaPOJO.getHoras() == 23){
				alarmaPOJO.setHoras(0);
			}
			else{
				alarmaPOJO.setHoras(alarmaPOJO.getHoras() + 1);
			}
		}
		else alarmaPOJO.setMinutos(alarmaPOJO.getMinutos() + 5);
	}
}
