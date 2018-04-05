package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.DAOs.PreguntaDAOImp;

public class PreguntaSA {

	private PreguntaDAOImp preguntaDAO;

	public PreguntaSA(PreguntaDAOImp preguntaDAO) {
		super();
		this.preguntaDAO = preguntaDAO;
	}
	
	public boolean comprobarRespuesta(String idPregunta, int respuesta) {
		return preguntaDAO.getPregunta(idPregunta).getRespuestaCorrecta() == respuesta;
	}

}
