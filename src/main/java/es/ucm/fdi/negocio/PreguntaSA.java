package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.PreguntaDAO;

public class PreguntaSA {

	private PreguntaDAO preguntaDAO;

	public PreguntaSA(PreguntaDAO preguntaDAO) {
		super();
		this.preguntaDAO = preguntaDAO;
	}
	
	public boolean comprobarRespuesta(String idPregunta, int respuesta) {
		return preguntaDAO.getPregunta(idPregunta).getRespuestaCorrecta() == respuesta;
	}

}
