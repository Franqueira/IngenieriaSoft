package es.ucm.fdi.integracion.DAOs;

import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

public interface UsuarioDAO extends DAO<UsuarioPOJO>{
	
	public UsuarioPOJO find(String nombre);
	
}
