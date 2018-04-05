package es.ucm.fdi.integracion.POJOs;

public class ClanPOJO {//duda
	String nombreClan;

	public String getNombreClan() {
		return nombreClan;
	}

	public void setNombreClan(String nombreClan) {
		if(nombreClan.equals("")){
			throw new IllegalArgumentException("Error, el Clan debe contener algún caracter.");
		}
		this.nombreClan = nombreClan;
	}

	public ClanPOJO(String nombreClan) {
		super();
		this.nombreClan = nombreClan;
	}
	

}
