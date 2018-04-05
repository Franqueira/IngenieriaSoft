package es.ucm.fdi.integracion.DAOs;

public class PreguntaUsuarioDAOImp implements PreguntaUsuarioDAO {
	
	private BD<PreguntaUsuarioPOJO> preguntas;
	private Random rand;

	public PreguntaUsuarioDAOImp(BD<PreguntaUsuarioPOJO> preguntas){
		this.preguntas = preguntas;
		this.rand = new Random();
	}
	
	public String getPreguntaAleat(){
		
	}

}