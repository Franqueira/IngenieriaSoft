package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.AlarmaUsuarioPOJO;

/**
 * 
 * @author Javier Guzmán
 *
 */
public interface AlarmaUsuarioDAO {
	public ArrayList<String> getAlarmasUsuario(String idUsuario);
	
	public void removeAlarmaUsuario(String idAlarma);
	
	public void addAlarmaUsuario(AlarmaUsuarioPOJO au);
	
}
