package es.ucm.fdi.negocio;

import java.util.ArrayList;
import java.util.stream.Collectors;

import es.ucm.fdi.integracion.DAOs.ClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioDAO;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

/**
 * 
 * Implementacion de la interfaz TestperclanSA
 *
 */

public class TestperclanSAImp implements TestperclanSA{
	private ClanDAOImp clanDAO;
	private UsuarioClanDAO usuarioClanDAO;
	private UsuarioDAO usuarioDAO;

	public TestperclanSAImp(ClanDAOImp clanDAO, UsuarioClanDAO usuarioClanDAO,
			UsuarioDAO usuarios) {
		this.clanDAO = clanDAO;
		this.usuarioClanDAO = usuarioClanDAO;
		this.usuarioDAO = usuarios;
	}

	public ArrayList<UsuarioPOJO> getRanking(String nombreClan) {
		ArrayList<UsuarioPOJO> ranking = new ArrayList<>();
		ArrayList<String> miembros = usuarioClanDAO.getMiembrosClan(nombreClan);
		for(String m : miembros){
			ranking.add((UsuarioPOJO) usuarioDAO.getFromId(m));
		}
		return ranking.stream()
				.sorted((u,v)-> v.getPuntuacion() - u.getPuntuacion())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public void setRanking(UsuarioPOJO usuario, int puntuacion) {
		usuario.setPuntuacion(puntuacion);
	}
	
	public void setGanador(String nombreClan){
		getRanking(nombreClan).get(0).setEsGanador(true);
	}
	
	public void eliminarUsuarioClan(String idUsuario) {
		String idClan = ((UsuarioPOJO) usuarioDAO.getFromId(idUsuario)).getIdClan();
		usuarioClanDAO.remove(idUsuario);
		if (((ClanPOJO) clanDAO.getFromId(idClan)).getLider().equals(idUsuario)) {
			ArrayList<String> c = usuarioClanDAO.getMiembrosClan(idClan);
			if (c.isEmpty())
				clanDAO.remove(idClan);
			else
				((ClanPOJO) clanDAO.getFromId(idClan)).setLider(c.get(0));
		}
	}

	public void anadirUsuarioClan(String idUsuario, String idClan) {
		((UsuarioPOJO)usuarioDAO.getFromId(idUsuario)).setIdClan(idClan);
		usuarioClanDAO.save(new UsuarioClanPOJO(idClan, idUsuario));
		
	}
	
	public void crearClan(String idUsuario, String idClan) {
		clanDAO.save(new ClanPOJO(idClan, idUsuario));
		((UsuarioPOJO)usuarioDAO.getFromId(idUsuario)).setIdClan(idClan);
		usuarioClanDAO.save(new UsuarioClanPOJO(idClan, idUsuario));
	}
}
