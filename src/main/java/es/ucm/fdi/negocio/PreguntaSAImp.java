package es.ucm.fdi.negocio;

import java.util.ArrayList;

import es.ucm.fdi.integracion.DAOs.PreguntaDAO;
import es.ucm.fdi.integracion.DAOs.PreguntaUsuarioDAO;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaUsuarioPOJO;

/**
 * 
 * Implementacion de la interfaz PreguntaSA
 * 
 */

public class PreguntaSAImp implements PreguntaSA {

	private PreguntaDAO preguntaDAO;
	private PreguntaUsuarioDAO preguntaUsuarioDAO;

	public PreguntaSAImp(PreguntaDAO preguntaDAO,
			PreguntaUsuarioDAO preguntaUsuarioDAO) {
		this.preguntaDAO = preguntaDAO;
		this.preguntaUsuarioDAO = preguntaUsuarioDAO;
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
	public void agregarPregunta(PreguntaPOJO pregunta) {
		preguntaDAO.save(pregunta);
	}
	@Override
	public void eliminarPregunta(String idPregunta) {
		preguntaDAO.remove(idPregunta);
	}

}
