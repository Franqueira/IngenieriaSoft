package es.ucm.fdi.negocio;

import java.util.ArrayList;
import java.util.stream.Collectors;

import es.ucm.fdi.integracion.DAOs.*;
import es.ucm.fdi.integracion.POJOs.*;

/**
 * 
 * Implementacion de la interfaz TestperclanSA
 *
 */

public class TestperclanSAImp implements TestperclanSA {
	private ClanDAOImp clanDAO;
	private UsuarioClanDAO usuarioClanDAO;
	private UsuarioDAO usuarioDAO;
	private PreguntaClanDAO preguntaClanDAO;

	public TestperclanSAImp(ClanDAOImp clanDAO, UsuarioClanDAO usuarioClanDAO,
			UsuarioDAO usuarios, PreguntaClanDAO preguntaClanDAO) {
		this.clanDAO = clanDAO;
		this.usuarioClanDAO = usuarioClanDAO;
		this.usuarioDAO = usuarios;
		this.preguntaClanDAO = preguntaClanDAO;
	}

	public ArrayList<UsuarioPOJO> getRanking(String nombreClan) {
		ArrayList<UsuarioPOJO> ranking = new ArrayList<>();
		ArrayList<String> miembros = usuarioClanDAO.getMiembrosClan(nombreClan);
		for (String m : miembros) {
			ranking.add((UsuarioPOJO) usuarioDAO.getFromId(m));
		}
		return ranking.stream()
				.sorted((u, v) -> v.getPuntuacion() - u.getPuntuacion())
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public void setPuntuacionRanking(UsuarioPOJO usuario, int puntuacion) {
		usuario.setPuntuacion(puntuacion);
		usuarioDAO.update(usuario);
	}

	public void setGanador(String nombreClan) {
		UsuarioPOJO ganador = getRanking(nombreClan).get(0);
		ganador.setEsGanador(true);
		usuarioDAO.update(ganador);
	}

	/**
	 * Elimina el usuario pasado por atributo. Si el usuario era el líder del
	 * clan, el nuevo líder será el usuario con mayor puntuación. Si el usuario
	 * era el último miembro del clan el clan se elimina.
	 * 
	 */
	public void eliminarUsuarioClan(String idUsuario) {
		String idClan = ((UsuarioPOJO) usuarioDAO.getFromId(idUsuario))
				.getIdClan();
		usuarioClanDAO.remove(idUsuario);
		UsuarioPOJO usuario = (UsuarioPOJO) usuarioDAO.getFromId(idUsuario);
		usuario.setIdClan(null);
		usuarioDAO.update(usuario);
		if (((ClanPOJO) clanDAO.getFromId(idClan)).getLider().equals(idUsuario)) {
			ArrayList<UsuarioPOJO> c = getRanking(idClan);
			if (c.isEmpty())
				clanDAO.remove(idClan);
			else {
				ClanPOJO clan = (ClanPOJO) clanDAO.getFromId(idClan);
				clan.setLider(c.get(0).getId());
				clanDAO.update(clan);
			}
		}
	}

	public void anadirUsuarioClan(String idUsuario, String idClan) {
		
		UsuarioPOJO usuario = (UsuarioPOJO) usuarioDAO.getFromId(idUsuario);
		if(idClan!=null)
			eliminarUsuarioClan(usuario.getId());
		usuario.setPuntuacion(0);
		usuario.setIdClan(idClan);
		usuarioDAO.update(usuario);
		usuarioClanDAO.save(new UsuarioClanPOJO(idClan, idUsuario));

	}

	public void crearClan(String idUsuario, String idClan) {
		clanDAO.save(new ClanPOJO(idClan, idUsuario));
		UsuarioPOJO lider = (UsuarioPOJO) usuarioDAO.getFromId(idUsuario);
		lider.setIdClan(idClan);
		usuarioDAO.update(lider);
		usuarioClanDAO.save(new UsuarioClanPOJO(idClan, idUsuario));
	}

	// tiene poco sentido llamar a este método no?
	@Override
	public ArrayList<String> preguntasClan(String idClan) {
		return preguntaClanDAO.getPreguntas(idClan);
	}
}
