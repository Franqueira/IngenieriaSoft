package es.ucm.fdi.integracion.POJOs;

/**
 * Clase que representa un clan en la aplicación. Contiene información acerca de
 * su nombre y el id del líder del mismo.
 */

public class ClanPOJO extends POJO {
	private static final long serialVersionUID = -3656663855718569874L;
	String lider;

	public ClanPOJO(String nombreClan, String lider) {
		super(nombreClan);
		this.lider = lider;
	}

	public String getNombreClan() {
		return getId();
	}

	public void setNombreClan(String nombreClan) {
		if (nombreClan.equals("")) {
			throw new IllegalArgumentException(
					"Error, el Clan debe contener algún caracter.");
		}
		this.id = nombreClan;
	}

	public String getLider() {
		return lider;
	}

	public void setLider(String lider) {
		this.lider = lider;
	}
}
