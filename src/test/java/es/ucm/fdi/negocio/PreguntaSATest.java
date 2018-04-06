package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;

public class PreguntaSATest {
	public boolean comprobarRespuesta(String idPregunta, int respuesta) {
		return ((PreguntaPOJO) preguntaDAO.getFromId(idPregunta)).getRespuestaCorrecta() == respuesta;
	}
}
