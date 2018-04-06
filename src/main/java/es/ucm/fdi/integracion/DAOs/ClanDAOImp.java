package es.ucm.fdi.integracion.DAOs;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;

public class ClanDAOImp implements ClanDAO{
	public BDHashMap<ClanPOJO> clanes;

	public ClanDAOImp(BDHashMap<ClanPOJO> clanes) {
		this.clanes = clanes;
	}

	public ClanPOJO getClan(String nombre) {
		return clanes.find(nombre);
	}

	public void saveClan(ClanPOJO c) {
		clanes.insert(c, c.getNombreClan());
	}

	public void removeClan(String c) {
		clanes.removeId(c);
	}
}
