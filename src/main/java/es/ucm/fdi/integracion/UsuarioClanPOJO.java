package es.ucm.fdi.integracion;

public class UsuarioClanPOJO {
	String idClan; // su nombre
	String idUsuario;

	public UsuarioClanPOJO(String idClan, String idUsuario) {
		super();
		this.idClan = idClan;
		this.idUsuario = idUsuario;
	}

	public String getIdClan() {
		return idClan;
	}

	public void setIdClan(String idClan) {
		this.idClan = idClan;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

}
