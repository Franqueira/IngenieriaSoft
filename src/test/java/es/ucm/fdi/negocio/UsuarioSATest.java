package es.ucm.fdi.negocio;

import java.util.ArrayList;

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

public class UsuarioSATest {
	private UsuarioSA usuario;
	private BDHashMap<AlarmaPOJO> BDalarma;
	private BDHashMap<PreguntaPOJO> BDpregunta;
	private BDHashMap<UsuarioPOJO> BDusuario;
	private BDHashMap<PreguntaUsuarioPOJO> BDpreguntaUsuario;
	private BDHashMap<AlarmaUsuarioPOJO> BDalarmaUsuario;
	private BDHashMap<ClanPOJO> BDclan;
	private BDHashMap<UsuarioClanPOJO> BDusuarioClan;
	private UsuarioDAOImp usuarioDAO = new UsuarioDAOImp(BDusuario);
	private AlarmaDAOImp alarmaDAO = new AlarmaDAOImp(BDalarma);
	private AlarmaUsuarioDAOImp alarmaUsuarioDAO = new AlarmaUsuarioDAOImp(BDalarmaUsuario);
	private PreguntaDAOImp preguntaDAO = new PreguntaDAOImp(BDpregunta);
	private PreguntaUsuarioDAOImp preguntaUsuarioDAO= new PreguntaUsuarioDAOImp(BDpreguntaUsuario);
	private UsuarioClanDAOImp usuarioClanDAO = new UsuarioClanDAOImp(BDusuarioClan);
	private ClanDAOImp clanDAO = new ClanDAOImp (BDclan);
	public UsuarioSATest(){
		this.BDalarma = new BDHashMap<AlarmaPOJO>();
		
		//this.BDpregunta = new BD<>();
		//this.BDusuario = new BD<>();
		
		setup();
	}

	private void setup(){
		
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
		usuarioDAO.save(new UsuarioPOJO("jaime123", "Jaime Fernandez", 109, "soyjaime", "Spain"));
		
		
		//Cracion de alarmas
		alarmaDAO.save(new AlarmaPOJO("al1", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al2", 5, 0, false, "whatsapp_audio3.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al3", 16, 47, true, "song1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al4", 0, 0, false, "song2.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al5", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al6", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al7", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al8", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al9", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al10", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al11", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al13", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al14", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al15", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al16", 12, 23, true, "mytone1.mp3"));
		
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
		testperclanSA.CrearClan("javigm", "Los Matinfos");
		testperclanSA.AnadirUsuarioClan("borisc", "Los Matinfos");
		testperclanSA.AnadirUsuarioClan("jc", "Los Matinfos");
		testperclanSA.AnadirUsuarioClan("franqui", "Los Matinfos");
		
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
		respuestas10.add("el cairo");
		respuestas10.add("copenague");
		respuestas10.add("estocolmo");
		respuestas10.add("helsinki");
		preguntaDAO.save(new PreguntaPOJO("a", "cual es la capital de dinamarca?", respuestas10, 1));
		ArrayList<String> respuestas11=new ArrayList<String>();
		respuestas11.add("el cairo");
		respuestas11.add("copenague");
		respuestas11.add("estocolmo");
		respuestas11.add("helsinki");
		preguntaDAO.save(new PreguntaPOJO("a", "cual es la capital de suecia?", respuestas11, 1));
		ArrayList<String> respuestas12=new ArrayList<String>();
		respuestas12.add("el cairo");
		respuestas12.add("copenague");
		respuestas12.add("estocolmo");
		respuestas12.add("helsinki");
		preguntaDAO.save(new PreguntaPOJO("a", "cual es la capital de finlandia?", respuestas12, 1));
	
		//inicializar los demas para luego hacer el test
		usuario=new UsuarioSAImp(usuarioDAO,usuarioClanDAO,alarmaUsuarioDAO,clanDAO,alarmaDAO,preguntaDAO,preguntaUsuarioDAO);
	}
	
	
}
