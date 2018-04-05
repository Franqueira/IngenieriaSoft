package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

public class UsuarioSAImp implements UsuarioSA {
	public UsuarioDAOImp usuario;

	public boolean EliminarUsuarioClan(String idUsuario) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean AnadirUsuarioClan(String idUsuario) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean AnadirUsuario(String idUsuario, String nombreReal,
			int puntuacion, String descPerfil, String password, String country) {

		return false;
	}

	public void AnadirAlarma(String idAlarma, int horas, int minutos,
			boolean active, String Tono) {
		// TODO Auto-generated method stub

	}

	public void EliminarAlarma(String idAlarma) {
		// TODO Auto-generated method stub

	}

}
