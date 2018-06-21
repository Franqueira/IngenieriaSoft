package es.ucm.fdi.negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.*;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.AlarmaDAOImp;
import es.ucm.fdi.integracion.DAOs.AlarmaUsuarioDAOImp;
import es.ucm.fdi.integracion.DAOs.ClanDAOImp;
import es.ucm.fdi.integracion.DAOs.FactoriaDAOs;
import es.ucm.fdi.integracion.DAOs.PreguntaDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaUsuarioDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.integracion.POJOs.AlarmaUsuarioPOJO;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

/**
 * Clase que contiene los test que comprueban la funcionalidad de los UsuarioSA
 */

@SuppressWarnings("unchecked")
public class UsuarioSATest {
	@SuppressWarnings("rawtypes")
	FactoriaDAOs factoria = new FactoriaDAOs();
	private UsuarioSA usuario;
	private UsuarioDAOImp usuarioDAO = (UsuarioDAOImp) factoria.creaDAO(6,
			new BDHashMap<UsuarioPOJO>());
	private AlarmaDAOImp alarmaDAO = (AlarmaDAOImp) factoria.creaDAO(0,
			new BDHashMap<AlarmaPOJO>());
	private AlarmaUsuarioDAOImp alarmaUsuarioDAO = (AlarmaUsuarioDAOImp) factoria
			.creaDAO(1, new BDHashMap<AlarmaUsuarioPOJO>());
	private PreguntaDAOImp preguntaDAO = (PreguntaDAOImp) factoria.creaDAO(4,
			new BDHashMap<PreguntaPOJO>());
	private PreguntaUsuarioDAO preguntaUsuarioDAO = (PreguntaUsuarioDAO) factoria
			.creaDAO(5, new BDHashMap<PreguntaUsuarioPOJO>());
	private UsuarioClanDAO usuarioClanDAO = (UsuarioClanDAO) factoria.creaDAO(
			7, new BDHashMap<UsuarioClanPOJO>());
	private ClanDAOImp clanDAO = (ClanDAOImp) factoria.creaDAO(2,
			new BDHashMap<ClanPOJO>());

	/**
	 * Creación de una situación inicial
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
	 * Comprueba que el sistema elimina correctamente un usuario
	 * 
	 * @see InicializaUsuarioDAOImp1
	 */
	@Test
	public void eliminarUsuarioTest() {
		usuario.eliminarUsuario("jc");
		assertEquals("Debería desaparecer de usuarioDAO", null,
				usuarioDAO.find("JC Villanueva"));
		String idClan = ((UsuarioPOJO) usuarioDAO.getFromId("javigm"))
				.getIdClan();
		ClanPOJO c = (ClanPOJO) clanDAO.getFromId(idClan);
		assertFalse("jc no deberia seguir siendo el lider", c.getLider()
				.equals("jc"));
		assertTrue("franqui deberia ser el lider",
				c.getLider().equals("franqui"));
		usuario.eliminarUsuario("franqui");
		c = (ClanPOJO) clanDAO.getFromId(idClan);
		assertEquals("Debería desaparecer de usuarioDAO", null,
				usuarioDAO.find("franqui"));
		assertFalse("Debería cambiar de líder", c.getLider().equals("franqui"));
	}

	/**
	 * Comprueba que se añade un usuario correctamente
	 */
	@Test
	public void anadirUsuarioTest() {
		UsuarioPOJO jaime = new UsuarioPOJO("jaime123", "Jaime Fernandez", 109,
				"soyjaime", "Spain");
		usuario.anadirUsuario(jaime);
		assertTrue("debería encontrarlo",
				usuarioDAO.find("Jaime Fernandez") != null);
		assertEquals("Debería encontrarlo", jaime,
				usuarioDAO.getFromId("jaime123"));
	}

	/**
	 * @see InicializaPreguntaDAOImp1,InicializaUsuarioDAOImp1
	 */
	@Test
	public void informarRespuestaTest() {
		assertTrue("La respuesta correcta es la 1",
				((PreguntaPOJO) preguntaDAO.getFromId("al1"))
						.getRespuestaCorrecta() == 1);
		assertEquals("javi debería tener 1001 puntos", 1001,
				((UsuarioPOJO) usuarioDAO.getFromId("javigm")).getPuntuacion());
		usuario.informarRespuesta("javigm", "al1", 1);
		assertEquals("Deberia tener 10 puntos mas", 1011,
				((UsuarioPOJO) usuarioDAO.getFromId("javigm")).getPuntuacion());
		usuario.informarRespuesta("javigm", "al2", 1);
	}

	/**
	 * @see InicializaAlarmaUsuarioDAOImp1
	 */
	@Test
	public void preguntasUsuarioTest() {
		ArrayList<String> list = alarmaUsuarioDAO.getAlarmasUsuario("jc");
		ArrayList<String> esperadas = new ArrayList<>();
		esperadas.add("al10");
		esperadas.add("al15");

		/*
		 * Para comprobar que las dos listas son iguales (sin importar el orden)
		 * comprobamos que todas las preguntas de esperadas se encuentra en list
		 * y ademas que tienen el mismo tamano.
		 * 
		 * Si list tiene el mismo tamano y contiene todas las preguntas de
		 * esperadas entonces son la misma lista.
		 */

		for (String s : esperadas) {
			assertTrue("List deberia contener la alarma" + s, list.contains(s));
		}
		assertTrue("El tamaño de list deberia ser igual al de esperadas",
				list.size() == esperadas.size());

	}

}
