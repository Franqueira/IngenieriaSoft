package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.DAOs.*;
import es.ucm.fdi.integracion.POJOs.*;

/**
 * 
 * Implementación de la interfaz AlarmaSA
 *
 */
public class AlarmaSAImp implements AlarmaSA {
	private AlarmaDAO alarmaDAO;
	private AlarmaUsuarioDAO alarmaUsuarioDAO;

	public AlarmaSAImp(AlarmaDAO alarmaDAO, AlarmaUsuarioDAO alarmaUsuarioDAO) {
		this.alarmaDAO = alarmaDAO;
		this.alarmaUsuarioDAO = alarmaUsuarioDAO;
	}

	@Override
	public String getTone(String alarma) {
		return ((AlarmaPOJO) alarmaDAO.getFromId(alarma)).getTono();
	}

	@Override
	public void posponerAlarma(String alarma) {
		AlarmaPOJO alarmaPOJO = (AlarmaPOJO) alarmaDAO.getFromId(alarma);
		if (alarmaPOJO.getMinutos() >= 55) {
			alarmaPOJO.setMinutos(alarmaPOJO.getMinutos() - 55);
			if (alarmaPOJO.getHoras() == 23) {
				alarmaPOJO.setHoras(0);
			} else {
				alarmaPOJO.setHoras(alarmaPOJO.getHoras() + 1);
			}
		} else
			alarmaPOJO.setMinutos(alarmaPOJO.getMinutos() + 5);
		alarmaDAO.update(alarmaPOJO);
	}

	@Override
	public void AnadirAlarma(AlarmaPOJO alarma, String idUsuario) {
		alarmaDAO.save(alarma);
		alarmaUsuarioDAO.save(new AlarmaUsuarioPOJO(alarma.getId(), idUsuario));

	}

	@Override
	public void EliminarAlarma(String idAlarma) {
		alarmaDAO.remove(idAlarma);
		alarmaUsuarioDAO.remove(idAlarma);

	}
}
