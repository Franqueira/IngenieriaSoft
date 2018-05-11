package es.ucm.fdi.negocio;

/**
 * Contiene los test que comprueban la funcionalidad de PreguntaSA
 */

import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.PreguntaDAO;
import es.ucm.fdi.integracion.DAOs.PreguntaDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaUsuarioDAO;

public class PreguntaSATest {
	private PreguntaDAOImp preguntaDAO;
	private PreguntaSA preguntaSA;
	private PreguntaUsuarioDAO preguntaUsuarioDAO;
	
	
	/**
	 * Creaccion de las preguntas
	 */
	@Before
	public void setup() {
		preguntaDAO = new PreguntaDAOImp(new BDHashMap<PreguntaPOJO>());
		//preguntaSA = new PreguntaSAImp(preguntaDAO);
		preguntaSA = new PreguntaSAImp(preguntaDAO, preguntaUsuarioDAO);
		
		ArrayList<String> respuestas1 = new ArrayList<String>();
		respuestas1.add("Madrid");
		respuestas1.add("Paris");
		respuestas1.add("Roma");
		respuestas1.add("Londres");
		preguntaDAO.save(new PreguntaPOJO("a1", "cual es la capital de españa?", "geografía", respuestas1, 1));
		preguntaDAO.save(new PreguntaPOJO("a2", "cual es la capital de francia?", "geografía", respuestas1, 2));
		preguntaDAO.save(new PreguntaPOJO("a3", "cual es la capital de italia?", "geografía", respuestas1, 3));
		preguntaDAO.save(new PreguntaPOJO("a4", "cual es la capital de reino unido?", "geografía", respuestas1, 4));
		
		ArrayList<String> respuestas2 = new ArrayList<String>();
		respuestas2.add("Wahington");
		respuestas2.add("Moscu");
		respuestas2.add("Praga");
		respuestas2.add("Berlin");
		preguntaDAO.save(new PreguntaPOJO("a5", "cual es la capital de eeuu?", "geografía", respuestas2, 1));
		preguntaDAO.save(new PreguntaPOJO("a6", "cual es la capital de rusia?", "geografía", respuestas2, 2));
		preguntaDAO.save(new PreguntaPOJO("a7", "cual es la capital de checoslovaquia?", "geografía", respuestas2, 3));
		preguntaDAO.save(new PreguntaPOJO("a8", "cual es la capital de alemania?", "geografía", respuestas2, 4));
		
		ArrayList<String> respuestas3 = new ArrayList<String>();
		respuestas3.add("el cairo");
		respuestas3.add("copenague");
		respuestas3.add("estocolmo");
		respuestas3.add("helsinki");
		preguntaDAO.save(new PreguntaPOJO("a9", "cual es la capital de egipto?", "geografía", respuestas3, 1));
		preguntaDAO.save(new PreguntaPOJO("a10", "cual es la capital de dinamarca?", "geografía", respuestas3, 2));
		preguntaDAO.save(new PreguntaPOJO("a11", "cual es la capital de suecia?", "geografía", respuestas3, 3));
		preguntaDAO.save(new PreguntaPOJO("a12", "cual es la capital de finlandia?", "geografía", respuestas3, 4));	
	
	}
	
	/**
	 * Prueba que el sistema sabe si la respuesta es correcta o falsa
	 */
	//@Test
	/*public void getActiveTest(){
		assertTrue("Debería ser correcta",preguntaSA.comprobarRespuesta("a1",1));
		assertFalse("Debería ser falsa",preguntaSA.comprobarRespuesta("a1",2));
		assertFalse("Debería ser falsa",preguntaSA.comprobarRespuesta("a1",3));
	}*/
}
