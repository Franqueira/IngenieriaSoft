package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;

public interface PreguntaUsuarioDAO extends DAO<PreguntaUsuarioPOJO>{
	
	public ArrayList<String> getPreguntas(String idUsuario);

}
