package es.ucm.fdi;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.AlarmaDAOImp;
import es.ucm.fdi.integracion.DAOs.AlarmaUsuarioDAOImp;
import es.ucm.fdi.integracion.DAOs.ClanDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaClanDAO;
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
import es.ucm.fdi.negocio.AlarmaSA;
import es.ucm.fdi.negocio.AlarmaSAImp;
import es.ucm.fdi.negocio.PreguntaSA;
import es.ucm.fdi.negocio.PreguntaSAImp;
import es.ucm.fdi.negocio.TestperclanSA;
import es.ucm.fdi.negocio.TestperclanSAImp;

public class FullTest {

	private UsuarioDAOImp usuarioDAO;
	private AlarmaDAOImp alarmaDAO;
	private AlarmaUsuarioDAOImp alarmaUsuarioDAO;
	private PreguntaDAOImp preguntaDAO;
	private PreguntaUsuarioDAOImp preguntaUsuarioDAO;
	private UsuarioClanDAOImp usuarioClanDAO;
	private ClanDAOImp clanDAO;
	private PreguntaClanDAO preguntaClanDAO;
	@Before
	private void setup(){
		new InicializaUsuarioDAOImp1().inicializa(usuarioDAO);
		new InicializaAlarmaDAOImp1().inicializa(alarmaDAO);
		new InicializaAlarmaUsuarioDAOImp1().inicializa(alarmaUsuarioDAO);
		new InicializaPreguntaDAOImp1().inicializa(preguntaDAO);
		new InicializaPreguntaUsuarioDAOImp1().inicializa(preguntaUsuarioDAO);
		new InicializaUsuarioClanDAOImp1().inicializa(usuarioClanDAO);
		new InicializaClanDAOImp1().inicializa(clanDAO);
		new InicializaPreguntaClanDAOImp1().inicializa(preguntaClanDAO);
	}
	
	@Test
	public void Testpertar(){
		UsuarioPOJO user = (UsuarioPOJO) usuarioDAO.getFromId("peter_hy");
		/*La aplicación comprueba que es la hora de una alarma posible y se abre*/
		/**El movil se comunica con la base de datos para acceder a la información de la alarma
		 * que no tiene localmente*/
		AlarmaPOJO a = (AlarmaPOJO) alarmaDAO.getFromId("al2");
		Assert.assertTrue("La alarma al2 debería existir", a!=null);
		Assert.assertTrue("La alarma al2 debería estar activa", a.isActive());

		/*AlarmaSA alarmaSA = new AlarmaSAImp(alarmaDAO);
		alarmaSA.reproducirAlarma(a);
		//Suena
		PreguntaPOJO pregunta = (PreguntaPOJO) preguntaDAO.getFromId(preguntaUsuarioDAO.getPreguntas("peter_hy").get(0));
		Assert.assertTrue("La pregunta debería existir", pregunta!=null);
		//Mostrar pregunta
		PreguntaSA preguntaSA = new PreguntaSAImp(preguntaDAO, preguntaUsuarioDAO);
		assertTrue("Debería ser correcta",preguntaSA.comprobarRespuesta("a2",2));
		alarmaSA.desconectarAlarma(a);*/
		
		TestperclanSA testperclanSA = new TestperclanSAImp(clanDAO, usuarioClanDAO, usuarioDAO, preguntaClanDAO);
		testperclanSA.getRanking(user.getIdClan());
		//Mostrar ranking
	}
	
	@Test
	public void TestGanador(){
		TestperclanSAImp tesperclan=new TestperclanSAImp(clanDAO,usuarioClanDAO,usuarioDAO,preguntaClanDAO);
		ArrayList<UsuarioPOJO> usuarios=tesperclan.getRanking("Los Matinfos");
		assertTrue("Debería ir en este orden",usuarios.get(0).getId().equals("borisc"));
		assertTrue("Debería ir en este orden",usuarios.get(1).getId().equals("franqui"));
		assertTrue("Debería ir en este orden",usuarios.get(2).getId().equals("javigm"));
		tesperclan.setGanador("Los Matinfos");
		assertTrue("Boris debería ser el ganador",((UsuarioPOJO)usuarioDAO.getFromId("borisc")).isEsGanador());
		
	}
}
