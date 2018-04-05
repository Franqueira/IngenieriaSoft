package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.DAOs.AlarmaDAO;
import es.ucm.fdi.integracion.DAOs.AlarmaDAOImp;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

public class AlarmaSA {
	
	private AlarmaDAO alarmaDAO;
	public AlarmaSA(AlarmaDAOImp alarmaDAO) {
		this.alarmaDAO = alarmaDAO;
	}
	
	public void reproducirAlarma(AlarmaPOJO a){
		
	}

}
