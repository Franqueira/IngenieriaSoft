

package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.DAOs.AlarmaUsuarioDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

public class UsuarioSAImp implements UsuarioSA {
	public UsuarioDAOImp usuario;
	public UsuarioClanDAOImp usuarioClan;
	public AlarmaUsuarioDAOImp usuarioAlarma;
	public void EliminarUsuarioClan(String idUsuario) {
	
	}

	public void AnadirUsuarioClan(String idUsuario,String idClan) {

	
	}

	public void AnadirUsuario(String idUsuario, String nombreReal,
			int puntuacion, String descPerfil, String password, String country) {

	}
	public void EliminarUsuario(String idUsuario){
		
	}
	public void AnadirAlarma(String idAlarma, int horas, int minutos,
			boolean active, String Tono) {


	}

	public void EliminarAlarma(String idAlarma) {

	}
	public void CrearClan(String idUsuario,String idClan){
		
	}
}