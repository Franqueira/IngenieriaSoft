package es.ucm.fdi.integracion.DAOs;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;

public class PreguntaDAOTest {
	public void setup(PreguntaDAO preguntaDAO) {
		ArrayList<String> respuestas1=new ArrayList<String>();
		respuestas1.add("Madrid");
		respuestas1.add("Paris");
		respuestas1.add("Roma");
		respuestas1.add("Londres");
		preguntaDAO.save(new PreguntaPOJO("a", "cual es la capital de españa?", respuestas1, 1));
		ArrayList<String> respuestas2=new ArrayList<String>();
		respuestas2.add("Madrid");
		respuestas2.add("Paris");
		respuestas2.add("Roma");
		respuestas2.add("Londres");
		preguntaDAO.save(new PreguntaPOJO("a", "cual es la capital de francia?", respuestas2, 2));
		ArrayList<String> respuestas3=new ArrayList<String>();
		respuestas3.add("Madrid");
		respuestas3.add("Paris");
		respuestas3.add("Roma");
		respuestas3.add("Londres");
		preguntaDAO.save(new PreguntaPOJO("a", "cual es la capital de italia?", respuestas3, 3));
		ArrayList<String> respuestas4=new ArrayList<String>();
		respuestas4.add("Madrid");
		respuestas4.add("Paris");
		respuestas4.add("Roma");
		respuestas4.add("Londres");
		preguntaDAO.save(new PreguntaPOJO("a", "cual es la capital de reino unido?", respuestas4, 4));
		ArrayList<String> respuestas5=new ArrayList<String>();
		respuestas5.add("Wahington");
		respuestas5.add("Moscu");
		respuestas5.add("Praga");
		respuestas5.add("Berlin");
		preguntaDAO.save(new PreguntaPOJO("a", "cual es la capital de eeuu?", respuestas5, 1));
		ArrayList<String> respuestas6=new ArrayList<String>();
		respuestas6.add("Wahington");
		respuestas6.add("Moscu");
		respuestas6.add("Praga");
		respuestas6.add("Berlin");
		preguntaDAO.save(new PreguntaPOJO("a", "cual es la capital de rusia?", respuestas5, 2));
		ArrayList<String> respuestas7=new ArrayList<String>();
		respuestas7.add("Wahington");
		respuestas7.add("Moscu");
		respuestas7.add("Praga");
		respuestas7.add("Berlin");
		preguntaDAO.save(new PreguntaPOJO("a", "cual es la capital de checoslovaquia?", respuestas5, 3));
		ArrayList<String> respuestas8=new ArrayList<String>();
		respuestas8.add("Wahington");
		respuestas8.add("Moscu");
		respuestas8.add("Praga");
		respuestas8.add("Berlin");
		preguntaDAO.save(new PreguntaPOJO("a", "cual es la capital de alemania?", respuestas8, 4));
		ArrayList<String> respuestas9=new ArrayList<String>();
		respuestas9.add("el cairo");
		respuestas9.add("copenague");
		respuestas9.add("estocolmo");
		respuestas9.add("helsinki");
		preguntaDAO.save(new PreguntaPOJO("a", "cual es la capital de egipto?", respuestas9, 1));
		ArrayList<String> respuestas10=new ArrayList<String>();
		respuestas9.add("el cairo");
		respuestas9.add("copenague");
		respuestas9.add("estocolmo");
		respuestas9.add("helsinki");
		preguntaDAO.save(new PreguntaPOJO("a", "cual es la capital de el cairo?", respuestas9, 1));
		ArrayList<String> respuestas11=new ArrayList<String>();
		respuestas9.add("el cairo");
		respuestas9.add("copenague");
		respuestas9.add("estocolmo");
		respuestas9.add("helsinki");
		preguntaDAO.save(new PreguntaPOJO("a", "cual es la capital de el cairo?", respuestas9, 1));
		ArrayList<String> respuestas12=new ArrayList<String>();
		respuestas9.add("el cairo");
		respuestas9.add("copenague");
		respuestas9.add("estocolmo");
		respuestas9.add("helsinki");
		preguntaDAO.save(new PreguntaPOJO("a", "cual es la capital de el cairo?", respuestas9, 1));
	}
	
	@Test
	public void getAllTest() {
		PreguntaDAO preguntaDAO = new PreguntaDAOImp(new BDHashMap<PreguntaPOJO>());
		setup(preguntaDAO);
		ArrayList<PreguntaPOJO> todas = preguntaDAO.getAll();
		ArrayList<PreguntaPOJO>  esperadas = new ArrayList<>();
		esperadas.add((PreguntaPOJO) alarma
		assertEquals("Se esperaban todas las preguntas", esperadas, todas);
	}
	
	@Test
	public void getPreguntasTest() {
		PreguntaDAO preguntaDAO = new PreguntaDAOImp(new BDHashMap<PreguntaPOJO>());
		setup(preguntaDAO);
		ArrayList<PreguntaPOJO> preguntas = preguntaDAO.getAll();
		ArrayList<PreguntaPOJO>  esperadas = new ArrayList<>();
		esperadas.add((PreguntaPOJO) alarma
		assertEquals("Se esperaban todas las preguntas a, c y e", esperadas, preguntas);
	}
}
