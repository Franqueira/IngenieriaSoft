package es.ucm.fdi.negocio;

import java.util.ArrayList;

import es.ucm.fdi.integracion.DAOs.*;
import es.ucm.fdi.integracion.POJOs.*;

/**
 * 
 * Implementacion de la interfaz PreguntaSA
 * 
 */

public class PreguntaSAImp implements PreguntaSA {
	private PreguntaDAO preguntaDAO;
	private PreguntaUsuarioDAO preguntaUsuarioDAO;
	private UsuarioDAO usuarioDAO;
	private PreguntaClanDAO preguntaClanDAO;

	public PreguntaSAImp(PreguntaDAO preguntaDAO,
			PreguntaUsuarioDAO preguntaUsuarioDAO, UsuarioDAO usuarioDAO,
			PreguntaClanDAO preguntaClanDAO) {
		this.preguntaDAO = preguntaDAO;
		this.preguntaUsuarioDAO = preguntaUsuarioDAO;
		this.usuarioDAO = usuarioDAO;
		this.preguntaClanDAO = preguntaClanDAO;
	}

	@Override
	public void vincularCategoria(String categoria, String idUsuario) {
		ArrayList<PreguntaPOJO> preguntas = preguntaDAO
				.getPreguntasPorCategoria(categoria);
		for (PreguntaPOJO pregunta : preguntas) {
			preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO(pregunta.getId(),
					idUsuario));
		}
	}

	@Override
	public void desvincularCategoria(String categoria, String idUsuario) {
		ArrayList<PreguntaPOJO> preguntas = preguntaDAO
				.getPreguntas(preguntaUsuarioDAO.getPreguntas(idUsuario));
		for (PreguntaPOJO pregunta : preguntas) {
			if (pregunta.getCategoria().equals(categoria)) {
				preguntaUsuarioDAO.remove(pregunta.getId());
			}
		}
	}

	@Override
	public void agregarPregunta(PreguntaPOJO pregunta, String idUsuario) {
		preguntaUsuarioDAO.save(new PreguntaUsuarioPOJO(pregunta.getId(),
				idUsuario));
		String idClan = ((UsuarioPOJO) usuarioDAO.getFromId(idUsuario))
				.getIdClan();
		if (idClan.length() != 0) // para ver que tiene clan
			preguntaClanDAO
					.save(new PreguntaClanPOJO(pregunta.getId(), idClan));
		preguntaDAO.save(pregunta);
	}

	@Override
	public void eliminarPregunta(String idPregunta, String idUsuario) {
		preguntaUsuarioDAO.remove(idPregunta);// aquí debería pasar esta id o de
												// usuario
		preguntaClanDAO.remove(idPregunta);
		preguntaDAO.remove(idPregunta);
	}

}
