package es.ucm.fdi.integracion.POJOs;

/**
 * Relaciona un usuario con un clan, indicando que el usuario es miembro del
 * clan.
 */
public class UsuarioClanPOJO extends POJO {

	private static final long serialVersionUID = -7318816738728432942L;
	String idClan;

	public UsuarioClanPOJO(String idClan, String idUsuario) {
		super(idUsuario);
		this.idClan = idClan;
	}

	public String getIdClan() {
		return idClan;
	}

	public void setIdClan(String idClan) {
		this.idClan = idClan;
	}
}
