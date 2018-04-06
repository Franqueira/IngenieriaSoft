package es.ucm.fdi.integracion.DAOs;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;
import junit.framework.TestCase;

public class PreguntaUsuarioDAOTest{
	
	private BDHashMap<PreguntaUsuarioPOJO> BDPreguntaUsuario;
	
	public PreguntaUsuarioDAOTest(){
		
		this.BDPreguntaUsuario = new BDHashMap<PreguntaUsuarioPOJO>();
		setup();
	}
	
	
	
	public void setup() {
		PreguntaUsuarioDAOImp preguntaUsuarioDAO = new PreguntaUsuarioDAOImp(BDPreguntaUsuario);
		
		preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO("a1","peter_hy"));
		preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO("a2","peter_hy"));
		preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO("a3","peter_hy"));
		preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO("a4","peter_hy"));
		preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO("a5","peter_hy"));
		preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO("a6","peter_hy"));
		preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO("a7","peter_hy"));
		preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO("a8","peter_hy"));
		preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO("a9","peter_hy"));
		preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO("a10","peter_hy"));
		preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO("a11","peter_hy"));
		preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO("a12","peter_hy"));
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
