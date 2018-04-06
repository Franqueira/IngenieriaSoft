package es.ucm.fdi.integracion.POJOs;


public class PreguntaUsuarioPOJO extends POJO{
	String id_usuario;

	public PreguntaUsuarioPOJO(String id_pregunta,String id_usuario) {
		super(id_pregunta);
		this.id_usuario = id_usuario;
	}

	public String getIdUsuario() {
		return id_usuario;
	}

	public void setIdUsuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	@Override
	public POJO clone() {
		// TODO Auto-generated method stub
		return null;
	}


}
