package es.ucm.fdi;

import java.util.ArrayList;

import junit.framework.Assert;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.AlarmaDAOImp;
import es.ucm.fdi.integracion.DAOs.AlarmaUsuarioDAOImp;
import es.ucm.fdi.integracion.DAOs.ClanDAO;
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
import es.ucm.fdi.negocio.TestperclanSA;
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
		
		//Creacion de usuarios
		usuarioDAO.guardaUsuario(new UsuarioPOJO("javigm", "Javier Guzman", 1001, "hola123", "Spain"));
		usuarioDAO.guardaUsuario(new UsuarioPOJO("peter_hy", "Peter Stones", 147, "hello321", "England"));
		usuarioDAO.guardaUsuario(new UsuarioPOJO("xu_xu", "Xu Xin Chao", 2099, "yoselchinito", "China"));
		usuarioDAO.guardaUsuario(new UsuarioPOJO("Wiledk7", "Wilson Eduardo Lopez", 1365, "holamamasita", "Colombia"));
		
		//Cracion de alarmas
		alarmaDAO.saveAlarm(new AlarmaPOJO("al1", 12, 23, true, "mytone1.mp3"));
		alarmaDAO.saveAlarm(new AlarmaPOJO("al2", 5, 0, false, "whatsapp_audio3.mp3"));
		alarmaDAO.saveAlarm(new AlarmaPOJO("al3", 16, 47, true, "song1.mp3"));
		alarmaDAO.saveAlarm(new AlarmaPOJO("al4", 0, 0, false, "song2.mp3"));
		
		//Asignacion de usuarios y alarmas
		alarmaUsuarioDAO.addAlarmaUsuario(new AlarmaUsuarioPOJO("al1", "javigm"));
		alarmaUsuarioDAO.addAlarmaUsuario(new AlarmaUsuarioPOJO("al2", "peter_hy"));
		alarmaUsuarioDAO.addAlarmaUsuario(new AlarmaUsuarioPOJO("al3", "xu_xu"));
		alarmaUsuarioDAO.addAlarmaUsuario(new AlarmaUsuarioPOJO("al4", "Wiledk7"));
		
		//Creacion de clanes
		
		//TestperclanSA testperclanSA = new TestperclanSAImp(clanDAO, usuarioClanDAO, usuarios);
		
		
		
		
		
		
		//inicializar los demas para luego hacer el test
		
	}
	
	//@Test
	public void Testpertar(){
		AlarmaDAOImp alarmaDAO = new AlarmaDAOImp(BDalarma);
		AlarmaSAImp alarmaSA = new AlarmaSAImp(alarmaDAO);
		
		AlarmaPOJO a = alarmaDAO.getAlarma("al1");
		Assert.assertTrue("La alarma al1 debería existir", a!=null); //No se por que no va
		alarmaSA.reproducirAlarma(a);
	}

}
