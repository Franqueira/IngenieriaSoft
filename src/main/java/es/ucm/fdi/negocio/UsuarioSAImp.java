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
	public boolean EliminarUsuario(String idUsuario){
		
		return false;
	}
	public boolean AnadirAlarma(String idAlarma, int horas, int minutos,
			boolean active, String Tono) {
		return false;

	}

	public boolean EliminarAlarma(String idAlarma) {

		return false;
	}
	public boolean CrearClan(String idUsuario,String idClan){
		
		return false;
	}
}
