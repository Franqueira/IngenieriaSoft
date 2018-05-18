package es.ucm.fdi.integracion.POJOs;

/**
 * 
 * Establece la relacion entre una alarma y un usuario, indicando que el usuario
 * tiene la alarma entre sus alarmas propias
 *
 */

public class AlarmaUsuarioPOJO extends POJO {
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
}
