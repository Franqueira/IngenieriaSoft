package es.ucm.fdi;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.AlarmaDAOImp;
import es.ucm.fdi.integracion.DAOs.AlarmaUsuarioDAOImp;
import es.ucm.fdi.integracion.DAOs.ClanDAOImp;
import es.ucm.fdi.integracion.DAOs.FactoriaDAOs;
import es.ucm.fdi.integracion.DAOs.PreguntaClanDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaUsuarioDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.integracion.POJOs.AlarmaUsuarioPOJO;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaClanPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;
import es.ucm.fdi.negocio.AlarmaSA;
import es.ucm.fdi.negocio.AlarmaSAImp;
import es.ucm.fdi.negocio.FachadaUsuario;
import es.ucm.fdi.negocio.FachadaUsuarioImp;
import es.ucm.fdi.negocio.TestperclanSA;
import es.ucm.fdi.negocio.TestperclanSAImp;
import es.ucm.fdi.negocio.UsuarioSA;
import es.ucm.fdi.negocio.UsuarioSAImp;

/**
 * Clase encargada de probar el caso de uso testpertar, realizando la secuencia
 * de acciones necesarias.
 */

@SuppressWarnings("unchecked")
public class FullTest {

	@SuppressWarnings("rawtypes")
	FactoriaDAOs factoria = new FactoriaDAOs();
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
	private PreguntaClanDAOImp preguntaClanDAO = (PreguntaClanDAOImp) factoria
			.creaDAO(3, new BDHashMap<PreguntaClanPOJO>());
	private TestperclanSA testperclanSA;
	private UsuarioSA usuarioSA;
	private AlarmaSA alarmaSA;
	private FachadaUsuario fachadaUsuario;

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
		fachadaUsuario = new FachadaUsuarioImp(alarmaSA, null, testperclanSA,
				usuarioSA);
	}

	/**
	 * Si el booleano es true devuelve las preguntas del usuario, si no las de todo su clan
	 * 
	 * @param a 	booleano que indica la opción
	 * 
	 * @return lista con las preguntas
	 */
	public ArrayList<PreguntaPOJO> getPreguntas(boolean a, String idUsuario) {
		ArrayList<PreguntaPOJO> preguntas = new ArrayList<>();
		if (a) {
			for (String pregunta : fachadaUsuario.preguntasUsuario(idUsuario)) {
				preguntas.add((PreguntaPOJO) preguntaDAO.getFromId(pregunta));
			}
		} else {
			for (String pregunta : fachadaUsuario
					.preguntasClan(((UsuarioPOJO) usuarioDAO
							.getFromId(idUsuario)).getIdClan())) {
				preguntas.add((PreguntaPOJO) preguntaDAO.getFromId(pregunta));
			}
		}
		return preguntas;
	}

	/**
	 * Elige la siguiente pregunta
	 */
	public PreguntaPOJO elegirPregunta(ArrayList<PreguntaPOJO> preguntas) {
		PreguntaPOJO pregunta = preguntas.get(0);
		preguntas.remove(0);
		preguntas.add(preguntas.size(), pregunta);
		return pregunta;
	}

	/*
	 * El test para preguntas del clan sería exactamente pero con
	 * clanoUsuario=false;
	 */
	/**
	 * Aquí reproducimos la secuencia de acciones del caso de uso Testpertar
	 * 
	 * @see InicializaUsuarioDAOImp1, InicializaAlarmaDAOImp1
	 */
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
		/*
		 * La alarma empieza a sonar, se le da la opción al usuario de posponer
		 * la alarma. Si pulsa en el botón que aparece se llama al método:
		 * alarmaSA.posponerAlarma(a.getId()); o
		 * fachadaUsuarioSAs.posponerAlarma(a.getId());
		 */

		// este booleano indica que quiere sus preguntas propias.
		boolean clanoUsuario = true;
		ArrayList<PreguntaPOJO> preguntas = getPreguntas(clanoUsuario,
				user.getId());
		// se le muestra una pregunta al usuario
		PreguntaPOJO pregunta = elegirPregunta(preguntas);
		/*
		 * Responde incorrectamente, su puntuacion baja 10 puntos y se le vuelve
		 * a mostra otra pregunta
		 */
		fachadaUsuario.informarRespuesta(user.getId(), pregunta.getId(), 2);
		user = (UsuarioPOJO) usuarioDAO.getFromId("peter_hy");
		assertEquals("Deberia haberle restado 10 puntos", user.getPuntuacion(),
				137);
		pregunta = elegirPregunta(preguntas);
		fachadaUsuario.informarRespuesta(user.getId(), pregunta.getId(), 1);
		user = (UsuarioPOJO) usuarioDAO.getFromId("peter_hy");
		assertEquals("Deberia haberle restado 10 puntos", user.getPuntuacion(),
				127);
		/*
		 * Otra vez vuelve a responder incorrectamente, se repite la secuencia
		 */
		pregunta = elegirPregunta(preguntas);
		fachadaUsuario.informarRespuesta(user.getId(), pregunta.getId(), 1);
		user = (UsuarioPOJO) usuarioDAO.getFromId("peter_hy");
		assertEquals("Deberia haberle restado 10 puntos", user.getPuntuacion(),
				117);

		/*
		 * Como ya lleva tres falladas se muestra el boton del panico que
		 * permite apagar la alarma pese a no haber acertado ninguna pregunta
		 */

		// mostrarBotonPanico();

		/*
		 * El usuario decide no usar aun el boton y aparece otra pregunta
		 */

		/*
		 * El usuario la responde correctamente y su puntuacion se incrementa en
		 * 10 puntos
		 */

		pregunta = elegirPregunta(preguntas);
		fachadaUsuario.informarRespuesta(user.getId(), pregunta.getId(), 1);
		user = (UsuarioPOJO) usuarioDAO.getFromId("peter_hy");
		assertEquals("Deberia haberle sumado 10 puntos", user.getPuntuacion(),
				127);

		/*
		 * Como ya ha acertado una pregunta, la alarma se apaga
		 */

		// apagarAlarma();

	}

}
