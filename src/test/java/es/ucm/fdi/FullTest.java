package es.ucm.fdi;

import java.util.ArrayList;

import junit.framework.Assert;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.AlarmaDAOImp;
import es.ucm.fdi.integracion.DAOs.AlarmaUsuarioDAOImp;
import es.ucm.fdi.integracion.DAOs.ClanDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.integracion.POJOs.AlarmaUsuarioPOJO;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;
import es.ucm.fdi.negocio.AlarmaSAImp;

import es.ucm.fdi.negocio.TestperclanSAImp;

public class FullTest {

	private BDHashMap<AlarmaPOJO> BDalarma;
	private BDHashMap<PreguntaPOJO> BDpregunta;
	private BDHashMap<UsuarioPOJO> BDusuario;
	private BDHashMap<AlarmaUsuarioPOJO> BDalarmaUsuario;
	private BDHashMap<ClanPOJO> BDclan;
	private BDHashMap<UsuarioClanPOJO> BDusuarioClan;
	
	public FullTest(){
		this.BDalarma = new BDHashMap<AlarmaPOJO>();
		//this.BDpregunta = new BD<>();
		//this.BDusuario = new BD<>();
		
		setup();
	}

	private void setup(){
		UsuarioDAOImp usuarioDAO = new UsuarioDAOImp(BDusuario);
		AlarmaDAOImp alarmaDAO = new AlarmaDAOImp(BDalarma);
		AlarmaUsuarioDAOImp alarmaUsuarioDAO = new AlarmaUsuarioDAOImp(BDalarmaUsuario);
		PreguntaDAOImp preguntaDAO = new PreguntaDAOImp(BDpregunta);
		UsuarioClanDAOImp usuarioClanDAO = new UsuarioClanDAOImp(BDusuarioClan);
		ClanDAOImp clanDAO = new ClanDAOImp (BDclan);
		
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
		
		
	
		//inicializar los demas para luego hacer el test
		
	}
	
	//@Test
	public void Testpertar(){
		AlarmaDAOImp alarmaDAO = new AlarmaDAOImp(BDalarma);
		AlarmaSAImp alarmaSA = new AlarmaSAImp(alarmaDAO);
		
		AlarmaPOJO a = (AlarmaPOJO) alarmaDAO.getFromId("al1");
		Assert.assertTrue("La alarma al1 debería existir", a!=null); //No se por que no va
		alarmaSA.reproducirAlarma(a);
	}

}
