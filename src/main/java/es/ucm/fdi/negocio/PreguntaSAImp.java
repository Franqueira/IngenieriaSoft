package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.DAOs.PreguntaDAOImp;

public class PreguntaSAImp implements PreguntaSA{

	private PreguntaDAOImp preguntaDAO;

	public PreguntaSAImp(PreguntaDAOImp preguntaDAO) {
		this.preguntaDAO = preguntaDAO;
	}
	
	public boolean comprobarRespuesta(String idPregunta, int respuesta) {
		return preguntaDAO.getFromId(idPregunta).getRespuestaCorrecta() == respuesta;
	}

}
