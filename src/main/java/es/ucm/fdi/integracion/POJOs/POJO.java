package es.ucm.fdi.integracion.POJOs;

public abstract class POJO {

	private String id;

	public POJO(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public abstract POJO clone();

}
