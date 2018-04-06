package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;
import java.util.List;

import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;

public interface PreguntaDAO {
	public PreguntaPOJO getPregunta(String id);
	
	public ArrayList<PreguntaPOJO> getPreguntas(List<String> list);
	
	public ArrayList<PreguntaPOJO> getAll();
	
	public void savePregunta(PreguntaPOJO preg);
	
	public void removePregunta(PreguntaPOJO preg);
}
