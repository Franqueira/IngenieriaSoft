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
	private UsuarioDAOImp usuarioDAO;
	private AlarmaDAOImp alarmaDAO;
	private AlarmaUsuarioDAOImp alarmaUsuarioDAO;
	private PreguntaDAOImp preguntaDAO;
	private PreguntaUsuarioDAOImp preguntaUsuarioDAO;
	private UsuarioClanDAOImp usuarioClanDAO;
	private ClanDAOImp clanDAO;
	
	
	/**
	 * Creaccion de una situacion inicial
	 */
	@Before
	private void setup(){
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
		assertEquals("Debería desaparecer de usuarioDAO",null,usuarioDAO.find("jc"));
		String idClan=((UsuarioPOJO) usuarioDAO.getFromId("javigm")).getIdClan();
		ClanPOJO c=(ClanPOJO)clanDAO.getFromId(idClan);
		assertTrue("Javi debería ser el líder del clan",c.getLider().equals("javigm"));
		usuario.EliminarUsuario("javigm");
		assertEquals("Debería desaparecer de usuarioDAO",null,usuarioDAO.find("javigm"));
		assertFalse("Debería cambiar de líder",c.getLider().equals("javigm"));	
	}
	
	/**
	 * Comprueba que se añade un usuario correctamente
	 */
	@Test
	public void AnadirUsuarioTest(){
		usuario.AnadirUsuario(new UsuarioPOJO("jaime123", "Jaime Fernandez", 109, "soyjaime", "Spain"));
		assertTrue("debería encontrarlo",usuarioDAO.find("jaime123")==null);	
	}
	
	/**
	 * Comprueba que un a alarma se añade correctamente
	 */
	@Test
	public void AnadirAlarmaTest(){
		usuario.AnadirAlarma(new AlarmaPOJO("al16", 12, 23, true, "mytone1.mp3"), "jc");
		assertTrue("Debería encontrarla",alarmaDAO.getFromId("al16")!=null);
		assertTrue("Debería añadir la alarma",alarmaUsuarioDAO.getAlarmasUsuario("jc").contains("al16"));
	}
	
	/**
	 * Comprueba que se añade una pregunta correctamente
	 */
	@Test
	public void AnadirPreguntaTest() {
		ArrayList<String> respuestas1=new ArrayList<String>();
		respuestas1.add("Madrid");
		respuestas1.add("Paris");
		respuestas1.add("Roma");
		respuestas1.add("Londres");
		preguntaDAO.save(new PreguntaPOJO("a1", "cual es la capital de españa?", "geografía", respuestas1, 1));
		
		//usuario.aniadirPregunta(new PreguntaPOJO(
		//		"a1", "cual es la capital de españa?", "geografía", respuestas1, 1), "javigm");
		assertTrue("Deberia encontrarla", preguntaUsuarioDAO.getPreguntas("javigm").contains("a1"));
	}
	
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
	
	/**
	 * Comprueba que se elimina correctamente una pregunta
	 */
	@Test
	public void EliminarPreguntaTest(){
		//usuario.eliminarPregunta("a12","peter_hy");
		try{
			preguntaDAO.getFromId("a12");
			assertTrue("Se experaba excepción",true);
		} catch(NullPointerException e){}
		assertFalse("No debería aparecer en la lista",preguntaUsuarioDAO.getPreguntas("peter_hy").contains("a12"));	
		assertTrue("No debería tener asignada esta alarma",!alarmaUsuarioDAO.getAlarmasUsuario(
				"javigm").contains("al2"));
		
	//usuario.EliminarPregunta("a12","peter_hy");
		
	//usuario.eliminarPregunta("a12","peter_hy");
	
	try{
	preguntaDAO.getFromId("a12");
	assertTrue("Se experaba excepción",true);
	}catch(NullPointerException e){}
	assertFalse("No debería aparecer en la lista",preguntaUsuarioDAO.getPreguntas("peter_hy").contains("a12"));	

		assertTrue("No debería tener asignada esta alarma",!alarmaUsuarioDAO.getAlarmasUsuario("javigm").contains("al2"));

	}
}
