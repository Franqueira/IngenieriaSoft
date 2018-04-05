

package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.DAOs.AlarmaUsuarioDAOImp;
import es.ucm.fdi.integracion.DAOs.ClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioClanDAOImp;
import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.ClanPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

public class UsuarioSAImp implements UsuarioSA {
	public UsuarioDAOImp usuario;
	public UsuarioClanDAOImp usuarioClan;
	public AlarmaUsuarioDAOImp usuarioAlarma;
	public ClanDAOImp clanes;
	public void EliminarUsuarioClan(String idUsuario) {
	String idClan=usuario.getUsuario(idUsuario).getIdClan();
	usuarioClan.eliminaUsuarioClan(idUsuario);
		if(clanes.getClan(idClan).getLider().equals(idUsuario)){
			clanes.getClan(idClan).cam;
		}
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