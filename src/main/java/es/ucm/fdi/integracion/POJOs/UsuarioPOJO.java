package es.ucm.fdi.integracion.POJOs;

/**
 * 
 * @author Javier Guzmán
 *
 */

public class UsuarioPOJO {
	private String idUsuario;
	private String nombreReal;
	private int puntuacion;
	private String descPerfil;
	private String password;
	private String country;
	private boolean esGanador;
	private String idClan;

	public UsuarioPOJO(String idUsuario, String nombreReal, int puntuacion,
			String descPerfil, String password, String country) {
		this.idUsuario = idUsuario;
		this.nombreReal = nombreReal;
		this.puntuacion = puntuacion;
		this.descPerfil = descPerfil;
		this.password = password;
		this.country = country;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public boolean isEsGanador() {
		return esGanador;
	}

	public void setEsGanador(boolean esGanador) {
		this.esGanador = esGanador;
	}

	public String getNombreReal() {
		return nombreReal;
	}

	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getDescPerfil() {
		return descPerfil;
	}

	public void setDescPerfil(String descPerfil) {
		this.descPerfil = descPerfil;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return idUsuario + '\n' + descPerfil + '\n' + "Puntuacion: "
				+ puntuacion;

	}

	public String getIdClan() {
		return idClan;
	}

	public void setIdClan(String idClan) {
		this.idClan = idClan;
	}
}
