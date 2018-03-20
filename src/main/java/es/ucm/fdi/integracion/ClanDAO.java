package es.ucm.fdi.integracion;

import es.ucm.fdi.datos.BD;

public class ClanDAO {
	public BD<ClanPOJO> clanes;

	public ClanDAO(BD<ClanPOJO> clanes) {
		this.clanes = clanes;
	}

	public ClanPOJO getClan(String nombre) {
		return clanes.find(nombre);

	}

	public void saveClan(ClanPOJO c) {
		clanes.insert(c, c.getNombreClan());
	}

	public void removeClan(ClanPOJO c) {
		clanes.removeId(c.getNombreClan());
	}
	// no vas a necesitar una lista entera para el clan.
}
