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

	public void AnadirUsuario(String idUsuario, String nombreReal,
			int puntuacion, String descPerfil, String password, String country) {

		usuarioDAO.guardaUsuario(new UsuarioPOJO(idUsuario, nombreReal,
				puntuacion, descPerfil, password, country));
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

	public void AnadirAlarma(String idAlarma, int horas, int minutos,
			boolean active, String tono, String idUsuario) {
		alarmaDAO.saveAlarm(new AlarmaPOJO(idAlarma, horas, minutos, active, tono));
		usuariosAlarmaDAO.addAlarmaUsuario(new AlarmaUsuarioPOJO(idAlarma,
				idUsuario));
	}

	public void EliminarAlarma(String idAlarma) {
		alarmaDAO.removeAlarm(idAlarma);
		usuariosAlarmaDAO.removeAlarmaUsuario(idAlarma);
	}
}