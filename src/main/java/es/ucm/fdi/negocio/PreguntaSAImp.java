package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.DAOs.PreguntaDAOImp;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;

/**
 * 
 * Implementacion de la interfaz PreguntaSA
 * 
 */

public class PreguntaSAImp implements PreguntaSA{

	private PreguntaDAOImp preguntaDAO;

	public PreguntaSAImp(PreguntaDAOImp preguntaDAO) {
		this.preguntaDAO = preguntaDAO;
	}
	
	public boolean comprobarRespuesta(String idPregunta, int respuesta) {
		return ((PreguntaPOJO) preguntaDAO.getFromId(idPregunta)).getRespuestaCorrecta() == respuesta;
	}

}
