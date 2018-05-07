package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;
import junit.framework.TestCase;

public class UsuarioClanDAOTest extends TestCase {
	private BDHashMap<UsuarioClanPOJO> BDusuarioClan;
	private UsuarioClanDAOImp usuarioClanDAO;
	
	@Before
	public void setup(){
		BDusuarioClan = new BDHashMap<UsuarioClanPOJO>();
		usuarioClanDAO = new UsuarioClanDAOImp(BDusuarioClan);
		
		usuarioClanDAO.save(new UsuarioClanPOJO("losPros","pepitoXD"));
		usuarioClanDAO.save(new UsuarioClanPOJO("losPros","juanito123"));
		usuarioClanDAO.save(new UsuarioClanPOJO("losPros","TheFirePro"));
		usuarioClanDAO.save(new UsuarioClanPOJO("losPros","CarlosGM"));
		usuarioClanDAO.save(new UsuarioClanPOJO("losPros","Mery_8"));
		usuarioClanDAO.save(new UsuarioClanPOJO("AlarmaSpain","_fran_"));
		usuarioClanDAO.save(new UsuarioClanPOJO("AlarmaSpain","MADRUGAD0R"));
		usuarioClanDAO.save(new UsuarioClanPOJO("AlarmaSpain","Admlnistrador"));
		usuarioClanDAO.save(new UsuarioClanPOJO("clanNuevo","Creador"));
		usuarioClanDAO.save(new UsuarioClanPOJO("AlarmaSpain","martin_1998"));
	}
	
	@Test
	public void testGetMiembrosClan(){
		ArrayList<String> miembros = new ArrayList<String>();
		miembros.add("pepitoXD");
		miembros.add("Mery_8");
		miembros.add("TheFirePro");
		miembros.add("juanito123");
		miembros.add("CarlosGM");
		assertEquals("Se comprueba que los miembros son los mismos",usuarioClanDAO.getMiembrosClan("losPros"), miembros);
		miembros.clear();
		miembros.add("MADRUGAD0R");
		miembros.add("Admlnistrador");
		miembros.add("martin_1998");
		miembros.add("_fran_");
		assertEquals("Se comprueba que los miembros son los mismos",usuarioClanDAO.getMiembrosClan("AlarmaSpain"), miembros);
		miembros.clear();
		miembros.add("Creador");
		assertEquals("Se comprueba que los miembros son los mismos",usuarioClanDAO.getMiembrosClan("clanNuevo"), miembros);
	}
	
}
