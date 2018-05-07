package es.ucm.fdi.integracion.DAOs;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;

public class PreguntaUsuarioDAOTest{
	private BDHashMap<PreguntaUsuarioPOJO> BDPreguntaUsuario;
	private PreguntaUsuarioDAOImp preguntaUsuarioDAO;
	
	@Before
	public void setup() {
		BDPreguntaUsuario = new BDHashMap<PreguntaUsuarioPOJO>();
		preguntaUsuarioDAO = new PreguntaUsuarioDAOImp(BDPreguntaUsuario);
		
		for(int i=1;i<13;i++){
			preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO("a"+i,"peter_hy"));
		}
	}
	
	

	@Test
	public void getPreguntasTest() {
		ArrayList<String> preguntas = preguntaUsuarioDAO.getPreguntas("peter_hy");
		assertTrue("Deberia contener la pregunta con el id", preguntas.contains("a1"));
		assertTrue("Deberia contener la pregunta con el id", preguntas.contains("a7"));
		assertFalse("No deberia contener la pregunta con el id", preguntas.contains("b1"));
	}
	
	
	

}
