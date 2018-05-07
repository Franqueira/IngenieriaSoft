package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;

/**
 * 
 * Contiene las opercaiones de acceso a memoria que trabajan con datos de usuarios y clanes a la vez
 *
 */
public interface UsuarioClanDAO extends DAO<UsuarioClanPOJO>{
	/**
	 * @param clan id del clan del que queremos obtener su lista de usuarios
	 * @return lista con los ids de los usuarios del clan clan
	 */
	
	public ArrayList<String> getMiembrosClan(String clan);
	
}