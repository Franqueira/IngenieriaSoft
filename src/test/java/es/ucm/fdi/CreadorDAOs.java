package es.ucm.fdi;

import java.util.ArrayList;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.AlarmaDAOImp;
import es.ucm.fdi.integracion.DAOs.AlarmaUsuarioDAOImp;
import es.ucm.fdi.integracion.DAOs.ClanDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaClanDAO;
import es.ucm.fdi.integracion.DAOs.PreguntaClanDAOImp;
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
import es.ucm.fdi.integracion.POJOs.PreguntaClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;
import es.ucm.fdi.negocio.TestperclanSAImp;

/*
 * Ahora mismo no es utilizado por la aplicación, pero cabe la posibilidad de que en
 * un futuro quiera usarse.
 */
public class CreadorDAOs {
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

	public UsuarioDAOImp getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAOImp usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public AlarmaDAOImp getAlarmaDAO() {
		return alarmaDAO;
	}

	public void setAlarmaDAO(AlarmaDAOImp alarmaDAO) {
		this.alarmaDAO = alarmaDAO;
	}

	public AlarmaUsuarioDAOImp getAlarmaUsuarioDAO() {
		return alarmaUsuarioDAO;
	}

	public void setAlarmaUsuarioDAO(AlarmaUsuarioDAOImp alarmaUsuarioDAO) {
		this.alarmaUsuarioDAO = alarmaUsuarioDAO;
	}

	public PreguntaDAOImp getPreguntaDAO() {
		return preguntaDAO;
	}

	public void setPreguntaDAO(PreguntaDAOImp preguntaDAO) {
		this.preguntaDAO = preguntaDAO;
	}

	public PreguntaUsuarioDAOImp getPreguntaUsuarioDAO() {
		return preguntaUsuarioDAO;
	}

	public void setPreguntaUsuarioDAO(PreguntaUsuarioDAOImp preguntaUsuarioDAO) {
		this.preguntaUsuarioDAO = preguntaUsuarioDAO;
	}

	public UsuarioClanDAOImp getUsuarioClanDAO() {
		return usuarioClanDAO;
	}

	public void setUsuarioClanDAO(UsuarioClanDAOImp usuarioClanDAO) {
		this.usuarioClanDAO = usuarioClanDAO;
	}

	public ClanDAOImp getClanDAO() {
		return clanDAO;
	}

	public void setClanDAO(ClanDAOImp clanDAO) {
		this.clanDAO = clanDAO;
	}

	public CreadorDAOs() {
		// Creacion de usuarios
		usuarioDAO.save(new UsuarioPOJO("javigm", "Javier Guzman", 1001,
				"hola123", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("peter_hy", "Peter Stones", 147,
				"hello321", "England"));
		usuarioDAO.save(new UsuarioPOJO("xu_xu", "Xu Xin Chao", 2099,
				"yoselchinito", "China"));
		usuarioDAO.save(new UsuarioPOJO("Wiledk7", "Wilson Eduardo Lopez",
				1365, "holamamasita", "Colombia"));
		usuarioDAO.save(new UsuarioPOJO("borisc", "Boris Carballa", 1244,
				"soyboris", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("franqui", "Miguel Franqueira", 1111,
				"soyFranqui", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("sergil", "Sergio Gil", 823,
				"soysergi", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("daniv", "Dani Valverde", 730,
				"soydani", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("pablitos", "Pablo Sanz", 545,
				"soypablo", "Spain"));
		usuarioDAO.save(new UsuarioPOJO("jc", "JC Villanueva", 108, "soyjc",
				"Spain"));

		// Creacion de alarmas
		alarmaDAO.save(new AlarmaPOJO("al1", 12, 23, true, "mytone1.mp3"));
		alarmaDAO
				.save(new AlarmaPOJO("al2", 5, 0, true, "whatsapp_audio3.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al3", 16, 47, true, "song1.mp3"));
		alarmaDAO.save(new AlarmaPOJO("al4", 0, 0, false, "song2.mp3"));
		for (int i = 5; i < 17; i++) {
			alarmaDAO
					.save(new AlarmaPOJO("al" + i, 12, 23, true, "mytone1.mp3"));
		}

		// Asignacion de usuarios y alarmas
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

		// Creacion de clanes
		TestperclanSAImp testperclanSA = new TestperclanSAImp(clanDAO,
				usuarioClanDAO, usuarioDAO, preguntaClanDAO);
		testperclanSA.crearClan("javigm", "Los Matinfos");
		testperclanSA.anadirUsuarioClan("borisc", "Los Matinfos");
		testperclanSA.anadirUsuarioClan("jc", "Los Matinfos");
		testperclanSA.anadirUsuarioClan("franqui", "Los Matinfos");

		ArrayList<String> respuestas1 = new ArrayList<String>();
		respuestas1.add("Madrid");
		respuestas1.add("Paris");
		respuestas1.add("Roma");
		respuestas1.add("Londres");
		preguntaDAO.save(new PreguntaPOJO("a1",
				"cual es la capital de españa?", "geografía", respuestas1, 1));
		preguntaDAO.save(new PreguntaPOJO("a2",
				"cual es la capital de francia?", "geografía", respuestas1, 2));
		preguntaDAO.save(new PreguntaPOJO("a3",
				"cual es la capital de italia?", "geografía", respuestas1, 3));
		preguntaDAO.save(new PreguntaPOJO("a4",
				"cual es la capital de reino unido?", "geografía", respuestas1,
				4));

		ArrayList<String> respuestas2 = new ArrayList<String>();
		respuestas2.add("Wahington");
		respuestas2.add("Moscu");
		respuestas2.add("Praga");
		respuestas2.add("Berlin");
		preguntaDAO.save(new PreguntaPOJO("a5", "cual es la capital de eeuu?",
				"geografía", respuestas2, 1));
		preguntaDAO.save(new PreguntaPOJO("a6", "cual es la capital de rusia?",
				"geografía", respuestas2, 2));
		preguntaDAO.save(new PreguntaPOJO("a7",
				"cual es la capital de checoslovaquia?", "geografía",
				respuestas2, 3));
		preguntaDAO
				.save(new PreguntaPOJO("a8", "cual es la capital de alemania?",
						"geografía", respuestas2, 4));

		ArrayList<String> respuestas3 = new ArrayList<String>();
		respuestas3.add("el cairo");
		respuestas3.add("copenague");
		respuestas3.add("estocolmo");
		respuestas3.add("helsinki");
		preguntaDAO.save(new PreguntaPOJO("a9",
				"cual es la capital de egipto?", "geografía", respuestas3, 1));
		preguntaDAO
				.save(new PreguntaPOJO("a10",
						"cual es la capital de dinamarca?", "geografía",
						respuestas3, 2));
		preguntaDAO.save(new PreguntaPOJO("a11",
				"cual es la capital de suecia?", "geografía", respuestas3, 3));
		preguntaDAO
				.save(new PreguntaPOJO("a12",
						"cual es la capital de finlandia?", "geografía",
						respuestas3, 4));

		for (int i = 1; i < 13; i++) {
			preguntaUsuarioDAO
					.save(new PreguntaUsuarioPOJO("a" + i, "peter_hy"));
		}
	}

}
