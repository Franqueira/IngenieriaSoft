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
		alarmaSA =new AlarmaSAImp(alarmaDAO,alarmaUsuarioDAO);
	}

	/**
	 * 
	 * @param a
	 *            Si es true devuelve las del usuario, si no las de todo su clan
	 * @return lista con las preguntas
	 */
	public ArrayList<PreguntaPOJO> getPreguntas(boolean a, String idUsuario) {
		ArrayList<PreguntaPOJO> preguntas = new ArrayList<>();
		if (a) {
			for (String pregunta : usuarioSA.preguntasUsuario(idUsuario)) {
				preguntas.add((PreguntaPOJO) preguntaDAO.getFromId(pregunta));
			}
		} else {
			for (String pregunta : testperclanSA
					.preguntasClan(((UsuarioPOJO) usuarioDAO
							.getFromId(idUsuario)).getIdClan())) {
				preguntas.add((PreguntaPOJO) preguntaDAO.getFromId(pregunta));
			}
		}
		return preguntas;
	}

	/*
	 * Este método debería elegir eficientemente la próxima pregunta. Queda
	 * pendiente ir llevando una lista con las preguntas ya respondidas y en que
	 * orden
	 */
	public PreguntaPOJO elegirPregunta(ArrayList<PreguntaPOJO> preguntas) {
		Random r = new Random();
		// devuelve una pregunta aleatoria de la lista
		int pregunta = r.nextInt(preguntas.size());
		return preguntas.get(pregunta);
	}

	@Test
	public void testpertarPreguntasPropias() {
		UsuarioPOJO user = (UsuarioPOJO) usuarioDAO.getFromId("peter_hy");
		/*
		 * La aplicación comprueba que es la hora de una alarma posible y se
		 * abre
		 */
		/*
		 * El móvil se comunica con la base de datos para acceder a la
		 * información de la alarma que no tiene localmente. Suponemos que la
		 * alarma a debería estar en la lista de alarmas del usuario.
		 */
		AlarmaPOJO a = (AlarmaPOJO) alarmaDAO.getFromId("al2");
		Assert.assertTrue("La alarma al2 debería existir", a != null);
		Assert.assertTrue("La alarma al2 debería estar activa", a.isActive());
		/**
		 * La alarma empieza a sonar, se le da la opción al usuario de posponer la alarma.
		 * Si pulsa en el botón que aparece se llama al método:
		 * alarmaSA.posponerAlarma(a.getId());
		 */
		
		// este booleano indica que quiere sus preguntas propias.
		boolean clanoUsuario = true;
		ArrayList<PreguntaPOJO> preguntas = getPreguntas(clanoUsuario,
				user.getId());
		boolean respuestaIncorrecta = true;
		int n=0;
		while (respuestaIncorrecta) {
			PreguntaPOJO pregunta = elegirPregunta(preguntas); // elige la
																// pregunta que
																// va a aparecer
																// en pantalla.
			/*
			 * muestraPregunta(pregunta);
			 * Se le muestra la pregunta al usuario y esperas la respuesta. Si
			 * acierta se pone respuestaIncorrecta a false. Si no se vuelve a
			 * repetir el proceso hasta que llegase a 3 veces que se le
			 * mostraría el botón del pánico.
			 */
			
			//suponemos que marca la primera opción
			usuarioSA.informarRespuesta(user.getId(),pregunta.getId(),0);
			//if(n>=3) mostrarBotonPanico();
			++n;
			//supongamos que ya acerto:
			respuestaIncorrecta=false;
		}
		//una vez responde correctamente se apaga la alarma.
		//el sistema ya tendría actualizada la puntuación del usuario.
		
	}
}
