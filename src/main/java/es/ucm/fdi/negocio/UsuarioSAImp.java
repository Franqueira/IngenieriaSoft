package es.ucm.fdi.negocio;

import java.util.ArrayList;

import es.ucm.fdi.integracion.DAOs.*;
import es.ucm.fdi.integracion.POJOs.*;

public class UsuarioSAImp implements UsuarioSA {
	public UsuarioDAO usuarioDAO;
	public UsuarioClanDAO usuariosClanDAO;
	public AlarmaUsuarioDAO usuariosAlarmaDAO;
	public ClanDAO clanDAO;
	public AlarmaDAO alarmaDAO;
	public PreguntaDAO preguntaDAO;
	public PreguntaUsuarioDAO preguntaUsuarioDAO;
	
	public UsuarioSAImp(UsuarioDAO usuarioDAO, UsuarioClanDAO usuariosClanDAO,
			AlarmaUsuarioDAO usuariosAlarmaDAO, ClanDAO clanDAO,
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

		usuarioDAO.guardaUsuario(new UsuarioPOJO(idUsuario, nombreReal,
				puntuacion, password, country));
	}

	public void EliminarUsuario(String idUsuario) {
		String idClan = usuarioDAO.getUsuario(idUsuario).getIdClan();
		usuarioDAO.eliminaUsuario(idUsuario);
		if (!idClan.equals("")) {
			usuariosClanDAO.eliminaUsuarioClan(idUsuario);
			if (clanDAO.getClan(idClan).getLider().equals(idUsuario)) {
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
	public void AnadirAlarma(AlarmaPOJO alarma, String idUsuario) {
		alarmaDAO.saveAlarm(alarma);
		usuariosAlarmaDAO.addAlarmaUsuario(new AlarmaUsuarioPOJO(alarma.getId(), idUsuario));
	}

	public void EliminarAlarma(String idAlarma) {
		alarmaDAO.removeAlarm(idAlarma);
		usuariosAlarmaDAO.removeAlarmaUsuario(idAlarma);
	}
}
