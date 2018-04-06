/**
 * 
 */
package es.ucm.fdi.integracion.POJOs;

import java.util.ArrayList;

public class PreguntaPOJO extends POJO{
	String texto;
	ArrayList<String> respuestas;
	int respuestaCorrecta;

	public PreguntaPOJO(String id, String texto, ArrayList<String> respuestas,
			int respuestaCorrecta) {
		super(id);
		this.texto = texto;
		this.respuestas = respuestas;
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public ArrayList<String> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(ArrayList<String> respuestas) {
		this.respuestas = respuestas;
	}

	public int getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public void setRespuestaCorrecta(int respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

	@Override
	public String toString() {
		String salida = texto + ":\n";
		for (String r : respuestas) {
			salida += "	-" + r + '\n';
		}
		return salida;
	}

	@Override
	public POJO clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
