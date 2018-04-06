package es.ucm.fdi.integracion.POJOs;

/**
 * 
 * @author Javier Guzmán
 *
 */

public class UsuarioPOJO extends POJO{
	private String nombreReal;
	private int puntuacion;
	private String password;
	private String country;
	private boolean esGanador;
	private String idClan;

	public UsuarioPOJO(String idUsuario, String nombreReal, int puntuacion,
			String password, String country) {
		super(idUsuario);
		this.nombreReal = nombreReal;
		this.puntuacion = puntuacion;
		this.password = password;
		this.country = country;
		esGanador=false;
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
		return id + '\n' + "Puntuacion: "
				+ puntuacion;

	}

	public String getIdClan() {
		return idClan;
	}

	public void setIdClan(String idClan) {
		this.idClan = idClan;
	}

	@Override
	public POJO clone() {
		return this;
	}
}
