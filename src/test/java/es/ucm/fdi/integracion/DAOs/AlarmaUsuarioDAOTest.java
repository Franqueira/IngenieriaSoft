package es.ucm.fdi.integracion.DAOs;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.*;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.integracion.POJOs.AlarmaUsuarioPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

/**
 * Clase encargada de probar AlarmaUsuarioDAO
 */
@SuppressWarnings("unchecked")
public class AlarmaUsuarioDAOTest {
	@SuppressWarnings("rawtypes")
	FactoriaDAOs factoria = new FactoriaDAOs();
	private AlarmaDAOImp alarmaDAO = (AlarmaDAOImp) factoria.creaDAO(0,
			new BDHashMap<AlarmaPOJO>());
	private UsuarioDAOImp usuarioDAO = (UsuarioDAOImp) factoria.creaDAO(6,
			new BDHashMap<UsuarioPOJO>());
	private AlarmaUsuarioDAOImp alarmaUsuarioDAO = (AlarmaUsuarioDAOImp) factoria
			.creaDAO(1, new BDHashMap<AlarmaUsuarioPOJO>());

	@Before
	public void setup() {
		new InicializaAlarmaDAOImp1().inicializa(alarmaDAO);
		new InicializaUsuarioDAOImp1().inicializa(usuarioDAO);
		new InicializaAlarmaUsuarioDAOImp1().inicializa(alarmaUsuarioDAO);
	}

	/**
	 * @see InicializaAlarmaUsuarioDAOImp1
	 */
	@Test
	public void getAlarmasUsuarioTest() {
		ArrayList<String> listaJavi = alarmaUsuarioDAO
				.getAlarmasUsuario("javigm");
		ArrayList<String> esperadasJavi = new ArrayList<>();
		esperadasJavi.add("al1");
		esperadasJavi.add("al13");
		esperadasJavi.add("al14");
		for (String e : esperadasJavi) { // Las de esperadas estan en listaJavi
			assertTrue(listaJavi.contains(e));
		}
		for (String e : listaJavi) {
			assertTrue(esperadasJavi.contains(e)); // Las de listaJavi estan
													// esperadas
		}
		ArrayList<String> listaBoris = alarmaUsuarioDAO
				.getAlarmasUsuario("borisc");
		ArrayList<String> esperadasBoris = new ArrayList<>();
		esperadasBoris.add("al5");
		esperadasBoris.add("al12");
		for (String e : esperadasBoris) { // Las de esperadas estan en
											// listaBoris
			assertTrue(listaBoris.contains(e));
		}
		for (String e : listaBoris) {
			assertTrue(esperadasBoris.contains(e)); // Las de listaBoris estan
													// esperadas
		}
	}

};
