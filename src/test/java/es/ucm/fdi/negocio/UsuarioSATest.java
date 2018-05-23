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

/**
 * Clase que contiene los test que comprueban la funcionalidad de los UsuarioSA
 */

public class UsuarioSATest {
	private UsuarioSA usuario;
	private UsuarioDAOImp usuarioDAO = new UsuarioDAOImp(new BDHashMap<UsuarioPOJO>());
	private AlarmaDAOImp alarmaDAO = new AlarmaDAOImp(new BDHashMap<AlarmaPOJO>());
	private AlarmaUsuarioDAOImp alarmaUsuarioDAO = new AlarmaUsuarioDAOImp(new BDHashMap<AlarmaUsuarioPOJO>());
	private PreguntaDAOImp preguntaDAO = new PreguntaDAOImp(new BDHashMap<PreguntaPOJO>());
	private PreguntaUsuarioDAOImp preguntaUsuarioDAO = new PreguntaUsuarioDAOImp(new BDHashMap<PreguntaUsuarioPOJO>());
	private UsuarioClanDAOImp usuarioClanDAO = new UsuarioClanDAOImp(new BDHashMap<UsuarioClanPOJO>());
	private ClanDAOImp clanDAO = new ClanDAOImp(new BDHashMap<ClanPOJO>());
	
	
	/**
	 * Creacion de una situacion inicial
	 */
	@Before
	public void setup(){
		new InicializaUsuarioDAOImp1().inicializa(usuarioDAO);
		new InicializaAlarmaDAOImp1().inicializa(alarmaDAO);
		new InicializaAlarmaUsuarioDAOImp1().inicializa(alarmaUsuarioDAO);
		new InicializaPreguntaDAOImp1().inicializa(preguntaDAO);
		new InicializaPreguntaUsuarioDAOImp1().inicializa(preguntaUsuarioDAO);
		new InicializaUsuarioClanDAOImp1().inicializa(usuarioClanDAO);
		new InicializaClanDAOImp1().inicializa(clanDAO);
	
		usuario = new UsuarioSAImp(usuarioDAO,usuarioClanDAO,alarmaUsuarioDAO,clanDAO,alarmaDAO,preguntaDAO,preguntaUsuarioDAO);
	}
	
	/**
	 * Comprueba que el sistema elimina correctamente un usuario
	 */
	@Test
	public void EliminarUsuarioTest(){
		usuario.EliminarUsuario("jc");
		assertEquals("Debería desaparecer de usuarioDAO",null,usuarioDAO.find("JC Villanueva"));
		String idClan=((UsuarioPOJO) usuarioDAO.getFromId("javigm")).getIdClan();
		ClanPOJO c =(ClanPOJO)clanDAO.getFromId(idClan);
		assertFalse("jc no deberia seguir siendo el lider",c.getLider().equals("jc"));
		assertTrue("franqui deberia ser el lider",c.getLider().equals("franqui"));
		usuario.EliminarUsuario("franqui");
		c =(ClanPOJO)clanDAO.getFromId(idClan);
		assertEquals("Debería desaparecer de usuarioDAO",null,usuarioDAO.find("franqui"));
		assertFalse("Debería cambiar de líder",c.getLider().equals("franqui"));	
	}
	
	/**
	 * Comprueba que se añade un usuario correctamente
	 */
	@Test
	public void AnadirUsuarioTest(){
		usuario.AnadirUsuario(new UsuarioPOJO("jaime123", "Jaime Fernandez", 109, "soyjaime", "Spain"));
		assertTrue("debería encontrarlo",usuarioDAO.find("Jaime Fernandez")!= null);
	}
	
	/**
	 * Comprueba que un a alarma se añade correctamente
	 */
	@Test
	public void AnadirAlarmaTest(){
		usuario.AnadirAlarma(new AlarmaPOJO("al16", 12, 23, true, "mytone1.mp3"), "jc");
		assertTrue("Debería encontrarla",alarmaDAO.getFromId("al16")!=null);
		assertTrue("Debería añadir la alarma",alarmaUsuarioDAO.getAlarmasUsuario("jc").contains("al16"));
		usuario.AnadirAlarma((AlarmaPOJO)alarmaDAO.getFromId("al2"), "pablitos");
		assertTrue("Deberia haber anadido una alarma existente", alarmaUsuarioDAO.getAlarmasUsuario("pablitos").contains("al2"));
	}
	
	/**
	 * Comprueba que se añade una pregunta correctamente
	 */
	/*@Test
	public void AnadirPreguntaTest() {
		ArrayList<String> respuestas1=new ArrayList<String>();
		respuestas1.add("Madrid");
		respuestas1.add("Paris");
		respuestas1.add("Roma");
		respuestas1.add("Londres");
		preguntaDAO.save(new PreguntaPOJO("a1", "cual es la capital de españa?", "geografía", respuestas1, 1));
		
		usuario.
		assertTrue("Deberia encontrarla", preguntaUsuarioDAO.getPreguntas("javigm").contains("a1"));
	}*/
	
	/**
	 * Comprueba que se elimina una alarma correctamente
	 */
	@Test
	public void EliminarAlarmaTest(){
		assertTrue("Debería estar la alarma",alarmaDAO.getFromId("al1")!=null);
		usuario.EliminarAlarma("al1");
		try{
			alarmaDAO.getFromId("al1");
			assertTrue("Se esperaba excepcion",true);
		}
		catch(NullPointerException e){
		}
		assertTrue("No debería tener asignada esta alarma",!alarmaUsuarioDAO.getAlarmasUsuario("javigm").contains("al1"));	
	}
	
	@Test
	public void informarRespuestaTest(){
		assertTrue("La respuesta correcta es la 1", ((PreguntaPOJO) preguntaDAO.getFromId("a1")).getRespuestaCorrecta() == 1);
		usuario.informarRespuesta("javigm", "a1", 1);
		assertEquals("Deberia tener 10 puntos mas", 1011, ((UsuarioPOJO)usuarioDAO.getFromId("javigm")).getPuntuacion());
		usuario.informarRespuesta("javigm", "a2", 1);
	}
	
}
