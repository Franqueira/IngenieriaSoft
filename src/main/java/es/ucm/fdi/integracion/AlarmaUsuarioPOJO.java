package es.ucm.fdi.integracion;

public class AlarmaUsuarioPOJO {
	String idAlarma;
	String idUsuario;
	public AlarmaUsuarioPOJO(String idAlarma,String idUsuario) {
		this.idAlarma=idAlarma;
		this.idUsuario=idUsuario;
	}
	public String getIdAlarma() {
		return idAlarma;
	}
	public void setIdAlarma(String idAlarma) {
		this.idAlarma = idAlarma;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	

}
