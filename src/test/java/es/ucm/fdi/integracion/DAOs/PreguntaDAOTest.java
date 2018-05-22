package es.ucm.fdi.integracion.DAOs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.InicializaPreguntaDAOImp1;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;

public class PreguntaDAOTest {
	private PreguntaDAO preguntaDAO = new PreguntaDAOImp(new BDHashMap<PreguntaPOJO>());
	
	@Before
	public void setup() {
		new InicializaPreguntaDAOImp1().inicializa(preguntaDAO);
	}
	
	@Test
	public void getAllTest() {
		ArrayList<PreguntaPOJO> todas = preguntaDAO.getAll();
		ArrayList<PreguntaPOJO>  esperadas = new ArrayList<>();
		
		for(int i = 1; i<13; i++){
			esperadas.add((PreguntaPOJO) preguntaDAO.getFromId("a"+i));
		}
		
		for(PreguntaPOJO a: todas){
			assertTrue(esperadas.contains(a));
		}
	}
	
	@Test
	public void getPreguntasTest() {
		
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("a1");
		lista.add("a5");
		lista.add("a11");
		ArrayList<PreguntaPOJO> preguntas = preguntaDAO.getPreguntas(lista);
		ArrayList<PreguntaPOJO>  esperadas = new ArrayList<>();
		
		esperadas.add((PreguntaPOJO) preguntaDAO.getFromId("a1"));
		esperadas.add((PreguntaPOJO) preguntaDAO.getFromId("a5"));
		esperadas.add((PreguntaPOJO) preguntaDAO.getFromId("a11"));
		
		assertEquals("Se esperaban las preguntas a1, a5 y a11", esperadas, preguntas);
	}
}
