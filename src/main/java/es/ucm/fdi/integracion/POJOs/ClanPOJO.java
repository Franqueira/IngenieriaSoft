package es.ucm.fdi.integracion.POJOs;

public class ClanPOJO {// duda
	String nombreClan;
	String lider;

	public ClanPOJO(String nombreClan, String lider) {
		this.nombreClan = nombreClan;
		this.lider = lider;
	}

	public String getNombreClan() {
		return nombreClan;
	}

	public void setNombreClan(String nombreClan) {
		if (nombreClan.equals("")) {
			throw new IllegalArgumentException(
					"Error, el Clan debe contener algún caracter.");
		}
		this.nombreClan = nombreClan;
	}

	public String getLider() {
		return lider;
	}

	public void setLider(String lider) {
		this.lider = lider;
	}

}
