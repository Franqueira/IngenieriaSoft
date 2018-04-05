package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.DAOs.AlarmaDAO;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

public class AlarmaSA {

	private AlarmaDAO alarmaDAO;
	private TonoDAO tonoDAO;
	
	public AlarmaSA(AlarmaDAO alarmaDAO, TonoDAO tonoDAO) {
		this.alarmaDAO = alarmaDAO;
		this.tonoDAO = tonoDAO;
	}
	
	public void reproducirAlarma(AlarmaPOJO a){
		
	}

}
