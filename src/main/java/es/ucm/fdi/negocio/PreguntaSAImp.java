package es.ucm.fdi.negocio;

import java.util.ArrayList;

import es.ucm.fdi.integracion.DAOs.PreguntaDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaUsuarioDAO;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;

/**
 * 
 * Implementacion de la interfaz PreguntaSA
 * 
 */

public class PreguntaSAImp implements PreguntaSA{

	private PreguntaDAOImp preguntaDAO;
	private PreguntaUsuarioDAO preguntaUsuarioDAO;

	public PreguntaSAImp(PreguntaDAOImp preguntaDAO, PreguntaUsuarioDAO preguntaUsuarioDAO) {
		this.preguntaDAO = preguntaDAO;
		this.preguntaUsuarioDAO = preguntaUsuarioDAO;
	}
	
	public boolean comprobarRespuesta(String idPregunta, int respuesta) {
		return ((PreguntaPOJO) preguntaDAO.getFromId(idPregunta)).getRespuestaCorrecta() == respuesta;
	}
	
	public void AnadirPregunta(PreguntaPOJO pregunta,String idUsuario){
		preguntaDAO.save(pregunta);
		preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO(pregunta.getId(),idUsuario));
	}
	public void ElminarPregunta(String idPregunta,String idUsuario){
		ArrayList<String> preguntas=preguntaUsuarioDAO.getPreguntas(idUsuario);
		if(preguntas.size()>10){ // solo dejamos eliminar si tiene mas de 10 preguntas.
			preguntaDAO.remove(idPregunta);
			preguntaUsuarioDAO.remove(idPregunta);
			
		}
	}

}
