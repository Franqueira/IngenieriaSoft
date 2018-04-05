package es.ucm.fdi.integracion.POJOs;


/**
 * @author Sergi
 *
 */
public class PreguntaUsuarioPOJO {
	String id_pregunta;
	String id_usuario;

	public PreguntaUsuarioPOJO(String id_usuario, String id_pregunta) {
		super();
		this.id_pregunta = id_pregunta;
		this.id_usuario = id_usuario;
	}

	public String getIdUsuario() {
		return id_usuario;
	}

	public void setIdUsuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getIdPregunta() {
		return id_pregunta;
	}

	public void setIdPregunta(String id_pregunta) {
		this.id_pregunta = id_pregunta;
	}

}
