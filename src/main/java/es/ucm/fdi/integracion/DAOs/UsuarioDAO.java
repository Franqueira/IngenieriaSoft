package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

public interface UsuarioDAO {
	public UsuarioPOJO getUsuario(String idUsuario);
	
	public void guardaUsuario(UsuarioPOJO user);
	
	public void eliminaUsuario(UsuarioPOJO user);
	
	public UsuarioPOJO buscaPorNombre(String nombre);
	
	public ArrayList<UsuarioPOJO> getUsersByCountry(String country);
	
}
