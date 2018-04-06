package es.ucm.fdi.integracion.DAOs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;

public class PreguntaDAOTest {
	public void setup(PreguntaDAO preguntaDAO) {
		//Creacion de preguntas
		ArrayList<String> respuestas1=new ArrayList<String>();
		respuestas1.add("Madrid");
		respuestas1.add("Paris");
		respuestas1.add("Roma");
		respuestas1.add("Londres");
		preguntaDAO.save(new PreguntaPOJO("a1", "cual es la capital de españa?", respuestas1, 1));
		preguntaDAO.save(new PreguntaPOJO("a2", "cual es la capital de francia?", respuestas1, 2));
		preguntaDAO.save(new PreguntaPOJO("a3", "cual es la capital de italia?", respuestas1, 3));
		preguntaDAO.save(new PreguntaPOJO("a4", "cual es la capital de reino unido?", respuestas1, 4));
		
		ArrayList<String> respuestas2=new ArrayList<String>();
		respuestas2.add("Wahington");
		respuestas2.add("Moscu");
		respuestas2.add("Praga");
		respuestas2.add("Berlin");
		preguntaDAO.save(new PreguntaPOJO("a5", "cual es la capital de eeuu?", respuestas2, 1));
		preguntaDAO.save(new PreguntaPOJO("a6", "cual es la capital de rusia?", respuestas2, 2));
		preguntaDAO.save(new PreguntaPOJO("a7", "cual es la capital de checoslovaquia?", respuestas2, 3));
		preguntaDAO.save(new PreguntaPOJO("a8", "cual es la capital de alemania?", respuestas2, 4));
		
		ArrayList<String> respuestas3=new ArrayList<String>();
		respuestas3.add("el cairo");
		respuestas3.add("copenague");
		respuestas3.add("estocolmo");
		respuestas3.add("helsinki");
		preguntaDAO.save(new PreguntaPOJO("a9", "cual es la capital de egipto?", respuestas3, 1));
		preguntaDAO.save(new PreguntaPOJO("a10", "cual es la capital de dinamarca?", respuestas3, 2));
		preguntaDAO.save(new PreguntaPOJO("a11", "cual es la capital de suecia?", respuestas3, 3));
		preguntaDAO.save(new PreguntaPOJO("a12", "cual es la capital de finlandia?", respuestas3, 4));	
	
	}
	
	@Test
	public void getAllTest() {
		PreguntaDAO preguntaDAO = new PreguntaDAOImp(new BDHashMap<PreguntaPOJO>());
		setup(preguntaDAO);
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
		PreguntaDAO preguntaDAO = new PreguntaDAOImp(new BDHashMap<PreguntaPOJO>());
		setup(preguntaDAO);
		
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
