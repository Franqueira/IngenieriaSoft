package es.ucm.fdi.integracion.POJOs;

public class UsuarioAmigoPOJO {
	String idUsuarioPrincipal;
	String idUsuarioAmigo;
	public UsuarioAmigoPOJO(String idUsuarioPrincipal, String idUsuarioAmigo) {
		super();
		this.idUsuarioPrincipal = idUsuarioPrincipal;
		this.idUsuarioAmigo = idUsuarioAmigo;
	}
	public String getIdUsuarioPrincipal() {
		return idUsuarioPrincipal;
	}
	public void setIdUsuarioPrincipal(String idUsuarioPrincipal) {
		this.idUsuarioPrincipal = idUsuarioPrincipal;
	}
	public String getIdUsuarioAmigo() {
		return idUsuarioAmigo;
	}
	public void setIdUsuarioAmigo(String idUsuarioAmigo) {
		this.idUsuarioAmigo = idUsuarioAmigo;
	}

}
