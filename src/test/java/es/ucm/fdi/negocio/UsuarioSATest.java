package es.ucm.fdi.negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

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
		usuarioDAO = new UsuarioDAOImp(new BDHashMap<UsuarioPOJO>());
		alarmaDAO = new AlarmaDAOImp(new BDHashMap<AlarmaPOJO>());
		alarmaUsuarioDAO = new AlarmaUsuarioDAOImp(new BDHashMap<AlarmaUsuarioPOJO>());
		preguntaDAO = new PreguntaDAOImp(new BDHashMap<PreguntaPOJO>());
		preguntaUsuarioDAO= new PreguntaUsuarioDAOImp(new BDHashMap<PreguntaUsuarioPOJO>());
		usuarioClanDAO = new UsuarioClanDAOImp(new BDHashMap<UsuarioClanPOJO>());
		clanDAO = new ClanDAOImp (new BDHashMap<ClanPOJO>());
		
		
		//Creacion de usuarios
		usuarioDAO.save(new UsuarioPOJO("javigm", "Javier Guzman", 1001, "hola123", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("peter_hy", "Peter Stones", 147, "hello321", "England"));
		usuarioDAO.save(new UsuarioPOJO("xu_xu", "Xu Xin Chao", 2099, "yoselchinito", "China"));
		usuarioDAO.save(new UsuarioPOJO("Wiledk7", "Wilson Eduardo Lopez", 1365, "holamamasita", "Colombia"));
		usuarioDAO.save(new UsuarioPOJO("borisc", "Boris Carballa", 1244, "soyboris", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("franqui", "Miguel Franqueira", 1111, "soyFranqui", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("sergil", "Sergio Gil", 823, "soysergi", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("daniv", "Dani Valverde", 730, "soydani", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("pablitos", "Pablo Sanz", 545, "soypablo", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("jc", "JC Villanueva", 108, "soyjc", "Spain"));
		
		
		//Creacion de alarmas
		alarmaDAO.save(new AlarmaPOJO("al1", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al2", 5, 0, false, "whatsapp_audio3.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al3", 16, 47, true, "song1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al4", 0, 0, false, "song2.mp3"));
		for(int i = 5; i<17;i++){
			alarmaDAO.save(new AlarmaPOJO("al"+i, 12, 23, true, "mytone1.mp3"));
		}
		
		//Asignacion de usuarios y alarmas
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al1", "javigm"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al2", "peter_hy"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al3", "xu_xu"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al4", "Wiledk7"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al5", "borisc"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al6", "franqui"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al7", "sergil"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al8", "daniv"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al9", "pablitos"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al10", "jc"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al11", "jaime123"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al12", "borisc"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al13", "javigm"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al14", "javigm"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al15", "jc"));
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al16", "franqui"));
		
		//Creacion de clanes
		TestperclanSAImp testperclanSA = new TestperclanSAImp(clanDAO, usuarioClanDAO,usuarioDAO);
		testperclanSA.crearClan("javigm", "Los Matinfos");
		testperclanSA.anadirUsuarioClan("borisc", "Los Matinfos");
		testperclanSA.anadirUsuarioClan("jc", "Los Matinfos");
		testperclanSA.anadirUsuarioClan("franqui", "Los Matinfos");
		
		ArrayList<String> respuestas1=new ArrayList<String>();
		respuestas1.add("Madrid");
		respuestas1.add("Paris");
		respuestas1.add("Roma");
		respuestas1.add("Londres");
		preguntaDAO.save(new PreguntaPOJO("a1", "cual es la capital de españa?", "geografía", respuestas1, 1));
		preguntaDAO.save(new PreguntaPOJO("a2", "cual es la capital de francia?", "geografía", respuestas1, 2));
		preguntaDAO.save(new PreguntaPOJO("a3", "cual es la capital de italia?", "geografía", respuestas1, 3));
		preguntaDAO.save(new PreguntaPOJO("a4", "cual es la capital de reino unido?", "geografía", respuestas1, 4));
		
		ArrayList<String> respuestas2=new ArrayList<String>();
		respuestas2.add("Wahington");
		respuestas2.add("Moscu");
		respuestas2.add("Praga");
		respuestas2.add("Berlin");
		preguntaDAO.save(new PreguntaPOJO("a5", "cual es la capital de eeuu?", "geografía", respuestas2, 1));
		preguntaDAO.save(new PreguntaPOJO("a6", "cual es la capital de rusia?", "geografía", respuestas2, 2));
		preguntaDAO.save(new PreguntaPOJO("a7", "cual es la capital de checoslovaquia?", "geografía", respuestas2, 3));
		preguntaDAO.save(new PreguntaPOJO("a8", "cual es la capital de alemania?", "geografía", respuestas2, 4));
		
		ArrayList<String> respuestas3=new ArrayList<String>();
		respuestas3.add("el cairo");
		respuestas3.add("copenague");
		respuestas3.add("estocolmo");
		respuestas3.add("helsinki");
		preguntaDAO.save(new PreguntaPOJO("a9", "cual es la capital de egipto?", "geografía", respuestas3, 1));
		preguntaDAO.save(new PreguntaPOJO("a10", "cual es la capital de dinamarca?", "geografía", respuestas3, 2));
		preguntaDAO.save(new PreguntaPOJO("a11", "cual es la capital de suecia?", "geografía", respuestas3, 3));
		preguntaDAO.save(new PreguntaPOJO("a12", "cual es la capital de finlandia?", "geografía", respuestas3, 4));	
		for(int i = 1; i<13; i++){
			preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO("a"+i,"peter_hy"));
		}
		//inicializar los demas para luego hacer el test
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
		usuario.AnadirPregunta(new PreguntaPOJO(
				"a1", "cual es la capital de españa?", "geografía", respuestas1, 1), "javigm");
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

		usuario.ElminarPregunta("a12","peter_hy");
		try{
			preguntaDAO.getFromId("a12");
			assertTrue("Se experaba excepción",true);
		} catch(NullPointerException e){}
		assertFalse("No debería aparecer en la lista",preguntaUsuarioDAO.getPreguntas("peter_hy").contains("a12"));	
		assertTrue("No debería tener asignada esta alarma",!alarmaUsuarioDAO.getAlarmasUsuario(
				"javigm").contains("al2"));

	usuario.EliminarPregunta("a12","peter_hy");
	try{
	preguntaDAO.getFromId("a12");
	assertTrue("Se experaba excepción",true);
	}catch(NullPointerException e){}
	assertFalse("No debería aparecer en la lista",preguntaUsuarioDAO.getPreguntas("peter_hy").contains("a12"));	

		assertTrue("No debería tener asignada esta alarma",!alarmaUsuarioDAO.getAlarmasUsuario("javigm").contains("al2"));

	}
}
