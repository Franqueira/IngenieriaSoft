package es.ucm.fdi.negocio;

import java.util.ArrayList;

import es.ucm.fdi.integracion.DAOs.*;
import es.ucm.fdi.integracion.POJOs.*;

/**
 * Implementación de la interfaz UsuarioSAImp
 */

public class UsuarioSAImp implements UsuarioSA {
	private UsuarioDAO usuarioDAO;
	private UsuarioClanDAO usuariosClanDAO;
	private ClanDAOImp clanDAO;
	private PreguntaDAO preguntaDAO;
	private PreguntaUsuarioDAO preguntaUsuarioDAO;

	public UsuarioSAImp(UsuarioDAO usuarioDAO, UsuarioClanDAO usuariosClanDAO,
			AlarmaUsuarioDAO usuariosAlarmaDAO, ClanDAOImp clanDAO,
			AlarmaDAO alarmaDAO, PreguntaDAO preguntaDAO,
			PreguntaUsuarioDAO preguntaUsuarioDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
		this.usuariosClanDAO = usuariosClanDAO;
		this.clanDAO = clanDAO;
		this.preguntaDAO = preguntaDAO;
		this.preguntaUsuarioDAO = preguntaUsuarioDAO;
	}

	public void anadirUsuario(UsuarioPOJO usuario) {
		usuarioDAO.save(usuario);
	}

	public void eliminarUsuario(String idUsuario) {
		String idClan = ((UsuarioPOJO) usuarioDAO.getFromId(idUsuario))
				.getIdClan();
		usuarioDAO.remove(idUsuario);
		if (idClan != null) {
			usuariosClanDAO.remove(idUsuario);
			if (((ClanPOJO) clanDAO.getFromId(idClan)).getLider().equals(
					idUsuario)) {
				ArrayList<String> c = usuariosClanDAO.getMiembrosClan(idClan);
				if (c.isEmpty())
					clanDAO.remove(idClan);
				else{
					ClanPOJO clan = (ClanPOJO) clanDAO.getFromId(idClan);
					clan.setLider(c.get(0));
					clanDAO.update(clan);
				}
			}
			
		}
	}

	public void informarRespuesta(String idUsuario, String idPregunta,
			int respuesta) {

		UsuarioPOJO user = (UsuarioPOJO) usuarioDAO.getFromId(idUsuario);
		if (((PreguntaPOJO) preguntaDAO.getFromId(idPregunta))
				.getRespuestaCorrecta() == respuesta) {
			// el usuario ha acertado la pregunta
			user.setPuntuacion(user.getPuntuacion() + 10);// 10 por poner
															// cualquier valor

		} else { // no acertó
			user.setPuntuacion(user.getPuntuacion() - 10); // restamos 10 si
															// falla
		}
		usuarioDAO.update(user);

	}
	
	@Override
	public ArrayList<String> preguntasUsuario(String usuario) {
		ArrayList<String> preguntas = new ArrayList<>();
		for (String p : preguntaUsuarioDAO.getPreguntas(usuario)) {
			preguntas.add(p);
		}
		return preguntas;
	}

}
