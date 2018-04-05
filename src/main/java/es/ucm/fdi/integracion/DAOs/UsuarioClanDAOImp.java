package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;

public interface UsuarioClanDAOImp {
	
	public String getClan(String id);
	
	public ArrayList<String> getMiembrosClan(String clan);
	
	public void guardaUsuarioClan(UsuarioClanPOJO uclan);
	
	public void eliminaUsuarioClan(UsuarioClanPOJO uclan);
}
