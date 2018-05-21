package es.ucm.fdi.negocio;

/**
 * Contiene los test que comprueban la funcionalidad de PreguntaSA
 */

import es.ucm.fdi.*;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.PreguntaClanDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaDAO;
import es.ucm.fdi.integracion.DAOs.PreguntaDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaUsuarioDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;

public class PreguntaSATest {
	private PreguntaDAOImp preguntaDAO;
	private PreguntaClanDAOImp preguntaClanDAO;
	private UsuarioDAOImp usuarioDAO;
	private PreguntaSA preguntaSA;
	private PreguntaUsuarioDAO preguntaUsuarioDAO;
	
	
	/**
	 * Creaccion de las preguntas
	 */
	@Before
	public void setup() {
		new InicializaPreguntaDAOImp1().inicializa(preguntaDAO);
		new InicializaPreguntaUsuarioDAOImp1().inicializa(preguntaUsuarioDAO);
		//preguntaSA = new PreguntaSAImp(preguntaDAO);
		preguntaSA = new PreguntaSAImp(preguntaDAO, preguntaUsuarioDAO,usuarioDAO,preguntaClanDAO);
		
	}
	
	/**
	 * Prueba que el sistema sabe si la respuesta esta bien
	 */
	//@Test
	/*public void getActiveTest(){
		assertTrue("Debería ser correcta",preguntaSA.comprobarRespuesta("a1",1));
		assertFalse("Debería ser falsa",preguntaSA.comprobarRespuesta("a1",2));
		assertFalse("Debería ser falsa",preguntaSA.comprobarRespuesta("a1",3));
	}*/
}
