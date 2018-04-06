package es.ucm.fdi.integracion.POJOs;

public class ClanPOJO extends POJO{// duda
	String lider;

	public ClanPOJO(String nombreClan, String lider) {
		super(nombreClan);
		this.lider = lider;
	}

	public String getNombreClan() { //en realidad sobra
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

	@Override
	public POJO clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
