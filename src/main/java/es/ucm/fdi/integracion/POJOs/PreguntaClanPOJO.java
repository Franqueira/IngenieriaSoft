package es.ucm.fdi.integracion.POJOs;

/**
 * 
 * Establece una relacion entre un clan y una pregunta.
 *
 */
public class PreguntaClanPOJO extends POJO{
	String id_clan;

	public PreguntaClanPOJO(String id_pregunta,String id_clan) {
		super(id_pregunta);
		this.id_clan = id_clan;
	}

	public String getIdClan() {
		return id_clan;
	}

	public void setIdClan(String id_clan) {
		this.id_clan = id_clan;
	}
}
