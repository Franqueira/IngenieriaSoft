package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;
import junit.framework.TestCase;

public class UsuarioClanDAOTest extends TestCase {
	private BDHashMap<UsuarioClanPOJO> BDusuarioClan;
	
	public UsuarioClanDAOTest(String testName){
		super(testName);
		this.BDusuarioClan = new BDHashMap<UsuarioClanPOJO>();
		setup();
	}
	
	public void setup(){
		UsuarioClanDAOImp usuarioClanDAO = new UsuarioClanDAOImp(BDusuarioClan);
		
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
	
	public void testGetMiembrosClan(){
		UsuarioClanDAOImp usuarioClanDAO = new UsuarioClanDAOImp(BDusuarioClan);
		ArrayList<String> miembros = new ArrayList<String>();
		miembros.add("pepitoXD");
		miembros.add("juanito123");
		miembros.add("TheFirePro");
		miembros.add("CarlosGM");
		miembros.add("Mery_8");
		assertEquals(usuarioClanDAO.getMiembrosClan("losPros"), miembros);
		miembros.clear();
		miembros.add("_fran_");
		miembros.add("MADRUGAD0R");
		miembros.add("Admlnistrador");
		miembros.add("martin_1998");
		assertEquals(usuarioClanDAO.getMiembrosClan("AlarmaSpain"), miembros);
		miembros.clear();
		miembros.add("Creador");
		assertEquals(usuarioClanDAO.getMiembrosClan("clanNuevo"), miembros);
	}
	
}
