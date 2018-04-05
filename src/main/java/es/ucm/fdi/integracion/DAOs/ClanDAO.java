package es.ucm.fdi.integracion.DAOs;

import es.ucm.fdi.integracion.POJOs.ClanPOJO;

public interface ClanDAO {
	public ClanPOJO getClan(String nombre);

	public void saveClan(ClanPOJO c);

	public void removeClan(ClanPOJO c);
}
