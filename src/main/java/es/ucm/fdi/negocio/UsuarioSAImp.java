package es.ucm.fdi.negocio;

import java.util.ArrayList;

import es.ucm.fdi.integracion.DAOs.*;
import es.ucm.fdi.integracion.POJOs.*;

public class UsuarioSAImp implements UsuarioSA {
	public UsuarioDAOImp usuarios;
	public UsuarioClanDAOImp usuariosClan;
	public AlarmaUsuarioDAOImp usuariosAlarma;
	public ClanDAOImp clanes;
	public AlarmaDAOImp alarmas;

	public void EliminarUsuarioClan(String idUsuario) {
		String idClan = usuarios.getUsuario(idUsuario).getIdClan();
		usuariosClan.eliminaUsuarioClan(idUsuario);
		if (clanes.getClan(idClan).getLider().equals(idUsuario)) {
			ArrayList<String> c = usuariosClan.getMiembrosClan(idClan);
			if (c.isEmpty())
				clanes.removeClan(idClan);
			else
				clanes.getClan(idClan).setLider(c.get(0));
		}
	}

	public void CrearClan(String idUsuario, String idClan) {
		clanes.saveClan(new ClanPOJO(idClan, idUsuario));
		usuariosClan.guardaUsuarioClan(new UsuarioClanPOJO(idClan, idUsuario));
	}

	public void AnadirUsuarioClan(String idUsuario, String idClan) {
		usuariosClan.guardaUsuarioClan(new UsuarioClanPOJO(idClan, idUsuario));
	}

	public void AnadirUsuario(String idUsuario, String nombreReal,
			int puntuacion, String descPerfil, String password, String country) {

		usuarios.guardaUsuario(new UsuarioPOJO(idUsuario, nombreReal,
				puntuacion, descPerfil, password, country));
	}

	public void EliminarUsuario(String idUsuario) {
		String idClan = usuarios.getUsuario(idUsuario).getIdClan();
		usuarios.eliminaUsuario(idUsuario);
		if (!idClan.equals("")) {
			usuariosClan.eliminaUsuarioClan(idUsuario);
			if (clanes.getClan(idClan).getLider().equals(idUsuario)) {
				ArrayList<String> c = usuariosClan.getMiembrosClan(idClan);
				if (c.isEmpty())
					clanes.removeClan(idClan);
				else
					clanes.getClan(idClan).setLider(c.get(0));
			}

		}
	}

	public void AnadirAlarma(String idAlarma, int horas, int minutos,
			boolean active, String tono, String idUsuario) {
		alarmas.saveAlarm(new AlarmaPOJO(idAlarma, horas, minutos, active, tono));
		usuariosAlarma.addAlarmaUsuario(new AlarmaUsuarioPOJO(idAlarma,
				idUsuario));
	}

	public void EliminarAlarma(String idAlarma) {
		alarmas.removeAlarm(idAlarma);
		usuariosAlarma.removeAlarmaUsuario(idAlarma);
	}
}