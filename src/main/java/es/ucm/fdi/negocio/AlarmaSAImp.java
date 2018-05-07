package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.DAOs.AlarmaDAO;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

public class AlarmaSAImp implements AlarmaSA{
	private AlarmaDAO alarmaDAO;
	@Override
	public String getTone(String alarma) {
		return ((AlarmaPOJO) alarmaDAO.getFromId(alarma)).getTono();
	}
}
