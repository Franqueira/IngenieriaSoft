package es.ucm.fdi.integracion.DAOs;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.POJO;

public class HashMapDAO<T extends POJO> implements DAO<T>{
	
	private BDHashMap<T> BD;
	
	@Override
	public void save(T t) {
		BD.insert(t, t.getId());
	}

	@Override
	public void update(T t) {
		BD.removeId(t.getId());
		BD.insert(t, t.getId());
	}

	@Override
	public POJO getFromId(String id) {
		return BD.find(id).clone();
	}

	@Override
	public void remove(String id) {
		BD.removeId(id);
	}
	
}
