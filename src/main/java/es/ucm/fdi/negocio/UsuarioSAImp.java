package es.ucm.fdi.negocio;

import java.util.ArrayList;

import es.ucm.fdi.integracion.DAOs.*;
import es.ucm.fdi.integracion.POJOs.*;

public class UsuarioSAImp implements UsuarioSA {
	public UsuarioDAO usuarioDAO;
	public UsuarioClanDAO usuariosClanDAO;
	public AlarmaUsuarioDAO usuariosAlarmaDAO;
	public ClanDAOImp clanDAO;
	public AlarmaDAO alarmaDAO;
	public PreguntaDAO preguntaDAO;
	public PreguntaUsuarioDAO preguntaUsuarioDAO;
	
	public UsuarioSAImp(UsuarioDAO usuarioDAO, UsuarioClanDAO usuariosClanDAO,
			AlarmaUsuarioDAO usuariosAlarmaDAO, ClanDAOImp clanDAO,
			AlarmaDAO alarmaDAO, PreguntaDAO preguntaDAO,
			PreguntaUsuarioDAO preguntaUsuarioDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
		this.usuariosClanDAO = usuariosClanDAO;
		this.usuariosAlarmaDAO = usuariosAlarmaDAO;
		this.clanDAO = clanDAO;
		this.alarmaDAO = alarmaDAO;
		this.preguntaDAO = preguntaDAO;
		this.preguntaUsuarioDAO = preguntaUsuarioDAO;
	}

	public void AnadirUsuario(String idUsuario, String nombreReal,
			int puntuacion, String password, String country) {

		usuarioDAO.save(new UsuarioPOJO(idUsuario, nombreReal,
				puntuacion, password, country));
	}

	public void EliminarUsuario(String idUsuario) {
		String idClan = ((UsuarioPOJO) usuarioDAO.getFromId(idUsuario)).getIdClan();
		usuarioDAO.remove(idUsuario);
		if (!idClan.equals("")) {
			usuariosClanDAO.eliminaUsuarioClan(idUsuario);
			if (clanDAO.getFromId(idClan).getLider().equals(idUsuario)) {
				ArrayList<String> c = usuariosClanDAO.getMiembrosClan(idClan);
				if (c.isEmpty())
					clanDAO.removeClan(idClan);
				else
					clanDAO.getClan(idClan).setLider(c.get(0));
			}

		}
	}
	public void AnadirPregunta(PreguntaPOJO pregunta,String idUsuario){
		preguntaDAO.savePregunta(pregunta);
		preguntaUsuarioDAO.savePreguntaUsuario(new PreguntaUsuarioPOJO(pregunta.getId(),idUsuario));
	}
	public void ElminarPregunta(String idPregunta,String idUsuario){
		ArrayList<String> preguntas=preguntaUsuarioDAO.getPreguntas(idUsuario);
		if(preguntas.size()>10){ // solo dejamos eliminar si tiene mas de 10 preguntas.
			preguntaDAO.removePregunta(idPregunta);
			preguntaUsuarioDAO.removePreguntaUsuario(idPregunta);
			
		}
	}
	public void AnadirAlarma(AlarmaPOJO alarma, String idUsuario) {
		alarmaDAO.save(alarma);
		usuariosAlarmaDAO.save(new AlarmaUsuarioPOJO(alarma.getId(), idUsuario));
	}

	public void EliminarAlarma(String idAlarma) {
		alarmaDAO.remove(idAlarma);
		usuariosAlarmaDAO.remove(idAlarma);
	}
}
