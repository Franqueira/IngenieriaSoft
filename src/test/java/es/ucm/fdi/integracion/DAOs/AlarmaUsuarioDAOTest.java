package es.ucm.fdi.integracion.DAOs;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.integracion.POJOs.AlarmaUsuarioPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

public class AlarmaUsuarioDAOTest {
	public void setup(AlarmaUsuarioDAOImp alarmaUsuarioDAO, UsuarioDAOImp usuarioDAO, AlarmaDAOImp alarmaDAO){
		
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
				alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al7", "borisc"));
				alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al8", "daniv"));
				alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al9", "borisc"));
				alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al10", "jc"));
				alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al11", "jaime123"));
				alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al12", "borisc"));
				alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al13", "javigm"));
				alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al14", "javigm"));
				alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al15", "jc"));
				alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO("al16", "franqui"));
	}
	
	@Test
	public void getAlarmasUsuarioTest(){
		AlarmaDAOImp alarmaDAO = new AlarmaDAOImp(new BDHashMap<AlarmaPOJO>());
		UsuarioDAOImp usuarioDAO = new UsuarioDAOImp(new BDHashMap<UsuarioPOJO>());
		AlarmaUsuarioDAOImp alarmaUsuarioDAO = new AlarmaUsuarioDAOImp(new BDHashMap<AlarmaUsuarioPOJO>());
		setup(alarmaUsuarioDAO, usuarioDAO, alarmaDAO);
		ArrayList<String> listaJavi = alarmaUsuarioDAO.getAlarmasUsuario("javigm");
		ArrayList<String> esperadasJavi = new ArrayList<>();
		esperadasJavi.add("al1");
		esperadasJavi.add("al13");
		esperadasJavi.add("al14");
		for(String e: esperadasJavi){ //Las de esperadas estan en listaJavi
			assertTrue(listaJavi.contains(e));
		}
		for(String e: listaJavi){
			assertTrue(esperadasJavi.contains(e)); //Las de listaJavi estan esperadas
		}
		ArrayList<String> listaBoris = alarmaUsuarioDAO.getAlarmasUsuario("borisc");
		ArrayList<String> esperadasBoris = new ArrayList<>();
		esperadasBoris.add("al5");
		esperadasBoris.add("al7");
		esperadasBoris.add("al9");
		esperadasBoris.add("al12");
		for(String e: esperadasBoris){ //Las de esperadas estan en listaBoris
			assertTrue(listaBoris.contains(e));
		}
		for(String e: listaBoris){
			assertTrue(esperadasBoris.contains(e)); //Las de listaBoris estan esperadas
		}
	}
	
	
};
