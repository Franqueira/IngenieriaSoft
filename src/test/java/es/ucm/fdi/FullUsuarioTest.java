package es.ucm.fdi;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.*;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.AlarmaDAOImp;
import es.ucm.fdi.integracion.DAOs.AlarmaUsuarioDAOImp;
import es.ucm.fdi.integracion.DAOs.ClanDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaUsuarioDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.integracion.POJOs.AlarmaUsuarioPOJO;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;
import es.ucm.fdi.negocio.UsuarioSA;
import es.ucm.fdi.negocio.UsuarioSAImp;

/**
 * Clase que contiene los test que comprueban la funcionalidad de los UsuarioSA
 */

public class FullUsuarioTest {
	private UsuarioSA usuario;
	private UsuarioDAOImp usuarioDAO = new UsuarioDAOImp(
			new BDHashMap<UsuarioPOJO>());
	private AlarmaDAOImp alarmaDAO = new AlarmaDAOImp(
			new BDHashMap<AlarmaPOJO>());
	private AlarmaUsuarioDAOImp alarmaUsuarioDAO = new AlarmaUsuarioDAOImp(
			new BDHashMap<AlarmaUsuarioPOJO>());
	private PreguntaDAOImp preguntaDAO = new PreguntaDAOImp(
			new BDHashMap<PreguntaPOJO>());
	private PreguntaUsuarioDAOImp preguntaUsuarioDAO = new PreguntaUsuarioDAOImp(
			new BDHashMap<PreguntaUsuarioPOJO>());
	private UsuarioClanDAOImp usuarioClanDAO = new UsuarioClanDAOImp(
			new BDHashMap<UsuarioClanPOJO>());
	private ClanDAOImp clanDAO = new ClanDAOImp(new BDHashMap<ClanPOJO>());

	/**
	 * Creacion de una situacion inicial
	 */
	@Before
	public void setup() {
		new InicializaUsuarioDAOImp1().inicializa(usuarioDAO);
		new InicializaAlarmaDAOImp1().inicializa(alarmaDAO);
		new InicializaAlarmaUsuarioDAOImp1().inicializa(alarmaUsuarioDAO);
		new InicializaPreguntaDAOImp1().inicializa(preguntaDAO);
		new InicializaPreguntaUsuarioDAOImp1().inicializa(preguntaUsuarioDAO);
		new InicializaUsuarioClanDAOImp1().inicializa(usuarioClanDAO);
		new InicializaClanDAOImp1().inicializa(clanDAO);

		usuario = new UsuarioSAImp(usuarioDAO, usuarioClanDAO,
				alarmaUsuarioDAO, clanDAO, alarmaDAO, preguntaDAO,
				preguntaUsuarioDAO);
	}
	
	/**
	 * 
	 * Comprueba que se obtienen correctamente las preguntas de un usuario
	 * 
	 */
	@Test
	public void testPreguntasUsuario() {
		ArrayList<String> list = usuario.preguntasUsuario("peter_hy");
		ArrayList<String> esperadas = new ArrayList<>();
		for (int i = 1; i < 13; i++) {
			esperadas.add("a" + i);
		}

		/*
		 * Para comprobar que las dos listas son iguales (sin importar el orden)
		 * comprobamos que todas las preguntas de esperadas se encuentra en list
		 *  y ademas que tienen el mismo tamano.
		 * 
		 * Si list tiene el mismo tamano y contiene todas las preguntas de esperadas
		 * entonces son la misma lista.
		 * 
		 */

		for(String s : esperadas) {
			assertTrue("List deberia contener la pregunta" + s,
					list.contains(s));
		}
		assertTrue("El tamaño de list deberia ser igual al de esperadas",
				list.size() == esperadas.size());
		
	}
	
	@Test
	public void testAlarmasUsuario() {
		ArrayList<String> list = alarmaUsuarioDAO.getAlarmasUsuario("jc");
		ArrayList<String> esperadas = new ArrayList<>();
		esperadas.add("al10");
		esperadas.add("al15");
		
		/*
		 * Para comprobar que las dos listas son iguales (sin importar el orden)
		 * comprobamos que todas las preguntas de esperadas se encuentra en list
		 *  y ademas que tienen el mismo tamano.
		 * 
		 * Si list tiene el mismo tamano y contiene todas las preguntas de esperadas
		 * entonces son la misma lista.
		 * 
		 */
		
		for(String s : esperadas) {
			assertTrue("List deberia contener la alarma" + s,
					list.contains(s));
		}
		assertTrue("El tamaño de list deberia ser igual al de esperadas", 
				list.size() == esperadas.size());

	}
}