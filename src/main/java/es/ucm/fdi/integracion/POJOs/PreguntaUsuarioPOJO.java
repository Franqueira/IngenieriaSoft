package es.ucm.fdi.integracion.POJOs;

/**
 * Establece una relación entre un usuario y una pregunta, indicando que un
 * usuario ha seleccionado una pregunta para guardarla y que este entre las que
 * se muestren al ejecutar la alarma
 */
public class PreguntaUsuarioPOJO extends POJO {

	private static final long serialVersionUID = -9052737111214414553L;
	String id_usuario;

	public PreguntaUsuarioPOJO(String id_pregunta, String id_usuario) {
		super(id_pregunta);
		this.id_usuario = id_usuario;
	}

	public String getIdUsuario() {
		return id_usuario;
	}

	public void setIdUsuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}
}
