package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.DAOs.PreguntaDAOImp;

public class PreguntaSAImp implements PreguntaSA{

	private PreguntaDAOImp preguntaDAO;

	public PreguntaSAImp(PreguntaDAOImp preguntaDAO) {
		super();
		this.preguntaDAO = preguntaDAO;
	}
	
	public boolean comprobarRespuesta(String idPregunta, int respuesta) {
		return preguntaDAO.getPregunta(idPregunta).getRespuestaCorrecta() == respuesta;
	}

}
