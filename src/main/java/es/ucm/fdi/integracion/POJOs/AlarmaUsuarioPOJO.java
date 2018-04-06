package es.ucm.fdi.integracion.POJOs;

public class AlarmaUsuarioPOJO extends POJO{
	String idUsuario;

	public AlarmaUsuarioPOJO(String idAlarma, String idUsuario) {
		super(idAlarma);
		this.idUsuario = idUsuario;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public POJO clone() {
		// TODO Auto-generated method stub
		return null;
	}
}
