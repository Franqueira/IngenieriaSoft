package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.AlarmaUsuarioPOJO;

public interface AlarmaUsuarioDAO extends DAO<AlarmaUsuarioPOJO>{
	
	public ArrayList<String> getAlarmasUsuario(String idUsuario);
	
}
