package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;

public interface PreguntaUsuarioDAO {
	public ArrayList<String> getPreguntas(String idUsuario);

	public void savePreguntaUsuario(PreguntaUsuarioPOJO pu);

	public void removePreguntaUsuario(String idPU);
}
