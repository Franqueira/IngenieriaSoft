package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

public interface AlarmaDAO extends DAO<AlarmaPOJO>{
	
	public ArrayList<AlarmaPOJO> getActive();
	
}
