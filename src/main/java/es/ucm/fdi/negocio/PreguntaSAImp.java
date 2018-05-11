package es.ucm.fdi.negocio;

import java.util.ArrayList;

import es.ucm.fdi.integracion.DAOs.PreguntaDAO;
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

	private PreguntaDAO preguntaDAO;
	private PreguntaUsuarioDAO preguntaUsuarioDAO;

	public PreguntaSAImp(PreguntaDAO preguntaDAO, PreguntaUsuarioDAO preguntaUsuarioDAO) {
		this.preguntaDAO = preguntaDAO;
		this.preguntaUsuarioDAO = preguntaUsuarioDAO;
	}
	
	public boolean comprobarRespuesta(String idPregunta, int respuesta) {
		return ((PreguntaPOJO) preguntaDAO.getFromId(idPregunta)).getRespuestaCorrecta() == respuesta;
	}
	
	public void vincularPreguntas(String categoria, String idUsuario){
		ArrayList<PreguntaPOJO> preguntas = preguntaDAO.getPreguntasPorCategoria(categoria);
		for(PreguntaPOJO pregunta : preguntas){
			preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO(pregunta.getId(),idUsuario));
		}
	}
	public void desvincularPregunta(String idPregunta,String idUsuario){
		ArrayList<String> preguntas=preguntaUsuarioDAO.getPreguntas(idUsuario);
		if(preguntas.size()>10){ // solo dejamos eliminar si tiene mas de 10 preguntas.
			preguntaUsuarioDAO.remove(idPregunta);
			
		}
	}
	
	public void agregarPregunta(PreguntaPOJO pregunta){
		preguntaDAO.save(pregunta);
	}
	
	public void eliminarPregunta(String idPregunta){
		preguntaDAO.remove(idPregunta);
	}

}
