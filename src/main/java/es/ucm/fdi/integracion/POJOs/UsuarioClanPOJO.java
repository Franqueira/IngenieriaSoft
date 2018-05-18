package es.ucm.fdi.integracion.POJOs;

/**
 * Relaciona un usuario con un caln, indicando que el usuario es miembro del
 * clan.
 *
 */
public class UsuarioClanPOJO extends POJO {
	String idClan; // su nombre

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
