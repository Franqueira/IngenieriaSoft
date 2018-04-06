package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.DAOs.AlarmaDAO;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

public class AlarmaSAImp implements AlarmaSA{
	
	@SuppressWarnings("unused")
	private AlarmaDAO alarmaDAO;
	
	public AlarmaSAImp(AlarmaDAO alarmaDAO) {
		this.alarmaDAO = alarmaDAO;
	}
	
	public void reproducirAlarma(AlarmaPOJO a){
		
	}
	
	public void desconectarAlarma(AlarmaPOJO a){
		
	}

}
