package es.ucm.fdi.integracion.DAOs;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.InicializaUsuarioClanDAOImp1;
import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;
import junit.framework.TestCase;

public class UsuarioClanDAOTest {
	private UsuarioClanDAOImp usuarioClanDAO = new UsuarioClanDAOImp(
			new BDHashMap<UsuarioClanPOJO>());

	@Before
	public void setup() {
		new InicializaUsuarioClanDAOImp1().inicializa(usuarioClanDAO);
	}
	/**
	 * @see IniciaizaUsuarioClanDAOImp1
	 */
	@Test
	public void testGetMiembrosClan() {
		ArrayList<String> miembros = new ArrayList<String>();
		miembros.add("pepitoXD");
		miembros.add("Mery_8");
		miembros.add("TheFirePro");
		miembros.add("juanito123");
		miembros.add("CarlosGM");
		assertEquals("Se comprueba que los miembros son los mismos",
				usuarioClanDAO.getMiembrosClan("losPros"), miembros);
		miembros.clear();
		miembros.add("MADRUGAD0R");
		miembros.add("Admlnistrador");
		miembros.add("martin_1998");
		miembros.add("_fran_");
		assertEquals("Se comprueba que los miembros son los mismos",
				usuarioClanDAO.getMiembrosClan("AlarmaSpain"), miembros);
		miembros.clear();
		miembros.add("Creador");
		assertEquals("Se comprueba que los miembros son los mismos",
				usuarioClanDAO.getMiembrosClan("clanNuevo"), miembros);
	}

}
