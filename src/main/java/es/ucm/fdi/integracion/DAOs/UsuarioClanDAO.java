package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;

public interface UsuarioClanDAO extends DAO<UsuarioClanPOJO>{
	
	public ArrayList<String> getMiembrosClan(String clan);
	
}