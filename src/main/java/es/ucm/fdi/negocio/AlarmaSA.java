package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.DAOs.AlarmaDAOImp;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

public class AlarmaSA {

	private AlarmaDAOImp alarmaDAO;
	private TonoDAO tonoDAO;
	
	public AlarmaSA(AlarmaDAOImp alarmaDAO, TonoDAO tonoDAO) {
		this.alarmaDAO = alarmaDAO;
		this.tonoDAO = tonoDAO;
	}
	
	public void reproducirAlarma(AlarmaPOJO a){
		
	}

}
