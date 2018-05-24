package es.ucm.fdi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.AlarmaDAO;
import es.ucm.fdi.integracion.DAOs.AlarmaDAOImp;
import es.ucm.fdi.integracion.DAOs.AlarmaUsuarioDAO;
import es.ucm.fdi.integracion.DAOs.AlarmaUsuarioDAOImp;
import es.ucm.fdi.integracion.DAOs.ClanDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaClanDAO;
import es.ucm.fdi.integracion.DAOs.PreguntaClanDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaDAO;
import es.ucm.fdi.integracion.DAOs.PreguntaDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaUsuarioDAO;
import es.ucm.fdi.integracion.DAOs.PreguntaUsuarioDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.integracion.POJOs.AlarmaUsuarioPOJO;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaClanPOJO;
import es.ucm.fdi.negocio.AlarmaSA;
import es.ucm.fdi.negocio.AlarmaSAImp;
import es.ucm.fdi.negocio.PreguntaSA;
import es.ucm.fdi.negocio.PreguntaSAImp;
import es.ucm.fdi.negocio.TestperclanSA;
import es.ucm.fdi.negocio.TestperclanSAImp;
import es.ucm.fdi.negocio.UsuarioSA;
import es.ucm.fdi.negocio.UsuarioSAImp;

/**
 * 
 * Clase encargada de probar la funcionalidad de la aplicación, probando las
 * acciones a realizar para los distrintos casos de uso.
 *
 */
public class FullTest {

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
	private PreguntaClanDAO preguntaClanDAO = new PreguntaClanDAOImp(
			new BDHashMap<PreguntaClanPOJO>());
	private TestperclanSA testperclanSA;
	private UsuarioSA usuarioSA;
	private AlarmaSA alarmaSA;

	@Before
	public void setup() {
		new InicializaUsuarioDAOImp1().inicializa(usuarioDAO);
		new InicializaAlarmaDAOImp1().inicializa(alarmaDAO);
		new InicializaAlarmaUsuarioDAOImp1().inicializa(alarmaUsuarioDAO);
		new InicializaPreguntaDAOImp1().inicializa(preguntaDAO);
		new InicializaPreguntaUsuarioDAOImp1().inicializa(preguntaUsuarioDAO);
		new InicializaUsuarioClanDAOImp1().inicializa(usuarioClanDAO);
		new InicializaClanDAOImp1().inicializa(clanDAO);
		new InicializaPreguntaClanDAOImp1().inicializa(preguntaClanDAO);
		testperclanSA = new TestperclanSAImp(clanDAO, usuarioClanDAO,
				usuarioDAO, preguntaClanDAO);
		usuarioSA = new UsuarioSAImp(usuarioDAO, usuarioClanDAO,
				alarmaUsuarioDAO, clanDAO, alarmaDAO, preguntaDAO,
				preguntaUsuarioDAO);
		alarmaSA = new AlarmaSAImp(alarmaDAO, alarmaUsuarioDAO);
	}

	
}
