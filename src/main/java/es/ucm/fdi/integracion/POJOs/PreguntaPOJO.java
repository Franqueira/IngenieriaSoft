package es.ucm.fdi.integracion.POJOs;

import java.util.ArrayList;

/**
 * 
 * Clase que representa un pregunta de la aplicación. Contiene el texto de la pregunta (texto), 
 * una lista con las posibles respuestas tipo-test(respuestas) y un entero indicando el indice de´
 * la lista en el que se encuentra la respuesta correcta.
 *
 */
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
}
