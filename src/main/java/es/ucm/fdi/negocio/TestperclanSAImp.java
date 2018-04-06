package es.ucm.fdi.negocio;

import java.util.ArrayList;
import java.util.stream.Collectors;

import es.ucm.fdi.integracion.DAOs.ClanDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioDAO;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;


public class TestperclanSAImp implements TestperclanSA{
	private ClanDAO clanDAO;
	private UsuarioClanDAO usuarioClanDAO;
	private UsuarioDAO usuarioDAO;

	public TestperclanSAImp(ClanDAO clanDAO, UsuarioClanDAO usuarioClanDAO,
			UsuarioDAO usuarios) {
		this.clanDAO = clanDAO;
		this.usuarioClanDAO = usuarioClanDAO;
		this.usuarioDAO = usuarios;
	}

	public ArrayList<UsuarioPOJO> getRanking(String nombreClan) {
		ArrayList<UsuarioPOJO> ranking = new ArrayList<>();
		ArrayList<String> miembros = usuarioClanDAO.getMiembrosClan(nombreClan);
		for(String m : miembros){
			ranking.add(usuarioDAO.getUsuario(m));
		}
		return ranking.stream()
				.sorted((u,v)-> u.getPuntuacion()-v.getPuntuacion())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public void setGanador(String nombreClan){
		getRanking(nombreClan).get(0).setEsGanador(true);
	}
	
	public void EliminarUsuarioClan(String idUsuario) {
		String idClan = usuarioDAO.getUsuario(idUsuario).getIdClan();
		usuarioClanDAO.eliminaUsuarioClan(idUsuario);
		if (clanDAO.getClan(idClan).getLider().equals(idUsuario)) {
			ArrayList<String> c = usuarioClanDAO.getMiembrosClan(idClan);
			if (c.isEmpty())
				clanDAO.removeClan(idClan);
			else
				clanDAO.getClan(idClan).setLider(c.get(0));
		}
	}

	public void CrearClan(String idUsuario, String idClan) {
		clanDAO.saveClan(new ClanPOJO(idClan, idUsuario));
		usuarioClanDAO.guardaUsuarioClan(new UsuarioClanPOJO(idClan, idUsuario));
	}

	public void AnadirUsuarioClan(String idUsuario, String idClan) {
		usuarioClanDAO.guardaUsuarioClan(new UsuarioClanPOJO(idClan, idUsuario));
	}
}
