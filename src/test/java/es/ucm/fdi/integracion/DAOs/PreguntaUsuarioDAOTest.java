package es.ucm.fdi.integracion.DAOs;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;

public class PreguntaUsuarioDAOTest{
	
	private BDHashMap<PreguntaUsuarioPOJO> BDPreguntaUsuario;
	
	public PreguntaUsuarioDAOTest(){
		
		this.BDPreguntaUsuario = new BDHashMap<PreguntaUsuarioPOJO>();
		setup();
	}
	
	
	
	public void setup() {
		PreguntaUsuarioDAOImp preguntaUsuarioDAO = new PreguntaUsuarioDAOImp(BDPreguntaUsuario);
		
		for(int i=1;i<13;i++){
			preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO("a"+i,"peter_hy"));
		}
	}
	
	

	@Test
	public void getPreguntasTest() {
		PreguntaUsuarioDAOImp preguntaUsuarioDAO = new PreguntaUsuarioDAOImp(BDPreguntaUsuario);
		ArrayList<String> preguntas = preguntaUsuarioDAO.getPreguntas("peter_hy");
		assertTrue("Deberia contener la pregunta con el id", preguntas.contains("a1"));
		assertTrue("Deberia contener la pregunta con el id", preguntas.contains("a7"));
		assertFalse("No deberia contener la pregunta con el id", preguntas.contains("b1"));
	}
	
	
	

}
