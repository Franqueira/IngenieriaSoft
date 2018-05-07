
package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;
import java.util.List;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.POJO;

public class HashMapDAOImp<T extends POJO> implements DAO<T>{
	
	protected BDHashMap<T> BD;
	
	protected HashMapDAOImp(BDHashMap<T> BD) {
		this.BD = BD;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void save(T t) {
		BD.insert((T) t.clone(), t.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(T t) {
		BD.removeId(t.getId());
		BD.insert((T) t.clone(), t.getId());
	}

	@Override
	public POJO getFromId(String id) {
		return BD.find(id).clone();
	}

	@Override
	public void remove(String id) {
		BD.removeId(id);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<T> getFromIds(List<T> pojos) {
		ArrayList<T> nuevos = new ArrayList<>();
		pojos.forEach(pojo -> nuevos.add((T) pojo.clone()));
		return nuevos;
	}
	
}
