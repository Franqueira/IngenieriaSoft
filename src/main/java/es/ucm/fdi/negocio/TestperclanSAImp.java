package es.ucm.fdi.negocio;

import java.util.ArrayList;
import java.util.stream.Collectors;

import es.ucm.fdi.integracion.DAOs.ClanDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAO;
import es.ucm.fdi.integracion.DAOs.UsuarioDAO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;


public class TestperclanSAImp implements TestperclanSA{
	private ClanDAO clanDAO;
	private UsuarioClanDAO usuarioClanDAO;
	private UsuarioDAO usuarioDAO;

	@Override
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
	
	
	
	
}
